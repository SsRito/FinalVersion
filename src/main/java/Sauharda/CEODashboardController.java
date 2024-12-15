package Sauharda;

import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.util.Scanner;

public class CEODashboardController
{
    @javafx.fxml.FXML
    private BorderPane ceoDashboardBorderPane;
    @javafx.fxml.FXML
    private Label userNameLabel;
    @javafx.fxml.FXML
    private Label goalLabel;
    @javafx.fxml.FXML
    private Label designationLabel;

    @javafx.fxml.FXML
    public void initialize() {
        userNameLabel.setText("A");
        designationLabel.setText("CEO");
    }

    @javafx.fxml.FXML
    public void planningOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Sauharda/planning-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Planning");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void projectsOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Sauharda/projectApproval-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Projects");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void viewFeedbackOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Sauharda/viewFeedback.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("CEO Dashboard");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void financeOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Sauharda/finance-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Finance");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void keyUpdatesOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Sauharda/keyUpdate-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Key Updates");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void partnershipOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Sauharda/partnership-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Partnership");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void signOutOnAction(ActionEvent actionEvent) {
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
    public void notificationOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("notification-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = new Stage();
            nextStage.setTitle("Notification");
            nextStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void reloadDashboardOnAction(ActionEvent actionEvent) {
        File f = new File("newGoal.txt");
        try {
            Scanner s = new Scanner(f);
            StringBuilder strBuilder = new StringBuilder();
            while (s.hasNextLine()) {
                String str = s.nextLine();
                String[] tokens = str.split(",");
                CEOPlan c = new CEOPlan(tokens[0]);
                strBuilder.append(c.getGoal()).append("\n");
            }
            goalLabel.setText(strBuilder.toString());
        } catch (Exception e) {
            //
        }
    }
}