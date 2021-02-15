package lapr.project.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Java mail sender.
 */
public class JavaMailSender {
    private JavaMailSender() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Send mail.
     *
     * @param recipient the recipient
     * @throws MessagingException the messaging exception
     */
    public static void sendMail(String recipient, String message) throws MessagingException {
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccountEmail = "lapr3.g37.020.021@gmail.com";
        String pwd = "QwGLYiV]6YeW";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, pwd);
            }
        });

        Message messageObj = prepareMessage(session,myAccountEmail,recipient, message);

        Transport.send(messageObj);
    }

    private static Message prepareMessage(Session session,String myAccountEmail,String recipient,String message) {
        try {
            Message messageObj = new MimeMessage(session);
            messageObj.setFrom(new InternetAddress(myAccountEmail));
            messageObj.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            messageObj.setSubject("Charging Scooter");
            messageObj.setText("Greetings,Scooter successfully parked, battery will be charged in " + message +  " hours ");
            return messageObj;
        } catch (Exception ex) {
            Logger.getLogger(JavaMailSender.class.getName()).log(Level.SEVERE,null, ex);
        }
        return null;
    }
}
