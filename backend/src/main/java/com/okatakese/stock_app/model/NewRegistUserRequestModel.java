package com.okatakese.stock_app.model;

import java.util.Date;

import lombok.Data;

@Data
public class NewRegistUserRequestModel {
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

}
