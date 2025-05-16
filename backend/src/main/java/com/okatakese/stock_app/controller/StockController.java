package com.okatakese.stock_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.okatakese.stock_app.model.StockDataModel;
import com.okatakese.stock_app.service.StockService;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    /**
     * 株価情報取得処理
     * @return
     */
    @GetMapping
    public StockDataModel getStockData(@RequestParam(name = "ticker") String ticker) {
        StockDataModel stockData = stockService.getStockData(ticker);
        return stockData;
    }
}
