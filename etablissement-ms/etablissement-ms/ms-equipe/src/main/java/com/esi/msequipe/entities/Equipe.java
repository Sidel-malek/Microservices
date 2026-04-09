package com.esi.msequipe.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipe;

    private String nomEquipe ;

    @OneToMany(mappedBy="equipe")
    private List<Chercheur> chercheurs ;


}
