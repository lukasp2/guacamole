package base.gameobject;

import base.helpers.Vector;
import base.helpers.ID;

import java.awt.Dimension;
import java.awt.Graphics;

public abstract class GameObject {
    protected Vector vector;
    protected Dimension dimensions;
    protected int speed = 3;
    protected ID id;

    public GameObject(ID id, Vector vector, Dimension dimensions) {
        this.id = id;
        this.vector = vector; // defines position and direction
        this.dimensions = dimensions;
    }

    public Vector getVector() {
        return vector;
    }

    public Dimension getDimensions() {
        return dimensions;
    }

    public void tick() {
        vector.getPosition().setX(vector.getPosition().getX() + vector.getVelocity().getX());
        vector.getPosition().setY(vector.getPosition().getY() + vector.getVelocity().getY());
    }
    
    public abstract void render(Graphics g);
}
