package util;

public class HashUtil {
    public static String hasher (String password) {
        Integer hash = 0;
        for (int i = 0; i < password.length(); i++) {
            hash += password.charAt(i);
        }
        return hash.toString();
    }
}
