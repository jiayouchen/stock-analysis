package analysis.stock.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import analysis.stock.model.StockInfo;

public interface CalculateService {

    // 均价
    public BigDecimal calAveragePrice(List<StockInfo> stockInfos, Date date, int limit);

    // N趋势力度
    public BigDecimal calTrendN(StockInfo stockInfo, int lastIsChangeN, BigDecimal trendN);

    // N累计涨跌
    public int calIsChangeCountN(StockInfo stockInfo, int lastIsChangeN, int isChangeCountN);

    // N高价
    public double calhPriceN(StockInfo stockInfo, int lastIsChangeN, double lasthPriceN);

    // N低价
    public double callPriceN(StockInfo stockInfo, int lastIsChangeN, double lastlPriceN);

    // 4第一个A
    public int calFirst4A(StockInfo stockInfo, int lastIsChangeN);

    // 4趋势缩小
    public int calReduceTrend4(StockInfo stockInfo, BigDecimal lastChange);

    // 买高地价A
    public int calBuyTopPriceA(StockInfo stockInfo);

    // 卖高地价A
    public int calSellTopPriceA(StockInfo stockInfo);

}