package com.example.gestionvol.web;


import com.example.gestionvol.dao.VolRepository;
import com.example.gestionvol.entities.Vol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class VolController {

    @Autowired
    private VolRepository volRepository;





    @PostMapping("/create-vol")
    public Vol createVol( @RequestBody Vol vol) {
        return volRepository.save(vol);
    }


}
