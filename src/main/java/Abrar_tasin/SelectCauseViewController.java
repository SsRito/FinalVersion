package Abrar_tasin;

import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SelectCauseViewController
{
    @javafx.fxml.FXML
    private TextField enterAmountTextField;
    @javafx.fxml.FXML
    private TextField causeLabel;
    @javafx.fxml.FXML
    private ComboBox causeComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        causeComboBox.getItems().addAll("All", "Education Fund", "Clean Water Initiative", "Help Poor People", "Tree Plantation");
    }

    @javafx.fxml.FXML
    public void donateOnAction(ActionEvent actionEvent) {
        if (enterAmountTextField.getText().isEmpty()) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Please fill up properly.");
            errorAlert.show();
        } else {
            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmAlert.setContentText("Thank you for your valuable support!");
            confirmAlert.show();
        }
    }

    @Deprecated
    public void causeComboBox(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void goBackToDashboardOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Abrar_tasin/DonorDashboard-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Donor Dashboard");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }
}