package com.funtl.hello.spring.cloud.service.admin.Service.impl;

import com.funtl.hello.spring.cloud.service.admin.Service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServieImpl implements TestService {
    @Override
    public String SayHi(String message) {
        return "WELCOME!"+message;
    }
}
