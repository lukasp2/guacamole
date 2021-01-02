package base.gameobject;

import base.helpers.Vector;
import base.Window;
import base.helpers.ID;
import base.helpers.Pair;

import java.awt.Dimension;
import java.awt.Graphics;

public abstract class GameObject {
    protected Vector vector;
    protected Dimension objectSize;
    protected int speed = 8;
    protected ID id;

    // cannot move outside of frame
    protected boolean confineToFrame = true;

    public GameObject(ID id, Vector vector, Dimension objectSize) {
        this.id = id;
        this.vector = vector; // defines position and direction of object
        this.objectSize = objectSize;
    }

    public Vector getVector() {
        return vector;
    }

    public Dimension getDimensions() {
        return objectSize;
    }

    public void tick(Window window) {
        Pair pos = vector.getPosition();
        Pair vel = vector.getVelocity();

        if (confineToFrame) {
            int titlebarHeight = 38;
            int lowerFrameBound = window.getFrame().getHeight() - objectSize.height - titlebarHeight;
            int rightFrameBound = window.getFrame().getWidth() - objectSize.width;

            if (pos.getX() < 0) {
                pos.setX(0);
            }
            else if (pos.getX() > rightFrameBound) {
                pos.setX(rightFrameBound);
            }
            
            if (pos.getY() < 0) {
                pos.setY(0);
            }
            else if (pos.getY() > lowerFrameBound) {
                pos.setY(lowerFrameBound);
            }
            
            if ((pos.getX() <= 0 && vel.getX() < 0) || (pos.getX() >= rightFrameBound && vel.getX() > 0)) {
                vel.setX(0);
            }
            if ((pos.getY() <= 0 && vel.getY() < 0) || (pos.getY() >= lowerFrameBound && vel.getY() > 0)) {
                vel.setY(0);
            }
        }

        pos.setX(pos.getX() + vel.getX());
        pos.setY(pos.getY() + vel.getY());
    }
    
    public abstract void render(Graphics g);
}