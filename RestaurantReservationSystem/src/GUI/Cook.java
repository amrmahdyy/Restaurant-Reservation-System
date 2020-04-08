package GUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import backend.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Cook implements Initializable {

    @FXML
    private TextArea textarea;

    @FXML
    private Button showorder;
    Waiter w=new Waiter();
    Cooker c=new Cooker();




    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    @FXML
    void showOrder(ActionEvent event) {
        textarea.setStyle("-fx-control-inner-background-: #F2BC94");

        System.out.println(c.getMealsArray()+"\t\t\t"+c.mealsArray(0));
        for (int i = 0; i < c.getMealsArray(); i++) {
            textarea.appendText(c.mealsArray(i)+"\t\t\t"+w.getclientTableNumberArray(i)+"\n");


        }

        showorder.setDisable(true);

    }

    @FXML
    void logout(MouseEvent event) throws IOException {
        Parent sample = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene user2=new Scene(sample);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(user2);
        window.show();

    }


}
