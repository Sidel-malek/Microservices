package com.example.msqueryjoin.repository;

import com.example.msqueryjoin.entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository extends JpaRepository<Chambre, String> {
}
