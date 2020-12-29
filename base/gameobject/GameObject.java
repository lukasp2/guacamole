package base.gameobject;

import base.helpers.Vector;
import base.helpers.ID;
import base.helpers.Pair;

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

    public Vector getVector() {
        return vector;
    }

    public Dimension getDimensions() {
        return dimensions;
    }

    public void tick() {
        vector.setPosition(
            new Pair(vector.getPosition().getX() + vector.getVelocity().getX(),
            vector.getPosition().getY() + vector.getVelocity().getY())
        );
    }
    
    public abstract void render(Graphics g);
}
