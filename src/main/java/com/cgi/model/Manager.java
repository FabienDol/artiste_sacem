package com.cgi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    public int budget;

    @OneToMany(mappedBy = "mng") //Foreign Key dans Artist
    @ToString.Exclude
    private List<Artist> artists = new ArrayList<>();

}
