package base;

import base.states.menus.Start;

public class Program implements Runnable {
    public final int WIDTH = 1240;
    public final int HEIGHT = WIDTH / 16 * 9;

    public StateMachine sm;
    private Thread thread;

    public Program() {
        Window window = new Window("Guacamole", WIDTH, HEIGHT);
        sm = new StateMachine(window);
        sm.push(new Start());
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        sm.running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            sm.running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // main program loop
    public void run() {

        int waitTime = 1000 / 60; //65 being the desired FPS
        int sleepSkipped = 0;
        int maxSleepSkipped = 10;
        Long beforeTime = System.nanoTime();
        int fps = 0;
        int fpsTime = 0;
        while(sm.running){
            sm.peek().tick();
            sm.peek().render();
            
            Long afterTime = System.nanoTime();
            Long timeDiff = afterTime - beforeTime;
            Long sleepTime = waitTime - (timeDiff / 1000000L);

            if(sleepTime > 0){
                try {
                    Thread.sleep(sleepTime);
                } catch(InterruptedException ie) {
                }
            }
            else{ 
                sleepSkipped++;
                if(sleepSkipped == maxSleepSkipped){
                    Thread.yield();
                    sleepSkipped = 0;
                }
            }

            fpsTime += (System.nanoTime() - beforeTime) / 1000000;
            fps++;
            if(fpsTime > 1000){
                System.out.println("FPS: " + fps);
                fps = 0;
                fpsTime = 0;
            }

            beforeTime = System.nanoTime();
        }

        stop();
    }
}
