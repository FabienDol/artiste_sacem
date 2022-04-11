package com.cgi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@ToString
public enum InstrumentType {

    WIND(1), WOODWIND(2), BRASS(3), PERCUSSION(4), STRING(5);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private int sound;

    @OneToMany(mappedBy = "instruType")
    private List<Instrument> instruments = new ArrayList<>();

}
