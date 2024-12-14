package Sauharda;

import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class JobRecruitmentController
{
    @javafx.fxml.FXML
    private TableColumn<NewEmployee, String> dobTableColumn;
    @javafx.fxml.FXML
    private TableColumn<NewEmployee, String> nameTableColumn;
    @javafx.fxml.FXML
    private TableColumn<NewEmployee, String> addressTableColumn;
    @javafx.fxml.FXML
    private TableColumn<NewEmployee, String> genderTableColumn;
    @javafx.fxml.FXML
    private TableView<String> newEmployeeTableView;

    ArrayList<NewEmployee>  newEmployeeList;


    @FXML
    public void initialize() {
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<NewEmployee, String>("name"));
        dobTableColumn.setCellValueFactory(new PropertyValueFactory<NewEmployee, String>("dob"));
        genderTableColumn.setCellValueFactory(new PropertyValueFactory<NewEmployee, String>("gender"));
        addressTableColumn.setCellValueFactory(new PropertyValueFactory<NewEmployee, String>("address"));
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
    public void loadApplicationOnAction(ActionEvent actionEvent) {
            File f = new File("assignedVolunteerInfo.txt");
            try {
                Scanner s = new Scanner(f);
                String str = "";
                String[] tokens;
                while(s.hasNextLine()){
                    str = s.nextLine();
                    tokens = str.split(",");
                    NewEmployee n = new NewEmployee(tokens[0], tokens[1], tokens[2], tokens[3]);
                    //newEmployeeTableView.getItems().add(n);
                }

            } catch (Exception e) {
                //
            }
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