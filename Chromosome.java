import java.util.Arrays;
import java.util.Random;

public class Chromosome {
  static Random randNum = new Random();
  private enum Actions {LEFT, UP, RIGHT, DOWN, WAIT}
  private Actions[] genes;
  private int fitness = 0;
  public Chromosome(int genomeLength) {
    genes = new int[genomeLength];
  }
  public Chromosome initChromosome() {
    for (int i = 0; i < genes.length; i++) {
      genes[i] = Actions.values()[randNum.nextInt(Actions.values().length)];
    }
    return this;
  }
  @Override
  public String toString() {
    return Arrays.toString(genes);
  }
  public Actions[] getGenes() {
    return genes;
  }
  public void setGene(int index, int value) {
    genes[index] = value;
  }
  public int calcFitness() {
    // add stuff to calculate distance in game with game class
  }
}
