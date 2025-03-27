package com.okatakese.stock_app.repository;

import java.util.Optional;

import com.okatakese.stock_app.model.UserInfoModel;

public interface InitRepository {
    public Optional<UserInfoModel> getUserInfo(String userId);
}
