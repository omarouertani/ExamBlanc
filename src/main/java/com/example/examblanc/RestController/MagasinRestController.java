package com.example.examblanc.RestController;

import com.example.examblanc.DAO.Entities.Client;
import com.example.examblanc.DAO.Entities.Magasin;
import com.example.examblanc.Services.Magasin.IMagasinService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("magasin")
@AllArgsConstructor
public class MagasinRestController {

    IMagasinService MagasinService;

    @PostMapping("ajouterMag")
    public Magasin ajouterMagasinEtPersonnels(@RequestBody Magasin m){
        return MagasinService.ajouterMagasinEtPersonnels(m);
    }

    @GetMapping("afficherCli")
    public List<Client> afficherClients(@RequestParam String nomMagasin){
        return MagasinService.afficherClients(nomMagasin);
    }

}
