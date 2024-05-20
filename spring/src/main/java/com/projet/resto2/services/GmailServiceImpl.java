package com.projet.resto2.services;

import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GmailServiceImpl implements  GmailService{
    public List<Message> listMessages() throws IOException {
        String user = "me";

        List<Message> listResponse = new ArrayList<>() ;
        return listResponse;
    }

    public Message getMessage(String messageId) throws IOException {
        String user = "me";
        return new Message();
    }
}
