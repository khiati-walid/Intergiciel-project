package com.example.hajjmanagementapp.proxy;

import com.example.hajjmanagementapp.model.Vol;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "ms-vol", url = "localhost:8097")
public interface VolProxy {


    @GetMapping("/vols/{id}")
    public Vol getVol(@PathVariable("id")Long idv);


}
