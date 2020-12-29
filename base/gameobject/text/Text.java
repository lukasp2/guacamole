package base.gameobject.text;

import base.helpers.ID;
import base.helpers.Vector;
import base.gameobject.GameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

public class Text extends GameObject {
    public Text(String s, int size, Color color, Vector vector, Dimension dimension) {
        super(ID.Text, vector, dimension);
    }

    public void tick() {}

    public void render(Graphics g) {}
}
