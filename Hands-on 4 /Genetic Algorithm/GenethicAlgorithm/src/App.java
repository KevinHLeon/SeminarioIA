public class App {
    public static void main(String[] args) throws Exception {
        int i = 1;
         Environment environment = new Environment();
         environment.Initialize();
         while (!environment.Evaluate()) {
            System.out.println("Iteración: " + i);
             environment.Selection();
             environment.Recombine();
             environment.Mutation();
             i++;
         }

    }
}
