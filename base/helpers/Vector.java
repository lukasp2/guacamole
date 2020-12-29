package base.helpers;

public class Vector {
    private Pair position;
    private Pair direction;
    private double speed;

    public Vector(Pair position, Pair direction, double speed) {
        this.position = position;
        this.direction = direction;
        this.speed = speed;
    }

    public void setPosition(Pair position) {
        this.position = position;
    }

    public void setDirection(Pair direction) {
        this.direction = direction;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Pair getPosition() {
        return this.position;
    }

    public Pair getDirection() {
        return this.direction;
    }

    public double getSpeed() {
        return this.speed;
    }
}
