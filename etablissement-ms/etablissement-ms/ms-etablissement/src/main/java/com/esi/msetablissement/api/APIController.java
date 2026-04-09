package com.esi.msetablissement.api;

import com.esi.msetablissement.Proxy.ChercheurProxy;
import com.esi.msetablissement.Repository.EtablissementRepository;
import com.esi.msetablissement.entities.Etablissement;
import com.esi.msetablissement.model.Chercheur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("api")
public class APIController {

    @Autowired
    EtablissementRepository etablissementRepo;

    @Autowired
    ChercheurProxy chercheurProxy;


}
