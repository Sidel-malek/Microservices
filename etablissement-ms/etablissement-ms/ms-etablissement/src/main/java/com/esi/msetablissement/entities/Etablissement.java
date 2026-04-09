package com.esi.msetablissement.entities;


import com.esi.msetablissement.model.Chercheur;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Etablissement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtablissement;

    private String nom;

    @Enumerated(EnumType.ORDINAL)
    private TypeEtablissement type;


    @JsonIgnore
    @OneToMany(mappedBy = "etablissement")
    private List<Laboratoire> laboratoires;


    @Transient
    private Chercheur directeur;




}
