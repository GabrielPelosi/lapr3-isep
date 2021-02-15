package lapr.project.controller;

import lapr.project.utils.JavaMailSender;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SendEmailWithChargeInformationController {

    private final String INPUT_DIR = "sendEmailTestFiles";
    private final String FLAG_EXTENSION_TO_COMPARE = ".flag";



    public void sendEmailWithChargeInfo() throws MessagingException, IOException {
        File[] allFiles;
        int sentMails = 0;
        File dir = new File(INPUT_DIR);
        if (dir.isDirectory() && dir.getName().equals(INPUT_DIR)){
            allFiles = dir.listFiles();
            for(int i = 0; i<allFiles.length; i++){
                for (int j = i + 1;j< allFiles.length; j++){
                    if (allFiles[j].getName().equals(allFiles[i].getName() + FLAG_EXTENSION_TO_COMPARE)){
                        List<String> l = Files.lines(Paths.get(allFiles[i].getPath())).collect(Collectors.toList());
                        JavaMailSender.sendMail(l.get(1),l.get(0));
                        sentMails++;
                        break;
                    }
                }
            }
        }
        System.out.println(sentMails + " email sent");
    }

}
