package com.okatakese.stock_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.okatakese.stock_app.logic.StockLogic;
import com.okatakese.stock_app.model.StockDataModel;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockLogic stockLogic;

    @Override
    public StockDataModel getStockData(String ticker) {
        StockDataModel stockData = new StockDataModel();
        stockData.setTickerData(stockLogic.getTickerData(ticker));
        stockData.setDividendData(stockLogic.getDividendData(ticker));
        return stockData;

    }
    
}
