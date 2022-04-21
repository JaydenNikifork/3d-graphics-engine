import java.awt.Graphics;
import java.lang.Math;

public class Camera {
    private float f = WindowConfig.SCREEN_WIDTH / 2;
    private Matrix pos = new Matrix(new float[][] {
        {0},
        {0},
        {0}
    });
    private Matrix rot = new Matrix(new float[][] {
        {0},
        {0},
        {0}
    });
    private Matrix camMtx = new Matrix(new float[][] {
        {f,0,WindowConfig.SCREEN_WIDTH/2,0},
        {0,f,WindowConfig.SCREEN_HEIGHT/2,0},
        {0,0,1,0}
    });
    private Cube cube = new Cube(
        new float[] {-100, 100, 0, 0},
        new float[] {-50, -50, 100, 150}, 
        new float[] {f, f, f+50, f+10000}
        );

    public Matrix[] convertTo2D(Matrix[] points) {
        int len = points.length;
        Matrix[] newPoints = new Matrix[len];

        for (int i = 0; i < len; i++) {
            newPoints[i] = camMtx.multiply(points[i]);
        }

        return newPoints;
    }

    public Matrix[] toPerspective(Matrix[] points) {
        int len = points.length;
        Matrix[] newPoints = new Matrix[len];
        Matrix temp;
        float z;

        for (int i = 0; i < len; i++) {
            z = points[i].getVal(2, 0);
            temp = new Matrix(new float[][]{
                {1/z,0,0},
                {0,1/z,0},
                {0,0,1}
                
            });
            newPoints[i] = temp.multiply(points[i]);
        }

        return newPoints;
    }

    public void drawCube(Graphics g) {
        Matrix[] points = cube.getPoints();
        points = convertTo2D(points);
        points = toPerspective(points);
        g.drawLine(Math.round(points[0].getVal(0, 0)), Math.round(points[0].getVal(1, 0)), Math.round(points[1].getVal(0, 0)), Math.round(points[1].getVal(1, 0)));
        g.drawLine(Math.round(points[1].getVal(0, 0)), Math.round(points[1].getVal(1, 0)), Math.round(points[2].getVal(0, 0)), Math.round(points[2].getVal(1, 0)));
        g.drawLine(Math.round(points[2].getVal(0, 0)), Math.round(points[2].getVal(1, 0)), Math.round(points[3].getVal(0, 0)), Math.round(points[3].getVal(1, 0)));
        g.drawLine(Math.round(points[3].getVal(0, 0)), Math.round(points[3].getVal(1, 0)), Math.round(points[0].getVal(0, 0)), Math.round(points[0].getVal(1, 0)));
        g.drawLine(Math.round(points[0].getVal(0, 0)), Math.round(points[0].getVal(1, 0)), Math.round(points[2].getVal(0, 0)), Math.round(points[2].getVal(1, 0)));
        g.drawLine(Math.round(points[1].getVal(0, 0)), Math.round(points[1].getVal(1, 0)), Math.round(points[3].getVal(0, 0)), Math.round(points[3].getVal(1, 0)));

    }
}
