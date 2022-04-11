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
    private Artist artist;

    public SacemRegistration() {
    }

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

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "SacemRegistration{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", artist=" + artist +
                '}';
    }
}
