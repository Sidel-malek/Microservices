package com.esisba.msediteur.Projection;

import com.esisba.coreapi.events.EditeurCreatedEvent;
import com.esisba.msediteur.Repositories.EditeurRepository;
import com.esisba.msediteur.StoredAggregate.Editeur;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component //lancer automatiquement apres lancement de serveur
public class EditeurProjectionListner {

    @Autowired
    EditeurRepository editeurRepository;

    @EventHandler
    public void addEditeur(EditeurCreatedEvent event){
        Editeur editeur = new Editeur(
                event.getEditeurId(),
                event.getName(),
                event.getPays()
        );
        editeurRepository.save(editeur);
    }

}
