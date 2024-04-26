package com.projet.resto2.repository;

import com.projet.resto2.entity.User;
import com.projet.resto2.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findFirstByEmail(String email);
    User findByUserRole(UserRole userRole);
}
