package Farha_Yesmin;

import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class DonorRecordViewcontroller
{
    @javafx.fxml.FXML
    private TextField donationMethodTextField;
    @javafx.fxml.FXML
    private DatePicker donationDatePicker;
    @javafx.fxml.FXML
    private TextField donorIDTextField;
    @javafx.fxml.FXML
    private TextField donationAmountTextField;
    ArrayList<DonorRecord>donorRecord;

    @javafx.fxml.FXML
    public void initialize() {
        donorRecord = new ArrayList<>();
        donationDatePicker.setValue(LocalDate.now());
    }

    @javafx.fxml.FXML
    public void showDonorRecordOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/Farha_Yesmin/showDonorRecord-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage currentStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            currentStage.setTitle("Donor Record");
            currentStage.setScene(nextScene);
            currentStage.show();
        }
        catch(Exception e) {
//
        }
    }


    @javafx.fxml.FXML
    public void addDonorandSaveOnAction(ActionEvent actionEvent) {
        DonorRecord donor = new DonorRecord(
                donorIDTextField.getText(),donationDatePicker.getValue(),
                Float.parseFloat(donationAmountTextField.getText()),
                donationMethodTextField.getText()
        );
        donorRecord.add(donor);


        FileWriter fw = null;
        File f = new File("DonorRecord.txt");
        try {
            if(f.exists()){
                fw = new FileWriter(f,true); //true means append
            }
            else{
                fw = new FileWriter(f); //by default false means new file add
            }
            String str = "";
            for(DonorRecord d: donorRecord){
                str += d.toString("donorRecord");
            }
            fw.write(str);
            fw.close();
        }
        catch (Exception e) {
            //
        }


    }
}