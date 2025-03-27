package com.okatakese.stock_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.okatakese.stock_app.model.UserInfoModel;
import com.okatakese.stock_app.service.InitService;

@RestController
public class InitController {
    @Autowired
    private InitService initService;

    @GetMapping("/init")
    public String getInitData() {
        UserInfoModel userInfo = initService.getInitData();    
        return userInfo.getUserName();
    }
}
