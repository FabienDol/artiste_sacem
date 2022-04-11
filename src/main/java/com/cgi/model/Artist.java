package com.cgi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String bandName;
    @NonNull
    private int size;
    @NonNull
    private String country;

    @ManyToOne
    private Manager mng;

    @OneToOne
    private SacemRegistration sacem;

    @OneToMany(mappedBy = "med")
    @ToString.Exclude
    private List<Media> medias = new ArrayList<>();

    @OneToMany(mappedBy = "art")
    @ToString.Exclude
    private List<Instrument> instruments = new ArrayList<>();

    @ManyToOne
    private Instrument favoriteInstrument;

    @ManyToMany
    private List<Instrument> playableInstruments = new ArrayList<>();

}
