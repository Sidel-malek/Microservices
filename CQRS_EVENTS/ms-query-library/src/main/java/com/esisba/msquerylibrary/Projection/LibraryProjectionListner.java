package com.esisba.msquerylibrary.Projection;

import com.esisba.coreapi.events.BookAddedEvent;
import com.esisba.coreapi.events.BookRemovedEvent;
import com.esisba.coreapi.events.LibraryCreatedEvent;
import com.esisba.msquerylibrary.entities.Book;
import com.esisba.msquerylibrary.entities.Library;
import com.esisba.msquerylibrary.repositories.BookRepository;
import com.esisba.msquerylibrary.repositories.LibraryRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // ncer au moment de lancement des serveurs
public class LibraryProjectionListner {

    // this.but est de ecouter s'il ya des evenemts entre en axon

    @Autowired
    LibraryRepository libraryRepository;
    @Autowired
    BookRepository bookRepository;

    @EventHandler
    public void AddLibrary(LibraryCreatedEvent event){ // on utilise cette methode lorsque recoit un evenement LibraryCreationEvent
        Library library = new Library(event.getLibraryId(), event.getName() , null);
        libraryRepository.save(library);
    }

    @EventHandler
    public void AddBook( BookAddedEvent event){
        Library library = libraryRepository.findById(event.getLibraryId()).get();
        Book book = new Book(event.getIsbn(), event.getTitle(), library, event.getEditeurId());
        bookRepository.save(book);
    }

    @EventHandler
    public void removebook(BookRemovedEvent event){
        bookRepository.deleteById(event.getIsbn());
    }
}
