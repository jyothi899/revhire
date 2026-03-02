//package com.rev_hire.util;
//
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.util.Base64;
//
//
//public class PasswordUtil {
//
//    /**
//     * Hashes the password using SHA-256.
//     */
//    public static String hashPassword(String password) {
//        try {
//            MessageDigest md = MessageDigest.getInstance("SHA-256");
//            byte[] hashedBytes = md.digest(password.getBytes());
//            return Base64.getEncoder().encodeToString(hashedBytes);
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException("Error hashing password", e);
//        }
//    }
//
//    /**
//     * Verifies if the provided password matches the hashed version.
//     */
//    public static boolean checkPassword(String password, String hashed) {
//        return hashPassword(password).equals(hashed);
//    }
//}
package com.rev_hire.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PasswordUtil {

    private static final Logger logger = Logger.getLogger(PasswordUtil.class.getName());

    /**
     * Hashes the password using SHA-256.
     */
    public static String hashPassword(String password) {
        try {
            logger.info("Hashing password using SHA-256");

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashedBytes);

        } catch (NoSuchAlgorithmException e) {
            logger.log(Level.SEVERE, "Error hashing password", e);
            throw new RuntimeException("Error hashing password", e);
        }
    }

    /**
     * Verifies if the provided password matches the hashed version.
     */
    public static boolean checkPassword(String password, String hashed) {
        logger.info("Checking password match");
        return hashPassword(password).equals(hashed);
    }
}
