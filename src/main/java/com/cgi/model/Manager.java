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

    public Manager(int budget) {
        this.budget = budget;
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
