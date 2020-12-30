package base.states.menus;

import base.KeyInput;
import base.gameobject.text.Text;
import base.helpers.Vector;
import base.helpers.Pair;
import base.states.State;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class Menu extends State {
    private static final long serialVersionUID = -7258389546270293186L;
    private Pair position = new Pair(100, 100);

    LinkedList<Text> menuOptions = new LinkedList<Text>();

    int currentOption = 0;
    int numOptions;

    Color activeOption = Color.ORANGE;
    Color inactiveOption = Color.LIGHT_GRAY;

    public Menu() {
        this.addKeyListener(new KeyInput(this));
    }

    public void addTitle(String str) {
        super.addObjects(new Text(str, "TimesRoman", 24, inactiveOption, Font.PLAIN, new Vector(new Pair(position.getX(), position.getY()), new Pair(0, 0))));
    }

    public void addOptions(String... strs) {
        int currY = 50;
        for (String str : strs) {
            Text t = new Text(str, "TimesRoman", 20, inactiveOption, Font.PLAIN, new Vector(new Pair(position.getX(), position.getY() + currY), new Pair(0, 0)));
            super.addObjects(t);
            menuOptions.add(t);
            currY += 40;
            ++numOptions;
        }
        menuOptions.get(0).color = activeOption;
    }

    public void keyPressActions(int key) {
        super.keyPressActions(key);
        if (key == KeyEvent.VK_W && currentOption != 0 && kic.keyIsReady(key)) {
            menuOptions.get(currentOption).color = inactiveOption;
            --currentOption;
            menuOptions.get(currentOption).color = activeOption;
            kic.pressKey(key);
        }

        if (key == KeyEvent.VK_S && currentOption != numOptions - 1 && kic.keyIsReady(key)) {
            menuOptions.get(currentOption).color = inactiveOption;
            ++currentOption;
            menuOptions.get(currentOption).color = activeOption;
            kic.pressKey(key);
        }
    }

    public void keyReleaseActions(int key) {
        super.keyReleaseActions(key);
    }

    public void tick() {
        super.tick();
    }
}
