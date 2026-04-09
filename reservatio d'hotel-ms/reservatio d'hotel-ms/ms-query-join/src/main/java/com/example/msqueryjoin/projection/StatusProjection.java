package com.example.msqueryjoin.projection;

import com.example.coreapi.events.*;
import com.example.msqueryjoin.entities.Chambre;
import com.example.msqueryjoin.entities.StatusTable;
import com.example.msqueryjoin.repository.ChambreRepository;
import com.example.msqueryjoin.repository.StatusTableRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatusProjection {

    @Autowired
    private StatusTableRepository statusTableRepository;

    @Autowired
    private ChambreRepository chambreRepository;



    @EventHandler
    public void on(ChambreAddedEvent event) {
        chambreRepository.save(
                new Chambre(event.getIdCh() , event.getIdH())
        ) ;
    }


    @EventHandler
    public void on (ReservationAddedEvent event){
        if (statusTableRepository.existsById(event.getIdCh())){
            StatusTable statusTable = statusTableRepository.findById(event.getIdCh()).get();
            statusTable.setNbReservation(statusTable.getNbReservation() + 1);
            statusTableRepository.save(statusTable);
        } else
        {
            StatusTable statusTable = new StatusTable();
            statusTable.setIdCh(event.getIdCh());
            Chambre chambre = chambreRepository.findById(event.getIdCh()).get();
            statusTable.setIdH(chambre.getIdH());
            statusTable.setNbReservation(1);
            statusTableRepository.save(statusTable);
        }

    }

    @EventHandler
    public void on (ReservationRemovedEvent event){

        if (statusTableRepository.existsById(event.getIdCh())){
            StatusTable statusTable = statusTableRepository.findById(event.getIdCh()).get();
            if(statusTable.getNbReservation() == 1){
                statusTableRepository.delete(statusTable);
            }else {
                statusTable.setNbReservation(statusTable.getNbReservation() - 1);
                statusTableRepository.save(statusTable);
            }

        }
    }

    //----A complèter-------------
}
