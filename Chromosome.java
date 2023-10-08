import javafx.fxml.FXML;
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
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Maze.fxml"));
    loader.load();
    Controller controll = loader.getController();
    square.add(controll);
    while (square.isTouching()) {
      for (Actions i: genes) {
        switch (i) {
          case LEFT:
            square.x--;
            square.square.setX(square.x);
            break;
          case RIGHT:
            square.x++;
            square.square.setX(square.x);
            break;
          case UP:
            square.y--;
            square.square.setY(square.y);
            break;
          case DOWN:
            square.y++;
            square.square.setY(square.y);
            System.out.println("no");
            break;
          }
          controll.anchorPane.setPrefWidth(Math.random() + 599.5);
      }
    }
    System.out.println(controll.anchorPane.getPrefWidth());
    System.out.println("yes");
    controll.anchorPane.getChildren().remove(square);
  }
}
