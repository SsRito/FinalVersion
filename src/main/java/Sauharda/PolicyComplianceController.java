package Sauharda;

import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class PolicyComplianceController
{
    @javafx.fxml.FXML
    private TextField detailsTextField;
    @javafx.fxml.FXML
    private TextField policyNameTextField;
    @javafx.fxml.FXML
    private DatePicker deadlineDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> complianceStatusComboBox;
    @javafx.fxml.FXML
    private TextField correctiveActionsTextField;

    ArrayList<PolicyCompliance> policyComplianceArrayList;

    @javafx.fxml.FXML
    public void initialize() {
        complianceStatusComboBox.getItems().addAll("Compliant", "Partially Compliant", "Non Compliant");
        policyComplianceArrayList = new ArrayList<PolicyCompliance>();
    }

    @javafx.fxml.FXML
    public void goBackToDashboardOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Sauharda/hrManagerDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Hr Manager");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void generateCompliaceReportOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Sauharda/generateComplianceReport-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Generate Compliance Report");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void saveOnAction(ActionEvent actionEvent) {
        policyComplianceArrayList.add(
                new PolicyCompliance(
                        policyNameTextField.getText(),
                        complianceStatusComboBox.getValue(),
                        detailsTextField.getText(),
                        correctiveActionsTextField.getText(),
                        deadlineDatePicker.getValue()
                )
        );

        if (policyNameTextField.getText().isEmpty()|| complianceStatusComboBox.getValue().isBlank() ||
                detailsTextField.getText().isEmpty() || correctiveActionsTextField.getText().isEmpty()){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Please fill up properly");
            errorAlert.show();
        }

        else{
            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmAlert.setContentText("Saved Successfully");
            confirmAlert.show();

            FileWriter fw = null;
            File f = new File("policyComplianceDetails.txt");
            try {
                if(f.exists()){
                    fw = new FileWriter(f, true);
                }
                else{
                    fw = new FileWriter(f);
                }

                String str = "";
                for (PolicyCompliance p:policyComplianceArrayList){
                    str += p.toString("for file");
                    fw.write(str);
                    fw.close();
                }
            } catch (Exception e) {
                //
            }
        }
        policyNameTextField.clear();
        detailsTextField.clear();
        correctiveActionsTextField.clear();
    }
}
