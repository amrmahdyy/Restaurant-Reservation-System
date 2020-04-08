package GUI;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import backend.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MANAGER implements Initializable {
    @FXML
    private ResourceBundle resources;
    @FXML
    private TextArea totalprice_area1;
    @FXML
    private URL location;
    Cooker c1 = new Cooker();
    ReadClientData read=new ReadClientData();
  Customer customer=new Customer();
  Manager manager=new Manager();
  Waiter w1=new Waiter();
    @FXML
    private TextArea totalprice_area;

    @FXML
    private Button showTotalprice;


    @FXML
    private Pane pi_order;

    @FXML
    private Rectangle rec_order;


    @FXML
    private TextArea clientName;

    @FXML
    private TextArea orders;

    @FXML
    private TextArea no_table;
    @FXML
    private Button b_order;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        rec_order.setVisible(true);

        pi_order.toFront();

    }







    @FXML
    void pushOrder(ActionEvent event) {

        rec_order.setVisible(true);
        for (int i = 0; i < read.finalLength("client","order");i++) {
            orders.appendText(c1.mealsArray(i)+"\n");
        }
        double appetizerTaxes=1.10;
        double mainCourseTaxes=1.15;
        double desertTaxes=1.20;
        for (int i = 0; i < read.finalLength("client","name"); i++) {

            double price=Double.parseDouble(manager.getTotalMoneyArray(i));
            if(customer.getClientDishTypeArray(i).equals("appetizer"))
                clientName.appendText(customer.getClientNameDataArray(i)+"\t\t paid: "+(price*appetizerTaxes)+"\n");
            if(customer.getClientDishTypeArray(i).equals("main_course"))
                clientName.appendText(customer.getClientNameDataArray(i)+"\t\t paid: "+(price*mainCourseTaxes)+"\n");
            if(customer.getClientDishTypeArray(i).equals("desert"))
                clientName.appendText(customer.getClientNameDataArray(i)+"\t\t paid: "+(price*desertTaxes)+"\n");
        }

            int [] stringToNumber=new int[read.finalLength("client","table")];
            int [] arr=new int[read.finalLength("client","table")];
            for(int i=0;i<read.finalLength("client","table");i++) {
                stringToNumber[i] = Integer.parseInt(w1.getclientTableNumberArray(i));
                arr[i] = stringToNumber[i];
            }
            int length = arr.length;
            length =manager.removeDuplicateElements(arr, length);
            //printing array elements
            for (int i=0; i<length; i++)
                no_table.appendText("Table Number "+arr[i]+" is Reserved\n");

        b_order.setDisable(true);
    }
    @FXML
    void totalprice(ActionEvent event) {
        manager.totalMoney();
        totalprice_area1.appendText(String.valueOf(manager.getTotalMoneyBeforeTaxes()));
        totalprice_area.appendText(String.valueOf(manager.getTotalMoney()));
        showTotalprice.setDisable(true);

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
