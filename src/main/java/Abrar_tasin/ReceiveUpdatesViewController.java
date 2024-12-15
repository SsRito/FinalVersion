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

public class ReceiveUpdatesViewController {
    @javafx.fxml.FXML
    private TextField phoneNumberTextField;
    @javafx.fxml.FXML
    private ComboBox updatesAboutComboBox;
    @javafx.fxml.FXML
    private TextField emailTextField;
    @javafx.fxml.FXML
    private ComboBox updatesOnComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        updatesAboutComboBox.getItems().addAll("Climate Change Awareness", "Nutrition and Fitness Campaigns", "AI and Ethics Advocacy", "Reforestation Efforts");
        updatesOnComboBox.getItems().addAll("All", "Email", "Contact No.");
    }

    @Deprecated
    public void updatesAboutComboBox(ActionEvent actionEvent) {
    }

    @Deprecated
    public void updatesOnComboBox(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void goBackToDashboardOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Abrar_tasin/DonorDashboard-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Donor Dashboard");
            stage.setScene(nextScene);
            stage.show();
        } catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void submitOnAction(ActionEvent actionEvent) {
        boolean hasEmptyField = false;
        String errorMessage = "";

        if (emailTextField.getText().isEmpty()) {
            hasEmptyField = true;
            errorMessage += "Email is required.\n";
        }

        if (phoneNumberTextField.getText().isEmpty()) {
            hasEmptyField = true;
            errorMessage += "Phone number is required.\n";
        }

        if (updatesOnComboBox.getSelectionModel().getSelectedItem() == null) {
            hasEmptyField = true;
            errorMessage += "Please select 'Receive updates on' option.\n";
        }

        if (updatesAboutComboBox.getSelectionModel().getSelectedItem() == null) {
            hasEmptyField = true;
            errorMessage += "Please select 'Receive updates about' option.\n";
        }

        if (hasEmptyField) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Please fill in all required fields."); // Added header for clarity
            errorAlert.setContentText(errorMessage);
            errorAlert.showAndWait(); // Use showAndWait() to prevent further actions until the alert is dismissed
        } else {
            // All fields are filled, proceed with form submission logic
            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmAlert.setContentText("Thank you for your interest! You'll be notified soon.");
            confirmAlert.showAndWait();
        }
    }


}