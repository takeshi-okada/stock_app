package com.okatakese.stock_app.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfoModel {
    /**
     * ユーザーID
     */
    private String userId;
    /**
     * ユーザーパスワード
     */
    private String userPassword;
    /**
     * ユーザー名
     */
    private String userName;
    /**
     * ユーザー生年月日
     */
    private Date birth;
    /**
     * 削除フラグ
     */
    private boolean deleteFlg;
}
