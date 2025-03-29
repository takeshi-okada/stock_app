package com.okatakese.stock_app.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.okatakese.stock_app.model.UserInfoModel;
import com.okatakese.stock_app.repository.mybatis.UserInfoMapper;


@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public Optional<UserInfoModel> getUserInfo(String userId) {
        return userInfoMapper.getUserInfo(userId);
    }

    @Override
    public int insertUserInfo(UserInfoModel userInfoModel) {
        return userInfoMapper.insertUserInfo(userInfoModel);
    }
    
}
