package Farha_Yesmin;

import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FinancialReportViewController {
    @javafx.fxml.FXML
    private DatePicker reportDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> reportTypeComboBox;
    @javafx.fxml.FXML
    private TextField expenseTextField;
    @javafx.fxml.FXML
    private TextField incomeTextField;
    @javafx.fxml.FXML
    private TextField donationAmountTextField;
    @javafx.fxml.FXML
    private ComboBox<String> dateRangeComboBox;
    ArrayList<FinancialReport>monthlyList;
    ArrayList<FinancialReport>projectList;
    ArrayList<FinancialReport>donationList;


    @javafx.fxml.FXML
    public void initialize() {
        monthlyList = new ArrayList<>();
        projectList = new ArrayList<>();
        donationList = new ArrayList<>();
        reportTypeComboBox.getItems().addAll("Monthly Financial Report", "Project Financial report",
                "Donation Financial Report");
        dateRangeComboBox.getItems().addAll("Monthly", "Weekly", "Daily");
    }

    @javafx.fxml.FXML
    public void donationReportOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/Farha_Yesmin/donationFinancialReport-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.setTitle("Donation Report");
            currentStage.setScene(nextScene);
            currentStage.show();
        } catch (Exception e) {
//
        }
    }

    @javafx.fxml.FXML
    public void projectReportOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/Farha_Yesmin/projectFinancialReport-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.setTitle("Project Report");
            currentStage.setScene(nextScene);
            currentStage.show();
        } catch (Exception e) {
//
        }
    }

    @javafx.fxml.FXML
    public void monthlyReportOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/Farha_Yesmin/monthlyFinancialReport-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.setTitle("Monthly Report");
            currentStage.setScene(nextScene);
            currentStage.show();
        } catch (Exception e) {
//
        }
    }


    @FXML
    public void saveDonationReportOnAction(ActionEvent actionEvent) {
        donationList.add(new FinancialReport(
                dateRangeComboBox.getValue(),
                reportDatePicker.getValue(),
                Float.parseFloat(donationAmountTextField.getText())
        ));
        File f = new File("CourseInfo.bin");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            if (f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            for(FinancialReport c: donationList){
                oos.writeObject(c);
            }
            oos.close();
        }
        catch (Exception e){
            //
        }


    }
    @FXML
    public void saveMonthlyReportOnAction(ActionEvent actionEvent) {
        monthlyList.add(new FinancialReport(
                dateRangeComboBox.getValue(),
                reportDatePicker.getValue(),
                Float.parseFloat(incomeTextField.getText()),
                Float.parseFloat(expenseTextField.getText())
        ));

//        FileWriter fw = null;
//        File f = new File("donationReport.txt");
//        try {
//            if(f.exists()){
//                fw = new FileWriter(f,true); //true means append
//            }
//            else{
//                fw = new FileWriter(f); //by default false means new file add
//            }
//            String str = "";
//            for(FinancialReport d: donationList){
//                str += d.toString(toString());
//            }
//            fw.write(str);
//            fw.close();
//        }
//        catch (Exception e) {
//            //
//        }
    }

    @FXML
    public void saveProjectReportOnAction(ActionEvent actionEvent) {
    }
}