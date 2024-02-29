package com.example.examblanc.Services.CarteFId;

import com.example.examblanc.DAO.Entities.CarteFId;

public interface ICarteFId {

    void ajouterCarteEtAffecterClient(CarteFId carteFId, long cin);

    long effectuerOperation(String typeOperation, long numCarte, int montant);
}
