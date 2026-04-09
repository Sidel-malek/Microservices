package com.esi.msequipe;

import com.esi.msequipe.Repository.ChercheurRepository;
import com.esi.msequipe.Repository.EquipeRepository;
import com.esi.msequipe.entities.Chercheur;
import com.esi.msequipe.entities.Equipe;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MsEquipeApplication implements CommandLineRunner{

    @Resource
    private EquipeRepository equipeRepository;

    @Resource
    private ChercheurRepository chercheurRepository;

    public static void main(String[] args) {
        SpringApplication.run(MsEquipeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Equipe eq1=new Equipe(null,"eq1", null);
        Equipe eq2=new Equipe(null,"eq2", null);

        Equipe eq3=new Equipe(null,"eq3", null);
        Equipe eq4=new Equipe(null,"eq4", null);

        equipeRepository.save(eq1);   equipeRepository.save(eq2);   equipeRepository.save(eq3);
        equipeRepository.save(eq4);

        chercheurRepository.save(new Chercheur(1L, "ch1" , "ch1@gmail.com" , eq1, 1L));
        chercheurRepository.save(new Chercheur(2L, "ch2" , "ch1@gmail.com" , eq1 , 1L));

        chercheurRepository.save(new Chercheur(3L, "ch3" , "ch1@gmail.com" , eq2 , 1L));
        chercheurRepository.save(new Chercheur(4L, "ch4" , "ch1@gmail.com" , eq2, 1L));

        chercheurRepository.save(new Chercheur(5L, "ch5" , "ch1@gmail.com" , eq3, 2L));
        chercheurRepository.save(new Chercheur(6L, "ch6" , "ch1@gmail.com" , eq3, 2L));

        chercheurRepository.save(new Chercheur(7L, "ch7" , "ch1@gmail.com" , eq4, 2L));
        chercheurRepository.save(new Chercheur(8L, "ch8" , "ch1@gmail.com" , eq4, 2L));





    }
}
