package base.states.menus;

import java.awt.event.KeyEvent;

public class Settings extends Menu {
    private static final long serialVersionUID = -8133856754836385760L;

    private int playerControlsToModify = 1;
    private int numPlayers = 1;
    private int volume = 50;

    public Settings() {
        super.addTitle("Main Menu");
        super.addOptions("number of players", "player controls", "sound", "back");
    }

    public void keyPressActions(int key) {
        super.keyPressActions(key);
        
        // increase num players ()
        if (currentOption == 0 && key == KeyEvent.VK_RIGHT && kic.keyIsReady(key)) {
            ++numPlayers;
            kic.pressKey(key);
        }
        //decrease num players
        if (currentOption == 0 && key == KeyEvent.VK_LEFT && kic.keyIsReady(key)) {
            --numPlayers;
            kic.pressKey(key);
        }

        // change what player's controls to modify
        if (currentOption == 1 && key == KeyEvent.VK_RIGHT && kic.keyIsReady(key) && playerControlsToModify < numPlayers) {
            ++playerControlsToModify;
            kic.pressKey(key);
        }
        if (currentOption == 1 && key == KeyEvent.VK_LEFT && kic.keyIsReady(key) && playerControlsToModify != 1) {
            --playerControlsToModify;
            kic.pressKey(key);
        }

        // increase volume
        if (currentOption == 2 && key == KeyEvent.VK_RIGHT && kic.keyIsReady(key)) {
            volume += 5;
            kic.pressKey(key);
        }
        //decrease volume
        if (currentOption == 2 && key == KeyEvent.VK_LEFT && kic.keyIsReady(key)) {
            volume -= 5;
            kic.pressKey(key);
        }

        // back to main menu
        if (currentOption == 3 && key == KeyEvent.VK_ENTER && kic.keyIsReady(key)) {

            // create an instance of the Settings (a new class) class and return it?
            // or StateMachine has a Settings object.
            sm.pop(1);
        }
    }

    public void tick() {
        super.tick();

        // modify objects based on:
        // - num players
        // - the active player's controls
        // - volume
    }
}
