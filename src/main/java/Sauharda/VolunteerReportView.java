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
import java.util.Scanner;

public class VolunteerReportView
{
    @javafx.fxml.FXML
    private TableColumn<Volunteer, String> volunteeringFieldTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Volunteer, String> nameTableColumn;
    @javafx.fxml.FXML
    private TableView<Volunteer> volunteerReportTableView;

    @javafx.fxml.FXML
    public void initialize() {
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<Volunteer, String>("name"));
        volunteeringFieldTableColumn.setCellValueFactory(new PropertyValueFactory<Volunteer, String>("volunteeringField"));
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

    @javafx.fxml.FXML
    public void loadReportOnAction(ActionEvent actionEvent) {
        volunteerReportTableView.getItems().clear();
        File f = new File("assignedVolunteerInfo.txt");
        try {
            Scanner s = new Scanner(f);
            String str = "";
            String[] tokens;
            while(s.hasNextLine()){
                str = s.nextLine();
                tokens = str.split(",");
                Volunteer v = new Volunteer(tokens[0], tokens[1]);
                volunteerReportTableView.getItems().add(v);
            }

        } catch (Exception e) {
            //
        }
    }
}