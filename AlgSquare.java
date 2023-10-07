import javafx.fxml.FXMLLoader;
import javafx.scene.shape.Rectangle;
public class AlgSquare {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Maze.fxml"));
    Controller controller = loader.getController();
    Rectangle square;
    public AlgSquare(int x, int y) {
        square = new Rectangle();
        square.setX(x);
        square.setY(y);
        square.setHeight(10);
        square.setWidth(10);
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
