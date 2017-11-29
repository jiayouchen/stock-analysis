package analysis.stock.service.impl;

import analysis.stock.model.StockInfo;
import analysis.stock.service.CalculateService;
import analysis.stock.service.StockInfoService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("calculateService")
public class CalculateServiceImpl implements CalculateService {

    @Resource(name = "stockInfoService")
    private StockInfoService stockInfoService;

    /**
     * @param stockInfos
     *            :股票代码
     * @param date
     *            :日期
     * @param limit
     *            :天数
     * @return averagePrice:均价
     */
    public BigDecimal calAveragePrice(List<StockInfo> stockInfos, Date date, int limit) {
        for (StockInfo stockInfo : stockInfos) {
            if (stockInfo.getDate() == date) {
                if (stockInfos.indexOf(stockInfo) < limit - 2) {
                    return null;
                }
            }
        }
        BigDecimal sum = BigDecimal.ZERO;
        for (int i = 0; i < limit - 1; i++) {
            sum = sum.add(BigDecimal.valueOf(
                    stockInfoService.getStockInfoByDate(stockInfos, date, i).getClosingPrice()));
        }
        sum = sum.add(BigDecimal.valueOf(
                stockInfoService.getStockInfoByDate(stockInfos, date, 0).getCurrentPrice()));
        return sum.divide(BigDecimal.valueOf(limit), 4, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * @param stockInfo
     *            :股票信息
     * @param lastIsChange
     *            :上次N涨跌判断
     * @param trend
     *            :N趋势力度
     * @return trend:N趋势力度
     */
    public BigDecimal calTrendN(StockInfo stockInfo, int lastIsChangeN, BigDecimal trendN) {
        if (stockInfo.getIsChangeN() == lastIsChangeN) {
            trendN = trendN.add(stockInfo.getChange());
        } else {
            trendN = stockInfo.getChange();
        }
        return trendN;
    }

    /**
     * @param stockInfo
     *            :股票信息
     * @param lastIsChange
     *            :上次N涨跌判断
     * @param isChangeCount
     *            :N累计涨跌
     * @return isChangeCount:N累计涨跌
     */
    public int calIsChangeCountN(StockInfo stockInfo, int lastIsChangeN, int isChangeCountN) {
        if (stockInfo.getIsChangeN() == lastIsChangeN) {
            isChangeCountN += stockInfo.getIsChangeN();
        } else {
            isChangeCountN = stockInfo.getIsChangeN();
        }
        return isChangeCountN;
    }

    /**
     * @param stockInfo
     *            :股票信息
     * @param lastIsChange
     *            :上次N涨跌判断
     * @param lasthPriceN
     *            :N高价
     * @return hPriceN:N高价
     */
    public double calhPriceN(StockInfo stockInfo, int lastIsChangeN, double lasthPriceN) {
        if (stockInfo.getIsChangeN() == lastIsChangeN) {
            return Math.max(lasthPriceN, stockInfo.gethPrice());
        } else {
            return stockInfo.gethPrice();
        }
    }

    /**
     * @param stockInfo
     *            :股票信息
     * @param lastIsChange
     *            :上次N涨跌判断
     * @param lastlPriceN
     *            :N低价
     * @return lPriceN :N低价
     */
    public double callPriceN(StockInfo stockInfo, int lastIsChangeN, double lastlPriceN) {
        if (stockInfo.getIsChangeN() == lastIsChangeN) {
            return Math.min(lastlPriceN, stockInfo.getlPrice());
        } else {
            return stockInfo.getlPrice();
        }
    }

    /**
     * @param stockInfo
     *            :股票信息
     * @param lastIsChange
     *            :上次N涨跌判断
     * @return first4A :4第一个A
     */
    public int calFirst4A(StockInfo stockInfo, int lastIsChangeN) {
        if (stockInfo.getIsChangeN() == lastIsChangeN) {
            return -Integer.signum(stockInfo.getIsChangeN());
        } else if (stockInfo.getOpenningPrice() > stockInfo.getCurrentPrice()) {
            return -Integer.signum(stockInfo.getIsChangeN());
        } else {
            return 0;
        }
    }

    /**
     * @param stockInfo
     *            :股票信息
     * @param lastChange
     *            :上次长短期线判断
     * @return reduceTrend4 :4趋势缩小
     */
    public int calReduceTrend4(StockInfo stockInfo, BigDecimal lastChange) {
        if (stockInfo.getChange().abs().compareTo(lastChange.abs()) < 0) {
            return -stockInfo.getChange().compareTo(BigDecimal.ZERO);
        } else {
            return 0;
        }
    }

    /**
     * @param stockInfo
     *            :股票信息
     * @return buyTopPriceA :买高地价A
     */
    public int calBuyTopPriceA(StockInfo stockInfo) {
        return (stockInfo.gethPriceN_3() > stockInfo.gethPriceN() ? 1 : 0)
                * (stockInfo.gethPriceN_3() > stockInfo.gethPriceN_1() ? -1 : 0)
                * (stockInfo.gethPriceN_3() > stockInfo.getlPriceN_2() ? 1 : 0);
    }

    /**
     * @param stockInfo
     *            :股票信息
     * @return buyTopPriceA :卖高地价A
     */
    public int calSellTopPriceA(StockInfo stockInfo) {
        return (stockInfo.getlPriceN_3() < stockInfo.getlPriceN() ? 1 : 0)
                * (stockInfo.getlPriceN_3() < stockInfo.getlPriceN_1() ? 1 : 0)
                * (stockInfo.getlPriceN_3() < stockInfo.getlPriceN_2() ? 1 : 0);
    }

}