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

public class EmployeePerformanceController
{
    @javafx.fxml.FXML
    private TableColumn<Employee, String> fromDateTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> nameTableColumn;
    @javafx.fxml.FXML
    private DatePicker fromDateDatePicker;
    @javafx.fxml.FXML
    private TextField employeeNameTextField;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> toDateTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> performanceComboBox;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> performanceTableColumn;
    @javafx.fxml.FXML
    private DatePicker toDateDatePicker;
    @javafx.fxml.FXML
    private TableView<Employee> employeeRecordTableView;

    ArrayList<Employee> employeeList;

    @javafx.fxml.FXML
    public void initialize() {
        performanceComboBox.getItems().addAll("Excellent", "Good", "Neutral", "Poor", "Awful");

        fromDateTableColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("fromDate"));
        toDateTableColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("toDate"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeName"));
        performanceTableColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("performance"));

        employeeList = new ArrayList<Employee>();
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
        employeeRecordTableView.getItems().clear();
        employeeList.add(
                new Employee(
                        employeeNameTextField.getText(),
                        performanceComboBox.getValue(),
                        fromDateDatePicker.getValue(),
                        toDateDatePicker.getValue()
                )
        );
        if (employeeNameTextField.getText().isEmpty()|| fromDateDatePicker.getValue().isAfter(LocalDate.now())
                || toDateDatePicker.getValue().isAfter(LocalDate.now()) || performanceComboBox.getValue().isEmpty()) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Please fill up properly");
            errorAlert.show();
        }
        else{
            for (Employee e: employeeList){
                employeeRecordTableView.getItems().add(e);
            }

            try {
                FileWriter fw = null;
                File f = new File("employeePerformanceInfo.txt");
                if(f.exists()){
                    fw = new FileWriter(f, true);
                }
                else{
                    fw = new FileWriter(f);
                }

                String str = "";
                for (Employee e:employeeList){
                    str += e.toString("for file");
                    fw.write(str);
                    fw.close();
                }
            } catch (Exception e) {
                //
            }
        }
        employeeNameTextField.clear();
    }
}