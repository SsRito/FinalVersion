package com.sauharda.oop_projects.group_42;

import Sauharda.CEO;
import Sauharda.HRManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LoginController
{
    @javafx.fxml.FXML
    private TextField emailTextField;
    @javafx.fxml.FXML
    private PasswordField passwordPasswordField;

    ArrayList<CEO> ceoArrayList = new ArrayList<>();
    ArrayList<HRManager> hrManagerArrayList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        ceoArrayList.add(new CEO("ceo1234", "CEO", "ceo@ngo.com"));
        hrManagerArrayList.add(new HRManager("HR Manager", "hrmanager@ngo.com", "hrmanager1234"));

    }

    @javafx.fxml.FXML
    public void signUpOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("signUp.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Sign Up");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void loginOnAction(ActionEvent actionEvent) {
        String email = emailTextField.getText().trim();
        String password = passwordPasswordField.getText().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Please fill up properly");
            errorAlert.show();
        }

        for (CEO ceo : ceoArrayList) {
            if (ceo.getEmail().equalsIgnoreCase(email) && ceo.getPassword().equals(password)) {
                try {
                    Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

                    FXMLLoader fxmlLoader
                            = new FXMLLoader(MainApplication.class.getResource("/Sauharda/ceoDashboard.fxml"));
                    Scene nextScene = new Scene(fxmlLoader.load());

                    stage.setTitle("CEO Dashboard");
                    stage.setScene(nextScene);
                    stage.show();
                }
                catch (Exception e) {
                    //
                }
                return;
            }
        }

        for (HRManager hrManager : hrManagerArrayList) {
            if (hrManager.getEmail().equalsIgnoreCase(email) && hrManager.getPassword().equals(password)) {
                try {
                    Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

                    FXMLLoader fxmlLoader
                            = new FXMLLoader(MainApplication.class.getResource("/Sauharda/hrManagerDashboard.fxml"));
                    Scene nextScene = new Scene(fxmlLoader.load());

                    stage.setTitle("HR Manager Dashboard");
                    stage.setScene(nextScene);
                    stage.show();
                }
                catch (Exception e) {
                    //
                }
                return;
            }
        }


        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setContentText("Incorrect Email or Password");
        errorAlert.show();
    }

    @javafx.fxml.FXML
    public void forgetPasswordOnAction(ActionEvent actionEvent) {
    }
}