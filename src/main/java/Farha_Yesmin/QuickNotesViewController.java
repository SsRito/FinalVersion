package Farha_Yesmin;

import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class QuickNotesViewController
{
    @javafx.fxml.FXML
    private DatePicker noteDatePicker;
    @javafx.fxml.FXML
    private TextArea noteTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> projectNameComboBox;
    ArrayList<QuickNote>notesList;

    @javafx.fxml.FXML
    public void initialize() {
        notesList = new ArrayList<>();
        projectNameComboBox.getItems().addAll("Community Development","Education",
                "HealthCare","Human Rights","Youth Development","Others");
        noteDatePicker.setValue(LocalDate.now());
    }

    @javafx.fxml.FXML
    public void saveNoteOnAction(ActionEvent actionEvent) {
        notesList.add(new QuickNote(projectNameComboBox.getValue(),
                noteTextArea.getText(),noteDatePicker.getValue()
        ));
        FileWriter fw = null;
        File f = new File("QuickNote.txt");
        try {
            if(f.exists()){
                fw = new FileWriter(f,true); //true means append
            }
            else{
                fw = new FileWriter(f); //by default false means new file add
            }
            String str = "";
            for(QuickNote q: notesList){
                str += q.toString();
            }
            fw.write(str);
            fw.close();
        }
        catch (Exception e) {
            //
        }
        projectNameComboBox.setValue(null);
        noteTextArea.clear();
    }

    @javafx.fxml.FXML
    public void returnHomeOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/Farha_Yesmin/fieldWorkerDashboard-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage currentStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            currentStage.setTitle("FieldWorker Dashboard");
            currentStage.setScene(nextScene);
            currentStage.show();
        }
        catch(Exception e) {
//
        }
    }
}