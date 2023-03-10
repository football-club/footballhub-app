package com.footballhub.hubservices.common.listener;

import com.footballhub.hubconfig.StartupMessagePrinter;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupMessageListener {
    @EventListener
    public void onApplicationEvent(StartupMessagePrinter startupMessagePrinter){
        System.out.println(startupMessagePrinter.getMessage());
    }
}
