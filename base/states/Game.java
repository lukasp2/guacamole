package base.states;

import base.KeyInput;
import base.PlayerControls;
import base.gameobject.living.Player;
import base.helpers.Pair;

import java.util.LinkedList;

public class Game extends State {
    private static final long serialVersionUID = -2181434414442395366L;

    LinkedList<Player> players = new LinkedList<Player>();

    // in the settings menu, you can add players and control player settings.
    // save that, and call Game(players).

    // 1. we need to invalidate the keyboard listner in Start. it is still running.
    public Game() {
        System.out.println("HELLO");
        players.add(new Player(new PlayerControls(), new Pair(100, 200)));
        objects.addAll(players);
    }

    public void keyPressActions(int key) {
        super.keyPressActions(key);
        System.out.print("we are in the game and pressing keys!");

        for (Player p : players) {
            p.actOnKeyPress(kic, key);
        }
    }

    public void tick() {
        super.tick();
    }
}
