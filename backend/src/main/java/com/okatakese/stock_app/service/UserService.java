package com.okatakese.stock_app.service;

import com.okatakese.stock_app.model.UserInfoModel;
/**
 * ユーザー情報関連サービス
 */
public interface UserService {
     /**
      * ユーザー情報を取得
      * @param userId ユーザーIDs
      * @param password ユーザーパスワード
      * @return ユーザー情報
      */
     public UserInfoModel getUserInfo(String userId, String password);

     /**
      * ユーザー情報を登録する処理
      * @param userInfoModel 新規ユーザー情報
      */
     public void insertUserInfo(UserInfoModel userInfoModel);
}
