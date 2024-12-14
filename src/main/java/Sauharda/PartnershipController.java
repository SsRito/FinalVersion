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

public class PartnershipController
{
    @javafx.fxml.FXML
    private TextField proposedAmountTextField;
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> statusComboBox;
    @javafx.fxml.FXML
    private TextField companyNameTextField;
    @javafx.fxml.FXML
    private TextArea proposalDetailsTextArea;

    ArrayList <Partnership> partnershipList;

    @javafx.fxml.FXML
    public void initialize() {
        statusComboBox.getItems().addAll("Pending", "Active", "Closed", "Renewed");
        partnershipList = new ArrayList<Partnership>();
    }

    @javafx.fxml.FXML
    public void viewPartnershipDetailsOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Sauharda/partnershipDetails-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Partnership Details");
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
    public void submitProposalOnAction(ActionEvent actionEvent) {
        partnershipList.add(
                new Partnership(
                        companyNameTextField.getText(),
                        proposalDetailsTextArea.getText(),
                        statusComboBox.getValue(),
                        dateDatePicker.getValue(),
                        Integer.parseInt(proposedAmountTextField.getText())
                )
        );

        if (proposalDetailsTextArea.getText().isEmpty()|| dateDatePicker.getValue().isAfter(LocalDate.now())
                || statusComboBox.getValue().isBlank() || companyNameTextField.getText().isEmpty() || proposedAmountTextField.getText().isEmpty()){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Please fill up properly");
            errorAlert.show();
        }

        else{
            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmAlert.setContentText("Submitted Successfully");
            confirmAlert.show();

            FileWriter fw = null;
            File f = new File("partnershipDetails.txt");
            try {
                if(f.exists()){
                    fw = new FileWriter(f, true);
                }
                else{
                    fw = new FileWriter(f);
                }

                String str = "";
                for (Partnership p:partnershipList){
                    str += p.toString("for file");
                    fw.write(str);
                    fw.close();
                }
            } catch (Exception e) {
                //
            }
        }
        companyNameTextField.clear();
        proposalDetailsTextArea.clear();
        proposedAmountTextField.clear();
    }
}