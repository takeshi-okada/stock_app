export interface DividendDataModel {
    /** 一株あたりの配当金（会社予想） */
    dps: string,
    /** 配当利回り（会社予想） */
    dividendYield: string,
    /** 配当性向 */
    dividendPayoutRatio: string,
    /** 基準月 */
    baseMonth: string,
    /** 配当金第一四半期 */
    firstQuarter: string,
    /** 配当金第二四半期 */
    secondQuarter: string,
    /** 配当金第三四半期 */
    thirdQuarter: string
    /** 配当金第四四半期 */
    fourthQuarter: string
}