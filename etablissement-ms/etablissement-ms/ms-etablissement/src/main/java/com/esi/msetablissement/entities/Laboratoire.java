package com.esi.msetablissement.entities;


import com.esi.msetablissement.model.Chercheur;
import com.esi.msetablissement.model.Equipe;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Laboratoire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLabo;

    private String nom;

    @Enumerated(EnumType.ORDINAL)
    private Specialite specialite;

    @ManyToOne
    private Etablissement etablissement;

    @Transient
    private Collection<Equipe> equipes;

    @Transient
    private Chercheur dir_labo ;



}
