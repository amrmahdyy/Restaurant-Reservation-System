package GUI;

import backend.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.event.ActionEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class User implements Initializable {
    Alert a = new Alert(Alert.AlertType.NONE);
    @FXML
    private ResourceBundle resources;
    @FXML
    private Rectangle rec_table;
    @FXML
    private Rectangle rec_app;
    @FXML
    private Rectangle rec_main;
    @FXML
    private Rectangle rec_des;
    @FXML
    private Pane pi_appetizer;
    @FXML
    private Pane pi_dessert;
    @FXML
    private Pane pi_main;
    @FXML
    private RadioButton beef;
    @FXML
    private ToggleGroup foodorder;
    @FXML
    private RadioButton soup;
    @FXML
    private RadioButton chicken;
    @FXML
    private RadioButton potatos;
    @FXML
    private RadioButton salad;
    @FXML
    private RadioButton pie;
    @FXML
    private RadioButton cake;
    @FXML
    private TextArea receipt;
    @FXML
    private Label label1;
    Customer c1 = new Customer();
    public int tableRequest;
    public String status = "";
    public int confirm = 0;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rec_app.setVisible(false);
        rec_main.setVisible(true);
        rec_des.setVisible(false);
        rec_table.setVisible(false);
        pi_main.toFront();
        // CONFIGURATION OF RADIO BUTTONS
        foodorder = new ToggleGroup();
        this.beef.setToggleGroup(foodorder);
        this.soup.setToggleGroup(foodorder);
        this.chicken.setToggleGroup(foodorder);
        this.pie.setToggleGroup(foodorder);
        this.potatos.setToggleGroup(foodorder);
        this.cake.setToggleGroup(foodorder);
        this.salad.setToggleGroup(foodorder);


    }


    @FXML
    void appetizerActionPerformed(ActionEvent event) {
        rec_app.setVisible(true);
        rec_main.setVisible(false);
        rec_des.setVisible(false);
        rec_table.setVisible(false);
        pi_appetizer.toFront();

    }

    @FXML
    void dessertActionPerformed(ActionEvent event) {
        rec_app.setVisible(false);
        rec_main.setVisible(false);
        rec_des.setVisible(true);
        rec_table.setVisible(false);
        pi_dessert.toFront();

    }

    @FXML
    void mainActionPerformed(ActionEvent event) {
        rec_app.setVisible(false);
        rec_main.setVisible(true);
        rec_des.setVisible(false);
        rec_table.setVisible(false);
        pi_main.toFront();
    }

    @FXML
    void logout(MouseEvent event) throws IOException {
        Parent sample = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene user2 = new Scene(sample);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(user2);
        window.show();

    }

    @FXML
    void reservetable(MouseEvent event) throws IOException {
        rec_app.setVisible(false);
        rec_main.setVisible(false);
        rec_des.setVisible(false);
        rec_table.setVisible(true);
        Parent table1 = FXMLLoader.load(getClass().getResource("table.fxml"));
        Scene table = new Scene(table1);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(table);
        window.show();


    }

    public int choice = 0;

    @FXML
    public int foodOrder(ActionEvent event) {
        receipt.setVisible(false);

        //if (c1.getNoAvaliabiltyStatus().equals("false")) {
        if (chicken.isSelected()) {
            choice = 1;

            if (choice > 0 && choice < 8) {
                receipt.setVisible(true);
                c1.totalAmount = 0;
                receipt.setText("Price after taxes \t\t" + String.valueOf(c1.printReceipt(choice - 1)));

            }
        } else if (salad.isSelected()) {
            choice = 2;
            if (choice > 0 && choice < 8) {
                receipt.setVisible(true);
                c1.totalAmount = 0;
                receipt.setText("price after taxes \t\t" + String.valueOf(c1.printReceipt(choice - 1)));

            }
        } else if (potatos.isSelected()) {
            choice = 3;
            if (choice > 0 && choice < 8) {
                receipt.setVisible(true);
                c1.totalAmount = 0;

                receipt.setText("price after taxes \t\t"+String.valueOf(c1.printReceipt(choice - 1)));

            }

        } else if (pie.isSelected()) {
            choice = 4;
            if (choice > 0 && choice < 8) {
                receipt.setVisible(true);
                c1.totalAmount = 0;
                receipt.setText("price after Taxes \t\t" + String.valueOf(c1.printReceipt(choice - 1)));

            }
        } else if (cake.isSelected()) {
            choice = 5;
            if (choice > 0 && choice < 8) {
                receipt.setVisible(true);
                c1.totalAmount = 0;
                receipt.setText("Price after taxes \t\t" + String.valueOf(c1.printReceipt(choice - 1)));

            }
        } else if (soup.isSelected()) {
            choice = 6;
            if (choice > 0 && choice < 8) {
                receipt.setVisible(true);
                c1.totalAmount = 0;
                receipt.setText("Price after Taxes \t\t" + String.valueOf(c1.printReceipt(choice - 1)));

            }
        } else if (beef.isSelected()) {
            choice = 7;
            if (choice > 0 && choice < 8) {
                receipt.setVisible(true);
                c1.totalAmount = 0;
                receipt.setText("Price after Taxes \t\t" + String.valueOf(c1.printReceipt(choice - 1)));

            }
        } else {
            choice = 0;
            receipt.setVisible(false);
            c1.totalAmount = 0;
        }

        return choice;
    }

    public void myFunction(String text, int value) {
        this.status = text;
        this.tableRequest = value;

    }

    @FXML
    void confirmOrder(ActionEvent event) throws IOException {

        //alert.initModality(Modality.APPLICATION_MODAL);  cause run time error



            if (status.equals("false") && choice != 0) {
                Alert.AlertType type = Alert.AlertType.CONFIRMATION;
                Alert alert = new Alert(type);
                alert.setContentText("PRESS OK TO CONFIREM OR CANCEL TO CANCEL YOUR ORDER");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                confirm = 1;
                c1.confirmOrder(tableRequest, choice - 1);
                System.out.println("Reservation confirmed");
                a.setAlertType(Alert.AlertType.INFORMATION);
                a.setContentText("Reservation confirmed");
                a.show();}
                else if (result.get() == ButtonType.CANCEL) {
                    Parent user = FXMLLoader.load(getClass().getResource("user.fxml"));
                    Scene user1 = new Scene(user);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(user1);
                    window.show();

                }


            } else if (status.equals("true") || tableRequest == 0) {
                a.setAlertType(Alert.AlertType.ERROR);
                a.setContentText("this table isn't avaliable ,please pick another table or choose a button on case not selected");
                a.show();
            } else {
                a.setAlertType(Alert.AlertType.ERROR);
                a.setContentText("Please reserve order firts");
                a.show();
            }

    }
    @FXML
    void addOrder(ActionEvent event) throws IOException {
        if (confirm == 1) {
            Parent user = FXMLLoader.load(getClass().getResource("user.fxml"));
            Scene user1 = new Scene(user);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(user1);
            window.show();
        } else {
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Please make your first order and confirm first");
            a.show();
        }
    }

}