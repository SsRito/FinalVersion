package Farha_Yesmin;
import Sauharda.CEOPlan;
import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.util.Scanner;

public class FieldWorkerDashboardViewController
{
    @javafx.fxml.FXML
    private Label newGoalLabel;
    @javafx.fxml.FXML
    private Label fieldWorkerNameLabel;
    @javafx.fxml.FXML
    private Label fieldWorkerDesignationLabel;

    @javafx.fxml.FXML
    public void initialize() {
        fieldWorkerDesignationLabel.setText("Field Worker");
    }

    @javafx.fxml.FXML
    public void leaveReqOnAction(ActionEvent actionEvent) {
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
    public void attendanceOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void taskOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void feedBackOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/Farha_Yesmin/feedBack-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage currentStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            currentStage.setScene(nextScene);
            currentStage.show();
        }
        catch(Exception e) {
//
        }
    }

    @javafx.fxml.FXML
    public void manageBeneficiaryOnAction(ActionEvent actionEvent) {
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
            newGoalLabel.setText(strBuilder.toString());
        } catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void quickNotesOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void recordFieldVisitOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void reportExpenseOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void signOutOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("login.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage currentStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            currentStage.setTitle("Login Page");
            currentStage.setScene(nextScene);
            currentStage.show();
        }
        catch(Exception e) {
//
        }
    }
}