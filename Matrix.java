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

    public float getVal(int m, int n) {
        return vals[m][n];
    }

    public void setVal(float val, int m, int n) {
        vals[m][n] = val;
    }
}
