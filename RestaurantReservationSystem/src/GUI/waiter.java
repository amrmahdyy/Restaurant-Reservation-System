package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import backend.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class waiter implements Initializable {
    Customer c1 = new Customer();
    ReadClientData read = new ReadClientData();
    Waiter w=new Waiter();
    Manager manager=new Manager();


    @FXML
    private Button showOrder;

    @FXML
    private TextArea textArea;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void displayOrder(ActionEvent event) {


          textArea.appendText("\n");
//       for (int i = 0; i < (read.finalLength("client", "name"))-1; i++) {
//
//            for (int j = i + 1; j < read.finalLength("client", "name"); j++) {
//
//
//                if (!(c1.getClientNameDataArray(i).equals(c1.getClientNameDataArray(j)) && (i != j))) {
//
//                    textArea.appendText(c1.getClientNameDataArray(i) + "\t\t" + w.getclientTableNumberArray(i)+"\n");
//                }
//             if ((c1.getClientNameDataArray(i).equals(c1.getClientNameDataArray(j)) && (i != j))) {
//                    textArea.appendText(c1.getClientNameDataArray(i) + "\t\t\t" + w.getclientTableNumberArray(i) + "\n");
//                }
//                break;
//            }
//
//        }

        int[] stringToNumber = new int[read.getLength("client", "table")];
        int[] arr = new int[read.getLength("client", "table")];
        for (int i = 0; i < read.getLength("client", "table"); i++) {
            stringToNumber[i] = Integer.parseInt(w.getclientTableNumberArray(i));
            arr[i] = stringToNumber[i];
        }
        int length = arr.length;
        Manager manager = new Manager();
        length = manager.removeDuplicateElements(arr, length);
        Customer c1 = new Customer();
        //printing array elements
        for (int i = 0; i < length; i++)
            textArea.appendText((i + 1)+") " + c1.getClientNameDataArray(i)+"\t\t\t" + arr[i] + "\n");
        showOrder.setDisable(true);


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
