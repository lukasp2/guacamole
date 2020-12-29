package base.gameobject.living;

import base.gameobject.GameObject;
import base.helpers.Vector;
import base.helpers.ID;

import java.awt.Graphics;
import java.awt.Dimension;

public class Living extends GameObject {
    private int health;

    public Living(ID id, int health, Vector vector, Dimension dimensions) {
        super(id, vector, dimensions);
        this.health = health;
    }

    public void tick() {}
    
    public void render(Graphics g) {}
}
