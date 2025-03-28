package com.okatakese.stock_app.repository;

import java.util.Optional;

import com.okatakese.stock_app.model.UserInfoModel;

/**
 * ログイン関連レポジトリ
 */
public interface LoginRepository {
     /**
      * ログインIDを元にユーザー情報を取得
      * @param userId ユーザーID
      * @return ユーザー情報
      */
     public Optional<UserInfoModel> getLoginUserInfo(String userId);
}
