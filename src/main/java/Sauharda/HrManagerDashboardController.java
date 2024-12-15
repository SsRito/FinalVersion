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

public class HrManagerDashboardController
{
    @javafx.fxml.FXML
    private BorderPane hrManagerDashboardBorderPane;
    @javafx.fxml.FXML
    private Label userNameLabel;
    @javafx.fxml.FXML
    private Label goalLabel;
    @javafx.fxml.FXML
    private Label hrManagerLabel;

    @javafx.fxml.FXML
    public void initialize() {
        userNameLabel.setText("B");
        hrManagerLabel.setText("HR Manager");
    }

    @javafx.fxml.FXML
    public void conflictResolutionOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void policyOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Sauharda/policyCompliance-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Policy Compliance");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void employeePerformanceOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Sauharda/employeePerformance-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Employee Performance");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void workforceOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void recruitmentOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Sauharda/recruitment-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Recruitment");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void trainingProgramOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Sauharda/trainingAndDevelopmentProgram-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Training & Development Program");
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
            //FXMLLoader fxmlLoader = new FXMLLoader(CreateNewBookController.class.getResource("LoadCourseInfoFromFileView.fxml"));
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