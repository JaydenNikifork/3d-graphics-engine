import javax.swing.*;
import java.awt.*;

public class WindowConfig {
    final static int SCREEN_WIDTH = 1000;
    final static int SCREEN_HEIGHT = 800;

    public static void init() {
        Camera cam = new Camera();
        Cube cube = new Cube(100, 100, 100);
        cube.move(-100, 30, 500);

        JPanel panel = new JPanel() {
            public void paint(Graphics g) {
                super.paint(g);
                g.setColor(Color.BLACK);
                cube.draw(g);
            }
        };

        JFrame frame = new JFrame("3D Graphics Engine");
        frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().add(panel);

        while (true) {
            // cube.move(0.000f, 0.0001f, 0);
            // System.out.println(cube.pos[0]);
            cube.rotate(0.000001f, 0.000002f, 0.000003f);
            // System.out.println("x: "+cube.points[0].x+" y: "+cube.points[1].y+" z: "+cube.points[2].z);
            
            panel.repaint();
        }
    }
}