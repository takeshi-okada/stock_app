package com.okatakese.stock_app.repository.mybatis;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.okatakese.stock_app.model.UserInfoModel;

@Mapper
public interface UserInfoMapper {
   public Optional<UserInfoModel> getUserInfo(String userId); 
}
