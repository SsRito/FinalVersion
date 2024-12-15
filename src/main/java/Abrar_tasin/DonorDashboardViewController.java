package Abrar_tasin;

import com.tasin.ms4_member3.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DonorDashboardViewController
{
    @javafx.fxml.FXML
    private Label userTypeLabel;

    @javafx.fxml.FXML
    public void initialize() {
        userTypeLabel.setText("Donor");
    }

    @javafx.fxml.FXML
    public void makeDonationOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Abrar_tasin/MakeDonation-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Donor Dashboard");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void receiveUpdatesOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Abrar_tasin/ReceiveUpdates-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Donor Dashboard");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void selectCauseOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Abrar_tasin/SelectCause-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Select a Cause Dashboard");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void recurringDonations(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void trackDonationProgressOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void updateInfoOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewTotalDonationsOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void signOutOnAction(ActionEvent actionEvent) {
    }
}