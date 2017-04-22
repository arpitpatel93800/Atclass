
package com.app.forgetpass;
import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;


public class SendEmail {
    public static void send(String to, String sub, 
                         String msg)
    { 
  
     Properties props = new Properties();
     
     props.put("mail.smtp.host", "smtp.gmail.com");
     props.put("mail.smtp.port", "587");		
     props.put("mail.smtp.auth", "true");
     props.put("mail.smtp.starttls.enable", "true");

    Session session = Session.getInstance(props,new javax.mail.Authenticator()
    {
  	  protected PasswordAuthentication getPasswordAuthentication() 
  	  {
  	 	 return new PasswordAuthentication("arpitpatel9380@gmail.com","arpit3010");
  	  }
   });
    
   try
   {
 
    MimeMessage message = new MimeMessage(session);
       message.setFrom(new InternetAddress("arpitpatel9380@gmail.com"));
       message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
       message.setSubject(sub);
       message.setText(msg);

       /* Transport class is used to deliver the message to the recipients */
       
       Transport.send(message);
 
 
    }
    catch(Exception e)
    {
    	 e.printStackTrace();
    }
  } 
    
}
