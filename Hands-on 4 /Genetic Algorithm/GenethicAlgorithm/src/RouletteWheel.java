import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RouletteWheel {
    private int totalFitness;
    private List<Choice> choices;

    private class Choice {
        public Individual individual;
        public int fitness;
        public double probability;
        public double cumulative_probability;

        public Choice(Individual individual) {
            this.individual = individual;
            fitness = 0;
            probability = 0.0;
            cumulative_probability = 0.0;
            String chromosomeString = individual.getChromosome();
            for (char c : chromosomeString.toCharArray())
                if ( c == '1')
                    fitness += 1;
            if (fitness == 0)
                fitness = 1;
        }
    }
    
    private void CalculateProbabilities() {
        if (totalFitness == 0)
            return;
        double cumulative_probability = 0.0;
        for (Choice choice : choices) {
            if (choice.fitness > 0)
                choice.probability = (double)choice.fitness / totalFitness;
            else
                choice.probability = (double) 1 / totalFitness;
            cumulative_probability += choice.probability;
            choice.cumulative_probability = cumulative_probability;
        }
    }

    public RouletteWheel() {

    }

    public void setRouletteWheel(List<Individual> population) {
        totalFitness = 0;
        choices = new ArrayList<Choice>();
        for (Individual individual : population) {
            Choice choice = new Choice(individual);
            totalFitness += choice.fitness;
            choices.add(choice);
        }
        CalculateProbabilities();
    }

    public Individual SpinWheel() {
        Random random = new Random();
        Individual individual = null;
        double value = random.nextDouble(0, 1);
        for(Choice choice : choices) {
            if (value <= choice.cumulative_probability) {
                totalFitness -= choice.fitness;
                individual = choice.individual;
                choices.remove(choice);
                /*System.out.println("Value: " + value );
                System.out.println("Selected: " + choice.individual.getChromosome() );
            System.out.println("Cumulate Probability: " + choice.cumulative_probability );*/
            /*System.out.println("Fitness: " + choice.fitness );
            System.out.println("Probability: " + choice.probability ); */
                CalculateProbabilities();
                return individual;
            }
        }
        return individual;
    }

}
