package Farha_Yesmin;

import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.time.LocalDate;

public class RequestLeaveViewController
{
    @javafx.fxml.FXML
    private DatePicker fromDatePicker;
    @javafx.fxml.FXML
    private DatePicker toDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> leaveTypeComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        fromDatePicker.setValue(LocalDate.now());
        toDatePicker.setValue(LocalDate.now());
        leaveTypeComboBox.getItems().addAll("Sick Leave","Casual Leave");
    }

    @javafx.fxml.FXML
    public void returnHomeOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/Farha_Yesmin/fieldWorkerDashboard-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage currentStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            currentStage.setTitle("FieldWorker Dashboard");
            currentStage.setScene(nextScene);
            currentStage.show();
        }
        catch(Exception e) {
//
        }
    }

    @javafx.fxml.FXML
    public void submitRequestOnAction(ActionEvent actionEvent) {
        if(leaveTypeComboBox.getValue().isEmpty() || fromDatePicker.getValue()==null ||
                toDatePicker.getValue()==null){
            showAlert(Alert.AlertType.WARNING,"Invalid Input");
        }
        else{
            showAlert(Alert.AlertType.CONFIRMATION,"Request Approved");
        }
        leaveTypeComboBox.setValue(null);
    }
    private void showAlert(Alert.AlertType alertType, String message) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }
}