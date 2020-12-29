package base.gameobject.object;

import base.helpers.ID;
import base.helpers.Vector;
import base.gameobject.GameObject;

import java.awt.Color;
import java.awt.Graphics;

public class Object extends GameObject {
    public Object(ID id, Vector vector) {
        super(id, vector);
    }

    public void tick() {}
    
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(20, 50, 80, 80);

        g.setColor(Color.GREEN);
        g.fillRect(200, 200, 120, 120);

        g.setColor(Color.GREEN);
        g.fillRect(320, 415, 20, 20);
    }
}
