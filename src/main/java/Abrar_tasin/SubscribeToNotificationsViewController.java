package Abrar_tasin;

import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class SubscribeToNotificationsViewController
{
    @javafx.fxml.FXML
    private TextField nameField;
    @javafx.fxml.FXML
    private RadioButton emailRadioButton;
    @javafx.fxml.FXML
    private TextField emailField;
    @javafx.fxml.FXML
    private RadioButton smsRadioButton;
    @javafx.fxml.FXML
    private TextField contactField;
    @javafx.fxml.FXML
    private RadioButton callRadioButton;

    private ToggleGroup tg;

    @FXML
    public void initialize() {
        tg = new ToggleGroup();
        emailRadioButton.setToggleGroup(tg);
        callRadioButton.setToggleGroup(tg);
        smsRadioButton.setToggleGroup(tg);
        emailRadioButton.setSelected(true);
    }

    @javafx.fxml.FXML
    public void goBackToDashboardOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Abrar_tasin/BeneficiaryDashboard-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Beneficiary Dashboard");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void subscribeOnAction(ActionEvent actionEvent) {
        if (nameField.getText().isEmpty() || contactField.getText().isEmpty() || emailField.getText().isEmpty()){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Please fill up properly.");
            errorAlert.show();
        }
        else{
            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmAlert.setContentText("Subscribed! You'll get your notifications.");
            confirmAlert.show();
        }
    }
}