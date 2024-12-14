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
import java.util.ArrayList;
import java.util.Scanner;

public class MonthlyFinancialReportViewController
{
    @javafx.fxml.FXML
    private TableColumn<FinancialReport,String> incomeCol;
    @javafx.fxml.FXML
    private TableColumn<FinancialReport,String> expenseCol;
    @javafx.fxml.FXML
    private TableColumn<FinancialReport,String> reportDateCol;
    @javafx.fxml.FXML
    private TableView<FinancialReport> monthlyReportTableView;
    @javafx.fxml.FXML
    private TableColumn<FinancialReport,String> dateRangeCol;

    @javafx.fxml.FXML
    public void initialize() {
        reportDateCol.setCellValueFactory(new PropertyValueFactory<FinancialReport,String>("reportDate"));
        dateRangeCol.setCellValueFactory(new PropertyValueFactory<FinancialReport,String>("dateRange"));
        incomeCol.setCellValueFactory(new PropertyValueFactory<FinancialReport,String>("income"));
        expenseCol.setCellValueFactory(new PropertyValueFactory<FinancialReport,String>("expense"));

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
        File f = new File("monthlyReport.txt");
        try{
            Scanner s = new Scanner(f);
            String str = "";
            String[] tokens;
            while(s.hasNextLine()){
                str = s.nextLine();
                tokens = str.split(",");
                FinancialReport m = new FinancialReport(tokens[0],LocalDate.parse(tokens[1]),
                        Float.parseFloat(tokens[2]),
                        Float.parseFloat(tokens[3]));
                monthlyReportTableView.getItems().add(m);
            }
        }
        catch (Exception e) {
            //
        }


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