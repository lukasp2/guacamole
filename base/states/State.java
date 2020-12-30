package base.states;

import base.KeyInput;
import base.KeyInputCooldown;
import base.StateMachine;
import base.gameobject.GameObject;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class State extends Canvas {
    private static final long serialVersionUID = -8198482209728477582L;

    // synchronize!
    public LinkedList<GameObject> objects = new LinkedList<GameObject>();

    public StateMachine sm;
    public KeyInputCooldown kic;

    public State() {
        this.addKeyListener(new KeyInput(this));
        kic = new KeyInputCooldown();
        setKeyboardCooldowns();
    }

    // adds Game Objects to list
    public void addObjects(GameObject... objs) {
        for (GameObject obj : objs) {
            objects.add(obj);
        }
    }

    // override this method to add cooldowns to keys
    // default cooldown is 100 milliseconds
    public void setKeyboardCooldowns() {}

    public void keyPressActions(int key) {
        if (key == KeyEvent.VK_ESCAPE && kic.keyIsReady(key)) {
            kic.pressKey(key);
            sm.running = false;
        }
    }

    public void keyReleaseActions(int key) {
    }
    
    // process and update information
    public void tick() {
        for (int i = 0; i < objects.size(); ++i) {
            objects.get(i).tick();
        }
    }
    
    // draw result to screen
    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            super.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(Color.black);
        g.fillRect(0, 0, sm.window.getFrame().getWidth(), sm.window.getFrame().getHeight());

        for (int i = 0; i < objects.size(); ++i) {
            objects.get(i).render(g);
        }

        g.dispose();
        bs.show();
    } 
}