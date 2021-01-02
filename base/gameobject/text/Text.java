package base.gameobject.text;

import base.helpers.ID;
import base.helpers.Vector;
import base.gameobject.GameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Font;

public class Text extends GameObject {
    public String str;
    public Color color;
    public Font font;

    public Text(String str, String font, int size, Color color, int fontstyle, Vector vector) {
        super(ID.Text, vector, new Dimension(0, 0));
        this.font = new Font(font, fontstyle, size);
        this.str = str;
        this.color = color;
    }

    public void render(Graphics g) {
        g.setFont(font);
        g.setColor(color);
        g.drawString(str, vector.getPosition().getX(), vector.getPosition().getY());
    }
}
