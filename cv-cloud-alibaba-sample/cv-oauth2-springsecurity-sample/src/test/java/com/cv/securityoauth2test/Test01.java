package com.cv.securityoauth2test;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.keygen.BytesKeyGenerator;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.security.crypto.password.*;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

public class Test01 {


    @Test
    public void test02(){




        // Create an encoder with strength 16
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String result = encoder.encode("myPassword");
        boolean myPassword = encoder.matches("myPassword1", result);
        if (myPassword){
            System.out.println("1111111");
        }


        BytesKeyGenerator generator = KeyGenerators.secureRandom();
        byte[] key = generator.generateKey();

        System.out.println();



        // 1. delegate encode
//        String idForEncode = "bcrypt";
//        Map encoders = new HashMap<>();
//        encoders.put(idForEncode, new BCryptPasswordEncoder());
//        encoders.put("noop", NoOpPasswordEncoder.getInstance());
//        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
//        encoders.put("scrypt", new SCryptPasswordEncoder());
//        encoders.put("sha256", new StandardPasswordEncoder());
//
//        PasswordEncoder passwordEncoder =
//                new DelegatingPasswordEncoder(idForEncode, encoders);

//        User user = new User();

//        User user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("user")
//                .build();
//        System.out.println(user.getPassword());
// {bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG


    }




    @Test
    public void test01(){


        PasswordEncoder passwordEncoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();

        for (int i = 0; i < 5; i++) {
            System.out.println("第"+i+"次："+passwordEncoder.encode("hello world"));
        }



    }



//    public static void main(String[] args) {
//
//
//
//
//    }


}
