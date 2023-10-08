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
  }
  public static void main(String[] args) throws IOException {
    launch(args);
  }
}
