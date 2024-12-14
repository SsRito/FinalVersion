package Farha_Yesmin;

import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ExpenseCategoryViewController
{
    @javafx.fxml.FXML
    private TextField totalExpenseAmountTextField;
    @javafx.fxml.FXML
    private ComboBox<String> expenseCategoryComboBox;
    @javafx.fxml.FXML
    private TextArea expenseCategoryTextArea;
    ArrayList<Expense>expenseCategoryList;

    @javafx.fxml.FXML
    public void initialize() {
        expenseCategoryList = new ArrayList<>();
        expenseCategoryComboBox.getItems().addAll("salaries","Project","Travel");
    }

    @javafx.fxml.FXML
    public void CategorizeOnAction(ActionEvent actionEvent) {
        Expense category = new Expense(
                expenseCategoryComboBox.getValue(),
                Float.parseFloat(totalExpenseAmountTextField.getText())
       );
        expenseCategoryTextArea.appendText(expenseCategoryComboBox.getValue()+","+
                totalExpenseAmountTextField.getText()+"\n");
        expenseCategoryComboBox.setValue(null);
        totalExpenseAmountTextField.clear();
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