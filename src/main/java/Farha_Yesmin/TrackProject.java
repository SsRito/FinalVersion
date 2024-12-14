package Farha_Yesmin;

public class TrackProject {
    private String projectName;
    private float resourceExpense, logisticsExpense, operationalExpense,
            totalExpenseAmount,remainingAmount;

    public TrackProject() {
    }

    public TrackProject(String projectName, float resourceExpense, float logisticsExpense, float operationalExpense, float totalExpenseAmount, float remainingAmount) {
        this.projectName = projectName;
        this.resourceExpense = resourceExpense;
        this.logisticsExpense = logisticsExpense;
        this.operationalExpense = operationalExpense;
        this.totalExpenseAmount = totalExpenseAmount;
        this.remainingAmount = remainingAmount;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public float getResourceExpense() {
        return resourceExpense;
    }

    public void setResourceExpense(float resourceExpense) {
        this.resourceExpense = resourceExpense;
    }

    public float getLogisticsExpense() {
        return logisticsExpense;
    }

    public void setLogisticsExpense(float logisticsExpense) {
        this.logisticsExpense = logisticsExpense;
    }

    public float getOperationalExpense() {
        return operationalExpense;
    }

    public void setOperationalExpense(float operationalExpense) {
        this.operationalExpense = operationalExpense;
    }

    public float getTotalExpenseAmount() {
        return totalExpenseAmount;
    }

    public void setTotalExpenseAmount(float totalExpenseAmount) {
        this.totalExpenseAmount = totalExpenseAmount;
    }

    public float getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(float remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    @Override
    public String toString() {
        return "TrackProject{" +
                "projectName='" + projectName + '\'' +
                ", resourceExpense=" + resourceExpense +
                ", logisticsExpense=" + logisticsExpense +
                ", operationalExpense=" + operationalExpense +
                ", totalExpenseAmount=" + totalExpenseAmount +
                ", remainingAmount=" + remainingAmount +
                '}';
    }
}
