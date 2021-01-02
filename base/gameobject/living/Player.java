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
        controls.addAction(KeyEvent.VK_W, () -> movementUp());
        controls.addAction(KeyEvent.VK_S, () -> movementDown());
        controls.addAction(KeyEvent.VK_A, () -> movementLeft());
        controls.addAction(KeyEvent.VK_D, () -> movementRight());
        controls.addAction(KeyEvent.VK_G, () -> action());
    }

    public void movementUp() {
        vector.getVelocity().setY(-1 * speed * controls.keyIsPressed());
    }

    public void movementDown() {
        vector.getVelocity().setY(1 * speed * controls.keyIsPressed());
    }

    public void movementLeft() {
        vector.getVelocity().setX(-1 * speed * controls.keyIsPressed());
    }

    public void movementRight() {
        vector.getVelocity().setX(1 * speed * controls.keyIsPressed());
    }

    public void action() {

    }

    public void actOnKeyPress(KeyInputCooldown kic, int key) {
        if (kic.keyIsReady(key) && controls.has(key)) {
            controls.runPressAction(key);
        }
    }

    public void actOnKeyRelease(KeyInputCooldown kic, int key) {
        if (controls.has(key)) {
            controls.runReleaseAction(key);
        }
    }

    public void render(Graphics g) {
        super.render(g);
        g.setColor(Color.PINK);
        g.fillRect(vector.getPosition().getX(), vector.getPosition().getY(), (int)objectSize.getWidth(), (int)objectSize.getHeight());
    }
}
