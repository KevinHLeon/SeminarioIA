public class SLR {
    private float beta0;
    private float beta1;
    private int n;
    private float sumX;
    private float sumY;
    private float sumXY;
    private float sumXsumY;
    private float sumXsumX;
    private float sumXquad;

    DataSet dataSet = new DataSet();
    DiscreteMaths discreteMaths = new DiscreteMaths();

    private void computeBeta0() {
        beta0 = (sumY - beta1 * sumX) / n;
    }
    private void computeBeta1() {
        beta1 = (n * sumXY - sumXsumY) /
                (n * sumXquad - sumXsumX);
    }
    public SLR() {
        beta0 = 0;
        beta1 = 0;
        n = dataSet.getX().length;
        sumX = discreteMaths.sum(dataSet.getX());
        sumY = discreteMaths.sum(dataSet.getY());
        sumXY = discreteMaths.sumXY(dataSet.getX(), dataSet.getY());
        sumXsumY = discreteMaths.sumXsumY(sumX, sumY);
        sumXsumX = discreteMaths.sumXsumY(sumX, sumX);
        sumXquad = discreteMaths.sumQuad(dataSet.getX());
        computeBeta1();
        computeBeta0();
    }

    public float getBeta0(){
        return beta0;
    }
    
    public float getBeta1(){
        return beta1;
    }

    public float toPredict(float x) {
        float y = 0;
        y = beta0 + beta1 * x;
        return y;   
    }
  
}
