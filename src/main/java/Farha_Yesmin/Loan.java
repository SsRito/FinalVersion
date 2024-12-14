package Farha_Yesmin;

public class Loan {
    private String borrowerName,repaymentTerm;
    private float borrowingAmount;

    public Loan() {
    }

    public Loan(String borrowerName, String repaymentTerm, float borrowingAmount) {
        this.borrowerName = borrowerName;
        this.repaymentTerm = repaymentTerm;
        this.borrowingAmount = borrowingAmount;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public String getRepaymentTerm() {
        return repaymentTerm;
    }

    public void setRepaymentTerm(String repaymentTerm) {
        this.repaymentTerm = repaymentTerm;
    }

    public float getBorrowingAmount() {
        return borrowingAmount;
    }

    public void setBorrowingAmount(float borrowingAmount) {
        this.borrowingAmount = borrowingAmount;
    }

    @Override
    public String toString() {
        return borrowerName+","+repaymentTerm+","+borrowingAmount+"\n";
    }
}
