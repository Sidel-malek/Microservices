package com.esisba.msquerylibrary.repositories;

import com.esisba.msquerylibrary.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book , String > {
}
