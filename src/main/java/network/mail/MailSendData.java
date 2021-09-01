package network.mail;

public class MailSendData {
    protected String to, subject, msg, imagePath;
    protected MailSendData(String to, String subject, String msg, String imagePath) {
        this.to = to;
        this.subject = subject;
        this.msg = msg;
        this.imagePath = imagePath;
    }
}