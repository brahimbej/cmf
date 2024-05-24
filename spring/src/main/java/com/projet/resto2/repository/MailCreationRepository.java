package com.projet.resto2.repository;

import com.projet.resto2.entity.MailCreation;
import com.projet.resto2.entity.mailReceiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MailCreationRepository extends JpaRepository<MailCreation, Long> {
}
