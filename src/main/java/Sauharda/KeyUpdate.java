package Sauharda;

import java.time.LocalDate;

public class KeyUpdate {
    private String announcementFor, announcement;
    private LocalDate date;

    public KeyUpdate() {
    }

    public KeyUpdate(String announcementFor, String announcement, LocalDate date) {
        this.announcementFor = announcementFor;
        this.announcement = announcement;
        this.date = date;
    }

    public String getAnnouncementFor() {
        return announcementFor;
    }

    public void setAnnouncementFor(String announcementFor) {
        this.announcementFor = announcementFor;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "KeyUpdate{" +
                "announcementFor='" + announcementFor + '\'' +
                ", announcement='" + announcement + '\'' +
                ", date=" + date +
                '}';
    }

    public String toString(String reason) {
        return announcementFor + "," + announcement + "," + date + '\n';
    }
}
