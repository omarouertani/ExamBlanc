package com.example.examblanc.DAO.Reopsitory;

import com.example.examblanc.DAO.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
   Client findByCin (long c);
}
