public class DataSet {
    private float x[];
    private float y[];

    public DataSet() {
        // x = new float[] {1, 3, 5, 7, 9};
        // y = new float[] {(float) 32.5, (float) 37.3, (float) 36.4, (float) 32.4, (float) 28.5};
        x = new float[] {-3, -2, -1, 0, 1, 2, 3};
        y = new float[] {(float)7.5, 3, (float)0.5, 1, 3, 6, 14};
    }

    public float[] getX() {
        return x;
    }

    public float[] getY() {
        return y;
    }
}
 