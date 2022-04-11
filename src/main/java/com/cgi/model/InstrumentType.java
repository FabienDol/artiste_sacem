package com.cgi.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public enum InstrumentType {

    WIND(1), WOODWIND(2), BRASS(3), PERCUSSION(4), STRING(5);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int sound;

    @OneToMany(mappedBy = "instruType")
    private List<Instrument> instruments = new ArrayList<>();

    InstrumentType() {
    }

    InstrumentType(int sound) {
        this.sound = sound;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }

    @Override
    public String toString() {
        return "InstrumentType{" +
                "id=" + id +
                ", sound=" + sound +
                ", instruments=" + instruments +
                '}';
    }
}
