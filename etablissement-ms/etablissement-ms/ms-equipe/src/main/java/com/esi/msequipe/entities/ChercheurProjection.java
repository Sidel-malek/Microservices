package com.esi.msequipe.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "chProjection" , types = Chercheur.class)
public interface ChercheurProjection {
       public String getNom();
       public String getEmail();

       @Value("#{target.equipe.nomEquipe}")
       public String getNomEquipe();



}
