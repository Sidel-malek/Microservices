package com.esisba.msquerybookstatus.projection;

import com.esisba.coreapi.events.BookAddedEvent;
import com.esisba.coreapi.events.BookRemovedEvent;
import com.esisba.coreapi.events.EditeurCreatedEvent;
import com.esisba.msquerybookstatus.entities.CompositeKey;
import com.esisba.msquerybookstatus.entities.EditeurJoinBook;
import com.esisba.msquerybookstatus.entities.EditeurTemp;
import com.esisba.msquerybookstatus.repositories.EditeurJoinBookRepository;
import com.esisba.msquerybookstatus.repositories.EditeurTempRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EditeurJoinBookProjectionListner {

    @Autowired
    EditeurJoinBookRepository editeurJoinBookRepository;

    @Autowired
    EditeurTempRepository editeurTempRepository;
    //1st handler -> addbook
    @EventHandler
    public void addBook (BookAddedEvent event){
        EditeurJoinBook editeurJoinBook = new EditeurJoinBook();
        editeurJoinBook.setBookTitle(event.getTitle());
        editeurJoinBook.setKeyJoin(new CompositeKey(event.getEditeurId(), event.getIsbn()));

        EditeurTemp editeurTemp  = editeurTempRepository.findById(event.getEditeurId()).get();
        editeurJoinBook.setEditeurName(editeurTemp.getEditeurName());

        editeurJoinBookRepository.save(editeurJoinBook);


    }
    //2end  handler -> editeur
    @EventHandler
    public void addEditeur(EditeurCreatedEvent event){
        EditeurTemp editeur = new EditeurTemp(event.getEditeurId(), event.getName());
        editeurTempRepository.save(editeur);
    }

    @EventHandler
    public void removeBook (BookRemovedEvent event){
        editeurJoinBookRepository.deleteEditeurJoinBookByKeyJoin_Isbn(event.getIsbn());
    }
}
