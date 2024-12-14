package Sauharda;

import java.time.LocalDate;

public class PolicyCompliance {
    private String policyName, complianceStatus, details, correctiveAction;
    private LocalDate deadline;

    public PolicyCompliance() {
    }

    public PolicyCompliance(String policyName, String complianceStatus, String details, String correctiveAction, LocalDate deadline) {
        this.policyName = policyName;
        this.complianceStatus = complianceStatus;
        this.details = details;
        this.correctiveAction = correctiveAction;
        this.deadline = deadline;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getComplianceStatus() {
        return complianceStatus;
    }

    public void setComplianceStatus(String complianceStatus) {
        this.complianceStatus = complianceStatus;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCorrectiveAction() {
        return correctiveAction;
    }

    public void setCorrectiveAction(String correctiveAction) {
        this.correctiveAction = correctiveAction;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "PolicyCompliance{" +
                "policyName='" + policyName + '\'' +
                ", complianceStatus='" + complianceStatus + '\'' +
                ", details='" + details + '\'' +
                ", correctiveAction='" + correctiveAction + '\'' +
                ", deadline=" + deadline +
                '}';
    }

    public String toString(String reason){
        return policyName + "," + complianceStatus + "," + details + "," + correctiveAction + "," + deadline + '\n';
    }
}
