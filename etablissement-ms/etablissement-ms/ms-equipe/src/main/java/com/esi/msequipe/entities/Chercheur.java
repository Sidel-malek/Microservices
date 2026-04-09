package com.esi.msequipe.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Chercheur {
    @Id
    private Long idChercheur;

    private String nom ;

    private String email;

    @ManyToOne
    private Equipe equipe ;

    private Long idEtablissement;

}
