export interface TickerDataModel {
    /** 企業名 */
    companyName: string,
    /** 銘柄コード */
    ticker: string,
    /** セクター */
    sector: string,
    /** 株価 */
    stockPrice: string,
    /** 前日比 */
    comparedToThePreviousDay: string,
    /** 前日比パーセント */
    percentComparedToThePreviousDay: string,
    /** 前日終値 */
    yesterdayFinishPrice: string,
    /** 始値 */
    startPrice: string,
    /** 高値 */
    highestPrice: string,
    /** 安値 */
    lowestPrice: string
}