package Farha_Yesmin;

import java.time.LocalDate;

public class Expense {
    private String expenseCategory;
    private float expenseAmount;
    private LocalDate expenseDate;
    private String expenseReason;

    public Expense() {
    }

    public Expense(String expenseCategory, float expenseAmount, LocalDate expenseDate, String expenseReason) {
        this.expenseCategory = expenseCategory;
        this.expenseAmount = expenseAmount;
        this.expenseDate = expenseDate;
        this.expenseReason = expenseReason;
    }
    public Expense(String expenseCategory, float expenseAmount){

    }

    public String getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public float getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(float expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getExpenseReason() {
        return expenseReason;
    }

    public void setExpenseReason(String expenseReason) {
        this.expenseReason = expenseReason;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expenseCategory='" + expenseCategory + '\'' +
                ", expenseAmount=" + expenseAmount +
                ", expenseDate=" + expenseDate +
                ", expenseReason='" + expenseReason + '\'' +
                '}';
    }
    public String toString(String category){
        return expenseCategory+","+expenseAmount+"\n";
    }
}
