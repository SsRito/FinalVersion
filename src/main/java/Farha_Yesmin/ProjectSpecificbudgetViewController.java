package Farha_Yesmin;

import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProjectSpecificbudgetViewController
{
    @javafx.fxml.FXML
    private TextField logisticsExoenseTextField;
    @javafx.fxml.FXML
    private TextField operationalExpenseTextField;
    @javafx.fxml.FXML
    private Label totalExpenseLabel;
    @javafx.fxml.FXML
    private TextField ResourceExpenseTextField;
    float totalExpenseAmount;
    @javafx.fxml.FXML
    private ComboBox<String> projectNameComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        projectNameComboBox.getItems().addAll("Community Development","Education",
                "HealthCare","Human Rights","Youth Development");
    }

    @javafx.fxml.FXML
    public void trackExpenditureOnAction(ActionEvent actionEvent) {
        totalExpenseAmount = Float.parseFloat(ResourceExpenseTextField.getText())+
                Float.parseFloat(operationalExpenseTextField.getText())+
                Float.parseFloat(logisticsExoenseTextField.getText());
        totalExpenseLabel.setText(Float.toString(totalExpenseAmount));

        projectNameComboBox.setValue(null);
        ResourceExpenseTextField.clear();
        operationalExpenseTextField.clear();
        logisticsExoenseTextField.clear();
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