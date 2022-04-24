import java.awt.Graphics;

public class Cube {
    public float[] pos = {0f, 0f, 0f};
    public float[] rot = {0f, 0f, 0f};
    public float[] scale;
    final private static Vec[] startingPoints = {
        new Vec(-0.5f, -0.5f, -0.5f),
        new Vec(-0.5f, 0.5f, -0.5f),
        new Vec(0.5f, 0.5f, -0.5f),
        new Vec(0.5f, -0.5f, -0.5f),
        new Vec(0.5f, -0.5f, 0.5f),
        new Vec(0.5f, 0.5f, 0.5f),
        new Vec(-0.5f, 0.5f, 0.5f),
        new Vec(-0.5f, -0.5f, 0.5f)
    };
    private float tempX, tempY, tempZ;
    
    public Vec[] points = new Vec[8];
    
    public Tri[] tris3D = {
        new Tri(startingPoints[0], startingPoints[1], startingPoints[2]),
        new Tri(startingPoints[0], startingPoints[2], startingPoints[3]),
        new Tri(startingPoints[3], startingPoints[2], startingPoints[5]),
        new Tri(startingPoints[3], startingPoints[5], startingPoints[4]),
        new Tri(startingPoints[4], startingPoints[5], startingPoints[6]),
        new Tri(startingPoints[4], startingPoints[6], startingPoints[7]),
        new Tri(startingPoints[7], startingPoints[6], startingPoints[1]),
        new Tri(startingPoints[7], startingPoints[1], startingPoints[0]),
        new Tri(startingPoints[7], startingPoints[0], startingPoints[4]),
        new Tri(startingPoints[7], startingPoints[3], startingPoints[4]),
        new Tri(startingPoints[1], startingPoints[6], startingPoints[5]),
        new Tri(startingPoints[1], startingPoints[5], startingPoints[2])
    };


    public Cube(float xScale, float yScale, float zScale) {
        scale = new float[] {xScale, yScale, zScale};
        points = startingPoints.clone();
    }


    public void move(float x, float y, float z) {
        pos[0] += x;
        pos[1] += y;
        pos[2] += z;
        updatePoints();
    }


    public void rotate(float x, float y, float z) {
        rot[0] += x;
        rot[1] += y;
        rot[2] += z;
        updatePoints();
    }


    public void scale(float x, float y, float z) {
        scale[0] *= x;
        scale[1] *= y;
        scale[2] *= z;
        updatePoints();
    }


    private void updatePoints() {
        points = new Vec[] {
            new Vec(-0.5f, -0.5f, -0.5f),
            new Vec(-0.5f, 0.5f, -0.5f),
            new Vec(0.5f, 0.5f, -0.5f),
            new Vec(0.5f, -0.5f, -0.5f),
            new Vec(0.5f, -0.5f, 0.5f),
            new Vec(0.5f, 0.5f, 0.5f),
            new Vec(-0.5f, 0.5f, 0.5f),
            new Vec(-0.5f, -0.5f, 0.5f)
        };
        
        for (Vec point : points) {
            // Scale
            point.x *= scale[0];
            point.y *= scale[1];
            point.z *= scale[2];

            // Rotate
            tempY = point.y;
            point.y = point.y * (float) Math.cos(rot[0]) - point.z * (float) Math.sin(rot[0]);
            point.z = tempY * (float) Math.sin(rot[0]) + point.z * (float) Math.cos(rot[0]);
            tempX = point.x;
            point.x = point.x * (float) Math.cos(rot[1]) + point.z * (float) Math.sin(rot[1]);
            point.z = -tempX * (float) Math.sin(rot[1]) + point.z * (float) Math.cos(rot[1]);
            tempX = point.x;
            point.x = point.x * (float) Math.cos(rot[2]) - point.y * (float) Math.sin(rot[2]);
            point.y = tempX * (float) Math.sin(rot[2]) + point.y * (float) Math.cos(rot[2]);

            // Translate
            point.x += pos[0];
            point.y += pos[1];
            point.z += pos[2];
        }

        tris3D = new Tri[] {
            new Tri(points[0], points[1], points[2]),
            new Tri(points[0], points[2], points[3]),
            new Tri(points[3], points[2], points[5]),
            new Tri(points[3], points[5], points[4]),
            new Tri(points[4], points[5], points[6]),
            new Tri(points[4], points[6], points[7]),
            new Tri(points[7], points[6], points[1]),
            new Tri(points[7], points[1], points[0]),
            new Tri(points[7], points[0], points[3]),
            new Tri(points[7], points[3], points[4]),
            new Tri(points[1], points[6], points[5]),
            new Tri(points[1], points[5], points[2])
        };
    }

    
    public void draw(Graphics g) {
        for (Tri tri : tris3D) {
            if (new Vec(tri.p1.x, tri.p1.y, tri.p1.z).dotProd(tri.normal().normalize()) < 0) {
                Camera.toPerspective(Camera.to2D(tri)).draw(g);
            }
            // System.out.println(Camera.to2D(tri).p1.x);
        }
    }
}
