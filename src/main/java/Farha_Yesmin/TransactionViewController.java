package Farha_Yesmin;

import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;


public class TransactionViewController
{
    @javafx.fxml.FXML
    private DatePicker transactiondateDatePicker;
    @javafx.fxml.FXML
    private TextField amountTextField;
    @javafx.fxml.FXML
    private TextField transactionIDTextField;
    @javafx.fxml.FXML
    private TextField paymentMethodTextField;
    @javafx.fxml.FXML
    private ComboBox<String> transactionCategoryComboBox;
    ArrayList<Transaction> transactionList;

    @javafx.fxml.FXML
    public void initialize() {
        transactionList = new ArrayList<>();
        transactiondateDatePicker.setValue(LocalDate.now());
        transactionCategoryComboBox.getItems().addAll("Donation","Expense","Income");

    }

    @javafx.fxml.FXML
    public void saveTransactionOnAction(ActionEvent actionEvent) {
        transactionList.add(new Transaction(transactionIDTextField.getText(),
                transactiondateDatePicker.getValue(),
                Float.parseFloat(amountTextField.getText()),
                transactionCategoryComboBox.getValue(),
                paymentMethodTextField.getText()
        ));
        transactionIDTextField.clear();
        amountTextField.clear();
        paymentMethodTextField.clear();
        transactionCategoryComboBox.setValue(null);
        FileWriter fw = null;
        File f = new File("TransactionReport.txt");
        try {
            if(f.exists()){
                fw = new FileWriter(f,true); //true means append
            }
            else{
                fw = new FileWriter(f); //by default false means new file add
            }
            String str = "";
            for(Transaction c: transactionList){
                str += c.toString("for file");
            }
            fw.write(str);
            fw.close();
        }
        catch (Exception e) {
            //
        }
    }

    @javafx.fxml.FXML
    public void viewTransactionOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/Farha_Yesmin/viewTransaction-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage currentStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            currentStage.setTitle("Daily Transaction");
            currentStage.setScene(nextScene);
            currentStage.show();
        }
        catch(Exception e) {
//
        }

    }

}