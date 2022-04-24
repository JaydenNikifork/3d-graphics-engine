import java.awt.Graphics;
import java.lang.Math;

public class Camera {
    private static float f = WindowConfig.SCREEN_WIDTH / 2;
    private static Vec pos = new Vec(0, 0, 0);
    private static Vec rot = new Vec(0, 0, 0);
    
    private static Matrix camMtx = new Matrix(new float[][] {
        {f,0,0},
        {0,f,0},
        {0,0,1}
    });


    public static Tri to2D(Tri tri) {
        return new Tri(
            new Matrix(new float[][]{{f,0,0},{0,f,0},{0,0,1}}).matrixVecMultiply(new Vec(tri.p1.x-pos.x, tri.p1.y-pos.y, tri.p1.z-pos.z)),
            new Matrix(new float[][]{{f,0,0},{0,f,0},{0,0,1}}).matrixVecMultiply(new Vec(tri.p2.x-pos.x, tri.p2.y-pos.y, tri.p2.z-pos.z)),
            new Matrix(new float[][]{{f,0,0},{0,f,0},{0,0,1}}).matrixVecMultiply(new Vec(tri.p3.x-pos.x, tri.p3.y-pos.y, tri.p3.z-pos.z))
        );
    }


    public static Tri toPerspective(Tri tri) {
        return new Tri(
            new Matrix(new float[][]{{1/tri.p1.z,0,0},{0,1/tri.p1.z,0},{0,0,1}}).matrixVecMultiply(tri.p1),
            new Matrix(new float[][]{{1/tri.p2.z,0,0},{0,1/tri.p2.z,0},{0,0,1}}).matrixVecMultiply(tri.p2),
            new Matrix(new float[][]{{1/tri.p3.z,0,0},{0,1/tri.p3.z,0},{0,0,1}}).matrixVecMultiply(tri.p3)
        );
    }
}
