package base.gameobject.object;

import base.helpers.ID;
import base.helpers.Vector;
import base.gameobject.GameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

public class Object extends GameObject {
    public Object(ID id, Vector vector, Dimension dimensions) {
        super(id, vector, dimensions);
    }

    public void tick() {}
    
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(vector.getPosition().getX(), this.vector.getPosition().getY(), 80, 80);
    }
}
