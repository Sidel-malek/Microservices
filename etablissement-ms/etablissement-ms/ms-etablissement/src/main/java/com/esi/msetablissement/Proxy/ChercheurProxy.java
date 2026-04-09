package com.esi.msetablissement.Proxy;

import com.esi.msetablissement.model.Chercheur;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ms-equipe")
@LoadBalancerClient(name = "ms-equipe")
public interface ChercheurProxy {

    @GetMapping("/chercheurs/search/findChercheurByIdEtablissement")
    public Chercheur getChercheur(@RequestParam("ide") Long ide,
                           @RequestParam("projection") String projection);
}
