package com.esisba.msediteur.StoredAggregate;

import com.esisba.coreapi.commands.EditeurCreationCommand;
import com.esisba.coreapi.events.EditeurCreatedEvent;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.util.Assert;

@Entity
@Aggregate
@Data @AllArgsConstructor @NoArgsConstructor
public class Editeur {

    @Id
    @TargetAggregateIdentifier
    private String EditeurId;
    private String name;
    private String pays;

    @CommandHandler
    public Editeur(EditeurCreationCommand cmd) {
        Assert.notNull(cmd.getEditeurId(), "editeurId should be not null");
        Assert.notNull(cmd.getName(), "name should be not null");

        AggregateLifecycle.apply(new EditeurCreatedEvent(cmd.getEditeurId(), cmd.getName(), cmd.getPays()));

    }

    @EventSourcingHandler
    public void on(EditeurCreatedEvent event){
        this.EditeurId= event.getEditeurId();
        this.name = event.getName();
    }

}
