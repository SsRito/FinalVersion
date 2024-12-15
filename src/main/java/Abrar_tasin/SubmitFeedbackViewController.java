package Abrar_tasin;

import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;

public class SubmitFeedbackViewController
{

    @javafx.fxml.FXML
    private DatePicker datePickerTextField;
    @javafx.fxml.FXML
    private TextField feedbackTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void goBackToDashboardOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Abrar_tasin/BeneficiaryDashboard-view.fxml"));
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
    public void submitOnAction(ActionEvent actionEvent) {
        String feedBackCategory = feedbackTextField.getText();
        String feedBackName = nameTextField.getText();
        if (nameTextField.getText().isEmpty() || feedbackTextField.getText().isEmpty()) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Please fill up properly.");
            errorAlert.show();
        } else {
            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmAlert.setContentText("Thank you for your feedback! We will get back to you shortly!");
            confirmAlert.show();
        }

        //feedBackCategory.add(new feedBack(
                
        //));

        FileWriter fw = null;
        File f = new File("feedback.txt");
        try {
            if (f.exists()){
                fw = new FileWriter(f, true);
            }
            else {
                fw = new FileWriter(f);
            }
        } catch (Exception ignored) {
                //
        }
        String str = "" ;
        //for(Feedback f: feed)
    }
}