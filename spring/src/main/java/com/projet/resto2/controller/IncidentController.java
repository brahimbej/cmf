package com.projet.resto2.controller;

import com.projet.resto2.dto.SignupRequest;
import com.projet.resto2.entity.Incident;
import com.projet.resto2.repository.IncidentRepository;
import com.projet.resto2.repository.UserRepository;
import com.projet.resto2.services.jwt.UserService;
import com.projet.resto2.utils.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/incident")
@RequiredArgsConstructor
public class IncidentController {

    private final IncidentRepository incidentRepository;

    @PostMapping("/")
    public ResponseEntity<?> creerIncident(@RequestBody Incident incident) {

        incident.setStatus("pending");
        incidentRepository.save(incident);
        if (incident == null)
            return new ResponseEntity<>
                ("incident not created, Come again later", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(incident, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getIncidents() {
        System.out.println("getIncidents");
        List<Incident> incidents = incidentRepository.findAll();
        System.out.println(incidents);
        return new ResponseEntity<>(incidents, HttpStatus.OK);
    }
}
