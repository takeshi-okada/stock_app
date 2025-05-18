import type { DividendDataModel } from "./DividendDataModel";
import type { TickerDataModel } from "./TickerDataModel";

export interface StockDataModel {
    /** 銘柄コード情報 */
    tickerData: TickerDataModel;
    /** 配当金情報 */
    dividendData: DividendDataModel;
}