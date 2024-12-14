package Sauharda;

public class NewEmployee {
    private String name, dob, gender, address;

    public NewEmployee() {
    }

    public NewEmployee(String name, String dob, String gender, String address) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
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

    @Override
    public String toString() {
        return "NewEmployee{" +
                "name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String toString(String two){
        return name + "," + dob + "," + gender + "," + address + "\n";
    }
}
