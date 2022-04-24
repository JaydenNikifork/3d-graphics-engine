public class Matrix {
    private float[][] vals;

    public Matrix(float[][] matrix) {
        vals = matrix;
    }

    public Matrix multiply(Matrix mtx) {
        int m = vals.length;
        int n1 = vals[0].length;
        int n2 = mtx.vals[0].length;
        float[][] newVals = new float[m][n2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n2; j++) {
                for (int k = 0; k < n1; k++) {
                    newVals[i][j] += vals[i][k] * mtx.vals[k][j];
                }
            }
        }

        return new Matrix(newVals);
    }

    public Vec matrixVecMultiply(Vec vec) {
        return new Vec(
            vals[0][0] * vec.x + vals[0][1] * vec.y + vals[0][2] * vec.z,
            vals[1][0] * vec.x + vals[1][1] * vec.y + vals[1][2] * vec.z,
            vals[2][0] * vec.x + vals[2][1] * vec.y + vals[2][2] * vec.z
        );
    }

    public float getVal(int m, int n) {
        return vals[m][n];
    }

    public void setVal(float val, int m, int n) {
        vals[m][n] = val;
    }
}
