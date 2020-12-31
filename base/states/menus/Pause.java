package base.states.menus;

import java.awt.event.KeyEvent;

public class Pause extends Menu {
    private static final long serialVersionUID = 6010686138069172337L;

    public Pause() {
        super.addTitle("Game Paused");
        super.addOptions("Resume", "Quit");
    }

    public void keyPressActions(int key) {
        super.keyPressActions(key);

        if (key == KeyEvent.VK_ENTER && kic.keyIsReady(key)) {
            if (currentOption == 0) {
                sm.pop(1);
            }
        }
    }
}