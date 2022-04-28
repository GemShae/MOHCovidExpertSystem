package models;

public class Patient {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String country;

    public Patient() {
        country = "Jamaica";
    }

    public Patient(String firstName, String lastName, int age, String gender, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "*** Patient ***" +
                "\n First Name: " + firstName +
                "\n Last Name: " + lastName +
                "\n Age: " + age +
                "\n Gender: " + gender +
                "\n Country: " + country;
    }
}
