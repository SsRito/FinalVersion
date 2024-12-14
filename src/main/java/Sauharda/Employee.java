package Sauharda;

import java.time.LocalDate;

public class Employee {
    private String employeeName, performance;
    private LocalDate fromDate, toDate;

    public Employee() {
    }

    public Employee(String employeeName, String performance, LocalDate fromDate, LocalDate toDate) {
        this.employeeName = employeeName;
        this.performance = performance;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", performance='" + performance + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }

    public String toString(String reason) {
        return employeeName + "," + performance + "," + fromDate + "," + toDate + '\n';
    }
}
