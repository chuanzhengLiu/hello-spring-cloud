package com.funtl.hello.spring.cloud.service.admin.controller;

import com.funtl.hello.spring.cloud.service.admin.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private TestService testService;

    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "message") String message) {
        String s = testService.SayHi(message);
        return String.format("Hi，your message is : %s i am from port : %s", s, port);
    }
}
