package com.example.examblanc.DAO.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "T_CLIENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   int idClient;
   String nomClient;
   String prenomClient;
   String adresseClient;
   long cin;
   @ManyToMany(mappedBy = "clientsMagasin")
   List<Magasin> magasinClients;
   @OneToOne(cascade = CascadeType.ALL)
    CarteFId crt;
}
