package utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public static boolean isValidPathFile(String filaAddress) {

        String regex = "^[^\\s]+:\\\\+[^\\s]+\\.(jpg|jpeg)$";

        Pattern pattern = Pattern.compile(regex);
        if (filaAddress == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(filaAddress);

        return matcher.matches();
    }

}
