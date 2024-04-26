package com.projet.resto2.dto;

import com.projet.resto2.enums.UserRole;
import lombok.Data;


@Data
public class AuthenticationResponse {
    private String jwt;
    private UserRole userRole;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getJwt() {
        return jwt;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    private Long userId;
}
