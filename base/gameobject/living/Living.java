package base.gameobject.living;

import base.gameobject.GameObject;
import base.helpers.Vector;
import base.helpers.ID;

import java.awt.Graphics;

public class Living extends GameObject {
    private int health;

    public Living(ID id, int health, Vector vector) {
        super(id, vector);
        this.health = health;
    }

    public void tick() {}
    
    public void render(Graphics g) {}
}
