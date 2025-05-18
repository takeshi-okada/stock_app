package com.okatakese.stock_app.model;

import lombok.Data;

@Data
public class TickerDataModel {
    /** 企業名 */
    private String companyName;
    /** 銘柄コード */
    private String ticker;
    /** セクター */
    private String sector;
    /** 株価 */
    private String stockPrice;
    /** 前日比 */
    private String comparedToThePreviousDay;
    /** 前日比パーセント */
    private String percentComparedToThePreviousDay;
    /** 前日終値 */
    private String yesterdayFinishPrice;
    /** 始値 */
    private String startPrice;
    /** 高値 */
    private String highestPrice;
    /** 安値 */
    private String lowestPrice;
}
