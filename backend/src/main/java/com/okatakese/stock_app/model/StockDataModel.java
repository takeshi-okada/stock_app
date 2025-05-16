package com.okatakese.stock_app.model;

import lombok.Data;

@Data
public class StockDataModel {
    /** 株価 */
    private String stockPrice;
    /** 前日比 */
    private String comparedToThePreviousDay;
    /** 前日比パーセント */
    private String percentComparedToThePreviousDay;

}
