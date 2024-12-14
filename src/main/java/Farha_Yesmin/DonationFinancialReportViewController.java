package Farha_Yesmin;

import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class DonationFinancialReportViewController
{
    @javafx.fxml.FXML
    private TableView<FinancialReport> donationFinancialReportTableView;
    @javafx.fxml.FXML
    private TableColumn<FinancialReport,String> reportDateDCol;
    @javafx.fxml.FXML
    private TableColumn<FinancialReport,String> donationAmountCol;
    @javafx.fxml.FXML
    private TableColumn<FinancialReport,String> dateRangeDCol;
    ArrayList<FinancialReport>donationList;
    @javafx.fxml.FXML
    public void initialize() {
        reportDateDCol.setCellValueFactory(new PropertyValueFactory<FinancialReport,String>("reportDate"));
        donationAmountCol.setCellValueFactory(new PropertyValueFactory<FinancialReport,String>("donationAmount"));
        dateRangeDCol.setCellValueFactory(new PropertyValueFactory<FinancialReport,String>("dateRange"));
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