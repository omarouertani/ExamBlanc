package com.example.examblanc.DAO.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Entity
@Table(name = "T_CARTEFID")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarteFId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idCarte;
    long numeroCarte;
    long solde;
    LocalDate dateCreation;

}
