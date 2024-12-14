package Farha_Yesmin;
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

public class ProjectFinancialReportViewController
{
    @javafx.fxml.FXML
    private TableView<FinancialReport> projectFinancialReportTableView;
    @javafx.fxml.FXML
    private TableColumn<FinancialReport,String> reportDatePCol;
    @javafx.fxml.FXML
    private TableColumn<FinancialReport,String> dateRangePCol;
    @javafx.fxml.FXML
    private TableColumn<FinancialReport,String> expensePCol;
    @javafx.fxml.FXML
    private TableColumn exoensePCol1;

    @javafx.fxml.FXML
    public void initialize() {
        reportDatePCol.setCellValueFactory(new PropertyValueFactory<FinancialReport,String>("reportDate"));
        dateRangePCol.setCellValueFactory(new PropertyValueFactory<FinancialReport,String>("dateRange"));
        expensePCol.setCellValueFactory(new PropertyValueFactory<FinancialReport,String>("expense"));
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

    @javafx.fxml.FXML
    public void loadFinancialReportOnAction(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/Farha_Yesmin/financialReport-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage currentStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            currentStage.setScene(nextScene);
            currentStage.show();
        }
        catch(Exception e) {
//
        }
    }
}