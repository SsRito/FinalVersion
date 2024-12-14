package Sauharda;

import java.time.LocalDate;

public class Volunteer {
    private String name, volunteeringField, address, gender;
    private LocalDate dob;

    public Volunteer() {
    }

    public Volunteer(String name, String volunteeringField, String address, String gender, LocalDate dob) {
        this.name = name;
        this.volunteeringField = volunteeringField;
        this.address = address;
        this.gender = gender;
        this.dob = dob;
    }

    public Volunteer(String name, String volunteeringField) {
        this.name = name;
        this.volunteeringField = volunteeringField;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVolunteeringField() {
        return volunteeringField;
    }

    public void setVolunteeringField(String volunteeringField) {
        this.volunteeringField = volunteeringField;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Volunteer{" +
                "name='" + name + '\'' +
                ", volunteeringField='" + volunteeringField + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                '}';
    }

    public String toString(String two){
        return name + "," + volunteeringField + "\n";
    }
}
