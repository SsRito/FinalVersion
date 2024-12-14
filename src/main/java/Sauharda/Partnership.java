package Sauharda;

import java.time.LocalDate;

public class Partnership {
    private String companyName, proposalDetails, status;
    private LocalDate date;
    private int amount;

    public Partnership() {
    }

    public Partnership(String companyName, String proposalDetails, String status, LocalDate date, int amount) {
        this.companyName = companyName;
        this.proposalDetails = proposalDetails;
        this.status = status;
        this.date = date;
        this.amount = amount;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getProposalDetails() {
        return proposalDetails;
    }

    public void setProposalDetails(String proposalDetails) {
        this.proposalDetails = proposalDetails;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Partnership{" +
                "companyName='" + companyName + '\'' +
                ", proposalDetails='" + proposalDetails + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }

    public String toString(String reason){
        return companyName + "," + proposalDetails + "," + status + "," + date + "," + amount + '\n';
    }
}
