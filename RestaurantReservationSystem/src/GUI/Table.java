package GUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import backend.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Table implements Initializable {

    Customer c1 = new Customer();
    Alert a = new Alert(Alert.AlertType.NONE);
    @FXML
    private Button Table3;

    @FXML
    private Button Table5;

    @FXML
    private Button Table6;

    @FXML
    private Button Table7;

    @FXML
    private Button Table1;

    @FXML
    private Button Table2;

    @FXML
    private Button Table4;
    @FXML
    private Label lable;
    public  int choice=0;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
  lable.setText(" ");

    }
    @FXML
    void table1(ActionEvent event) {
        choice=1;
       c1.checkTableAvaliabilty(1);
       lable.setText("You choosed table 1");

    }

    @FXML
    void table2(ActionEvent event) {
        choice=2;
        c1.checkTableAvaliabilty(2);
        lable.setText("You choosed table 2");


    }

    @FXML
    void table3(ActionEvent event) {
        choice=3;
        c1.checkTableAvaliabilty(3);
        lable.setText("You choosed table 3");

    }

    @FXML
    void table4(ActionEvent event) {
        choice=4;
        c1.checkTableAvaliabilty(4);
        lable.setText("You choosed table 4");

    }

    @FXML
    void table5(ActionEvent event) {
        choice=5;
        c1.checkTableAvaliabilty(5);
       lable.setText("You choosed table 5");

    }

    @FXML
    void table6(ActionEvent event) {
        choice=6;
        c1.checkTableAvaliabilty(6);
        lable.setText("You choosed table 6");

    }

    @FXML
    void table7(ActionEvent event) {
        choice=7;
        c1.checkTableAvaliabilty(7);
        lable.setText("You choosed table 7");

    }
// choice is passed to tableRequest in class user
   @FXML
    void confirmTable(ActionEvent event) throws IOException {

      c1.avaliabiltyInClientData( String.valueOf(choice));
      System.out.println(c1.getConfirmOrderCheck());
       if (c1.noAvaliabiltyStatus.equals("false")&&c1.getConfirmOrderCheck().equals("true")) {
           FXMLLoader loader=new FXMLLoader(getClass().getResource("user.fxml"));
           Parent sample = (Parent)loader.load();
           User seccontroller=loader.getController();
           seccontroller.myFunction(c1.noAvaliabiltyStatus,choice);
           Scene user2 = new Scene(sample);
           Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           window.setScene(user2);
           window.show();

       } else if(c1.noAvaliabiltyStatus.equals("true")||choice==0||c1.getConfirmOrderCheck().equals("false")) {

           a.setAlertType(Alert.AlertType.ERROR);
           a.setContentText("this table isn't avaliable ,please pick another table or choose a button on case not selected");
           a.show();

       }
   }
}