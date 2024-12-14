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

public class EmployeePerformanceReportView
{
    @javafx.fxml.FXML
    private TableColumn<Employee, String> fromDateTableColumn;
    @javafx.fxml.FXML
    private TableView<Employee> employeePerformanceTableView;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> nameTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> toDateTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> performanceTableColumn;

    @javafx.fxml.FXML
    public void initialize() {
        fromDateTableColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("fromDate"));
        toDateTableColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("toDate"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeName"));
        performanceTableColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("performance"));
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
        employeePerformanceTableView.getItems().clear();
        File f = new File("employeePerformanceInfo.txt");
        try {
            Scanner s = new Scanner(f);
            String str = "";
            String[] tokens;
            while(s.hasNextLine()){
                str = s.nextLine();
                tokens = str.split(",");
                Employee e = new Employee(tokens[0], tokens[1], LocalDate.parse(tokens[2]), LocalDate.parse(tokens[3]));
                employeePerformanceTableView.getItems().add(e);
            }

        } catch (Exception e) {
            //
        }
    }
}