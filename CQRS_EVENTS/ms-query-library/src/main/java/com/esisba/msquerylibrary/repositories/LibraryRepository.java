package com.esisba.msquerylibrary.repositories;

import com.esisba.msquerylibrary.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library ,String> {
}
