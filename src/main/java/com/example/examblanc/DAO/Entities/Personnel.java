package com.example.examblanc.DAO.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Entity
@Table(name = "T_PERSONNEL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idPersonnel;
    String nomPersonnel;
    String prenomPersonnel;
    LocalDate dateNaissanceP ;
    TypePersonnel typePersonnel;
    @OneToOne(cascade = CascadeType.ALL)
    Magasin magasinPersonnel;
    @ManyToOne(cascade = CascadeType.ALL)
    Magasin magasin;

}
