package lapr.project.controller;

import org.junit.jupiter.api.Test;
import javax.mail.MessagingException;
import java.io.IOException;

class SendEmailWithChargeInformationControllerTest {

    @Test
    void sendEmailWithChargeInfo() throws MessagingException, IOException {
        SendEmailWithChargeInformationController controller = new SendEmailWithChargeInformationController();
        controller.sendEmailWithChargeInfo();
    }
}