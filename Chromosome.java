import javafx.scene.shape.Rectangle;

import java.util.Arrays;
import java.util.Random;

public class Chromosome {
  static Random randNum = new Random();
  private enum Actions {LEFT, UP, RIGHT, DOWN, WAIT}
  private Actions[] genes;
  int x;
  int y;
  AlgSquare square;
  private int fitness = 0;
  public Chromosome(int genomeLength, int squareX, int squareY) {
    x = squareX;
    y = squareY;
    square = new AlgSquare(x, y);
    genes = new Actions[genomeLength];
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
  public void setGene(int index, Actions value) {
    genes[index] = value;
  }
  public int calcFitness() {
    return (int) square.square.getY();
  }
}
