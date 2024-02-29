package com.example.examblanc.Services.Magasin;

import com.example.examblanc.DAO.Entities.Client;
import com.example.examblanc.DAO.Entities.Magasin;

import java.util.List;

public interface IMagasinService {
    Magasin ajouterMagasinEtPersonnels (Magasin magasin);

    List<Client> afficherClients(String nomMagasin);
    void totalSolde();
}
