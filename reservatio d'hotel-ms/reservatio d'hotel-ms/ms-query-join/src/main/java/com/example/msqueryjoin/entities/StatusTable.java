package com.example.msqueryjoin.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class StatusTable {

    @Id
    private String idCh;
    private String idH;
    private int nbReservation;
     //----A complèter-------------
}
