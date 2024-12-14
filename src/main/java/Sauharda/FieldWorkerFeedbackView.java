package Sauharda;

import Farha_Yesmin.Budget;
import Farha_Yesmin.FeedBack;
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

public class FieldWorkerFeedbackView
{
    @javafx.fxml.FXML
    private TableColumn<Feedback,String> fieldWorkerFeedbackDateTableColumn;
    @javafx.fxml.FXML
    private TableView<Feedback> fieldWorkerTableView;
    @javafx.fxml.FXML
    private TableColumn<Feedback,String> fieldWorkerNameTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Feedback,String> fieldWorkerFeedbackTableColumn;

    @javafx.fxml.FXML
    public void initialize() {
        fieldWorkerFeedbackDateTableColumn.setCellValueFactory(new PropertyValueFactory<Feedback,String>("date"));
        fieldWorkerNameTableColumn.setCellValueFactory(new PropertyValueFactory<Feedback,String>("name"));
        fieldWorkerFeedbackTableColumn.setCellValueFactory(new PropertyValueFactory<Feedback,String>("feedbackText"));
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
    public void goBackToFeedbackOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Sauharda/viewFeedback.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Feedback");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void refreshTableOnAction(ActionEvent actionEvent) { File f = new File("FeedBack.txt");
        try{
            Scanner s = new Scanner(f);
            String str = "";
            String[] tokens;
            while(s.hasNextLine()){
                str = s.nextLine();
                tokens = str.split(",");
                FeedBack fe = new FeedBack(tokens[0], tokens[1], LocalDate.parse(tokens[2]));
                fieldWorkerTableView.getItems().add(fe);
            }
        }
        catch (Exception e) {
            //
        }
    }
}