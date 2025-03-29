package com.okatakese.stock_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.okatakese.stock_app.model.LoginRequestModel;
import com.okatakese.stock_app.model.UserInfoModel;
import com.okatakese.stock_app.service.UserService;
/**
 * ログイン関連コントローラー
 */
@RestController
public class LoginController {
    @Autowired
    private UserService loginService;

    /**
     * ログインボタン押下時処理
     * @param request ログイン情報入力値
     * @return
     */
    @PostMapping("/login")
    public UserInfoModel getLoginUser(@RequestBody LoginRequestModel request) {
        UserInfoModel userInfo = loginService.getUserInfo(request.getUserId(), request.getUserPassword());    
        return userInfo;
    }
}
