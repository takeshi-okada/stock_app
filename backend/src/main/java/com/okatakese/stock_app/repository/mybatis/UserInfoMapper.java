package com.okatakese.stock_app.repository.mybatis;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.okatakese.stock_app.model.UserInfoModel;

/**
 * ユーザー情報を扱うMapper
 */
@Mapper
public interface UserInfoMapper {
   /**
    * ユーザー情報を取得する
    * @param userId ユーザーID
    * @return ユーザー情報
    */
   public Optional<UserInfoModel> getUserInfo(@Param("userId") String userId); 
}
