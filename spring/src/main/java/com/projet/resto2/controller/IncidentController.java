package com.projet.resto2.controller;

import com.projet.resto2.dto.SignupRequest;
import com.projet.resto2.entity.Incident;
import com.projet.resto2.entity.Rapport;
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
        if (incident.getIncident().isEmpty() || incident.getType().isEmpty() || incident.getPriorite().isEmpty()) {
            return new ResponseEntity<>(incident, HttpStatus.BAD_REQUEST);
        }
        incident.setStatus("En cours");
        incidentRepository.save(incident);
        if (incident == null)
            return new ResponseEntity<>
                ("incident not created, Come again later", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(incident, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateIncident(@PathVariable Long id,  @RequestBody Incident updatedIncident) {
        System.out.println("update"+updatedIncident);
        if (!incidentRepository.existsById(id)) {
            return new ResponseEntity<>("Incident not found with id: " + id, HttpStatus.NOT_FOUND);
        }

        Incident existingIncident = incidentRepository.findById(id).orElse(null);
        if (existingIncident != null) {
            // Update only if the incident exists
            existingIncident.setIncident(updatedIncident.getIncident());
            existingIncident.setStatus(updatedIncident.getStatus());
            existingIncident.setType(updatedIncident.getType());
            existingIncident.setPriorite(updatedIncident.getPriorite());

            Incident savedIncident = incidentRepository.save(existingIncident);
            return new ResponseEntity<>(savedIncident, HttpStatus.OK);
        }

        return new ResponseEntity<>("Failed to update incident", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getIncidents() {
        System.out.println("getIncidents");
        List<Incident> incidents = incidentRepository.findAll();
        System.out.println(incidents);
        return new ResponseEntity<>(incidents, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteIncident(@PathVariable Long id) {

        incidentRepository.deleteById(id);


        return new ResponseEntity<>( HttpStatus.OK);
    }
}
