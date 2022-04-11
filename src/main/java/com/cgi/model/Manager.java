package com.cgi.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public int budget;

    @OneToMany(mappedBy = "mng") //Foreign Key dans Artist
    private List<Artist> artists = new ArrayList<>();

    public Manager() {
    }

    public Manager(int budget) {
        this.budget = budget;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", budget=" + budget +
                ", artists=" + artists +
                '}';
    }
}
