package com.okatakese.stock_app.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.okatakese.stock_app.model.UserInfoModel;
import com.okatakese.stock_app.repository.mybatis.UserInfoMapper;

@Repository
public class InitRepositoryImpl implements InitRepository {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public Optional<UserInfoModel> getUserInfo(String userId) {
        return userInfoMapper.getUserInfo("okada");
    }
    
}
