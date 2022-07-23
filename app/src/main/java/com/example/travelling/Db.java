package com.example.travelling;

public class Db {
    String Address;
    String City;
    String Date;
    String DateTravel;
    String Email;
    String FirstName;
    String LastName;
    String Phone;
    String State;

    public Db(){

    }

    public Db(String FirstName, String City, String Date, String DateTravel, String Email,
              String Address, String LastName, String Phone, String State) {
        this.Address = Address;
        this.City = City;
        this.Date = Date;
        this.DateTravel = DateTravel;
        this.Email = Email;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Phone = Phone;
        this.State = State;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getDateTravel() {
        return DateTravel;
    }

    public void setDateTravel(String DateTravel) {
        this.DateTravel = DateTravel;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }
}
