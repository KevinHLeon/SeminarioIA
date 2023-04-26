public class QLR {
    private float beta0;
    private float beta1;
    private float beta2;
    private int n;
    private float sumX;
    private float sumY;
    private float sumX2;
    private float sumX3;
    private float sumX4;
    private float sumXY;
    private float sumX2Y;

    private float Exx;
    private float Exy;
    private float Exx2;
    private float Ex2y;
    private float Ex2x2;

    DataSet dataSet = new DataSet();
    DiscreteMaths discreteMaths = new DiscreteMaths();

    private void computeBeta0() {
        beta0 = sumY/n - beta1*sumX/n - beta2*sumX2/n;
    }
    private void computeBeta1() {
        beta1 = (Exy*Ex2x2-Ex2y*Exx2)/(Exx*Ex2x2-Exx2*Exx2);
    }
    private void computeBeta2() {
        beta2 = (Ex2y*Exx-Exy*Exx2)/(Exx*Ex2x2-Exx2*Exx2);
    }

    private void Summatories() {
        n = dataSet.getX().length;

        sumX = discreteMaths.sum(dataSet.getX());
        sumY = discreteMaths.sum(dataSet.getY());
        sumX2 = discreteMaths.sumQuad(dataSet.getX());
        sumX3 = discreteMaths.sumCub(dataSet.getX());
        sumX4 = discreteMaths.sumPow(dataSet.getX());
        sumXY = discreteMaths.sumXY(dataSet.getX(), dataSet.getY());
        sumX2Y = discreteMaths.sumXsqY(dataSet.getX(), dataSet.getY());

        Exx = sumX2 - sumX * sumX / n;
        Exy = sumXY - sumX * sumY / n;
        Exx2 = sumX3 - sumX2 * sumX / n;
        Ex2y =  sumX2Y - sumX2 * sumY / n;
        Ex2x2 = sumX4 - sumX2 * sumX2 / n;
    }

    public QLR() {
        beta0 = 0;
        beta1 = 0;
        beta2 = 0;

        Summatories();

        computeBeta2();
        computeBeta1();
        computeBeta0();
    }

    public float getBeta0(){
        return beta0;
    }
    
    public float getBeta1(){
        return beta1;
    }

    public float getBeta2(){
        return beta2;
    }

    public float toPredict(float x) {
        float y = 0;
        y = beta0 + beta1 * x + beta2 * x * x;
        return y;   
    }
  
}
