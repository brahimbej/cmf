package com.projet.resto2.controller;

import com.projet.resto2.entity.Incident;
import com.projet.resto2.entity.Rapport;
import com.projet.resto2.repository.IncidentRepository;
import com.projet.resto2.repository.RapportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rapport")
@RequiredArgsConstructor
public class RapportController {

    private final RapportRepository rapportRepository;

    @PostMapping("/")
    public ResponseEntity<?> creerRapport(@RequestBody Rapport rapport) {
        System.out.println("rapport");
        System.out.println("rapport"+rapport.getDescription());
        System.out.println("rapport"+rapport.getIncident());
        rapportRepository.save(rapport);
        if (rapport == null)
            return new ResponseEntity<>
                    ("incident not created, Come again later", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(rapport, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getIncidents() {
        System.out.println("rapport");
        List<Rapport> rapports = rapportRepository.findAll();

        System.out.println(rapports);
        return new ResponseEntity<>(rapports, HttpStatus.OK);
    }
}
