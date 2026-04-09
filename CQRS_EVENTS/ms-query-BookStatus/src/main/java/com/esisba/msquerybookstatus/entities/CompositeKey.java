package com.esisba.msquerybookstatus.entities;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data @AllArgsConstructor @NoArgsConstructor
public class CompositeKey implements Serializable {

    private String editeurId;
    private String isbn;
}
