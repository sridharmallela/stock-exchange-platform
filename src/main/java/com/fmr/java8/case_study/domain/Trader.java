package com.fmr.java8.case_study.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"createdOn", "updatedOn"})
public class Trader {

    @Id
    @Column(unique = true, name = "traderId")
    private String id;

    @Column
    @NotNull(message = "First Name is missing and is required")
    @Size(min = 3, message = "First Name is atleast 3 characters or more")
    private String firstName;

    @Column
    @NotNull(message = "Last Name is missing and is required")
    @Size(min = 3, message = "Last Name is atleast 3 characters or more")
    private String lastName;

    // @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$",
    // message = "Email Addresses must follow RFC 5322 pattern")
    @Column
    @NotNull(message = "Email Address is missing and is required")
    @Size(min = 6, message = "Email Address is atleast 6 characters or more")
    @Email
    private String email;

    @Column
    @NotNull(message = "Phone Number is missing and is required")
    @Pattern(regexp = "(\\d){3,3}-\\d{3,3}-\\d{4,4}",
        message = "Phone Number must match 111-111-1111 format")
    @Size(min = 12, max = 12, message = "Phone Number is atleast 10 characters or more")
    private String phoneNum;

    @Column(unique = true)
    @NotNull(message = "Account Number is missing and is required")
    @Pattern(regexp = "(\\d){9,9}", message = "Account Number must match number format")
    @Size(min = 9, max = 9, message = "Account Number is exactly 9 characters")
    private String accountNumber;

    @Column
    @NotNull(message = "Account Balance is missing and is required")
    @Positive
    @DecimalMin("0.0")
    private Double availableBalance;

    @Column
    @NotNull(message = "Total Value is missing and is required")
    @DecimalMin("0.0")
    private Double totalValue;

    @Column
    private String accountType;

    @Column
    private Integer noOfPositions;

    @Column
    private LocalDateTime createdOn;

    @Column
    private LocalDateTime updatedOn;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = "Address Information is missing and is required")
    @MapsId
    @Valid
    @JoinColumn(name = "traderId")
    @JsonManagedReference
    private Address address;

    protected Trader() {
    }

    public Trader(final String firstName, final String lastName, final String email, final String phoneNum, final Address address, final String accountNumber, final Double availableBalance, final Double totalValue, final String accountType, final Integer noOfPositions) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
        this.accountNumber = accountNumber;
        this.availableBalance = availableBalance;
        this.totalValue = totalValue;
        this.accountType = accountType;
        this.noOfPositions = noOfPositions;
    }

    @PrePersist
    public void prePersist() {
        createdOn = LocalDateTime.now();
        updatedOn = createdOn;
    }

    @PreUpdate
    public void preUpdate() {
        updatedOn = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Double getAvailableBalance() {
        return availableBalance;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public String getAccountType() {
        return accountType;
    }

    public Integer getNoOfPositions() {
        return noOfPositions;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Trader)) return false;
        final Trader trader = (Trader) o;
        return id.equals(trader.id) &&
                   firstName.equals(trader.firstName) &&
                   lastName.equals(trader.lastName) &&
                   email.equals(trader.email) &&
                   phoneNum.equals(trader.phoneNum) &&
                   accountNumber.equals(trader.accountNumber) &&
                   availableBalance.equals(trader.availableBalance) &&
                   Objects.equals(totalValue, trader.totalValue) &&
                   Objects.equals(accountType, trader.accountType) &&
                   Objects.equals(noOfPositions, trader.noOfPositions) &&
                   createdOn.equals(trader.createdOn) &&
                   Objects.equals(updatedOn, trader.updatedOn) &&
                   Objects.equals(address, trader.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, phoneNum, accountNumber, availableBalance, totalValue, accountType, noOfPositions, createdOn, updatedOn, address);
    }

    @Override
    public String toString() {
        return "Trader{" +
                   "id='" + id + '\'' +
                   ", firstName='" + firstName + '\'' +
                   ", lastName='" + lastName + '\'' +
                   ", email='" + email + '\'' +
                   ", phoneNum='" + phoneNum + '\'' +
                   ", accountNumber='" + accountNumber + '\'' +
                   ", availableBalance=" + availableBalance +
                   ", totalValue=" + totalValue +
                   ", accountType='" + accountType + '\'' +
                   ", noOfPositions=" + noOfPositions +
                   ", createdOn=" + createdOn +
                   ", updatedOn=" + updatedOn +
                   ", address=" + address +
                   '}';
    }
}
