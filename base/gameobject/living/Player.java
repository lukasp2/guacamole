package base.gameobject.living;

import base.helpers.Vector;
import base.KeyInputCooldown;
import base.PlayerControls;
import base.helpers.ID;
import base.helpers.Pair;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

public class Player extends Living {
    private PlayerControls controls;

    public Player(PlayerControls controls, Pair position) {
        super(ID.Player, 100, new Vector(new Pair(100, 100), new Pair(0, 0)), new Dimension(50, 50));

        this.controls = controls;
        controls.addAction(KeyEvent.VK_W, () -> moveUp());
        controls.addAction(KeyEvent.VK_S, () -> moveDown());
        controls.addAction(KeyEvent.VK_A, () -> moveLeft());
        controls.addAction(KeyEvent.VK_D, () -> moveRight());
        controls.addAction(KeyEvent.VK_G, () -> action());
    }

    public void moveUp() {
        this.vector.getVelocity().setY(this.vector.getVelocity().getY() - 1);
    }

    public void moveDown() {
        this.vector.getVelocity().setY(this.vector.getVelocity().getY() + 1);
    }


    public void moveLeft() {
        this.vector.getVelocity().setX(this.vector.getVelocity().getX() - 1);
    }


    public void moveRight() {
        this.vector.getVelocity().setX(this.vector.getVelocity().getX() + 1);
    }


    public void action() {

    }

    public void actOnKeyPress(KeyInputCooldown kic, int key) {
        if (kic.keyIsReady(key)) {
            controls.getAction(key).run();
        }
    }

    public void tick() {
        super.tick();
    }

    public void render(Graphics g) {
        super.render(g);
        g.setColor(Color.PINK);
        g.fillRect(vector.getPosition().getX(), vector.getPosition().getY(), (int)dimensions.getWidth(), (int)dimensions.getHeight());
    }
}
