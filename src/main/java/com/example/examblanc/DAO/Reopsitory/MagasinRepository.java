package com.example.examblanc.DAO.Reopsitory;

import com.example.examblanc.DAO.Entities.Magasin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagasinRepository extends JpaRepository <Magasin,Integer> {
    Magasin findByNomMagasin(String nom);
}
