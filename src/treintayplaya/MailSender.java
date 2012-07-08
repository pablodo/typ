package treintayplaya;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author administrador
 */
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
    String mailFrom;
    String passFrom;
    String servidorSMTP = "smtp.gmail.com";
    String puertoEnvio = "465";
    Address[] mailsTo = null;
    String asunto = null;
    String cuerpo = null;
    Properties props;
    SMTPAuthenticator smtpAuth;
    Session session;
    
    public MailSender(String mailFrom, String passFrom){
        this(new String[0], mailFrom, passFrom);
    }
    
    public MailSender(String[] mailsTo, String mailFrom, String passFrom){
        try {
            this.mailFrom = mailFrom;
            Integer length = mailsTo.length;
            if (length > 0){
                this.mailsTo = new InternetAddress[length];
                for (int i = 0; i<mailsTo.length; i++){
                    if (mailsTo[i] != null && mailsTo[i].trim() != "")
                        this.mailsTo[i] = new InternetAddress(mailsTo[i]);
                }
            }
            this.passFrom = passFrom;
            props = new Properties();
            props.put("mail.smtp.user", mailFrom);
            props.put("mail.smtp.host", servidorSMTP);
            props.put("mail.smtp.port", puertoEnvio);
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.socketFactory.port", puertoEnvio);
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");
            
            smtpAuth = new SMTPAuthenticator(mailFrom, passFrom);
            session = Session.getInstance(props, smtpAuth);
        } catch (AddressException ex) {
            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public MailSender(String mailTo, String mailFrom, String passFrom) {
        this(new String[1], mailFrom, passFrom);
        try {
            this.mailsTo[0] = new InternetAddress(mailTo);
        } catch (AddressException ex) {
            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void send(String mailTo, String asunto, String mensaje){
        mailsTo = new InternetAddress[1];
        try {
            mailsTo[0] = new InternetAddress(mailTo);
            send(asunto, mensaje);
        } catch (Exception ex) {
            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void send(String asunto, String mensaje) throws Exception{
        
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setText(mensaje);
            msg.setSubject(asunto);
            msg.addRecipients(Message.RecipientType.TO, mailsTo);
            msg.setFrom(new InternetAddress(mailFrom));
            
            Transport.send(msg);
        } catch (MessagingException ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    private class SMTPAuthenticator extends Authenticator{
        String mail;
        String pass;
        public SMTPAuthenticator(String mail, String pass){
            this.mail = mail;
            this.pass = pass;
        }
        @Override
        public PasswordAuthentication getPasswordAuthentication(){
            return new PasswordAuthentication(mail, pass);
        }
    }
    
    public static void main(String args[]){
        String[] mails = {"pablodo@olx.com","pabliyus@gmail.com"};
        MailSender mail = new MailSender(mails, "pablo.diazogni@gmail.com", "");
        try{
            mail.send("Prueba", "Si te llego este mail, es que ya aprendi a mandar mails en java :)");
        }catch(Exception e){}
    }
}



