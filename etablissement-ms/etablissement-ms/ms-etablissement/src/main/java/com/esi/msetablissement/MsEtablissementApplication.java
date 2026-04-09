package com.esi.msetablissement;

import com.esi.msetablissement.Repository.EtablissementRepository;
import com.esi.msetablissement.Repository.LaboratoireRepository;
import com.esi.msetablissement.entities.Etablissement;
import com.esi.msetablissement.entities.Laboratoire;
import com.esi.msetablissement.entities.Specialite;
import com.esi.msetablissement.entities.TypeEtablissement;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class MsEtablissementApplication implements CommandLineRunner {

    @Resource
    EtablissementRepository etablissementRepository;
    @Resource
    LaboratoireRepository laboratoireRepository;

    @Resource
    RepositoryRestConfiguration repositoryRestConfiguration;
    public static void main(String[] args) {
        SpringApplication.run(MsEtablissementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Laboratoire.class);

        Etablissement e1=new Etablissement(null,"et1", TypeEtablissement.ecole,null, null);
        Etablissement e2=new Etablissement(null,"et1", TypeEtablissement.ecole,null , null);
        etablissementRepository.save(e1);
        etablissementRepository.save(e2);

        laboratoireRepository.save(new Laboratoire(null,"lab1", Specialite.electronique, e1,null, null));
        laboratoireRepository.save(new Laboratoire(null,"lab2", Specialite.informatique, e2,null, null));
        laboratoireRepository.save(new Laboratoire(null,"lab3", Specialite.mathematique, e2,null, null));
    }
}
