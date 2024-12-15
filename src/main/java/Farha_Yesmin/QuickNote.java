package Farha_Yesmin;

import java.time.LocalDate;

public class QuickNote {
    private String projectName, noteText;
    private LocalDate noteDate;

    public QuickNote() {
    }

    public QuickNote(String projectName, String noteText, LocalDate noteDate) {
        this.projectName = projectName;
        this.noteText = noteText;
        this.noteDate = noteDate;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public LocalDate getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(LocalDate noteDate) {
        this.noteDate = noteDate;
    }

    @Override
    public String toString() {
        return projectName+","+","+ noteText+","+noteDate+"\n";

    }
}
