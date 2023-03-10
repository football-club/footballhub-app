package com.footballhub.hubservices;

import com.footballhub.hubconfig.CustomBanner;
import com.footballhub.hubconfig.StartupMessagePrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationEventPublisher;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class FootballhubAppApplication implements CommandLineRunner {

    @Autowired
    private ApplicationEventPublisher publisher;
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(FootballhubAppApplication.class);
        app.setBanner(new CustomBanner());
        app.run(args);
    }

    @Override
    public void run(String... args) {
        publisher.publishEvent(new StartupMessagePrinter(this, "\nApplication Started on:\nhttp://localhost:8080\nhttps://localhost:8443"));
    }

}
