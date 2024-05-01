package com.projet.resto2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "rapports")
public class Rapport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String description;
    @OneToOne
    @JoinColumn(name = "incident_id", referencedColumnName = "id")
    private Incident incident;



}
