import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
  @Override
  public void start(Stage stage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Maze.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    Controller controller = loader.getController();
    stage.setScene(scene);
    stage.setTitle("AI solving maze");
    stage.show();

    Algorithim alg = new Algorithim(15);
    Population pop = new Population(15, Algorithim.length).initPopulation();
    pop.sortChromosomesByFitness();
    while (pop.getChromosomes()[0].calcFitness() < 331) {
      for (int i = 0; i < 15; i++) {
        pop.getChromosomes()[i].display();
      }
      pop = alg.evolvePopulation(pop);
    }
  }
  public static void main(String[] args) throws IOException {
    launch(args);
    /* code for running GA but it is not being run
    Algorithim alg = new Algorithim(15);
    Population pop = new Population(15, Algorithim.length).initPopulation();
    pop.sortChromosomesByFitness();
    while (pop.getChromosomes()[0].calcFitness() < 331) {
      for (int i = 0; i < 15; i++) {
        pop.getChromosomes()[i].display();
      }
      pop = alg.evolvePopulation(pop);
    } */
  }
}
