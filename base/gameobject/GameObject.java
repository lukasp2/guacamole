package base.gameobject;

import base.helpers.Vector;
import base.helpers.ID;

import java.awt.Dimension;
import java.awt.Graphics;

public abstract class GameObject {
    protected Vector vector;
    protected Dimension dimensions;
    protected ID id;

    public GameObject(ID id, Vector vector, Dimension dimensions) {
        this.id = id;
        this.vector = vector;
        this.dimensions = dimensions;
    }

    public abstract void tick();
    
    public abstract void render(Graphics g);
}
