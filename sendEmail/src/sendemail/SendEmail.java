/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendemail;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
public class SendEmail {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String username = "suntiver6@gmail.com";
        final String password = "01a02b03c04d05e";

        Properties prop = new Properties();
	prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
       });  
        
        
         try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("suntiverjastel@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                        InternetAddress.parse("suntiverjastel@gmail.com")
            );
            message.setSubject("No 2");
            message.setText("Dear Mail arthit,"
                    + "\n\n เทสครั้งที่ 1\n"
                    +"\n\n ผมจะไม่ขอออกความคิดเห็นใด ๆ ทั้งนั้น เพราะสิ่งที่คุณโพสมา ผมไม่ค่อยเข้าใจ ผมเลยไม่อยากจะพูดอะไรหรือคอมเม้นอะไรให้มันยาวเหยียดเพื่อที่คุณและเพื่อน ๆ จะได้ไม่ต้องสับสนและอ่านคอมเม้นของผม เอาเป็นว่าผมไม่ออกความคิดเห็นน่ะครับ ไปก่อนนะครับผมไม่ค่อยมีเวลาพูดหรือเม้นอะไรเยอะแยะหวังว่าเข้าใจน่ะครับ ผมพูดจริง ๆ น่ะครับว่าไม่อยากคอมเม้นอะไรยาว ๆ แต่ที่ผมเม้นยาว ๆ มันก็ไม่ได้ทำให้ผมเม้นยาวหรอก เพราะที่ผมไม่อยากเม้นยาวเพราะผมเม้นไม่ยาว แต่ถ้าผมเม้นยาวผมก็เม้นไม่ยาวมากหรอกครับ ผมเลยไม่อยา");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        
    }
    
}
