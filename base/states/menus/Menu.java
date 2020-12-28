package base.states.menus;

import base.gameobject.GameObject;
import base.states.State;

public class Menu extends State {
    public Menu(GameObject... objs) {
        for (GameObject obj : objs) {
            super.objects.add(obj);
        }
    }

    public void getInput() {
    }
}
