package Sauharda;

import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class VolunteerRecruitmentController
{
    @javafx.fxml.FXML
    private TableColumn<Volunteer, String> volunteeringFieldTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Volunteer, String> nameTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> volunteeringFieldComboBox;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TableView<Volunteer> assignedVolunteerTableView;

    ArrayList<Volunteer> volunteerList;

    @javafx.fxml.FXML
    public void initialize() {
        volunteeringFieldComboBox.getItems().addAll("Community Development", "Education", "Healthcare", "Human Rights", "Youth Development");

        nameTableColumn.setCellValueFactory(new PropertyValueFactory<Volunteer, String>("name"));
        volunteeringFieldTableColumn.setCellValueFactory(new PropertyValueFactory<Volunteer, String>("volunteeringField"));

        volunteerList = new ArrayList<Volunteer>();
    }

    @javafx.fxml.FXML
    public void sendReportToCEOOnAction(ActionEvent actionEvent) {
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setContentText("Sent Successfully");
        confirmAlert.show();
    }

    @javafx.fxml.FXML
    public void goBackToRecruitmentPageOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Sauharda/recruitment-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Recruitment");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void goBackToDashboardOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

            FXMLLoader fxmlLoader
                    = new FXMLLoader(MainApplication.class.getResource("/Sauharda/hrManagerDashboard.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());

            stage.setTitle("Hr Manager");
            stage.setScene(nextScene);
            stage.show();
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void viewApplicationOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveAndShowOnAction(ActionEvent actionEvent) {
        assignedVolunteerTableView.getItems().clear();
        volunteerList.add(
                new Volunteer(
                        nameTextField.getText(),
                        volunteeringFieldComboBox.getValue()
                )
        );
        if (nameTextField.getText().isEmpty() || volunteeringFieldComboBox.getValue().isEmpty()){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Please fill up properly");
            errorAlert.show();
        }
        else{
            for (Volunteer v: volunteerList){
                assignedVolunteerTableView.getItems().add(v);
            }
        }

        try {
            FileWriter fw = null;
            File f = new File("assignedVolunteerInfo.txt");
            if(f.exists()){
                fw = new FileWriter(f, true);
            }
            else{
                fw = new FileWriter(f);
            }

            String str = "";
            for (Volunteer v:volunteerList){
                str += v.toString("for file");
                fw.write(str);
                fw.close();
            }
        } catch (Exception e) {
            //
        }
    }
}