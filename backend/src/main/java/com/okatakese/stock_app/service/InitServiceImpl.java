package com.okatakese.stock_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.okatakese.stock_app.model.UserInfoModel;
import com.okatakese.stock_app.repository.InitRepository;

@Service
public class InitServiceImpl implements InitService {
    @Autowired
    private InitRepository initRepository;

    public UserInfoModel getInitData() {
        Optional<UserInfoModel> userInfo = initRepository.getUserInfo("okada");
        if (userInfo.isEmpty()) {
            throw new Error("存在しないIDです。 ID = " + "okada");
        }

        return userInfo.get();
    }
}
