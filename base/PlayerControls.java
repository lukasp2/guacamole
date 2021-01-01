package base;

import java.util.HashMap;

public class PlayerControls {
    private HashMap<Integer, Runnable> actions = new HashMap<Integer, Runnable>();

    // used as boolean so we can stop actions when key is released
    private Integer keyPressed;

    public void addAction(int key, Runnable action) {
        actions.put(key, action);
    }

    public Integer keyIsPressed() {
        return keyPressed;
    }

    public void runPressAction(int key) {
        keyPressed = 1;
        actions.get(key).run();
    }

    public void runReleaseAction(int key) {
        keyPressed = 0;
        actions.get(key).run();
    }

    public boolean has(int key) {
        return actions.containsKey(key);
    }
}
