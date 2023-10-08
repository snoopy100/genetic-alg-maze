import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
  @Override
  public void start(Stage stage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Maze.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    /* for testing but not working
    for (int i = 20; i < 50; i += 10) {
      for (int j = 20; j < 380; j += 20) {
        AlgSquare pepe = new AlgSquare(i, j);
        pepe.add();
      }
    }*/
    stage.setScene(scene);
    stage.setTitle("AI solving maze");
    stage.show();
  }
  public static void main(String[] args) {
    launch(args);
  }
}
