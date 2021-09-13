package network.udp;


import network.mail.ServerMailHandler;

import javax.mail.MessagingException;
import java.io.IOException;

public class NewUserLoginData {
    public static final int USER_NAME=0;
    public static final int PASSWORD=1;
    public static final int EMAIL=2;
    public static final String path = "src/main/resources/";
    public String userName;
    public String password;
    public String email;

    public boolean addData(int count, StringBuilder sb){
        return switch (count){
            case USER_NAME-> Validate.userNameValidate(userName=sb.toString());
            case PASSWORD-> Validate.passwordValidate(password=sb.toString());
            case EMAIL-> Validate.userNameValidate(email=sb.toString());
            default -> throw new IllegalStateException("Unexpected value: " + count);
        };
    }

    public void register() throws MessagingException, IOException {
        ServerMailHandler.setAndSend(email, "UNI_ Team", "Welcome to You and I");
    }


    public void send(byte[] customBuffer) throws MessagingException, IOException {
        int count = 0;
        NewUserLoginData data=new NewUserLoginData();
        for (int i = 1; i < customBuffer.length; i++) {
            StringBuilder sb = new StringBuilder();
            int s = customBuffer[i] & 0xff;
            if (s == 0) break;
            for (int j = 0; j < s && i < customBuffer.length; j++) {
                sb.append(customBuffer[i++]);
                if(!data.addData(count++,sb))return;
            }
            i--;
        }
        if (count == 3) {
            register();
        }
    }
}
