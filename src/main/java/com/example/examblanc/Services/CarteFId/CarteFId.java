package com.example.examblanc.Services.CarteFId;

import com.example.examblanc.DAO.Entities.Client;
import com.example.examblanc.DAO.Reopsitory.CarteFIRepository;
import com.example.examblanc.DAO.Reopsitory.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
@Service
@AllArgsConstructor
public class CarteFId implements ICarteFId{
    CarteFIRepository carteFIDrepository;
    ClientRepository clientRepository;
    @Override
    public void ajouterCarteEtAffecterClient(com.example.examblanc.DAO.Entities.CarteFId crt, long cin) {
        Client c = clientRepository.findByCin(cin);
        if (c != null) {
            c.setCrt(crt);
            crt.setSolde(0);
            crt.setDateCreation(LocalDate.now());
            carteFIDrepository.save(crt);
        } else {
            throw new RuntimeException("Le client avec le CIN " + cin + " n'existe pas.");
        }



    }

    @Override
    public long effectuerOperation(String typeOperation, long numCarte, int montant) {
        com.example.examblanc.DAO.Entities.CarteFId carteOpt = carteFIDrepository.findByNumeroCarte(numCarte);
        if (typeOperation.equals("+")) {
            carteOpt.setSolde(carteOpt.getSolde() + montant);
        } else if (typeOperation.equals("-")) {
            if (carteOpt.getSolde() < montant) {
                throw new RuntimeException("Solde insuffisant pour effectuer l'opération.");
            }
            carteOpt.setSolde(carteOpt.getSolde() - montant);
        } else {
            throw new RuntimeException("Type d'opération non reconnu : " + typeOperation);
        }

        // Sauvegarder la carte mise à jour et retourner le nouveau solde
        carteFIDrepository.save(carteOpt);
        return carteOpt.getSolde();}
}
