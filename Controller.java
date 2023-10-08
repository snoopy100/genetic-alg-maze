import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class Controller {
    @FXML Button goButton;
    @FXML AnchorPane anchorPane;
    @FXML Rectangle r1;
    @FXML Rectangle r2;
    @FXML Rectangle r3;
    @FXML Rectangle r4;
    @FXML Rectangle r5;
    @FXML Rectangle r6;
    @FXML Label genNumber;
    public void go() throws IOException {
        Algorithim alg = new Algorithim(15);
        Population pop = new Population(15, Algorithim.length).initPopulation();
        pop.sortChromosomesByFitness();
        while (pop.getChromosomes()[0].calcFitness() > 331) {
            for (int i = 0; i < 15; i++) {
                pop.getChromosomes()[i].display();
            }
            pop = alg.evolvePopulation(pop);
        }
        goButton.setOnAction(e -> System.out.println("why are you still pressing me"));
    }
}
// everything being claled but not siplayed