package com.projet.resto2.entity;

import com.projet.resto2.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Data
@Table(name = "incidents")
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String incident;
    private String type;
    private String echeance;
    private String status;
    private String priorite;
    @OneToMany(mappedBy = "incident")
    private List<Rapport> rapport = new ArrayList<>();

    @Override
    public String toString() {
        return "Incident{" +
                "id=" + id +
                ", incident='" + incident + '\'' +
                '}';
    }

}
