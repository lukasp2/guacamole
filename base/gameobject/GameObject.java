package base.gameobject;

import base.helpers.Vector;
import base.helpers.ID;

import java.awt.Graphics;

public abstract class GameObject {
    protected Vector vector;
    protected ID id;

    public GameObject(ID id, Vector vector) {
        this.id = id;
        this.vector = vector;
    }

    public abstract void tick();
    
    public abstract void render(Graphics g);
}
