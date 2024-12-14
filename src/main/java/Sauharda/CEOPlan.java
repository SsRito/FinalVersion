package Sauharda;

public class CEOPlan {
    private String goal;

    public CEOPlan() {
    }

    public CEOPlan(String goal) {
        this.goal = goal;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    @Override
    public String toString() {
        return "CEOPlan{" +
                "goal='" + goal + '\'' +
                '}';
    }

    public String toString(String reason) {
        return goal + '\n';
    }
}
