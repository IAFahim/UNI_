import file.json.Json;
import network.mail.MailSendData;
import network.mail.ServerMailHandler;

import java.io.File;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        ServerMailHandler serverMailHandler=new ServerMailHandler();
        serverMailHandler.setAndSend("fahimmanowarj5@gmail.com","hello vhia","I am Ishtiaq","src/main/resources/search-results-community-banner.png");
    }
}
