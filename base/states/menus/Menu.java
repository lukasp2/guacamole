package base.states.menus;

import base.gameobject.text.Text;
import base.helpers.Vector;
import base.helpers.Pair;
import base.states.State;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Menu extends State {
    private static final long serialVersionUID = -7258389546270293186L;
    private Pair position = new Pair(100, 100);

    int currentOption = 0;

    public Menu() {}

    public void addTitle(String str) {
        super.addObjects(new Text(str, "TimesRoman", 24, Color.LIGHT_GRAY, Font.PLAIN, new Vector(new Pair(position.getX(), position.getY()), new Pair(0, 0))));
    }

    public void addOptions(String... strs) {
        int currY = 50;
        for (String str : strs) {
            super.addObjects(new Text(str, "TimesRoman", 20, Color.LIGHT_GRAY, Font.PLAIN, new Vector(new Pair(position.getX() + 0, position.getY() + currY), new Pair(0, 0))));
            currY += 40;
        }
    }

    public void getInput() {
    }

    public void tick() {
        super.tick();
    }

    public void render(Graphics g) {
    }
}
