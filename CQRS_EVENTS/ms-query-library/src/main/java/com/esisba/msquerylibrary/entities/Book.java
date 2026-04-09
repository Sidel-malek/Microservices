package com.esisba.msquerylibrary.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

    @Id
    private String isbn;
    private String title;

    @ManyToOne
    private Library library;

    private String editeurId;
}
