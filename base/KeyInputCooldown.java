package base;

import java.util.Hashtable;

public class KeyInputCooldown {
    private class KeyMapEntry {
        public int cooldown;
        public long lastPressed;
        public KeyMapEntry(int cooldown, long lastPressed) {
            this.cooldown = cooldown;
            this.lastPressed = lastPressed;
        }
    }

    Hashtable<Integer, KeyMapEntry> ht = new Hashtable<Integer, KeyMapEntry>();

    public KeyInputCooldown() {}

    private void addKeyIfNotExists(int key) {
        if (! ht.containsKey(key)) {
            ht.put(key, new KeyMapEntry(100, -1));
        }
    }

    public void setCooldown(int key, int milliseconds) {
        ht.get(key).cooldown = milliseconds;
    }

    public int getCooldown(int key) {
        addKeyIfNotExists(key);
        return ht.get(key).cooldown;
    }

    public long getLastPressed(int key) {
        addKeyIfNotExists(key);
        return ht.get(key).lastPressed;
    }

    public boolean keyIsReady(int key) {
        addKeyIfNotExists(key);
        return System.currentTimeMillis() - ht.get(key).cooldown > ht.get(key).lastPressed;
    }

    public void pressKey(int key) {
        addKeyIfNotExists(key);
        ht.get(key).lastPressed = System.currentTimeMillis();
    }
}
