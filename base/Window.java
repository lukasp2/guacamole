package base;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Window extends Canvas {
    private static final long serialVersionUID = 2637057657081631720L;

    JFrame frame;

    public Window(String title, int width, int height) {
        frame = new JFrame();
        frame.setTitle(title);
        frame.setSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setFocusable(true);
    }

    public JFrame getFrame() {
        return frame;
    }
}
