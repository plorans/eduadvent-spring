package edu.um.eduadventspring.Security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class CustomPasswordEncoder implements PasswordEncoder {

    public String md5(CharSequence password) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(password.toString().getBytes("UTF-8"));
            byte[] raw = md5.digest();

            return Base64.getEncoder().encodeToString(raw);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new RuntimeException("Error encoding password", e);
        }

    }

    @Override
    public String encode(CharSequence rawPassword) {
        return "{b4md5}" + md5(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {

        if (encodedPassword.startsWith("{b4md5}")) {
            String encoded = encodedPassword; 
            String encodedRawPassword = encode(rawPassword);

            
            return encoded.equals(encodedRawPassword);
        } else {
            throw new IllegalArgumentException("unsupported encoder");
        }

    }

}
