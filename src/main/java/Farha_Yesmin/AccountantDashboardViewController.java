package Farha_Yesmin;

import Sauharda.CEOPlan;
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


public class AccountantDashboardViewController
{
    @javafx.fxml.FXML
    private BorderPane stageBorderPane;
    @javafx.fxml.FXML
    private Label accountantDesignationLabel;
    @javafx.fxml.FXML
    private Label accountantNameLabel;
    @javafx.fxml.FXML
    private Label newGoalLabel;

    @javafx.fxml.FXML
    public void initialize() {
        accountantDesignationLabel.setText("Accountant");
    }

    @javafx.fxml.FXML
    public void projectBudgetOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/Farha_Yesmin/projectSpecificbudget-view.fxml"));
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
    public void expenseCategoryOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/Farha_Yesmin/expenseCategory-view.fxml"));
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
    public void donorRecordOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/Farha_Yesmin/donorRecord-view.fxml"));
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
    public void loanManagementOnAction(ActionEvent actionEvent) {
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/Farha_Yesmin/loan-view.fxml"));
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
    public void manageBudgetOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/Farha_Yesmin/budgetManagement-view.fxml"));
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
    public void recordTransactionOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/Farha_Yesmin/transaction-view.fxml"));
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
    public void financialReportOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/Farha_Yesmin/financialReport-view.fxml"));
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
    public void expenseApprovalsOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/Farha_Yesmin/expenseApprovals-view.fxml"));
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
            newGoalLabel.setText(strBuilder.toString());
        } catch (Exception e) {
            //
        }

    }
}