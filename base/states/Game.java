package base.states;

import base.PlayerControls;
import base.gameobject.living.Player;
import base.helpers.Pair;
import base.states.menus.Pause;

import java.util.Arrays;
import java.util.LinkedList;
import java.awt.event.KeyEvent;

public class Game extends State {
    private static final long serialVersionUID = -2181434414442395366L;

    LinkedList<Player> players = new LinkedList<Player>();

    // TODO:
    // variable: GameSettings gameSettings.
    //              contains map level, num players
    // at start, call: Game(gameSettings)

    public Game() {
        // fetch settings from the gameSettings 
        players.add(new Player(new PlayerControls(), new Pair(100, 200)));
        objects.addAll(players);
    }

    public void keyPressActions(int key) {
        super.keyPressActions(key);
        
        for (Player p : players) {
            p.actOnKeyPress(kic, key);
        }

        if (key == KeyEvent.VK_P && kic.keyIsReady(key)) {
            this.sm.push(new Pause());
        }
    }

    public void keyReleaseActions(int key) {
        super.keyReleaseActions(key);

        for (Player p : players) {
            p.actOnKeyRelease(kic, key);
        }
    }

    public void tick() {
        super.tick();
    }
}

// objects.add(new Object(ID.Object, new Vector(new Pair(100, 200), new Pair(0, 0)), new Dimension(80, 80)));