package Sauharda;

import java.time.LocalDate;

public class TrainingAndDevelopmentProgram {
    private String trainingOn;
    private LocalDate date;
    private int totalParticipant, totalCost;

    public TrainingAndDevelopmentProgram() {
    }

    public TrainingAndDevelopmentProgram(String trainingOn, LocalDate date, int totalParticipant, int totalCost) {
        this.trainingOn = trainingOn;
        this.date = date;
        this.totalParticipant = totalParticipant;
        this.totalCost = totalCost;
    }

    public String getTrainingOn() {
        return trainingOn;
    }

    public void setTrainingOn(String trainingOn) {
        this.trainingOn = trainingOn;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTotalParticipant() {
        return totalParticipant;
    }

    public void setTotalParticipant(int totalParticipant) {
        this.totalParticipant = totalParticipant;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "TrainingAndDevelopmentProgram{" +
                "trainingOn='" + trainingOn + '\'' +
                ", date=" + date +
                ", totalParticipant=" + totalParticipant +
                ", totalCost=" + totalCost +
                '}';
    }

    public String toString(String reason){
        return trainingOn + "," + date + "," + totalParticipant + "," + totalCost + '\n';
    }
}
