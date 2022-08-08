package DoctorMail;
import javax.mail.Message;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DoctorMailUtil {
    public static void sendMail(String recepient) throws MessagingException {
        Properties properties=new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");

        String myAccountEmail="@gmail.com";
        String password="********";

        Session session=Session.getInstance(properties,new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        Message message=prepareMessage(session,myAccountEmail,recepient);
        Transport.send(message);
        System.out.println("Success");

    }
    private static Message prepareMessage(Session session,String myAccountEmail,String recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.addRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress(recepient)});
            message.setSubject("Message from doctor");
            message.setText("hey there");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(DoctorMailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}


