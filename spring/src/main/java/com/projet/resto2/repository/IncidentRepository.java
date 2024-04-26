package com.projet.resto2.repository;

import com.projet.resto2.entity.Incident;
import com.projet.resto2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentRepository extends JpaRepository<Incident,Long> {
}
