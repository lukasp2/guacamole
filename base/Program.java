package base;

import base.states.State;
import base.states.menus.Start;

import java.awt.Canvas;

public class Program extends Canvas implements Runnable {
    private static final long serialVersionUID = 4985816448274544227L;

    public final int WIDTH = 1240;
    public final int HEIGHT = WIDTH / 16 * 9;

    public Window window;
    public StateMachine sm;
    private Thread thread;

    public Program() {
        window = new Window("Guacamole", WIDTH, HEIGHT);

        State start = new Start();
        sm = new StateMachine(start);

        // these two needs to be done every State switch?
        window.frame.add(start);
        window.frame.setVisible(true);
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
                sm.stack.peek().getInput();
                sm.stack.peek().tick();
                --delta;
            }

            if (sm.running) {
                sm.stack.peek().render();
            }
            ++frames;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }
}
