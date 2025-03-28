package com.okatakese.stock_app.service;

import com.okatakese.stock_app.model.LoginRequestModel;
import com.okatakese.stock_app.model.UserInfoModel;
/**
 * ログイン関連サービス
 */
public interface LoginService {
     /**
      * ログインユーザー情報を取得
      * @param loginRequestInfo ログイン関連ユーザー入力値
      * @return ユーザー情報
      */
     public UserInfoModel getLoginUserInfo(LoginRequestModel loginRequestInfo);
}
