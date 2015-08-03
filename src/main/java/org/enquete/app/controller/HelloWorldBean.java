package org.enquete.app.controller;

import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldBean {

    public String hello() {
        return "Hello world from Server. Time now: "+ LocalDateTime.now().toString();
    }
}
