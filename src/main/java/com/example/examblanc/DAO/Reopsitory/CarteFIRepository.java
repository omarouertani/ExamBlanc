package com.example.examblanc.DAO.Reopsitory;

import com.example.examblanc.DAO.Entities.CarteFId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteFIRepository extends JpaRepository <CarteFId,Integer> {
CarteFId findByNumeroCarte (long num);
}
