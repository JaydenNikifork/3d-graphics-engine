import java.lang.Math;

public class Vec {
    public float x, y, z, mag;

    public Vec(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        mag = (float)Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }


    public Vec(float x, float y) {
        this.x = x;
        this.y = y;
    }


    public float dotProd(Vec vec) {
        return x * vec.x + y * vec.y + z * vec.z;
    }


    public Vec normalize() {
        return new Vec(x / mag, y / mag, z / mag);
    }
}
