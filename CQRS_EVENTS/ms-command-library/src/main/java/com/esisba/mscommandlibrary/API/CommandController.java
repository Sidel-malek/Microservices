package com.esisba.mscommandlibrary.API;

import com.esisba.coreapi.DTO.BookDTO;
import com.esisba.coreapi.DTO.LibraryDTO;
import com.esisba.coreapi.commands.AddBookCommand;
import com.esisba.coreapi.commands.LibraryCeationCommand;
import com.esisba.coreapi.commands.RemoveBookCommand;
import com.esisba.coreapi.events.LibraryCreatedEvent;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("command")
public class CommandController {

    @Autowired
    private CommandGateway commandGateway ;

    @PostMapping("library") //  CompletableFuture<String> is asynchronous and will eventually produce a result of type String.
    public CompletableFuture<String> createLibrary (@RequestBody LibraryDTO libraryDTO) {
        CompletableFuture<String> response = commandGateway.send(new LibraryCeationCommand(
               libraryDTO.getLibraryId(), libraryDTO.getName()
        ));

        return response;
    }


    @PostMapping("library/{libraryId}/book")
    public CompletableFuture<String> createBook (@RequestBody BookDTO bookDTO , @PathVariable String libraryId) {
        CompletableFuture<String> response = commandGateway.send(new AddBookCommand (
                libraryId,
                bookDTO.getIsbn() ,
                bookDTO.getTitle(),
                bookDTO.getEditeurId()
        ));
        return response;
    }

    @DeleteMapping("library/{library}/{isbn}")
    public CompletableFuture<String> removeBook (@PathVariable String library, @PathVariable String isbn) {
        CompletableFuture<String> response = commandGateway.send(new RemoveBookCommand(library ,isbn));
        return response;
    }
}
