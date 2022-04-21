import javax.swing.*;
import java.awt.*;

public class WindowConfig {
    final static int SCREEN_WIDTH = 1000;
    final static int SCREEN_HEIGHT = 800;

    public static void init() {
        Camera cam = new Camera();

        JPanel panel = new JPanel() {
            public void paint(Graphics g) {
                g.setColor(Color.BLACK);
                // g.fillPolygon(new int[] {100, 200, 150}, new int[] {100, 100, 200}, 3);
                cam.drawCube(g);
                // g.drawLine(100, 200, 200, 300);
            }
        };

        JFrame frame = new JFrame("3D Graphics Engine");
        frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().add(panel);
    }
}