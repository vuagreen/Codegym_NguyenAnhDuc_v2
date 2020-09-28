package demosendmai.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.io.IOException;

@SpringBootApplication
public class SendMail implements CommandLineRunner {
    @Autowired
    private JavaMailSender javaMailSender;

    public static void main(String[] args) {
        SendMail.run(SendMail.class, args);
    }

    private static void run(Class<SendMail> sendMailClass, String[] args) {
    }

    void sendEmail() {
        String a = "vuagreenr5@gmail.com";
        String content = "Testing from recover email";
        String content2 = "Hello Name \n recover code : 078587,Hello Name \n recover code : 078587,Hello Name \n recover code : 078587";
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(a);

        msg.setSubject(content);
        msg.setText(content2);

        javaMailSender.send(msg);

    }

    @Override
    public void run(String... args) throws Exception, IOException {
        System.out.println("Sending Email...");

        try {

            sendEmail();
            //sendEmailWithAttachment();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Done");

    }


}
