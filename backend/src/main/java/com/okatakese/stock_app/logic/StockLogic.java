package com.okatakese.stock_app.logic;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.okatakese.stock_app.model.DividendDataModel;
import com.okatakese.stock_app.model.TickerDataModel;

@Component
public class StockLogic {
    /**
     * 銘柄コード情報を取得する
     * @param ticker 銘柄コード
     * @return
     */
    public TickerDataModel getTickerData(String ticker) {
        try {
            String tickerUrl = "https://finance.yahoo.co.jp/quote/" + ticker;
            Document tickerDoc = Jsoup.connect(tickerUrl).get();

            Elements companyNameElement = tickerDoc.select("h2.PriceBoardMain__name__6uDh");
            Elements tickerElement = tickerDoc.select("div#industry span.PriceBoardMain__code__2wso");
            Elements sectorElement = tickerDoc.select("div#industry a.PriceBoardMain__industryName__1uny");
            Elements priceElement = tickerDoc.select("div.PriceBoardMain__headerPrice__gbs7 span.StyledNumber__value__3rXW");
            Elements transactionElement = tickerDoc.select("span.StyledNumber__value__3rXW.DataListItem__value__11kV");

            TickerDataModel tickerData = new TickerDataModel();
            tickerData.setCompanyName(companyNameElement.text());
            tickerData.setTicker(tickerElement.text());
            tickerData.setSector(sectorElement.text());
            tickerData.setStockPrice(priceElement.get(0).text());
            tickerData.setComparedToThePreviousDay(priceElement.get(1).text());
            tickerData.setPercentComparedToThePreviousDay(priceElement.get(2).text());
            tickerData.setYesterdayFinishPrice(transactionElement.get(0).text());
            tickerData.setStartPrice(transactionElement.get(1).text());
            tickerData.setHighestPrice(transactionElement.get(2).text());
            tickerData.setLowestPrice(transactionElement.get(3).text());
            return tickerData;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error("存在しないコードです。");
        }
    }

    /**
     * 配当情報を取得
     * @param ticker
     * @return
     */
    public DividendDataModel getDividendData(String ticker) {
        try {
            String dividendUrl = "https://finance.yahoo.co.jp/quote/" + ticker + "/dividend";
            Document dividendDoc = Jsoup.connect(dividendUrl).get();

            Elements dividendDetailElement = dividendDoc.select("span.StyledNumber__value__3rXW");
            Elements baseElement = dividendDoc.select("th.DpsHistoryTable__head__18SZ");
            DividendDataModel dividendData = new DividendDataModel();
            dividendData.setDps(dividendDetailElement.get(3).text());
            dividendData.setDividendYield(dividendDetailElement.get(4).text());
            dividendData.setDividendPayoutRatio(dividendDetailElement.get(5).text());
            dividendData.setBaseMonth(baseElement.get(8).text());
            dividendData.setFirstQuarter(dividendDetailElement.get(7).text());
            dividendData.setSecondQuarter(dividendDetailElement.get(8).text());
            dividendData.setThirdQuarter(dividendDetailElement.get(9).text());
            dividendData.setFourthQuarter(dividendDetailElement.get(10).text());
            return dividendData;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error("存在しないコードです。");
        }
    }
}
