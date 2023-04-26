public class DiscreteMaths {
    public DiscreteMaths() {}

    public float sum(float data[]) {
        float total = 0;

        for (float i : data)
            total += i;

        return total;
    }

    public float sumXY(float x[], float y[]) {
        float total = 0;

        for (int i=0; i < x.length; i++)
            total += x[i] * y[i];

        return total;
    }

    public float sumXsumY(float sumX, float sumY) {
        return sumX * sumY;
    }

    public float sumQuad(float data[]) {
        float total = 0;
        
        for (float i : data) {
            total += i*i;
        }

        return total;
    }
}
