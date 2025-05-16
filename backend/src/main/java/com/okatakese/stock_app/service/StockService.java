package com.okatakese.stock_app.service;

import com.okatakese.stock_app.model.StockDataModel;

public interface StockService {
    public StockDataModel getStockData(String ticker);
}
