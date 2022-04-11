package com.cgi.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public String name;

    @ManyToOne
    private InstrumentType instruType;

    @ManyToOne
    private Artist art;

    @ManyToMany(mappedBy = "playableInstruments")
    private List<Artist> players = new ArrayList<>();

    @OneToMany(mappedBy = "favoriteInstrument") //Foreign Key dans Artist
    private List<Artist> artistsFavInstru = new ArrayList<>();

    public Instrument() {
    }

    public Instrument(String name, InstrumentType instruType) {
        this.name = name;
        this.instruType = instruType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InstrumentType getInstruType() {
        return instruType;
    }

    public void setInstruType(InstrumentType instruType) {
        this.instruType = instruType;
    }

    public Artist getArt() {
        return art;
    }

    public void setArt(Artist art) {
        this.art = art;
    }

    public List<Artist> getPlayers() {
        return players;
    }

    public void setPlayers(List<Artist> players) {
        this.players = players;
    }

    public List<Artist> getArtistsFavInstru() {
        return artistsFavInstru;
    }

    public void setArtistsFavInstru(List<Artist> artistsFavInstru) {
        this.artistsFavInstru = artistsFavInstru;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", instruType=" + instruType +
                ", art=" + art +
                ", players=" + players +
                ", artistsFavInstru=" + artistsFavInstru +
                '}';
    }
}
