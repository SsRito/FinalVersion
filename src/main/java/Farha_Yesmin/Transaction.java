package Farha_Yesmin;

import java.time.LocalDate;

public class Transaction {
    private String transactionID;
    private LocalDate transactionDate;
    private float amount;
    private String category;
    private String paymentMethod;

    public Transaction() {
    }

    public Transaction(String transactionID, LocalDate transactionDate, float amount, String category, String paymentMethod) {
        this.transactionID = transactionID;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.category = category;
        this.paymentMethod = paymentMethod;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionID='" + transactionID + '\'' +
                ", transactionDate=" + transactionDate +
                ", amount=" + amount +
                ", category='" + category + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
    public String toString(String transaction){
        return transactionID+","+transactionDate+","+amount+","+category+","+
                paymentMethod+'\n';
    }
}
