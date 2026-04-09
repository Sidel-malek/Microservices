package com.esi.msequipe.model;

import jakarta.persistence.*;

import java.util.Collection;

public class Laboratoire {

    private Long idLabo;

    private String nom;
    private String specialite;
    private Etablissement etablissement;

}
