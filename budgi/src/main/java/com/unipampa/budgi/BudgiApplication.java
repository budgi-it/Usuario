package com.unipampa.budgi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BudgiApplication implements CommandLineRunner {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(BudgiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("BCRYPT = " + passwordEncoder.encode("123456"));

    }
}
