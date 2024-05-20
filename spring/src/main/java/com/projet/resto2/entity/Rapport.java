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
//    @ManyToOne
//    @JoinColumn(name = "incident_id")
    private long incidentId;

    @Override
    public String toString() {
        return "Rapport{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

}
