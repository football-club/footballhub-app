package com.footballhub.hubservices.common.controlers;

//import com.footballhub.hubservices.FootballhubAppApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class getTest {
//    Logger logger = LoggerFactory.getLogger(FootballhubAppApplication.class);

    @GetMapping("/")
    public String apiRoot() {
//        logger.info("Entering into -> {}", this.getClass().getSimpleName());
        return "hello world";
    }
}
