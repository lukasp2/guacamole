package base.states;

import base.PlayerControls;
import base.gameobject.living.Player;
import base.helpers.Pair;
import java.util.LinkedList;

public class Game extends State {
    private static final long serialVersionUID = -2181434414442395366L;

    LinkedList<Player> players = new LinkedList<Player>();

    // in the settings menu, you can add players and control player settings.
    // save that, and call Game(players).

    public Game() {
        System.out.println("HELLO");
        players.add(new Player(new PlayerControls(), new Pair(100, 200)));
        objects.addAll(players);
    }

    public void keyPressActions(int key) {
        super.keyPressActions(key);
        System.out.println("we are in the game and pressing keys!");

        for (Player p : players) {
            p.actOnKeyPress(kic, key);
        }
    }

    public void tick() {
        super.tick();
    }
}

// objects.add(new Object(ID.Object, new Vector(new Pair(100, 200), new Pair(0, 0)), new Dimension(80, 80)));