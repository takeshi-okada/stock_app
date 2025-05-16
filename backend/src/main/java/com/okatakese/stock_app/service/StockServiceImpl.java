package com.okatakese.stock_app.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.okatakese.stock_app.model.StockDataModel;

@Service
public class StockServiceImpl implements StockService {

    @Override
    public StockDataModel getStockData(String ticker) {
        try {
            String url = "https://finance.yahoo.co.jp/quote/" + ticker;
            Document doc = Jsoup.connect(url).get();

            // 株価を含む要素を取得（クラス名や構造は随時変更されることあり）
            Elements priceElement = doc.select("div.PriceBoardMain__headerPrice__gbs7 span.StyledNumber__value__3rXW"); // ←要確認

            StockDataModel stockDataModel = new StockDataModel();
            stockDataModel.setStockPrice(priceElement.get(0).text());
            stockDataModel.setComparedToThePreviousDay(priceElement.get(1).text());
            stockDataModel.setPercentComparedToThePreviousDay(priceElement.get(2).text());
            return stockDataModel;
        } catch (Exception e) {
            e.printStackTrace();
            StockDataModel stockDataModel = new StockDataModel();
            return stockDataModel;
        }
    }
    
}
