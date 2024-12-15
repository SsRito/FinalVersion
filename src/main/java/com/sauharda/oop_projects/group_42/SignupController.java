package com.sauharda.oop_projects.group_42;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class SignupController
{
    @javafx.fxml.FXML
    private TextField emailOrPhoneTextField;
    @javafx.fxml.FXML
    private PasswordField passwordPasswordField;
    @javafx.fxml.FXML
    private PasswordField confirmPasswordPasswordField;
    @javafx.fxml.FXML
    private TextField userNameTextField;
    @javafx.fxml.FXML
    private ComboBox<String> userTypeComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        userTypeComboBox.getItems().addAll("CEO", "HR Manager", "Accountant", "Donor", "Field Worker", "Beneficiary", "Event Organiser", "Research Analyst");
    }

    @javafx.fxml.FXML
    public void signUpOnAction(ActionEvent actionEvent) {
        if (emailOrPhoneTextField.getText().isEmpty()|| passwordPasswordField.getText().isBlank() || confirmPasswordPasswordField.getText().isEmpty() || userNameTextField.getText().isEmpty()){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Please fill up properly");
            errorAlert.show();
        } else if (passwordPasswordField.getText() != confirmPasswordPasswordField.getText()) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Password did not match");
            errorAlert.show();
        }

        else{
            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmAlert.setContentText("Signed Up Successfully");
            confirmAlert.show();

            try {
                Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

                FXMLLoader fxmlLoader
                        = new FXMLLoader(MainApplication.class.getResource("logIn.fxml"));
                Scene nextScene = new Scene(fxmlLoader.load());

                stage.setTitle("Log In");
                stage.setScene(nextScene);
                stage.show();
            }
            catch (Exception e) {
                //
            }
        }
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("logIn.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Log In");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void logInOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("logIn.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Log In");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }
}