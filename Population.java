import java.io.IOException;
import java.util.Arrays;

public class Population {
  private Chromosome[] chromosomes;
  int genomeSize;
  public Population(int popSize, int length) {
    chromosomes = new Chromosome[popSize];
    genomeSize = length;
  }
  public Population initPopulation() throws IOException {
    for (int i = 0; i < chromosomes.length; i++) {
      chromosomes[i] = new Chromosome(genomeSize, 20, 350).initChromosome();
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
  public void display() throws Exception {
      for (Chromosome i : chromosomes) {
          i.display();
      }
  }
}
