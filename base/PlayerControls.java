package base;

import java.util.HashMap;

public class PlayerControls {
    private HashMap<Integer, Runnable> actions = new HashMap<Integer, Runnable>();

    public PlayerControls() {}

    public void addAction(int key, Runnable action) {
        actions.put(key, action);
    }

    public Runnable getAction(int key) {
        return actions.get(key);
    }
}
