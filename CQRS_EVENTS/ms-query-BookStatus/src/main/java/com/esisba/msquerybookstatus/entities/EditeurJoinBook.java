package com.esisba.msquerybookstatus.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
public class EditeurJoinBook {

    @EmbeddedId
    private CompositeKey keyJoin;
    private String EditeurName;
    private String bookTitle;

}
