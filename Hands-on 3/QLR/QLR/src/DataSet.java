public class DataSet {
    private float x[];
    private float y[];

    public DataSet() {
        x = new float[] {1, 3, 5, 7, 9};
        y = new float[] {(float) 32.5, (float) 37.3, (float) 36.4, (float) 32.4, (float) 28.5};
    }

    public float[] getX() {
        return x;
    }

    public float[] getY() {
        return y;
    }
}
 