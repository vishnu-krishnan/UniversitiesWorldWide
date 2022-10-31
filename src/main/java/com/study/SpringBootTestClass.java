package com.study;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootTestClass {

    @RequestMapping("/greeting")
    public String GreetingMethod(){

        return "Hello Aliens";
    }

}
