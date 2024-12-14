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

import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;

public class ReviewBudgetViewController
{
    @javafx.fxml.FXML
    private TableColumn<Budget,String> totalBudgetCol;
    @javafx.fxml.FXML
    private TableColumn<Budget,String> fundraisingBudgetCol;
    @javafx.fxml.FXML
    private TableColumn<Budget,String> salaryBudgetCol;
    @javafx.fxml.FXML
    private TableColumn<Budget,String> projectBudgetCol;
    @javafx.fxml.FXML
    private TableColumn<Budget,String> administrationBudgetCol;
    @javafx.fxml.FXML
    private TableColumn<Budget,String> financialPeriodCol;
    @javafx.fxml.FXML
    private TableView<Budget> budgetTableView;

    @javafx.fxml.FXML
    public void initialize() {
        financialPeriodCol.setCellValueFactory(new PropertyValueFactory<Budget,String>("financialPeriod"));
        fundraisingBudgetCol.setCellValueFactory(new PropertyValueFactory<Budget,String>("fundraisingBudget"));
        administrationBudgetCol.setCellValueFactory(new PropertyValueFactory<Budget,String>("administrationBudget"));
        projectBudgetCol.setCellValueFactory(new PropertyValueFactory<Budget,String>("projectBudget"));
        salaryBudgetCol.setCellValueFactory(new PropertyValueFactory<Budget,String>("salaryBudget"));
        totalBudgetCol.setCellValueFactory(new PropertyValueFactory<Budget,String>("totalBudget"));
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
    public void loadBudgetPlanOnAction(ActionEvent actionEvent) {
        File f = new File("Budget.txt");
        try{
            Scanner s = new Scanner(f);
            String str = "";
            String[] tokens;
            while(s.hasNextLine()){
                str = s.nextLine();
                tokens = str.split(",");
                Budget c = new Budget(tokens[0], Float.parseFloat(tokens[1]),
                        Float.parseFloat(tokens[2]),
                        Float.parseFloat(tokens[3]),
                        Float.parseFloat(tokens[4]),
                        Float.parseFloat(tokens[5])
                );
                budgetTableView.getItems().add(c);
            }
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/Farha_Yesmin/budgetManagement-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage currentStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            currentStage.setScene(nextScene);
            currentStage.show();
        }
        catch(Exception e) {
//
        }
    }
}