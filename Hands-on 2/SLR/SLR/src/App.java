public class App {
    public static void main(String[] args) throws Exception {
        SLR slr = new SLR();
        float beta0 = slr.getBeta0();
        float beta1 = slr.getBeta1();
        System.out.println("Beta 0: " + beta0);
        System.out.println("Beta 1: " + beta1);
        System.out.println("Equation: y = " + beta0  + " + " + beta1 + "x");
        System.out.println("Predict 40: " + slr.toPredict(40));
        System.out.println("Predict 50: " + slr.toPredict(50));
        System.out.println("Predict 60: " + slr.toPredict(60));

    }
}
