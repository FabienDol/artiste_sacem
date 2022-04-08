package com.cgi.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class SacemRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public String code;

    @OneToOne(mappedBy = "sacem")
    private List<Artist> artists = new ArrayList<>();

    public SacemRegistration(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    @Override
    public String toString() {
        return "SacemRegistration{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", artists=" + artists +
                '}';
    }
}
