package com.example.examblanc.Services.Client;

import com.example.examblanc.DAO.Entities.Client;
import com.example.examblanc.DAO.Entities.Magasin;
import com.example.examblanc.DAO.Reopsitory.ClientRepository;
import com.example.examblanc.DAO.Reopsitory.MagasinRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientService implements IClientService{
    ClientRepository clientRepository;
    MagasinRepository magasinRepository;



    @Override
    public Client ajouterClient(Client c) {
        clientRepository.save(c);
        return c;
    }

    @Override
    public void affecterClientAMagasin(int idClient, int idMagasin) {
         Client c = clientRepository.findById(idClient).orElseThrow();
         Magasin m = magasinRepository.findById(idMagasin).orElseThrow();

         m.getClientsMagasin().add(c);
         magasinRepository.save(m);


    }
}
