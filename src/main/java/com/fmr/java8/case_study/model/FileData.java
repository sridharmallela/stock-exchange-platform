package com.fmr.java8.case_study.model;

import java.util.Objects;

public class FileData {

    String firstName;

    String lastName;

    String dob;

    String street;

    String zip;

    String city;

    String state;

    String phoneNumber;

    String email;

    String accountNumber;

    String money;

    String gender;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(final String dob) {
        this.dob = dob;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(final String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(final String state) {
        this.state = state;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(final String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(final String money) {
        this.money = money;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof FileData)) return false;
        final FileData fileData = (FileData) o;
        return Objects.equals(firstName, fileData.firstName) &&
                   Objects.equals(lastName, fileData.lastName) &&
                   Objects.equals(dob, fileData.dob) &&
                   Objects.equals(street, fileData.street) &&
                   Objects.equals(zip, fileData.zip) &&
                   Objects.equals(city, fileData.city) &&
                   Objects.equals(state, fileData.state) &&
                   Objects.equals(phoneNumber, fileData.phoneNumber) &&
                   Objects.equals(email, fileData.email) &&
                   Objects.equals(accountNumber, fileData.accountNumber) &&
                   Objects.equals(money, fileData.money) &&
                   Objects.equals(gender, fileData.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dob, street, zip, city, state, phoneNumber, email, accountNumber, money, gender);
    }

    @Override
    public String toString() {
        return "FileData{" +
                   "firstName='" + firstName + '\'' +
                   ", lastName='" + lastName + '\'' +
                   ", dob='" + dob + '\'' +
                   ", street='" + street + '\'' +
                   ", zip='" + zip + '\'' +
                   ", city='" + city + '\'' +
                   ", state='" + state + '\'' +
                   ", phoneNumber='" + phoneNumber + '\'' +
                   ", email='" + email + '\'' +
                   ", accountNumber='" + accountNumber + '\'' +
                   ", money='" + money + '\'' +
                   ", gender='" + gender + '\'' +
                   '}';
    }
}
