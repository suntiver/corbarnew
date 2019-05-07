/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchingemail;
import java.io.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SearchTerm;

/**
 *
 * @author Arthit
 */
public class SearchingEmail {

      public void searchEmail(String host, String port, String userName,
            String password, final String keyword) throws IOException {
        Properties properties = new Properties();
 
        // server setting
        properties.put("mail.imap.host", host);
        properties.put("mail.imap.port", port);
 
        // SSL setting
        properties.setProperty("mail.imap.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.imap.socketFactory.fallback", "false");
        properties.setProperty("mail.imap.socketFactory.port",
                String.valueOf(port));
 
        Session session = Session.getDefaultInstance(properties);
 
        try {
            // connects to the message store
            Store store = session.getStore("imap");
            store.connect(userName, password);
 
            // opens the inbox folder
            Folder folderInbox = store.getFolder("INBOX");
            folderInbox.open(Folder.READ_ONLY);
 
            // creates a search criterion
            SearchTerm searchCondition = new SearchTerm() {
                @Override
                public boolean match(Message msg) {
                   
                    try {
                        if (msg.getSubject().contains(keyword) ) {
                            return true;
                        }
                    } catch (MessagingException ex) {
                           ex.printStackTrace();
                    }
                    return false;
    
                }
                
            };
 
            // performs search through the folder
            Message[] foundMessages = folderInbox.search(searchCondition);
 
            for (int i = 0; i < foundMessages.length; i++) {
                Message message = foundMessages[i];
                String subject = message.getSubject();
                System.out.println("Subject: "+message.getSubject());
                System.out.println("From: "+message.getFrom()[0]);
                System.out.println("Sent date: "+message.getSentDate());
                System.out.println("Text: " + message.getContent().toString());
            }
 
            // disconnect
            folderInbox.close(false);
            store.close();
        } catch (MessagingException ex) {
            System.out.println("Could not connect to the message store.");
            ex.printStackTrace();
        }
    }
    
    
    
    public static void main(String[] args) throws IOException, InterruptedException {
        String host = "imap.gmail.com";
        String port = "993";
        String userName = "suntiverjastel@gmail.com";
        String password = "01a02b03c04d05e";
        SearchingEmail searcher = new SearchingEmail();
        String keyword = "";
      
          
            searcher.searchEmail(host, port, userName, password, keyword);
        
    }
    
}
