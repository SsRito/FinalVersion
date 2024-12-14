package Farha_Yesmin;
import com.sauharda.oop_projects.group_42.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class LoanViewController
{
    @javafx.fxml.FXML
    private TextField borrowerNameTextField;
    @javafx.fxml.FXML
    private TextField borrowingAmountTextField;
    @javafx.fxml.FXML
    private TextField repaymentTermTextField;
    ArrayList<Loan>loanList;
    @javafx.fxml.FXML
    public void initialize() {
        loanList = new ArrayList<>();
    }

    @javafx.fxml.FXML
    public void addAndSaveLoanOnAction(ActionEvent actionEvent) {
        loanList.add(new Loan(
                borrowerNameTextField.getText(),
                repaymentTermTextField.getText(),
                Float.parseFloat(borrowingAmountTextField.getText())
        ));
        borrowerNameTextField.clear();
        repaymentTermTextField.clear();
        borrowingAmountTextField.clear();
        FileWriter fw = null;
        File f = new File("Loan.txt");
        try {
            if(f.exists()){
                fw = new FileWriter(f,true); //true means append
            }
            else{
                fw = new FileWriter(f); //by default false means new file add
            }
            String str = "";
            for(Loan l: loanList){
                str += l.toString();
            }
            fw.write(str);
            fw.close();
        }
        catch (Exception e) {
            //
        }


    }

    @javafx.fxml.FXML
    public void loanRecordsOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/Farha_Yesmin/loanRecord-view.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage currentStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            currentStage.setTitle("Loan Records");
            currentStage.setScene(nextScene);
            currentStage.show();
        }
        catch(Exception e) {
//
        }
    }
}