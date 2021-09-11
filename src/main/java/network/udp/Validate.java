package network.udp;

public final class Validate {
    public static boolean userNameValidate(String userName) {
        int n = userName.length();
        if (n > 55) return false;
        for (int i = 0; i < n; i++) {
            char c = userName.charAt(i);
            if (!('0' <= c && c <= 'z')) {
                return false;
            }
        }
        return true;
    }

    public static boolean emailValidate(String email) {
        boolean atTheRateFound = false, dotFound = false;
        int n = email.length();
        if (n > 55) return false;
        for (int i = n-1; i > 4; i--) {
            char c = email.charAt(i);
            atTheRateFound |= (c == '@');
            dotFound |= (c == '.');
            if(atTheRateFound && dotFound) return true;
        }
        return false;
    }

    public static boolean passwordValidate(String password){
        return password.length()<61;
    }
}
