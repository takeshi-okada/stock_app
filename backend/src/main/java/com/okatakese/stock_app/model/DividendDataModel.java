package com.okatakese.stock_app.model;

import lombok.Data;

@Data
public class DividendDataModel {
    /** 一株あたりの配当金（会社予想） */
    private String dps;
    /** 配当利回り（会社予想） */
    private String dividendYield;
    /** 配当性向 */
    private String dividendPayoutRatio;
    /** 基準月 */
    private String baseMonth;
    /** 配当金第一四半期 */
    private String firstQuarter;
    /** 配当金第二四半期 */
    private String secondQuarter;
    /** 配当金第三四半期 */
    private String thirdQuarter;
    /** 配当金第四四半期 */
    private String fourthQuarter;
}

