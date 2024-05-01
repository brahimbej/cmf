//package com.projet.resto2.services;
//
//import org.apache.logging.log4j.LogManager;
//
//
//import java.util.logging.Logger;
//
//public class ReadEmailBaseImpl implements ReadEmail {
//
//    protected static final String USERNAME = "*****@gmail.com";
//    protected static final String PASSWORD = "*******";
//
//    private static Logger logger = LogManager.getLogger(ReadEmailBaseImpl.class);
//
//    @Autowired
//    private ProconFileService proconFileService;
//
//    protected void process(final String PROTOCOL, final String HOST, final Properties props) throws MessagingException, IOException {
//        // Creates a javax.mail.Authenticator object.
//        Authenticator auth = new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(ReadEmailPopImpl.USERNAME, ReadEmailPopImpl.PASSWORD);
//            }
//        };
//
//        // Creating mail session.
//        Session session = Session.getDefaultInstance(props, auth);
//
//        // Get the store provider and connect to the store.
//        Store store = session.getStore(PROTOCOL);
//        store.connect(HOST, ReadEmailPopImpl.USERNAME, ReadEmailPopImpl.PASSWORD);
//
//        // Get folder and open the INBOX folder in the store.
//        Folder inbox = store.getFolder("INBOX");
//        inbox.open(Folder.READ_WRITE);
//
//        // Retrieve the messages from the folder.
//        Message[] messages = inbox.getMessages();
//        for (Message message : messages) {
//            //message.setFlag(Flags.Flag.SEEN, true);  // todo: put back
//            if (message != null) {
//                String sentDate = message.getSentDate().toString();
//                List<MimeBodyPart> attachments = getAttachments(message);
//                logger.info("Read email subject '"+message.getSubject()+"' from '"+getAddressesAsString(message)+"' at '"+sentDate+"' with "+attachments.size()+" attachment/s '"+getAttachmentsAsString(attachments)+"'.");
//                if (!attachments.isEmpty()) {
//                    save(message, attachments);
//                    //message.setFlag(Flags.Flag.DELETED, true); // todo: put back
//                }
//            }
//        }
//
//        // Close folder and close store.
//        inbox.close(true);
//        store.close();
//    }
//}
