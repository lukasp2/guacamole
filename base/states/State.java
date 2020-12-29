package base.states;

import base.StateMachine;
import base.gameobject.GameObject;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.Color;
import java.util.LinkedList;

public class State extends Canvas {
    private static final long serialVersionUID = -8198482209728477582L;

    public LinkedList<GameObject> objects = new LinkedList<GameObject>();

    public StateMachine sm;

    public void addObjects(GameObject... objs) {
        for (GameObject obj : objs) {
            objects.add(obj);
        }
    }

     // get and store input
    public void getInput() {
        // if press P: sm.add(new Pause());
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
            System.out.println("state: render");
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