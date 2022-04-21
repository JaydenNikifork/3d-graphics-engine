public class Cube {
    private Matrix[] cube = new Matrix[4];

    public Cube(float[] xCoords, float[] yCoords, float[] zCoords) {
        for (int i = 0; i < 4; i++) {
            cube[i] = new Matrix(new float[][] {
                {xCoords[i]},
                {yCoords[i]},
                {zCoords[i]},
                {1}
            });
        }
    }

    public Matrix[] getPoints() {
        return cube;
    }
}
