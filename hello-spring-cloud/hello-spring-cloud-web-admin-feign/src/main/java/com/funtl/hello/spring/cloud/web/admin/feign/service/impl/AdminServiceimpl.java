package com.funtl.hello.spring.cloud.web.admin.feign.service.impl;

import org.springframework.stereotype.Service;

@Service
public class AdminServiceimpl implements com.funtl.hello.spring.cloud.web.admin.feign.service.AdminService {
    @Override
    public String sayHi(String message) {
        return "Hi,My Friends!"+message;
    }
}
