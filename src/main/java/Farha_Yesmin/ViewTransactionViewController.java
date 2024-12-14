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


public class ViewTransactionViewController
{
    @javafx.fxml.FXML
    private TableView<Transaction> transactionTableView;
    @javafx.fxml.FXML
    private TableColumn<Transaction,String> amountCol;
    @javafx.fxml.FXML
    private TableColumn<Transaction,String> transactionDateCol;
    @javafx.fxml.FXML
    private TableColumn<Transaction,String> categoryCol;
    @javafx.fxml.FXML
    private TableColumn<Transaction,String> transactionIDCol;
    @javafx.fxml.FXML
    private TableColumn<Transaction,String> paymentMethodCol;

    @javafx.fxml.FXML
    public void initialize() {
        transactionIDCol.setCellValueFactory(new PropertyValueFactory<Transaction, String>("transactionID"));
        transactionDateCol.setCellValueFactory(new PropertyValueFactory<Transaction, String>("transactionDate"));
        amountCol.setCellValueFactory(new PropertyValueFactory<Transaction, String>("amount"));
        paymentMethodCol.setCellValueFactory(new PropertyValueFactory<Transaction, String>("paymentMethod"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<Transaction, String>("category"));

    }

    @javafx.fxml.FXML
    public void loadTransactionReportOnAction(ActionEvent actionEvent) {
        File f = new File("TransactionReport.txt");
        try {
            Scanner s = new Scanner(f);
            String str = "";
            String[] tokens;
            while (s.hasNextLine()) {
                str = s.nextLine();
                tokens = str.split(",");
                Transaction t = new Transaction(tokens[0], LocalDate.parse(tokens[1]), Float.parseFloat(tokens[2]),
                        (tokens[3]), tokens[4]);
                transactionTableView.getItems().add(t);
            }
        } catch (Exception e) {
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
    public void BackOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/Farha_Yesmin/transaction-view.fxml"));
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