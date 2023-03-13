package com.coolerp.gestionstockapi.web.controller;


import com.coolerp.gestionstockapi.web.dao.MagasinDao;
import com.coolerp.gestionstockapi.web.model.Magasin;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
public class MagasinController {

    private final MagasinDao magasinDao;

    public MagasinController(MagasinDao magasinDao){
        this.magasinDao = magasinDao;
    }

    // Recuperer la liste de tous les magasins
    @GetMapping("/Magasins")
    public List<Magasin> listeMagasins(){
        return magasinDao.findAll();
    }

    // Recuperer les infos d'un magasin
    @GetMapping(value = "/Magasins/{id_Magasin}")
    public Magasin afficherUnMagasin(@PathVariable int id_Magasin){
        return magasinDao.findById(id_Magasin);
    }

    // Ajout des infos du magasin
    @PostMapping(value = "/Magasins")
    public ResponseEntity<Magasin> ajouterMagasin(@RequestBody Magasin magasin){
        Magasin magasinAdded = magasinDao.save(magasin);
        if (Objects.isNull(magasinAdded)){
            return  ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id_magasin}")
                .buildAndExpand(magasinAdded.getId_Magasin())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
