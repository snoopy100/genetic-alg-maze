import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class AlgSquare {
    int x, y;
    String id;
    FXMLLoader loader;
    Parent root;
    Controller controller;
    Rectangle square;
    public AlgSquare(int x, int y) throws IOException {
        loader = new FXMLLoader(getClass().getResource("/Maze.fxml"));
        root = loader.load();
        controller = loader.getController();
        square = new Rectangle();
        square.setX(x);
        square.setY(y);
        square.setHeight(10);
        square.setWidth(10);

    }
    public void add(Controller controll) {
        square.setId(this.toString());
        id = square.getId();
        controll.anchorPane.getChildren().add(square);
        System.out.println(controll.anchorPane.getChildren().contains(square));
    }
    public boolean isTouching() {
        if (square.getBoundsInParent().intersects(controller.r1.getBoundsInParent())) {
            return true;
        } else if (square.getBoundsInParent().intersects(controller.r2.getBoundsInParent())) {
            return true;
        } else if (square.getBoundsInParent().intersects(controller.r3.getBoundsInParent())) {
            return true;
        }else if (square.getBoundsInParent().intersects(controller.r4.getBoundsInParent())) {
            return true;
        } else if (square.getBoundsInParent().intersects(controller.r5.getBoundsInParent())) {
            return true;
        }else if (square.getBoundsInParent().intersects(controller.r6.getBoundsInParent())) {
            return true;
        }
        return false;
    }
}
