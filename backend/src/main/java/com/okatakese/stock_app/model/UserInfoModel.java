package com.okatakese.stock_app.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfoModel {
    private String userId;
    private String userName;
    private boolean deleteFlg;
}
