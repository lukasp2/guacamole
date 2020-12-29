package base.states.menus;

//import base.gameobject.text.Text;
import base.gameobject.object.Object;
import base.helpers.ID;
import base.helpers.Pair;
import base.helpers.Vector;

import java.awt.Graphics;

public class Start extends Menu {
    private static final long serialVersionUID = -2011243664367333350L;

    public Start() {
        System.out.println("start: constructor");
        Object o1 = new Object(ID.Object, new Vector(new Pair(0, 0), new Pair(0, 0), 0.0));
        super.addObjects(o1);
        /*
        Create this start menu. Call super() and create the text classes.
        Text t1 = new Text("1. Start Game");
        Text t2 = new Text("2. Game Settings");
        Text t3 = new Text("3. High scores");
        Text t4 = new Text("4. Exit");
        */
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

