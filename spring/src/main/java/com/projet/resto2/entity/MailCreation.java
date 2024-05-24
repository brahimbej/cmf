package com.projet.resto2.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MailCreation {
    @Id
    private Long id ;
    private String body;
    private String nameSender;
}
