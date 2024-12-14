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

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;


public class ShowDonorRecordViewController
{
    @javafx.fxml.FXML
    private TableColumn<DonorRecord,String> donorIDCol;
    @javafx.fxml.FXML
    private TableColumn<DonorRecord, String> donationDateCol;
    @javafx.fxml.FXML
    private TableColumn<DonorRecord,String> donationAmountCol;
    @javafx.fxml.FXML
    private TableColumn<DonorRecord,String> donationMethodCol;
    @javafx.fxml.FXML
    private TableView<DonorRecord> donorRecordTableView;

    @javafx.fxml.FXML
    public void initialize() {
        donorIDCol.setCellValueFactory(new PropertyValueFactory<DonorRecord,String>("donorID"));
        donationAmountCol.setCellValueFactory(new PropertyValueFactory<DonorRecord,String>("donationAmount"));
        donationMethodCol.setCellValueFactory(new PropertyValueFactory<DonorRecord,String>("donationMethod"));
        donationDateCol.setCellValueFactory(new PropertyValueFactory<DonorRecord,String>("donationDate"));
    }

    @javafx.fxml.FXML
    public void loadDonorRecordOnAction(ActionEvent actionEvent) {


        File f = new File("DonorRecord.txt");
        try{
            Scanner s = new Scanner(f);
            String str = "";
            String[] tokens;
            while(s.hasNextLine()){
                str = s.nextLine();
                tokens = str.split(",");
                DonorRecord c = new DonorRecord(tokens[0],LocalDate.parse(tokens[1]),
                        Float.parseFloat(tokens[2]),
                        tokens[3]);
                donorRecordTableView.getItems().add(c);
            }
        }
        catch (Exception e) {
            //
        }


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
    public void BackOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/Farha_Yesmin/donorRecord-view.fxml"));
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
}