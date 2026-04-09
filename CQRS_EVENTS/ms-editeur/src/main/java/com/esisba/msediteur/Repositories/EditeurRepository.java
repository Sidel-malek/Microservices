package com.esisba.msediteur.Repositories;


import com.esisba.msediteur.StoredAggregate.Editeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditeurRepository extends JpaRepository<Editeur, String> {
}
