package com.okatakese.stock_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.okatakese.stock_app.model.LoginRequestModel;
import com.okatakese.stock_app.model.UserInfoModel;
import com.okatakese.stock_app.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginRepository LoginRepository;

    public UserInfoModel getLoginUserInfo(LoginRequestModel loginRequestInfo) {
        Optional<UserInfoModel> loginUserInfoOptional = LoginRepository.getLoginUserInfo(loginRequestInfo.getUserId());
        if (loginUserInfoOptional.isEmpty()) {
            throw new Error("存在しないIDです。 ID = " + "okada");
        }

        UserInfoModel loginUserInfo = loginUserInfoOptional.get();
        if (!loginUserInfo.getUserPassword().equals(loginUserInfo.getUserPassword())) {
            throw new Error("パスワードが異なります。");
        }

        return loginUserInfo;
    }
}
