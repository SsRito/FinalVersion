package Sauharda;

import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ExpenseApprovalController
{
    @javafx.fxml.FXML
    private Label expenseReasonLabel;
    @javafx.fxml.FXML
    private Label expenseDateLabel;
    @javafx.fxml.FXML
    private Label expenseAmountLabel;
    @javafx.fxml.FXML
    private Label expenseCategoryLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void rejectOnAction(ActionEvent actionEvent) {
        //approvalLabel.setText("Rejected");

        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setContentText("Rejected");
        confirmAlert.show();
    }

    @javafx.fxml.FXML
    public void goBackToFinancePageOnAction(ActionEvent actionEvent) {
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
    public void goBackToDashboardOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Sauharda/ceoDashboard.fxml"));
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
    public void approveOnAction(ActionEvent actionEvent) {
        //approvalLabel.setText("Approved");

        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setContentText("Approved");
        confirmAlert.show();
    }
}