package base;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import base.states.State;

public class KeyInput extends KeyAdapter {

    State state;

    public KeyInput(State state) {
        this.state = state;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        state.keyPressActions(key);
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        state.keyReleaseActions(key);
    }
}
