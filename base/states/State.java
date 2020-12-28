package base.states;

import base.StateMachine;
import base.gameobject.GameObject;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.Color;
import java.util.LinkedList;

public class State extends Canvas {
    public LinkedList<GameObject> objects = new LinkedList<GameObject>();

    public StateMachine sm;

     // get and store input
    public void getInput() {

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
        g.fillRect(0, 0, 500, 500);

        for (int i = 0; i < objects.size(); ++i) {
            objects.get(i).render(g);
        }

        g.dispose();
        bs.show();
    } 
}