package com.example.examblanc.DAO.Reopsitory;

import com.example.examblanc.DAO.Entities.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonnelRepository extends JpaRepository <Personnel,Integer> {
}
