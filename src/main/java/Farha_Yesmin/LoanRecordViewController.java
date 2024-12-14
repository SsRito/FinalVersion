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
import java.util.Scanner;

public class LoanRecordViewController
{
    @javafx.fxml.FXML
    private TableView<Loan> loanTableView;
    @javafx.fxml.FXML
    private TableColumn<Loan,String> repaymentTermCol;
    @javafx.fxml.FXML
    private TableColumn<Loan,String> borrowerNameCol;
    @javafx.fxml.FXML
    private TableColumn<Loan,String> borrowingAmountCol;

    @javafx.fxml.FXML
    public void initialize() {
        borrowerNameCol.setCellValueFactory(new PropertyValueFactory<Loan,String>("borrowerName"));
        borrowingAmountCol.setCellValueFactory(new PropertyValueFactory<Loan,String>("borrowingAmount"));
        repaymentTermCol.setCellValueFactory(new PropertyValueFactory<Loan,String>("repaymentTerm"));
    }

    @javafx.fxml.FXML
    public void loadLoanRecordsOnAction(ActionEvent actionEvent) {
        File f = new File("Loan.txt");
        try{
            Scanner s = new Scanner(f);
            String str = "";
            String[] tokens;
            while(s.hasNextLine()){
                str = s.nextLine();
                tokens = str.split(",");
                Loan l = new Loan(tokens[0],tokens[1],
                        Float.parseFloat(tokens[2])
                );
                loanTableView.getItems().add(l);
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
    public void backOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/Farha_Yesmin/loan-view.fxml"));
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