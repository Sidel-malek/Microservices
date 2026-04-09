package com.esi.msequipe.Repository;

import com.esi.msequipe.entities.Chercheur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RepositoryRestResource
public interface ChercheurRepository extends JpaRepository<Chercheur, Long> {

    Chercheur findChercheurByIdEtablissement(Long ide );


}
