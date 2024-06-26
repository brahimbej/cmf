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

    @PostMapping("/add")
    public ResponseEntity<?> creerRapport(@RequestBody Rapport rapport) {
        System.out.println("rapport here");
        System.out.println("rapport");
        System.out.println("rapport"+rapport.getDescription());
        System.out.println("rapport"+rapport.getIncidentId());
        rapportRepository.save(rapport);
        if (rapport == null)
            return new ResponseEntity<>
                    ("rapport not created, Come again later", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(rapport, HttpStatus.CREATED);
    }

    @PostMapping("/ajout")
    public ResponseEntity<?> ajoutRapport(@RequestBody Rapport rapportRequest) {
        System.out.println("rapport here");

        Rapport rapport = rapportRepository.save(rapportRequest);
        if (rapport == null)
            return new ResponseEntity<>
                    ("rapport not created", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(rapport, HttpStatus.CREATED);
    }


    @GetMapping("/getAll")
    public ResponseEntity<?> getIncidents() {

        List<Rapport> rapports = rapportRepository.findAll();
        System.out.println("getrapport");
        System.out.println(rapports);
        return new ResponseEntity<>(rapports, HttpStatus.OK);
    }
}
