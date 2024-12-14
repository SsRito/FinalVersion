package Farha_Yesmin;

import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class BudgetManagementViewController
{
    @javafx.fxml.FXML
    private TextField projectBudgetTextField;
    @javafx.fxml.FXML
    private ComboBox<String> financialPeriodComboBox;
    @javafx.fxml.FXML
    private TextField fundraisingBudgetTextField;
    @javafx.fxml.FXML
    private TextField totalBudgetTextField;
    @javafx.fxml.FXML
    private TextField salaryBudgetTextField;
    @javafx.fxml.FXML
    private TextField administrationBudgetTextField;
    ArrayList<Budget>budgetList;

    @javafx.fxml.FXML
    public void initialize() {
        budgetList = new ArrayList<>();
        financialPeriodComboBox.getItems().addAll("Monthly","Weekly","Yearly");
    }

    @javafx.fxml.FXML
    public void reviewBudgetOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/Farha_Yesmin/reviewBudget-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage currentStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            currentStage.setTitle("Budget Plan");
            currentStage.setScene(nextScene);
            currentStage.show();
        }
        catch(Exception e) {
//
        }
    }

    @javafx.fxml.FXML
    public void saveBudgetPlanOnAction(ActionEvent actionEvent) {
        float totalBudget;
        totalBudget = Float.parseFloat(fundraisingBudgetTextField.getText())+
                Float.parseFloat(administrationBudgetTextField.getText())+
                Float.parseFloat(salaryBudgetTextField.getText())+
                Float.parseFloat(projectBudgetTextField.getText());
        totalBudgetTextField.setText(Float.toString(totalBudget));

        budgetList.add(new Budget(
                financialPeriodComboBox.getValue(),Float.parseFloat(fundraisingBudgetTextField.getText()),
                Float.parseFloat(administrationBudgetTextField.getText()),
                Float.parseFloat(projectBudgetTextField.getText()),
                Float.parseFloat(salaryBudgetTextField.getText()),
                Float.parseFloat(totalBudgetTextField.getText())
        ));
        FileWriter fw = null;
        File f = new File("Budget.txt");
        try {
            if(f.exists()){
                fw = new FileWriter(f,true); //true means append
            }
            else{
                fw = new FileWriter(f); //by default false means new file add
            }
            String str = "";
            for(Budget d: budgetList){
                str += d.toString("budget");
            }
            fw.write(str);
            fw.close();
        }
        catch (Exception e) {
            //
        }

    }
}