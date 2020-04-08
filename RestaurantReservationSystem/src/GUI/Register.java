package GUI;
import backend.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Register implements Initializable {
     public boolean accountCreated=false;
    Alert a = new Alert(Alert.AlertType.NONE);
    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    void Register(ActionEvent event) throws IOException {
        if (username.getText().isEmpty() && password.getText().isEmpty()) {
            accountCreated=false;
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Please enter your username and pass");
            a.show();
        }

        String user = username.getText();
        String pass = password.getText();
        AddAcount newAccount = new AddAcount();
        newAccount.createAccount(user, pass);
        accountCreated = true;
        if (accountCreated) {
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene user1 = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(user1);
            window.show();


        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
