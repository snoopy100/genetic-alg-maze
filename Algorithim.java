import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.Random;

public class Algorithim {
    int genNumber = 0;
  public static int POP_SIZE;
  public static int length = 5;
  public Algorithim(int popSize) {
    POP_SIZE = popSize;
  }
  public Population evolvePopulation(Population pop) throws IOException {
    Population evolvePop = mutatePopulation(crossoverPopulation(pop));
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/Maze.fxml"));
      Parent tmpVar = loader.load();
      Controller controller = loader.getController();
      controller.genNumber.setText("Generation number: " + genNumber);
      genNumber++;
    return evolvePop;
  }
  public Population crossoverPopulation(Population pop) throws IOException {
      length++;
      pop.sortChromosomesByFitness();
      Chromosome c1 = pop.getChromosomes()[0];
      Chromosome c2 = pop.getChromosomes()[2];
      Population newPop = new Population(POP_SIZE, length);
      newPop.initPopulation();
      for (int i = 0; i < POP_SIZE; i++) {
          for (int j = 0; j < length -2; j++) {
              Chromosome.Actions newGene;
              if (Math.random() > 0.5) {
                  newGene = c1.getGenes()[j];
              } else {
                  newGene = c2.getGenes()[j];
              }
              newPop.getChromosomes()[i].setGene(j, newGene);
          }
          newPop.getChromosomes()[i].setGene(length - 1, Chromosome.Actions.values()[new Random().nextInt(Chromosome.Actions.values().length)]);
      }
      return newPop;
  }
  public Population mutatePopulation(Population pop) {
      for (int i = 0; i < 15; i++)  {
          for (int j = 0; j < length; j++) {
              if (Math.random() > 0.02) {
                  pop.getChromosomes()[i].setGene(j, Chromosome.Actions.values()[new Random().nextInt(Chromosome.Actions.values().length)]);
              }
          }
      }
      return pop;
  }
}