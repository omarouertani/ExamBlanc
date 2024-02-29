package com.example.examblanc.DAO.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "T_MAGASIN")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Magasin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idMagasin;
    String nomMagasin;
    String adresseMagasin;
    long contactMagasin;
    @OneToOne( mappedBy = "magasinPersonnel")
    Personnel personnelMagasin;
    @OneToMany(mappedBy = "magasin")
    List<Personnel> Personnels;
    @ManyToMany
    List<Client> clientsMagasin;

}
