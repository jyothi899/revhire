//package com.rev_hire.util;
//
//import java.util.regex.Pattern;
//
//public class ValidationUtil {
//
//    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
//
//    /**
//     * Validates if the email format is correct.
//     */
//    public static boolean isValidEmail(String email) {
//        if (email == null)
//            return false;
//        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
//    }
//
//    /**
//     * Validates if the password meets security requirements.
//     */
//    public static boolean isValidPassword(String password) {
//        if (password == null || password.length() < 8)
//            return false;
//
//        boolean hasUpper = false;
//        boolean hasLower = false;
//        boolean hasDigit = false;
//        boolean hasSpecial = false;
//
//        String specialChars = "!@#$%^&*()-_=+[]{}|;:',.<>?/";
//
//        for (char c : password.toCharArray()) {
//            if (Character.isUpperCase(c))
//                hasUpper = true;
//            else if (Character.isLowerCase(c))
//                hasLower = true;
//            else if (Character.isDigit(c))
//                hasDigit = true;
//            else if (specialChars.indexOf(c) != -1)
//                hasSpecial = true;
//        }
//
//        return hasUpper && hasLower && hasDigit && hasSpecial;
//    }
//}
package com.rev_hire.util;

import java.util.regex.Pattern;
import java.util.logging.Logger;

public class ValidationUtil {

    private static final Logger logger = Logger.getLogger(ValidationUtil.class.getName());
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

    public static boolean isValidEmail(String email) {
        logger.info("Validating email format");

        if (email == null)
            return false;

        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }

    public static boolean isValidPassword(String password) {
        logger.info("Validating password strength");

        if (password == null || password.length() < 8)
            return false;

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        String specialChars = "!@#$%^&*()-_=+[]{}|;:',.<>?/";

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c))
                hasUpper = true;
            else if (Character.isLowerCase(c))
                hasLower = true;
            else if (Character.isDigit(c))
                hasDigit = true;
            else if (specialChars.indexOf(c) != -1)
                hasSpecial = true;
        }

        boolean valid = hasUpper && hasLower && hasDigit && hasSpecial;

        if (!valid) {
            logger.warning("Weak password attempt detected");
        }

        return valid;
    }
}
