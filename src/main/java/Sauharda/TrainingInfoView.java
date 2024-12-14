package Sauharda;

import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;

public class TrainingInfoView
{
    @javafx.fxml.FXML
    private TableColumn<TrainingAndDevelopmentProgram, String> totalCostTableColumn;
    @javafx.fxml.FXML
    private TableView<TrainingAndDevelopmentProgram> programRecordTableView;
    @javafx.fxml.FXML
    private TableColumn<TrainingAndDevelopmentProgram, String> dateTableColumn;
    @javafx.fxml.FXML
    private TableColumn<TrainingAndDevelopmentProgram, String> trainingOnTableColumn;
    @javafx.fxml.FXML
    private TableColumn<TrainingAndDevelopmentProgram, String> totalParticipantTableColumn;

    @javafx.fxml.FXML
    public void initialize() {
        trainingOnTableColumn.setCellValueFactory(new PropertyValueFactory<TrainingAndDevelopmentProgram, String>("trainingOn"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<TrainingAndDevelopmentProgram, String>("date"));
        totalParticipantTableColumn.setCellValueFactory(new PropertyValueFactory<TrainingAndDevelopmentProgram, String>("totalParticipant"));
        totalCostTableColumn.setCellValueFactory(new PropertyValueFactory<TrainingAndDevelopmentProgram, String>("totalCost"));
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
    public void loadReportOnAction(ActionEvent actionEvent) {
        programRecordTableView.getItems().clear();
        File f = new File("training&DevelopmentProgramInfo.txt");
        try {
            Scanner s = new Scanner(f);
            String str = "";
            String[] tokens;
            while(s.hasNextLine()){
                str = s.nextLine();
                tokens = str.split(",");
                TrainingAndDevelopmentProgram t = new TrainingAndDevelopmentProgram(tokens[0], LocalDate.parse(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
                programRecordTableView.getItems().add(t);
            }

        } catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void goBackToKPIPageOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Sauharda/kpiMetrics-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("KPI Metrics");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }
}