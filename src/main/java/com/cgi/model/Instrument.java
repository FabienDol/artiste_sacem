package com.cgi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    public String name;

    @NonNull
    @ManyToOne
    private InstrumentType instruType;

    @ManyToOne
    private Artist art;

    @ManyToMany(mappedBy = "playableInstruments")
    private List<Artist> players = new ArrayList<>();

    @OneToMany(mappedBy = "favoriteInstrument") //Foreign Key dans Artist
    private List<Artist> artistsFavInstru = new ArrayList<>();

}
