package base.helpers;

public class Vector {
    private Pair position;
    private Pair velocity;

    public Vector(Pair position, Pair velocity) {
        this.position = position;
    }

    public void setPosition(Pair position) {
        this.position = position;
    }

    public void setDirection(Pair velocity) {
        this.velocity = velocity;
    }

    public Pair getPosition() {
        return this.position;
    }

    public Pair getDirection() {
        return this.velocity;
    }
}
