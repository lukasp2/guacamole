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
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while (sm.running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                sm.peek().tick();
                --delta;
            }

            if (sm.running) {
                sm.peek().render();
            }
            ++frames;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }

            try {
                Thread.sleep(20);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        stop();
    }
}
