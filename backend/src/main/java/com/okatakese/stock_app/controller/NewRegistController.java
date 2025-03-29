package com.okatakese.stock_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.okatakese.stock_app.model.NewRegistUserRequestModel;
import com.okatakese.stock_app.model.UserInfoModel;
import com.okatakese.stock_app.service.UserService;

@RestController
public class NewRegistController {
    @Autowired
    private UserService userService;

    /**
     * 新規ユーザー登録ボタン押下時処理
     * @param request 新規ユーザー情報入力値
     * @return
     */
    @PostMapping("/new_regist")
    public String registUserInfo(@RequestBody NewRegistUserRequestModel request) {
        UserInfoModel userInfo = new UserInfoModel(
                                    request.getUserId(),
                                    request.getUserPassword(),
                                    request.getUserName(),
                                    request.getBirth(),
                                    false
                                );
        userService.insertUserInfo(userInfo);    
        return "成功";
    }
}
