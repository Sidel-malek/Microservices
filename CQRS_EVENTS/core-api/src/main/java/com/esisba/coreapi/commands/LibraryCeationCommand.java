package com.esisba.coreapi.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateVersion;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryCeationCommand {

    @TargetAggregateVersion
    private String libraryId;
    private String name;
}
