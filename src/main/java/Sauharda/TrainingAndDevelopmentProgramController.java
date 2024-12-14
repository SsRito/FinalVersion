package Sauharda;

import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class TrainingAndDevelopmentProgramController
{
    @javafx.fxml.FXML
    private TableColumn<TrainingAndDevelopmentProgram, String> totalCostTableColumn;
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TextField totalCostTextField;
    @javafx.fxml.FXML
    private TextField totalParticipantTextField;
    @javafx.fxml.FXML
    private TableView<TrainingAndDevelopmentProgram> programRecordTableView;
    @javafx.fxml.FXML
    private TableColumn<TrainingAndDevelopmentProgram, String> dateTableColumn;
    @javafx.fxml.FXML
    private TextField trainingOnTextField;
    @javafx.fxml.FXML
    private TableColumn<TrainingAndDevelopmentProgram, String> trainingOnTableColumn;
    @javafx.fxml.FXML
    private TableColumn<TrainingAndDevelopmentProgram, String> totalParticipantTableColumn;

    ArrayList<TrainingAndDevelopmentProgram> trainingAndDevelopmentProgramList;

    @javafx.fxml.FXML
    public void initialize() {
        trainingOnTableColumn.setCellValueFactory(new PropertyValueFactory<TrainingAndDevelopmentProgram, String>("trainingOn"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<TrainingAndDevelopmentProgram, String>("date"));
        totalParticipantTableColumn.setCellValueFactory(new PropertyValueFactory<TrainingAndDevelopmentProgram, String>("totalParticipant"));
        totalCostTableColumn.setCellValueFactory(new PropertyValueFactory<TrainingAndDevelopmentProgram, String>("totalCost"));

        trainingAndDevelopmentProgramList = new ArrayList<TrainingAndDevelopmentProgram>();
    }

    @javafx.fxml.FXML
    public void sendReportToCEOOnAction(ActionEvent actionEvent) {
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setContentText("Sent Successfully");
        confirmAlert.show();
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
    public void saveAndShowOnAction(ActionEvent actionEvent) {
        programRecordTableView.getItems().clear();
        trainingAndDevelopmentProgramList.add(
                new TrainingAndDevelopmentProgram(
                        trainingOnTextField.getText(),
                        dateDatePicker.getValue(),
                        Integer.parseInt(totalParticipantTextField.getText()),
                        Integer.parseInt(totalCostTextField.getText())
                )
        );
        if (trainingOnTextField.getText().isEmpty()|| dateDatePicker.getValue().isAfter(LocalDate.now())
                || totalParticipantTextField.getText().isEmpty() || totalCostTextField.getText().isEmpty()) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Please fill up properly");
            errorAlert.show();
        }

        else{
            for (TrainingAndDevelopmentProgram t: trainingAndDevelopmentProgramList){
                programRecordTableView.getItems().add(t);
            }

            try {
                FileWriter fw = null;
                File f = new File("training&DevelopmentProgramInfo.txt");
                if(f.exists()){
                    fw = new FileWriter(f, true);
                }
                else{
                    fw = new FileWriter(f);
                }

                String str = "";
                for (TrainingAndDevelopmentProgram t:trainingAndDevelopmentProgramList){
                    str += t.toString("for file");
                    fw.write(str);
                    fw.close();
                }
            } catch (Exception e) {
                //
            }
        }
        trainingOnTextField.clear();
        totalParticipantTextField.clear();
        totalCostTextField.clear();
    }
}