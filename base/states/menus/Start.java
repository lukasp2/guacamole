package base.states.menus;

import java.awt.event.KeyEvent;

import base.states.Game;

public class Start extends Menu {
    private static final long serialVersionUID = -2011243664367333350L;

    public Start() {
        super.addTitle("Main Menu");
        super.addOptions("start game", "game settings", "high score", "exit");
    }

    public void keyPressActions(int key) {
        super.keyPressActions(key);
        if (key == KeyEvent.VK_ENTER && kic.keyIsReady(key)) {
            if (currentOption == 0) {
                sm.push(new Game());
            }
            if (currentOption == 1) {
                sm.push(new Settings());
            }
            if (currentOption == 2) {
                System.out.println("High score!");
            }
            if (currentOption == 3) {
                System.out.println("Exit!");
            }
            kic.pressKey(key);
        }
    }

    public void tick() {
        super.tick();
    }
}    

