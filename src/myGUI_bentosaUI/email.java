package myGUI_bentosaUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bentolima
 
*/

import java.io.*;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Date;

import javax.mail.*;

import javax.mail.internet.*;

import com.sun.mail.smtp.*;

public class email{

    public void sendmail(String address,String subject,String message) throws Exception{
        String from = "secretaria@bento.cv";
        String pass = "bento123.";
        String[] to = {address};
        String host = "smtp.bento.cv";
        
        Properties prop = System.getProperties();
        prop.put("mail.smtp.starttls.enable","true");
        prop.put("mail.smtp.host",host);
        prop.put("mail.smtp.user", pass);
        prop.put("mail.smtp.password",pass);
        prop.put("mail.smtp.port","587");
        prop.put("mail.smtp.auth","true");
        
        Session session  = Session.getDefaultInstance(prop);
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(from));
        InternetAddress[] toaddress = new InternetAddress[to.length];
        
        for(int i = 0;i<to.length;i++){
            toaddress[i] = new InternetAddress(to[i]);
        }
        
        for (int i =0;i< toaddress.length;i++){
            msg.setRecipient(Message.RecipientType.TO, toaddress[i]);
        }
        
        msg.setSubject(subject);
        msg.setContent(message, "text/html,charset=utf-8");
        Transport transport = session.getTransport("smtp");
        transport.connect(host, from, pass);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();
    }
}
