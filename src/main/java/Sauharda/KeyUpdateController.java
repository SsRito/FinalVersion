package Sauharda;

import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class KeyUpdateController
{
    @javafx.fxml.FXML
    private ComboBox<String> announcingForComboBox;
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TextArea announcementTextArea;

    ArrayList<KeyUpdate>  keyUpdateList;

    @javafx.fxml.FXML
    public void initialize() {
        announcingForComboBox.getItems().addAll("All", "Accountant", "HR Manager", "Event Organiser", "Research Analyst");
        keyUpdateList = new ArrayList<KeyUpdate>();
    }

    @javafx.fxml.FXML
    public void postAnnouncementOnAction(ActionEvent actionEvent) {
        keyUpdateList.add(
                new KeyUpdate(
                        announcingForComboBox.getValue(),
                        announcementTextArea.getText(),
                        dateDatePicker.getValue()
                )
        );

        if (announcementTextArea.getText().isEmpty()|| dateDatePicker.getValue().isAfter(LocalDate.now())
        || announcingForComboBox.getValue().isBlank()){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Please fill up properly");
            errorAlert.show();
        }
        else{
            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmAlert.setContentText("Posted Successfully");
            confirmAlert.show();

            FileWriter fw = null;
            File f = new File("keyUpdateDetails.txt");
            try {
                if(f.exists()){
                    fw = new FileWriter(f, true);
                }
                else{
                    fw = new FileWriter(f);
                }

                String str = "";
                for (KeyUpdate k:keyUpdateList){
                    str += k.toString("for file");
                    fw.write(str);
                    fw.close();
                }
            } catch (Exception e) {
                //
            }
        }
        announcementTextArea.clear();
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
}