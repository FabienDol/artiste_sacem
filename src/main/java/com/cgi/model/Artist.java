package com.cgi.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "med")
    private List<Media> medias = new ArrayList<>();

    @OneToMany(mappedBy = "art")
    private List<Instrument> instruments = new ArrayList<>();

    @ManyToOne
    private Instrument favoriteInstrument;

    @ManyToMany
    private List<Instrument> playableInstruments = new ArrayList<>();

    public Artist() {
    }

    public Artist(String firstName, String lastName, String bandName, int size, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bandName = bandName;
        this.size = size;
        this.country = country;
    }

    public Artist(String bandName, int size, String country) {
        this.bandName = bandName;
        this.size = size;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Manager getMng() {
        return mng;
    }

    public void setMng(Manager mng) {
        this.mng = mng;
    }

    public SacemRegistration getSacem() {
        return sacem;
    }

    public void setSacem(SacemRegistration sacem) {
        this.sacem = sacem;
    }

    public List<Media> getMedias() {
        return medias;
    }

    public void setMedias(List<Media> medias) {
        this.medias = medias;
    }

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }

    public Instrument getFavoriteInstrument() {
        return favoriteInstrument;
    }

    public void setFavoriteInstrument(Instrument favoriteInstrument) {
        this.favoriteInstrument = favoriteInstrument;
    }

    public List<Instrument> getPlayableInstruments() {
        return playableInstruments;
    }

    public void setPlayableInstruments(List<Instrument> playableInstruments) {
        this.playableInstruments = playableInstruments;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bandName='" + bandName + '\'' +
                ", size=" + size +
                ", country='" + country + '\'' +
                ", mng=" + mng +
                ", sacem=" + sacem +
                ", medias=" + medias +
                ", instruments=" + instruments +
                ", favoriteInstrument=" + favoriteInstrument +
                ", playableInstruments=" + playableInstruments +
                '}';
    }
}
