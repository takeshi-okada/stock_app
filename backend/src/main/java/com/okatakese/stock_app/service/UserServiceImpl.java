package com.okatakese.stock_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.okatakese.stock_app.model.UserInfoModel;
import com.okatakese.stock_app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserInfoModel getUserInfo(String userId, String password) {
        Optional<UserInfoModel> loginUserInfoOptional = userRepository.getUserInfo(userId);
        if (loginUserInfoOptional.isEmpty()) {
            throw new Error("存在しないIDです。 ID = " + "okada");
        }

        UserInfoModel loginUserInfo = loginUserInfoOptional.get();
        if (!loginUserInfo.getUserPassword().equals(password)) {
            throw new Error("パスワードが異なります。");
        }

        return loginUserInfo;
    }

    @Override
    public void insertUserInfo(UserInfoModel userInfoModel) {
        int count = userRepository.insertUserInfo(userInfoModel);
        if (count < 1) {
            throw new Error("登録失敗");
        }
        return;
    }
}
