package com.example.examblanc.Services.Client;

import com.example.examblanc.DAO.Entities.Client;

public interface IClientService {
    Client ajouterClient (Client c);

    void affecterClientAMagasin (int idClient, int idMagasin);

}
