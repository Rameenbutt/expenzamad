package com.example.expenza;

public class User {
    String Name, Email, Password, Phone;

    public User() {
    }

    public User(String name, String email, String password, String phone) {
        Name = name;
        Email = email;
        Password = password;
        Phone = phone;
    }

    public String getName() { return Name; }
    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
