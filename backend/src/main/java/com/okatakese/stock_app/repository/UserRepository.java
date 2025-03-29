package com.okatakese.stock_app.repository;

import java.util.Optional;

import com.okatakese.stock_app.model.UserInfoModel;

/**
 * ユーザー関連レポジトリ
 */
public interface UserRepository {
     /**
      * ユーザーIDを元にユーザー情報を取得
      * @param userId ユーザーID
      * @return ユーザー情報
      */
     public Optional<UserInfoModel> getUserInfo(String userId);

     /**
      * ユーザー情報登録処理
      * @param userInfoModel 登録するユーザー情報
      * @return 成功数
      */
     public int insertUserInfo(UserInfoModel userInfoModel);
}
