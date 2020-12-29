package base.helpers;

public class Vector {
    private Pair position;
    private Pair velocity;

    public Vector(Pair position, Pair velocity) {
        this.position = position;
        this.velocity = velocity;
    }

    public void setPosition(Pair position) {
        this.position = position;
    }

    public void setVelocity(Pair velocity) {
        this.velocity = velocity;
    }

    public Pair getPosition() {
        return this.position;
    }

    public Pair getVelocity() {
        return this.velocity;
    }
}
