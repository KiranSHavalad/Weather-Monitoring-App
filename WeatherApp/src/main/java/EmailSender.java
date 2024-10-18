import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
public class EmailSender {
    public void sendAlert(String to, String subject, String body) throws MessagingException {
        String from = "your_email@gmail.com";
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // Correct import for Session
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication("kshavalad@gmail.com", "password");
            }
        });

        // Create a default MimeMessage object.
        Message message = new MimeMessage(session);

        // Set From field
        message.setFrom(new InternetAddress(from));

        // Set To field
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

        // Set Subject
        message.setSubject(subject);

        // Set message body
        message.setText(body);

        // Send message
        Transport.send(message);
    }
}
