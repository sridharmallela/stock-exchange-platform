package com.fmr.java8.case_study.domain;

import lombok.Data;
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

@Data
@Entity
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
}
