package com.footballhub.hubconfig;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupMessagePrinter extends ApplicationEvent {

    private final String message;

    public StartupMessagePrinter(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}