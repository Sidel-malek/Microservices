package com.esisba.msquerybookstatus.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class EditeurTemp {

    @Id
    private String editeurId;
    private String editeurName;
}
