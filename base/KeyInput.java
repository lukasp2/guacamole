package base;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println("Pressed " + key);

        //if (key == KeyEvent.VK_W) {}
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
    }
}
