import java.util.Random;

public class Individual {
    private static byte chromosome_size = 20;
    private String chromosome;

    public Individual() {
        chromosome = "";
        Random random = new Random();
        for (int i=0; i < chromosome_size; ++i) {
            int gene = random.nextInt(2);
            chromosome += Integer.toString(gene);
        }
    }

    public Individual(Individual parent1, Individual parent2) {
        chromosome = "";
        String chromoParent1 = parent1.getChromosome();
        String chromoParent2 = parent2.getChromosome();
        int middlePoint = (chromosome_size -1) / 2 + 1;
        chromosome += chromoParent1.substring(0, middlePoint);
        chromosome += chromoParent2.substring(middlePoint);
    }

    public String getChromosome() {
        return chromosome;
    }

    public void Mutate() {
        Random random = new Random();
        int mutateIdx = random.nextInt(chromosome_size);
        char mutateGene = chromosome.charAt(mutateIdx);

        if (mutateGene == '0')
            mutateGene = '1';
        else
            mutateGene = '0';

        StringBuilder sb = new StringBuilder(chromosome);
        sb.setCharAt(mutateIdx, mutateGene);
        chromosome = sb.toString();
    }
}
