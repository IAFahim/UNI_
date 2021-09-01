package network.mail;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class ServerMailHandler {
    private final String password;
    private final String from;
    private String host;
    private Properties properties;
    private Session session;
    private Message message;
    private int port;

    public ServerMailHandler() {
        host = "smtp.gmail.com";
        port = 587;
        from = "no.reply.announcer.auth@gmail.com";
        password = "KitKatFahim";
        build();
    }

    ServerMailHandler(String form, String password) {
        this.from = form;
        this.password = password;
        build();
    }

    ServerMailHandler(String host, int port, String from, String password) {
        this.host = host;
        this.port = port;
        this.from = from;
        this.password = password;
        build();
    }

    public void build() {
        setProperties();
        setSession();
    }

    private void setProperties() {
        properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.ssl.trust", host);
    }

    private void setSession() {
        session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
    }

    public void setAndSend(String to, String subject, String msg, String imagePath) {
        send(new MailSendData(to, subject, msg, imagePath));
    }

    public void setAndSend(String to, String subject, String msg) {
        setAndSend(to, subject, msg, null);
    }

    public void send(MailSendData data) {
        try {
            setMessage(data);
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setMessage(MailSendData data) throws MessagingException, IOException {
        message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(data.to));
        message.setSubject(data.subject);

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(data.msg, "text/html");
        Multipart multipart = new MimeMultipart();

        if (data.imagePath != null) {
            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            attachmentBodyPart.attachFile(new File(data.imagePath));
            multipart.addBodyPart(attachmentBodyPart);
        }

        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);
    }
}