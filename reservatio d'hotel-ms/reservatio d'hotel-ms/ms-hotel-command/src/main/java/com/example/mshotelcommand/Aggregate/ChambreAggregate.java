package com.example.mshotelcommand.Aggregate;

import com.example.coreapi.commands.AddChambreCommand;
import com.example.coreapi.commands.DeleteChambreCommand;
import com.example.coreapi.events.ChambreAddedEvent;
import com.example.coreapi.events.ChambreRemovedEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.EntityId;

import jakarta.persistence.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class ChambreAggregate {

    @Id
    @TargetAggregateIdentifier
    private String idCh;
    private String type;
    private Integer etage;

    @ManyToOne
    private HotelAggregate hotel;

}
