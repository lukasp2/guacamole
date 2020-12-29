package base.states.menus;

//import base.gameobject.text.Text;
import base.gameobject.object.Object;
import base.helpers.ID;
import base.helpers.Pair;
import base.helpers.Vector;

import java.awt.Graphics;
import java.awt.Dimension;

public class Start extends Menu {
    private static final long serialVersionUID = -2011243664367333350L;

    public Start() {
        System.out.println("start: constructor");
        Object o1 = new Object(ID.Object, new Vector(new Pair(80, 200), new Pair(0, 0)), new Dimension(50, 50));
        Object o2 = new Object(ID.Object, new Vector(new Pair(270, 250), new Pair(0, 0)), new Dimension(50, 50));
        Object o3 = new Object(ID.Object, new Vector(new Pair(1030, 510), new Pair(0, 0)), new Dimension(50, 50));
        super.addObjects(o1, o2, o3);
    }

    public void getInput() {
    }

    public void tick() {
        super.tick();
    }

    public void render(Graphics g) {
        super.render(g);
    }
}    

