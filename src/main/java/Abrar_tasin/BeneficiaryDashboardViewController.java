package Abrar_tasin;


import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BeneficiaryDashboardViewController
{
    @javafx.fxml.FXML
    private BorderPane beneficiaryBorderPane;
    @javafx.fxml.FXML
    private Label fieldLabel;
    @javafx.fxml.FXML
    private Label nameLabel;
    @javafx.fxml.FXML
    private Label nameTypeLabel;
    @javafx.fxml.FXML
    private Label nameLabel1;
    @javafx.fxml.FXML
    private Label userTypeLabel;

    @javafx.fxml.FXML
    public void initialize() {
        userTypeLabel.setText("Beneficiary");
        nameLabel.setText("x");

    }

    @javafx.fxml.FXML
    public void trackBenefitsOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void viewApplicationHistoryOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void subscribeNotificationOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Abrar_tasin/SubscribeToNotifications-view.fxml"));
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
    public void submitFeedbackOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Abrar_tasin/SubmitFeedback-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Submit Feedback");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void viewTotalBenefitsOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void eligibilityForBenefitsOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Abrar_tasin/eligibilityForBenefits-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Upcoming Events Scene");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void newBenefitOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Abrar_tasin/NewBenefit-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("New Benefit");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void updateInfoOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void signOutOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewUpcomingEventsOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Abrar_tasin/UpcomingEvents-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Upcoming Events Scene");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }
}