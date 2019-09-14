package com.msoft.noteappapi.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class SecurityUtil {
    private static final String SALT = "salt";//Salt should be protected carefully
    @Bean
    public static BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
    }
    @Bean
    public static String randomPassword(){
        String SALTCHARS ="ABCDEFGHIJKLMNOPQRSTUVWXYX1234567890";
        StringBuilder salt =new StringBuilder();
        Random random=new Random();
        while (salt.length()<18){
            int index=(int)(random.nextFloat()*SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr=salt.toString();
        return saltStr;
    }
}
