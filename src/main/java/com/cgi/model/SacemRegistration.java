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
public class SacemRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    public String code;

    @OneToOne(mappedBy = "sacem")
    @ToString.Exclude
    private Artist artist;

}
