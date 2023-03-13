package com.coolerp.gestionstockapi.web.dao;


import com.coolerp.gestionstockapi.web.model.Magasin;

import java.util.List;

public interface MagasinDao {
    List<Magasin> findAll();
    Magasin findById(int id_Magasin);
    Magasin save(Magasin magasin);
}
