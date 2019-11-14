package com.fmr.java8.case_study.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"createdOn", "updatedOn"})
public class Address {

    @Id
    @Column(unique = true, name = "traderId")
    @GeneratedValue(generator = "trader-uuid")
    @GenericGenerator(name = "trader-uuid", strategy = "uuid")
    private String id;

    @Column
    private String street;

    @Column
    private String city;

    @Column
    @NotNull(message = "Zip is missing and is required")
    @Size(min = 5, max = 5, message = "Zip code is exactly 5 characters or more")
    private String zip;

    @Column
    private String state;

    @Column
    private String country;

    @Column
    private LocalDateTime createdOn;

    @Column
    private LocalDateTime updatedOn;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Trader trader;

    protected Address() {
    }

    public Address(final String street, final String city, final String zip, final String state, final String country) {
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.state = state;
        this.country = country;
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

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public Trader getTrader() {
        return trader;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        final Address address = (Address) o;
        return id.equals(address.id) &&
                   Objects.equals(street, address.street) &&
                   Objects.equals(city, address.city) &&
                   zip.equals(address.zip) &&
                   Objects.equals(state, address.state) &&
                   Objects.equals(country, address.country) &&
                   createdOn.equals(address.createdOn) &&
                   Objects.equals(updatedOn, address.updatedOn) &&
                   Objects.equals(trader, address.trader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, city, zip, state, country, createdOn, updatedOn, trader);
    }

    @Override
    public String toString() {
        return "Address{" +
                   "id='" + id + '\'' +
                   ", street='" + street + '\'' +
                   ", city='" + city + '\'' +
                   ", zip='" + zip + '\'' +
                   ", state='" + state + '\'' +
                   ", country='" + country + '\'' +
                   ", createdOn=" + createdOn +
                   ", updatedOn=" + updatedOn +
                   ", trader=" + trader +
                   '}';
    }
}
