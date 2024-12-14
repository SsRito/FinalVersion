package Farha_Yesmin;

import Sauharda.Feedback;

import java.time.LocalDate;

public class FeedBack extends Feedback {
    private String name,feedbackText;
    private LocalDate date;

    public FeedBack() {
    }

    public FeedBack(String name, String feedbackText, LocalDate date) {
        this.name = name;
        this.feedbackText = feedbackText;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "FeedBack{" +
                "name='" + name + '\'' +
                ", feedbackText='" + feedbackText + '\'' +
                ", date=" + date +
                '}';
    }
    public String toString(String feedBack){
        return name+","+feedbackText+","+date+"\n";

    }

}
