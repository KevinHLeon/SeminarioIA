public class App {
    public static void main(String[] args) throws Exception {
        QLR qlr = new QLR();
        float beta0 = qlr.getBeta0();
        float beta1 = qlr.getBeta1();
        float beta2 = qlr.getBeta2();
        System.out.println("Beta 0: " + beta0);
        System.out.println("Beta 1: " + beta1);
        System.out.println("Beta 2: " + beta2);
        System.out.println("Equation: y = (" + beta0  + ") + (" + beta1 + ")x" 
                            + " + (" + beta2 + ")x2");
        System.out.println("Predict 2: " + qlr.toPredict(2));
        System.out.println("Predict 4: " + qlr.toPredict(4));
        System.out.println("Predict 6: " + qlr.toPredict(6));

    }
}
