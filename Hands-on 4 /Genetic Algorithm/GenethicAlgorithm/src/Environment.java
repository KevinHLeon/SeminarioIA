import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Environment {
    private List<Individual> population;
    private List<Individual> parents;
    private List<Individual> newPopulation;
    private RouletteWheel rouletteWheel;
    private static int populationSize = 20;
    private static double crossoverRate = .50;
    private static double mutationRate = .40;

    public Environment() {
        population = new ArrayList<>();
        newPopulation = new ArrayList<>();
        parents = new ArrayList<>();
    }

    public void Initialize() {
        population.clear();
        for(int i = 0; i < populationSize; i++)
            population.add(new Individual());
        rouletteWheel = new RouletteWheel();
    }

    public boolean Evaluate() {
        int fitness;
         for (Individual individual : population) {
            fitness = 0;
            for (char c : individual.getChromosome().toCharArray())
                if ( c == '1')
                    fitness += 1;
            if (fitness == individual.getChromosome().length()){
                return true;
            }
        }
        return false;
    }

    public void Selection() {
        /*System.out.println("Population: ");
        showPopulation(population);*/
        rouletteWheel.setRouletteWheel(population);
        while ((double) parents.size() / populationSize < crossoverRate) {
            if (population.size() < 2)
                break;
            Individual parent1 = rouletteWheel.SpinWheel();
            Individual parent2 = rouletteWheel.SpinWheel();
            parents.add(parent1);
            parents.add(parent2);
            population.remove(parent1);
            population.remove(parent2);
        }

    }

    public void Recombine() {
        /*System.out.println("Parents: ");
        showPopulation(parents);*/
        
        while(parents.size() > 0) {
            Individual parent1 = parents.get(0);
            parents.remove(0);
            Individual parent2 = parents.get(0);
            parents.remove(0);
            Individual son1 = new Individual(parent1, parent2);
            Individual son2 = new Individual(parent2, parent1);
            newPopulation.add(son1);
            newPopulation.add(son2);
        }
        /*System.out.println("New Population: ");
        showPopulation(newPopulation);*/
    }

    public void Mutation() {
        Random random = new Random();
        for (int i = 0; i < newPopulation.size(); i++) {
            double randomValue = random.nextDouble(0, 1);
            if(randomValue <= mutationRate){
                Individual individual = newPopulation.get(i);
                individual.Mutate();
                newPopulation.set(i, individual);
            }
        }

        for (Individual individual : newPopulation) {
            population.add(individual);
            
        }
        newPopulation.clear();

        /*System.out.println("Mutated Population: ");
        showPopulation(newPopulation);*/
        System.out.println("Population: ");
        showPopulation(population);

    }


    public void showPopulation(List<Individual> population) {
        for (Individual individual : population) {
            System.out.println("\"" + individual.getChromosome()+"\"");
        }
    }
}

