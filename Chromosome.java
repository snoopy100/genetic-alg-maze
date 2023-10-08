import javafx.fxml.FXMLLoader;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Chromosome {
  static Random randNum = new Random();
  public static enum Actions {
    LEFT, UP, RIGHT, DOWN
  }
  private Actions[] genes;
  int x;
  int y;
  AlgSquare square;
  private int fitness = 0;
  public Chromosome(int genomeLength, int squareX, int squareY) throws IOException {
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
  public void display() throws IOException {
    square.add(new FXMLLoader(getClass().getResource("/Maze.fxml")).getController());
    for (Actions i: genes) {
      switch (i) {
        case LEFT -> x--;
        case RIGHT -> x++;
        case UP -> y--;
        case DOWN -> y++;
      }
    }
  }
}
