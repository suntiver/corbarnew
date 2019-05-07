/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reademail;
import java.io.*;
import javax.mail.*;
import java.util.Properties;

public class ReadEmailFetching {
    
    
    public  static void receiveMail(String userName,String passWord) throws IOException{
        
        try {
            
            Properties props = new Properties();
            props.setProperty("mail.store.protocal","imaps");
            Session emailSession = Session.getDefaultInstance(props);
            Store emailStore = emailSession.getStore("imaps");
            emailStore.connect("imap.gmail.com",userName,passWord);
            
            //getting inbox folder
            
            Folder emailFolder =  emailStore.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);
            Message messages[] = emailFolder.getMessages();
            
            for(int i=0 ;i<messages.length;i++){
                Message message = messages[i];
                System.out.println("Email Number:"+i+1);
                System.out.println("Subject: "+message.getSubject());
                System.out.println("From: "+message.getFrom()[0]);
                System.out.println("Sent date: "+message.getSentDate());
                System.out.println("Text: " + message.getContent().toString());
                
               
            }

            
            
            emailFolder.close(false);
            emailStore.close();
            
        } catch (NoSuchProviderException nspe) {
            nspe.printStackTrace();
        } catch (MessagingException me) {
            
            me.printStackTrace();
        }
        catch (Exception exp){
            exp.printStackTrace();
        }
        
    }
    
    
    
    
    public static void main(String[] args) throws IOException {
        receiveMail("suntiverjastel@gmail.com","01a02b03c04d05e");
    }
   
}
