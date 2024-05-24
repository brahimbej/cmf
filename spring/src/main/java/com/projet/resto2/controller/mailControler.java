package com.projet.resto2.controller;


import com.projet.resto2.entity.MailCreation;
import com.projet.resto2.entity.mailReceiver;
import com.projet.resto2.repository.MailCreationRepository;
import com.projet.resto2.repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mail")
public class mailControler {

    @Autowired
    private MailRepository mailRepository;


    @Autowired
    private MailCreationRepository mailCreationRepository;


    @GetMapping("/listmail")
    public List<mailReceiver> getListMails()
    {
      return this.mailRepository.findAll();
    }

    @PostMapping("/add")
    public void createMail(@RequestBody MailCreation mailCreation){
     this.mailCreationRepository.save(mailCreation);
    }

}
