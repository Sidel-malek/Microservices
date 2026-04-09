package com.esisba.msquerybookstatus.repositories;

import com.esisba.msquerybookstatus.entities.CompositeKey;
import com.esisba.msquerybookstatus.entities.EditeurJoinBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditeurJoinBookRepository extends JpaRepository<EditeurJoinBook, CompositeKey> {

    int deleteEditeurJoinBookByKeyJoin_Isbn(String isbn);
}
