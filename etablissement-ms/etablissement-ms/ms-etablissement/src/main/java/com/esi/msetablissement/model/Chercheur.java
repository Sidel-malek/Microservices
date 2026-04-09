package com.esi.msetablissement.model;

import com.esi.msetablissement.entities.Etablissement;
import jakarta.persistence.OneToOne;

public class Chercheur {
    private Long idChercheur;
    private String nom ;
    private String email;
    private Equipe equipe ;


}
