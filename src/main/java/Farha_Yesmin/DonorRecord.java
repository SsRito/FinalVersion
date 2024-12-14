package Farha_Yesmin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class DonorRecord {
    private String donorID;
    private LocalDate donationDate;
    private float donationAmount;
    private String donationMethod;

    public DonorRecord() {
    }

    public DonorRecord(String donorID, LocalDate donationDate, float donationAmount, String donationMethod) {
        this.donorID = donorID;
        this.donationDate = donationDate;
        this.donationAmount = donationAmount;
        this.donationMethod = donationMethod;
    }

    public String getDonorID() {
        return donorID;
    }

    public void setDonorID(String donorID) {
        this.donorID = donorID;
    }

    public LocalDate getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(LocalDate donationDate) {
        this.donationDate = donationDate;
    }

    public float getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(float donationAmount) {
        this.donationAmount = donationAmount;
    }

    public String getDonationMethod() {
        return donationMethod;
    }

    public void setDonationMethod(String donationMethod) {
        this.donationMethod = donationMethod;
    }

    @Override
    public String toString() {
        return "DonorRecord{" +
                "donorID='" + donorID + '\'' +
                ", donationDate=" + donationDate +
                ", donationAmount=" + donationAmount +
                ", donationMethod='" + donationMethod + '\'' +
                '}';
    }

    public String toString(String donorRecord){
        return donorID+","+donationDate+","+donationAmount+","+
                donationMethod+"\n";
    }
}
