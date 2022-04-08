package com.cgi.model;

import jakarta.persistence.*;

@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String bandName;
    private int size;
    private String country;

    @ManyToOne
    private Manager mng;

    @OneToOne
    private SacemRegistration sacem;

    @ManyToMany
    private Media med;

    public Artist(String firstName, String lastName, String bandName, int size, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bandName = bandName;
        this.size = size;
        this.country = country;
    }


}
