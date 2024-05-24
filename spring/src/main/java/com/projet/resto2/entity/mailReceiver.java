package com.projet.resto2.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class mailReceiver {
    @Id
    private Long id ;
    private String mailValue;
}
