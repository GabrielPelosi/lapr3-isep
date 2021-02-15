package lapr.project.utils;

import org.junit.jupiter.api.Test;

import javax.mail.MessagingException;

class JavaMailSenderTest {

    @Test
    void sendMail() throws MessagingException {
        JavaMailSender.sendMail("lapr3.g37.020.021@gmail.com","10,7");
    }
}