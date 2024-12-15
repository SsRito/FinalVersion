package Abrar_tasin;

import com.tasin.ms4_member3.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewBenefitViewController
{
    @javafx.fxml.FXML
    private ComboBox newBenefitsComboBox;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TextField contactTextField;
    @javafx.fxml.FXML
    private TextField reasoningLabel;

    @javafx.fxml.FXML
    public void initialize() {
        newBenefitsComboBox.getItems().addAll("Unemployment Insurance", "Vision and Dental Care Assistance", "Small Business Loans", "Health Insurance Enrollment");
    }

    @javafx.fxml.FXML
    public void goBackToDashboardOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Abrar_tasin/BeneficiaryDashboard-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Beneficiary Dashboard");
            stage.setScene(nextScene);
            stage.show();
        } catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void submitOnAction(ActionEvent actionEvent) {
        if (nameTextField.getText().isEmpty() || contactTextField.getText().isEmpty()) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Please fill up properly.");
            errorAlert.show();
        }
        else {
            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmAlert.setContentText("Thank you for your interest! You'll be notified soon.");
            confirmAlert.show();
        }
    }
}