package com.example.collegelink;

public class UserHelper {
    String Name,Email,Password;

    public UserHelper() {
    }

    public UserHelper(String Name, String Email, String Password) {
        this.Name = Name;
        this.Email = Email;
        this.Password = Password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {

        this.Name = Name;
    }

    public String getEmail() {

        return Email;
    }

    public void setEmail(String Email) {

        this.Email = Email;
    }

    public String getPassword() {

        return Password;
    }

    public void setPassword(String Password) {

        this.Password = Password;
    }
}