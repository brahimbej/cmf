package com.projet.resto2.services;

import com.google.api.services.gmail.model.Message;

import java.io.IOException;
import java.util.List;

public interface GmailService {
    public List<Message> listMessages() throws IOException;

    public Message getMessage(String messageId) throws IOException ;
}
