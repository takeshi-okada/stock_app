package com.okatakese.stock_app.model;

import lombok.Data;

@Data
public class LoginRequestModel {
    /**
     * ユーザーID
     */
    private String userId;
    /**
     * ユーザーパスワード
     */
    private String userPassword;
}
