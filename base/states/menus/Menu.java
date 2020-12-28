package base.states.menus;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.Color;

import base.states.State;

public class Menu extends State {
    public void getInput() {
    }

    public void tick() {
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            super.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, 500, 500);
        g.dispose();
        bs.show();
    }
}
