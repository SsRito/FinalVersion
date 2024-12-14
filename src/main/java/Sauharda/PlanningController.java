package Sauharda;

import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class PlanningController
{
    @javafx.fxml.FXML
    private TextArea newGoalTextAea;

    ArrayList<CEOPlan> ceoPlanList;

    @javafx.fxml.FXML
    public void initialize() {
        ceoPlanList = new ArrayList<CEOPlan>();
    }

    @javafx.fxml.FXML
    public void publishGoalOnAction(ActionEvent actionEvent) {
        ceoPlanList.add(
                new CEOPlan(
                        newGoalTextAea.getText()
                )
        );

        if (newGoalTextAea.getText().isEmpty()){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Please fill up");
            errorAlert.show();
        }
        else{
            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmAlert.setContentText("Published Successfully");
            confirmAlert.show();

            FileWriter fw = null;
            File f = new File("newGoal.txt");
            try {
                if(f.exists()){
                    fw = new FileWriter(f, true);
                }
                else{
                    fw = new FileWriter(f);
                }

                String str = "";
                for (CEOPlan c:ceoPlanList){
                    str += c.toString("for file");
                    fw.write(str);
                    fw.close();
                }
            } catch (Exception e) {
                //
            }
        }
        newGoalTextAea.clear();
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

    @javafx.fxml.FXML
    public void viewKPIMetricsOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Sauharda/kpiMetrics-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("KPI Metrics");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }
}