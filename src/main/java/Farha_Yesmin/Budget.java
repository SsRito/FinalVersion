package Farha_Yesmin;

public class Budget {
    private String financialPeriod;
    private float fundraisingBudget, administrationBudget, projectBudget, salaryBudget, totalBudget;

    public Budget() {
    }

    public Budget(String financialPeriod, float fundraisingBudget, float administrationBudget, float projectBudget, float salaryBudget, float totalBudget) {
        this.financialPeriod = financialPeriod;
        this.fundraisingBudget = fundraisingBudget;
        this.administrationBudget = administrationBudget;
        this.projectBudget = projectBudget;
        this.salaryBudget = salaryBudget;
        this.totalBudget = fundraisingBudget+ administrationBudget+projectBudget+salaryBudget;
    }

    public String getFinancialPeriod() {
        return financialPeriod;
    }

    public void setFinancialPeriod(String financialPeriod) {
        this.financialPeriod = financialPeriod;
    }

    public float getFundraisingBudget() {
        return fundraisingBudget;
    }

    public void setFundraisingBudget(float fundraisingBudget) {
        this.fundraisingBudget = fundraisingBudget;
    }

    public float getAdministrationBudget() {
        return administrationBudget;
    }

    public void setAdministrationBudget(float administrationBudget) {
        this.administrationBudget = administrationBudget;
    }

    public float getProjectBudget() {
        return projectBudget;
    }

    public void setProjectBudget(float projectBudget) {
        this.projectBudget = projectBudget;
    }

    public float getSalaryBudget() {
        return salaryBudget;
    }

    public void setSalaryBudget(float salaryBudget) {
        this.salaryBudget = salaryBudget;
    }

    public float getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(float totalBudget) {
        this.totalBudget = totalBudget;
    }
    public double calculateTotalAmount(float fundraisingBudget,float projectBudget,float salaryBudget,
    float administrationBudget){
        return totalBudget = fundraisingBudget+projectBudget+salaryBudget+
                administrationBudget;
    }

    @Override
    public String toString() {
        return "Budget{" +
                "financialPeriod='" + financialPeriod + '\'' +
                ", fundraisingBudget=" + fundraisingBudget +
                ", administrationBudget=" + administrationBudget +
                ", projectBudget=" + projectBudget +
                ", salaryBudget=" + salaryBudget +
                ", totalBudget=" + totalBudget +
                '}';
    }
    public String toString(String budget){
        return financialPeriod+","+fundraisingBudget+","+administrationBudget+","+
                projectBudget+","+salaryBudget+","+totalBudget+"\n";
    }
}
