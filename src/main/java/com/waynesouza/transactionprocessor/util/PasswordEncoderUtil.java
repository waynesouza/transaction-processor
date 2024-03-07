package com.waynesouza.transactionprocessor.util;

import java.security.MessageDigest;
import java.util.Base64;

import static java.nio.charset.StandardCharsets.UTF_8;

public class PasswordEncoderUtil {

    public static String encrypt(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA_256");
            var hash = digest.digest(password.getBytes(UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
