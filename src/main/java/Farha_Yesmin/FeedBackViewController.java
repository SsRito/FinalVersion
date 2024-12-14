package Farha_Yesmin;

import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;


public class FeedBackViewController
{
    @javafx.fxml.FXML
    private TextArea feedBackTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> feedBackCategoryComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        feedBackCategoryComboBox.getItems().addAll("General FeedBack","Project","Program","Team");
    }

    @javafx.fxml.FXML
    public void submitOnAction(ActionEvent actionEvent) {
        String feedBackCategory = feedBackCategoryComboBox.getValue();
        String feedBackText = feedBackTextArea.getText();
        if (feedBackCategory.isEmpty() || feedBackText.isEmpty()){
            showAlert(Alert.AlertType.WARNING,"Incomplete Input");
        }
        else{
            showAlert(Alert.AlertType.CONFIRMATION,"Thank you for your feedback");

            FileWriter fw = null;
            File f = new File("FeedBack.txt");
            try {
                if(f.exists()){
                    fw = new FileWriter(f,true); //true means append
                }
                else{
                    fw = new FileWriter(f); //by default false means new file add
                }
                String str = "";
//                for(Budget d: budgetList){
//                    str += d.toString("budget");
//                }
                fw.write(str);
                fw.close();
            }
            catch (Exception e) {
                //
            }
        }
        feedBackCategoryComboBox.setValue(null);
        feedBackTextArea.clear();



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
    private void showAlert(Alert.AlertType alertType,String message) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }
}