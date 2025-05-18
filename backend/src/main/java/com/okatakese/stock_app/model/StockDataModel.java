package com.okatakese.stock_app.model;

import lombok.Data;

@Data
public class StockDataModel {
    /** 銘柄コード情報 */
    private TickerDataModel tickerData;
    /** 配当金情報 */
    private DividendDataModel dividendData;
}
