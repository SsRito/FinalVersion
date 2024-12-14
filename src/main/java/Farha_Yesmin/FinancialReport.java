package Farha_Yesmin;

import java.time.LocalDate;

public class FinancialReport {
    private String dateRange;
    private LocalDate reportDate;
    private float income,expense,donationAmount;

    public FinancialReport() {
    }

    public FinancialReport(String dateRange, LocalDate reportDate, float income, float expense, float donationAmount) {
        this.dateRange = dateRange;
        this.reportDate = reportDate;
        this.income = income;
        this.expense = expense;
        this.donationAmount = donationAmount;
    }

    public FinancialReport(String dateRange, LocalDate reportDate, float income, float expense) {
        this.dateRange = dateRange;
        this.reportDate = reportDate;
        this.income = income;
        this.expense = expense;
    }
    public FinancialReport(String dateRange, LocalDate reportDate, float donationAmount){
        this.dateRange = dateRange;
        this.reportDate = reportDate;
        this.donationAmount = donationAmount;
    }

    public String getDateRange() {
        return dateRange;
    }

    public void setDateRange(String dateRange) {
        this.dateRange = dateRange;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public float getExpense() {
        return expense;
    }

    public void setExpense(float expense) {
        this.expense = expense;
    }

    public float getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(float donationAmount) {
        this.donationAmount = donationAmount;
    }

    @Override
    public String toString() {
        return "FinancialReport{" +
                "dateRange='" + dateRange + '\'' +
                ", reportDate=" + reportDate +
                ", income=" + income +
                ", expense=" + expense +
                ", donationAmount=" + donationAmount +
                '}';
    }
    public String toString(String monthly){
        return dateRange+","+reportDate+","+income+","+expense+"\n";
    }
}
