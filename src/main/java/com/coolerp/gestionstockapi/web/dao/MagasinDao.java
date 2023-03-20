package com.coolerp.gestionstockapi.web.dao;

import com.coolerp.gestionstockapi.web.model.Magasin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MagasinDao extends JpaRepository<Magasin, Integer> {
    Magasin findById(int id_Magasin);
    List<Magasin> findByCoordoGreaterThan(int CoordoLimit);
}
