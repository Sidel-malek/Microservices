package com.esi.msequipe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

public class Etablissement {

    private Long idEtablissement;
    private String nom;
    private String type;
    private List<Laboratoire> laboratoires;

}
