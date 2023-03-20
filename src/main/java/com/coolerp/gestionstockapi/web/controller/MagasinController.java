package com.coolerp.gestionstockapi.web.controller;

import com.coolerp.gestionstockapi.web.dao.MagasinDao;
import com.coolerp.gestionstockapi.web.exceptions.MagasinIntrouvableException;
import com.coolerp.gestionstockapi.web.model.Magasin;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
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

    //Recupere la liste des magasins
    @GetMapping(value = "/Magasins")
    public MappingJacksonValue listeMagasins(){
        List<Magasin> magasins = magasinDao.findAll();
        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("Coordo");
        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamyque", monFiltre);
        MappingJacksonValue magasinsFiltres = new MappingJacksonValue(magasins);
        magasinsFiltres.setFilters(listDeNosFiltres);
        return magasinsFiltres;
    }

    //Recuperer un magasin par son Id
    @GetMapping("/Magasins/{id_Magasin}")
    public Magasin afficherUnMagasin(@PathVariable int id_Magasin) throws MagasinIntrouvableException {
       Magasin magasin = magasinDao.findById(id_Magasin);
            if (magasin==null) throw new MagasinIntrouvableException("Le Magasin avec l'id "+ id_Magasin + "est Introuvable.");
        return magasin;
    }

    //Liste des magasins au plus que les coordo
    @GetMapping(value = "coordo/Magasins/{CoordoLimit}")
    public List<Magasin> coordoRequetes(@PathVariable int CoordoLimit) {
       return magasinDao.findByCoordoGreaterThan(CoordoLimit);
    }

    @PostMapping(value = "/Magasins")
    public ResponseEntity<Magasin> ajouterMagasin(@RequestBody Magasin magasin){
        Magasin magasinAdded = magasinDao.save(magasin);
        if (Objects.isNull(magasinAdded)){
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id_Magasin}")
                .buildAndExpand(magasinAdded.getId_Magasin())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    // Supprimer un Magasin
    @DeleteMapping(value = "/Magasins/id_magasins")
    public void supprimerMagasin(@PathVariable int id_Magasin){
       magasinDao.deleteById(id_Magasin);
    }
    //Modifier un Magasin
    @PutMapping(value = "/Magasins")
    public void updateMagasin(@RequestBody Magasin magasin){
       magasinDao.save(magasin);
    }
}
