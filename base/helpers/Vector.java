package base.helpers;

public class Vector {
    // position on an x/y plane
    private Pair position;

    // velocity on an x/y plane
    private Pair velocity;

    public Vector() {
        this.position = new Pair();
        this.velocity = new Pair();
    }

    public Vector(Pair position, Pair velocity) {
        this.position = position;
        this.velocity = velocity;
    }

    public Pair getPosition() {
        return this.position;
    }

    public Pair getVelocity() {
        return this.velocity;
    }
}
