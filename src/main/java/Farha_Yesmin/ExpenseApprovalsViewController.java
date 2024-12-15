package Farha_Yesmin;

import Sauharda.ExpenseApprovalController;
import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ExpenseApprovalsViewController
{
    @javafx.fxml.FXML
    private TextField expenseAmountTextField;
    @javafx.fxml.FXML
    private DatePicker expenseDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> expenseCategoryComboBox;
    @javafx.fxml.FXML
    private Label approvalLabel;
    @javafx.fxml.FXML
    private TextField expenseReasonTextField;

    @javafx.fxml.FXML
    public void initialize() {
        expenseCategoryComboBox.getItems().addAll("Travel","Project","Salaries","Others");
    }

    @javafx.fxml.FXML
    public void submitApprovalOnAction(ActionEvent actionEvent) {
//        expenseCategoryLabel.setText(expenseCategoryComboBox.setValue());
//        expenseAmountLabel.setText(expenseAmountTextField.getText());
//        expenseDateLabel.setText(expenseDatePicker.getValue());
//        expenseReasonLabel.setText(expenseReasonTextField.getText());
        //ceo fxid
    }

    @javafx.fxml.FXML
    public void returnHomeOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/Farha_Yesmin/accountantDashboard-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage currentStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            currentStage.setTitle("Accountant Dashboard");
            currentStage.setScene(nextScene);
            currentStage.show();
        }
        catch(Exception e) {
//
        }
    }
}