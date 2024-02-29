package com.example.examblanc.Services.Magasin;

import com.example.examblanc.DAO.Entities.Client;
import com.example.examblanc.DAO.Entities.Magasin;
import com.example.examblanc.DAO.Entities.Personnel;
import com.example.examblanc.DAO.Reopsitory.MagasinRepository;
import com.example.examblanc.DAO.Reopsitory.PersonnelRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class MagasinService implements IMagasinService{
    MagasinRepository magasinRepository;
    PersonnelRepository personnelRepository;
    @Override
    public Magasin ajouterMagasinEtPersonnels(Magasin magasin) {
        // Sauvegarder le personnel avant de sauvegarder le magasin
        Personnel personnel = magasin.getPersonnelMagasin();
        if (personnel != null) {
            personnelRepository.save(personnel);
        }

        // Maintenant, sauvegarder le magasin
        return magasinRepository.save(magasin);
    }


    @Override
    public List<Client> afficherClients(String nomMagasin) {
        Magasin m = magasinRepository.findByNomMagasin(nomMagasin);
        if (m != null) {
            return m.getClientsMagasin();
        } else {
            throw new RuntimeException("Le magasin avec le nom " + nomMagasin + " n'existe pas.");
        }
    }
    @Scheduled(cron = "0 0 8 * * ?")
    @Override
    public void totalSolde() {
        // Récupérer tous les magasins
        List<Magasin> magasins = magasinRepository.findAll();

        // Parcourir chaque magasin
        for (Magasin magasin : magasins) {
            long totalSolde = 0;

            // Parcourir chaque client du magasin
            for (Client client : magasin.getClientsMagasin()) {
                // Ajouter le solde de la carte de fidélité du client au total
                totalSolde += client.getCrt().getSolde();
            }

            // Afficher le total des soldes des cartes de fidélité pour le magasin
            System.out.println("Total des soldes des cartes de fidélité pour le magasin " + magasin.getNomMagasin() + " : " + totalSolde);
        }
    }


}
