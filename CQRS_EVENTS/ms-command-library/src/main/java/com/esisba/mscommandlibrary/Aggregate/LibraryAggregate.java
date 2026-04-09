package com.esisba.mscommandlibrary.Aggregate;

import com.esisba.coreapi.commands.AddBookCommand;
import com.esisba.coreapi.commands.LibraryCeationCommand;
import com.esisba.coreapi.commands.RemoveBookCommand;
import com.esisba.coreapi.events.BookAddedEvent;
import com.esisba.coreapi.events.BookRemovedEvent;
import com.esisba.coreapi.events.LibraryCreatedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Aggregate
@NoArgsConstructor
public class LibraryAggregate   {

    @AggregateIdentifier
    private String libraryId;
    private String name;
    private List<String> isbnBooks ;



    @CommandHandler //recepion de commands
    public LibraryAggregate(LibraryCeationCommand cmd){

        Assert.notNull(cmd.getLibraryId(), "LibraryId should not be null");
        Assert.notNull(cmd.getName(), "Name should not be null");

        AggregateLifecycle.apply(new LibraryCreatedEvent(cmd.getLibraryId(), cmd.getName())); // publier un evenement pour qu'il sera consomer par la partie Query
    }

    @EventSourcingHandler // current state of this aggregate
    public void on (LibraryCreatedEvent event){
        this.name = event.getName();
        this.libraryId = event.getLibraryId();
        this.isbnBooks =new ArrayList<>();
    }


    @CommandHandler
    public void handlers(AddBookCommand cmd) throws Exception{

        Assert.notNull(cmd.getLibraryId(), "LibraryId should not be null");
        Assert.notNull(cmd.getIsbn(), "ISBN should not be null");
        if (isbnBooks.contains(cmd.getIsbn())){
            throw new Exception("ISBN already in use");
        }

        AggregateLifecycle.apply(new BookAddedEvent(cmd.getLibraryId(), cmd.getIsbn(), cmd.getTitle(), cmd.getEditeurId()));
    }

    @EventSourcingHandler
    public void on (BookAddedEvent event){
        this.isbnBooks.add(event.getIsbn());
    }

    @CommandHandler
    public void handlers(RemoveBookCommand cmd) throws Exception{

        Assert.notNull(cmd.getLibraryId(), "LibraryId should not be null");
        Assert.notNull(cmd.getIsbn(), "ISBN should not be null");
        if (! isbnBooks.contains(cmd.getIsbn())){
            throw new Exception("Book ISBN must be exist");
        }

        AggregateLifecycle.apply(new BookRemovedEvent(cmd.getLibraryId(), cmd.getIsbn()));
    }

    @EventSourcingHandler
    public void on (BookRemovedEvent event){
        this.isbnBooks.remove(event.getIsbn());
    }

}
