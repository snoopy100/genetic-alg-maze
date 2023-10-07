import java.util.Arrays;

public class Population {
  private Chromosome[] chromosomes;
  public Population(int popSize) {
    chromosomes = new Chromosome[popSize];
  }
  public Population initPopulation() {
    for (int i = 0; i < chromosomes.length; i++) {
      chromosomes[i] = new Chromosome(Algorithim.SOLUTION.length).initChromosome();
    }
    sortChromosomesByFitness();
    return this;
    }
  public void sortChromosomesByFitness() {
    Arrays.sort(chromosomes,(chrom1,chrom2) -> {
        int flag = 0;
        if(chrom1.calcFitness() > chrom2.calcFitness())
            flag=-1;
        else if (chrom1.calcFitness() < chrom2.calcFitness()) 
            flag=1;
        return flag;

    });
  }
  public Chromosome[] getChromosomes() {
    return chromosomes;
  }
}
