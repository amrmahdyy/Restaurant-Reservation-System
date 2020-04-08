package GUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.Scene;
import backend.*;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.lang.String;

public class Controller {
    public static boolean userNameStatus=false;
    private static String role = "";
    public static int  temp=0;
    int temp2;
    Verification u = new Verification();
    Person p1 = new Person();
    Alert a = new Alert(Alert.AlertType.NONE);


    @FXML
    private PasswordField pass;

    @FXML
    private TextField name;

    @FXML
    public void changeScreenButtonPushed(ActionEvent event) throws IOException {
        Parent user = FXMLLoader.load(getClass().getResource("user.fxml"));
        Scene user1=new Scene(user);
        Parent manager = FXMLLoader.load(getClass().getResource("MANAGER.fxml"));
        Scene manager1=new Scene(manager);
        Parent cook = FXMLLoader.load(getClass().getResource("cook.fxml"));
        Scene cook1=new Scene(cook);
        Parent waiter = FXMLLoader.load(getClass().getResource("waiter.fxml"));
        Scene waiter1=new Scene(waiter);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();




 String userName =name.getText();
        String password =pass.getText();
        for (int j = 0; j <100; j++) {
            if ((userName.equals(p1.getuserNameArray(j)) && password.equals(p1.getPasswordArray(j)))) {
                userNameStatus = true;
                role = p1.getRoleArray(j);
                System.out.println(role);
                temp = j;
                if (userNameStatus == true)
                    break;
            }



        }
        if(userNameStatus==false) {

            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Invalid password or username ");
            a.show();

        }
        System.out.println(role);
        switch (role) {
            case "Client":
                window.setScene(user1);
                window.show();
                break;
            case "Waiter":
                window.setScene(waiter1);
               window.show();
                break;
                case "Cooker":
                 window.setScene(cook1);
                  window.show();
                  break;
              case "Manager":
                  window.setScene(manager1);
                  window.show();
                  break;
        }

      }
    @FXML
    void register(ActionEvent event) throws IOException {
        Parent user = FXMLLoader.load(getClass().getResource("register.fxml"));
        Scene user1 = new Scene(user);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(user1);
        window.show();

    }
    public int getTemp2() {
        temp2=temp;
        return temp2;
    }

    }
