package com.esi.msetablissement.Repository;

import com.esi.msetablissement.entities.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtablissementRepository extends JpaRepository<Etablissement,Long> {
}
