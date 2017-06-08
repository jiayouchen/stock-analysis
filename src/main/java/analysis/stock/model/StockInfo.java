package analysis.stock.model;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import analysis.stock.util.DateUtil;
import com.alibaba.fastjson.annotation.JSONField;

public class StockInfo implements Comparable<StockInfo> {
    private int id; // ID
    private String stockName; // 股票名称
    private String stockCode; // 股票代码，SZ指在深圳交易的股票
    @JSONField(format = "yyyy-MM-dd")
    private Date date; // 当前显示股票信息的日期
    @JSONField(format = "HH:mm:ss")
    private Date time; // 具体时间
    private double openningPrice; // 今日开盘价
    private double closingPrice; // 昨日收盘价
    private double currentPrice; // 当前价格
    private double hPrice; // 今日最高价
    private double lPrice; // 今日最低价

    private BigDecimal averagePrice5; // 5日均价
    private BigDecimal averagePrice10; // 10日均价
    private BigDecimal change; // 长短期线判断
    private int isChangeN; // N涨跌判断
    private BigDecimal trendN; // N趋势力度
    private int isChangeCountN; // N累计涨跌
    private double hPriceN; // N高价
    private double lPriceN; // N低价

    private int isChangeN_1; // N-1涨跌判断
    private BigDecimal trendN_1; // N-1趋势力度
    private int isChangeCountN_1; // N-1累计涨跌
    private double hPriceN_1; // N-1高价
    private double lPriceN_1; // N-1低价

    private int isChangeN_2; // N-2涨跌判断
    private BigDecimal trendN_2; // N-2趋势力度
    private int isChangeCountN_2; // N-2累计涨跌
    private double hPriceN_2; // N-2高价
    private double lPriceN_2; // N-2低价

    private int isChangeN_3; // N-3涨跌判断
    private BigDecimal trendN_3; // N-3趋势力度
    private int isChangeCountN_3; // N-3累计涨跌
    private double hPriceN_3; // N-3高价
    private double lPriceN_3; // N-3低价

    private int estimate4; // 4跌涨跌判断
    private int accumulationTrend4; // 4累计趋势判断
    private int first4A; // 4第一个A
    private int reduceTrend4; // 4趋势缩小
    private int change31; // 31数量变化

    private int buyEstimate32A; // 买32高低判断A
    private int buyEstimate21A; // 买21高低判断A
    private int buyNotTopN_1A; // 买N-1非最高A
    private int buyDepartureA;// 买背驰A
    private int buyTopPriceA;// 买高地价A
    private int buySumA;// 买和A
    private int buyA;// 买入操作A
    private double buyPriceA;// 买入价A

    private int sellEstimate32A; // 卖32高低判断A
    private int sellEstimate21A; // 卖21高低判断A
    private int sellNotBottomN_1A; // 卖N-1非最低A
    private int sellDepartureA;// 卖背驰A
    private int sellTopPriceA;// 卖高地价A
    private int sellSumA;// 卖和A
    private int sellA;// 卖出操作A
    private double sellPriceA;// 卖出价A

    private int first4B; // 4第一个B
    private int buySumB;// 买和B
    private int buyB;// 买入操作B
    private double buyPriceB;// 买入价B
    private int sellSumB;// 卖和B
    private int sellB;// 卖出操作B
    private double sellPriceB;// 卖出价B

    private int estimate3; // 3跌涨跌判断
    private int accumulationTrend3; // 3累计趋势判断
    private int notFirst3; // 3非第一个
    private int reduceTrend3; // 3趋势缩小
    private int change20; // 20数量变化

    private int buyEstimate21C; // 买32高低判断C
    private int buyEstimate10C; // 买21高低判断C
    private int buyNotTopN_1C; // 买N-1非最高C
    private int buyDepartureC;// 买背驰C
    private int buyTopPriceC;// 买高地价C
    private int buySumC;// 买和C
    private int buyC;// 买入操作C
    private double buyPriceC;// 买入价C

    private int sellEstimate21C; // 卖21高低判断C
    private int sellEstimate10C; // 卖10高低判断C
    private int sellNotBottomN_1C; // 卖N-1非最低C
    private int sellDepartureC;// 卖背驰C
    private int sellTopPriceC;// 卖高地价C
    private int sellSumC;// 卖和C
    private int sellC;// 卖出操作C
    private double sellPriceC;// 卖出价C

    private int bp1;
    private int bp2;
    private int bp3;
    private int bp4;
    private int bp5;
    private int bp6;
    private int bp7;
    private int bp8;
    private int bp9;
    private double bp;

    private int sp1;
    private int sp2;
    private int sp3;
    private int sp4;
    private int sp5;
    private int sp6;
    private int sp7;
    private int sp8;
    private int sp9;
    private double sp;

    @Override
    public String toString() {
        String result = null;
        try {
            result = "{\"stockName\":\"" + stockName + "\",\"stockCode\":\"" + stockCode
                    + "\",\"date\":\"" + DateUtil.formatDate(date) + "\",\"time\":\"" + DateUtil.formatTime(time)
                    + "\",\"openningPrice\":" + openningPrice + ",\"closingPrice\":" + closingPrice
                    + ",\"currentPrice\":" + currentPrice + ",\"hPrice\":" + hPrice + ",\"lPrice\":"
                    + lPrice + "}";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int compareTo(StockInfo stockInfo) {
        int sort;
        if (stockInfo.getDate().compareTo(this.getDate()) > 0) {
            sort = 1;
        } else if (stockInfo.getDate().compareTo(this.getDate()) == 0) {
            if (stockInfo.getBuySumC() < this.getBuySumC()) {
                sort = 1;
            } else if (stockInfo.getBuySumC() == this.getBuySumC()) {
                sort = 0;
            } else {
                sort = -1;
            }
        } else {
            sort = -1;
        }
        return sort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getOpenningPrice() {
        return openningPrice;
    }

    public void setOpenningPrice(double openningPrice) {
        this.openningPrice = openningPrice;
    }

    public double getClosingPrice() {
        return closingPrice;
    }

    public void setClosingPrice(double closingPrice) {
        this.closingPrice = closingPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double gethPrice() {
        return hPrice;
    }

    public void sethPrice(double hPrice) {
        this.hPrice = hPrice;
    }

    public double getlPrice() {
        return lPrice;
    }

    public void setlPrice(double lPrice) {
        this.lPrice = lPrice;
    }

    public BigDecimal getAveragePrice5() {
        return averagePrice5;
    }

    public void setAveragePrice5(BigDecimal averagePrice5) {
        this.averagePrice5 = averagePrice5;
    }

    public BigDecimal getAveragePrice10() {
        return averagePrice10;
    }

    public void setAveragePrice10(BigDecimal averagePrice10) {
        this.averagePrice10 = averagePrice10;
    }

    public BigDecimal getChange() {
        return change;
    }

    public void setChange(BigDecimal change) {
        this.change = change;
    }

    public int getIsChangeN() {
        return isChangeN;
    }

    public void setIsChangeN(int isChangeN) {
        this.isChangeN = isChangeN;
    }

    public BigDecimal getTrendN() {
        return trendN;
    }

    public void setTrendN(BigDecimal trendN) {
        this.trendN = trendN;
    }

    public int getIsChangeCountN() {
        return isChangeCountN;
    }

    public void setIsChangeCountN(int isChangeCountN) {
        this.isChangeCountN = isChangeCountN;
    }

    public double gethPriceN() {
        return hPriceN;
    }

    public void sethPriceN(double hPriceN) {
        this.hPriceN = hPriceN;
    }

    public double getlPriceN() {
        return lPriceN;
    }

    public void setlPriceN(double lPriceN) {
        this.lPriceN = lPriceN;
    }

    public int getIsChangeN_1() {
        return isChangeN_1;
    }

    public void setIsChangeN_1(int isChangeN_1) {
        this.isChangeN_1 = isChangeN_1;
    }

    public BigDecimal getTrendN_1() {
        return trendN_1;
    }

    public void setTrendN_1(BigDecimal trendN_1) {
        this.trendN_1 = trendN_1;
    }

    public int getIsChangeCountN_1() {
        return isChangeCountN_1;
    }

    public void setIsChangeCountN_1(int isChangeCountN_1) {
        this.isChangeCountN_1 = isChangeCountN_1;
    }

    public double gethPriceN_1() {
        return hPriceN_1;
    }

    public void sethPriceN_1(double hPriceN_1) {
        this.hPriceN_1 = hPriceN_1;
    }

    public double getlPriceN_1() {
        return lPriceN_1;
    }

    public void setlPriceN_1(double lPriceN_1) {
        this.lPriceN_1 = lPriceN_1;
    }

    public int getIsChangeN_2() {
        return isChangeN_2;
    }

    public void setIsChangeN_2(int isChangeN_2) {
        this.isChangeN_2 = isChangeN_2;
    }

    public BigDecimal getTrendN_2() {
        return trendN_2;
    }

    public void setTrendN_2(BigDecimal trendN_2) {
        this.trendN_2 = trendN_2;
    }

    public int getIsChangeCountN_2() {
        return isChangeCountN_2;
    }

    public void setIsChangeCountN_2(int isChangeCountN_2) {
        this.isChangeCountN_2 = isChangeCountN_2;
    }

    public double gethPriceN_2() {
        return hPriceN_2;
    }

    public void sethPriceN_2(double hPriceN_2) {
        this.hPriceN_2 = hPriceN_2;
    }

    public double getlPriceN_2() {
        return lPriceN_2;
    }

    public void setlPriceN_2(double lPriceN_2) {
        this.lPriceN_2 = lPriceN_2;
    }

    public int getIsChangeN_3() {
        return isChangeN_3;
    }

    public void setIsChangeN_3(int isChangeN_3) {
        this.isChangeN_3 = isChangeN_3;
    }

    public BigDecimal getTrendN_3() {
        return trendN_3;
    }

    public void setTrendN_3(BigDecimal trendN_3) {
        this.trendN_3 = trendN_3;
    }

    public int getIsChangeCountN_3() {
        return isChangeCountN_3;
    }

    public void setIsChangeCountN_3(int isChangeCountN_3) {
        this.isChangeCountN_3 = isChangeCountN_3;
    }

    public double gethPriceN_3() {
        return hPriceN_3;
    }

    public void sethPriceN_3(double hPriceN_3) {
        this.hPriceN_3 = hPriceN_3;
    }

    public double getlPriceN_3() {
        return lPriceN_3;
    }

    public void setlPriceN_3(double lPriceN_3) {
        this.lPriceN_3 = lPriceN_3;
    }

    public int getEstimate4() {
        return estimate4;
    }

    public void setEstimate4(int estimate4) {
        this.estimate4 = estimate4;
    }

    public int getAccumulationTrend4() {
        return accumulationTrend4;
    }

    public void setAccumulationTrend4(int accumulationTrend4) {
        this.accumulationTrend4 = accumulationTrend4;
    }

    public int getFirst4A() {
        return first4A;
    }

    public void setFirst4A(int first4a) {
        first4A = first4a;
    }

    public int getReduceTrend4() {
        return reduceTrend4;
    }

    public void setReduceTrend4(int reduceTrend4) {
        this.reduceTrend4 = reduceTrend4;
    }

    public int getChange31() {
        return change31;
    }

    public void setChange31(int change31) {
        this.change31 = change31;
    }

    public int getBuyEstimate32A() {
        return buyEstimate32A;
    }

    public void setBuyEstimate32A(int buyEstimate32A) {
        this.buyEstimate32A = buyEstimate32A;
    }

    public int getBuyEstimate21A() {
        return buyEstimate21A;
    }

    public void setBuyEstimate21A(int buyEstimate21A) {
        this.buyEstimate21A = buyEstimate21A;
    }

    public int getBuyNotTopN_1A() {
        return buyNotTopN_1A;
    }

    public void setBuyNotTopN_1A(int buyNotTopN_1A) {
        this.buyNotTopN_1A = buyNotTopN_1A;
    }

    public int getBuyDepartureA() {
        return buyDepartureA;
    }

    public void setBuyDepartureA(int buyDepartureA) {
        this.buyDepartureA = buyDepartureA;
    }

    public int getBuyTopPriceA() {
        return buyTopPriceA;
    }

    public void setBuyTopPriceA(int buyTopPriceA) {
        this.buyTopPriceA = buyTopPriceA;
    }

    public int getBuySumA() {
        return buySumA;
    }

    public void setBuySumA(int buySumA) {
        this.buySumA = buySumA;
    }

    public int getBuyA() {
        return buyA;
    }

    public void setBuyA(int buyA) {
        this.buyA = buyA;
    }

    public double getBuyPriceA() {
        return buyPriceA;
    }

    public void setBuyPriceA(double buyPriceA) {
        this.buyPriceA = buyPriceA;
    }

    public int getSellEstimate32A() {
        return sellEstimate32A;
    }

    public void setSellEstimate32A(int sellEstimate32A) {
        this.sellEstimate32A = sellEstimate32A;
    }

    public int getSellEstimate21A() {
        return sellEstimate21A;
    }

    public void setSellEstimate21A(int sellEstimate21A) {
        this.sellEstimate21A = sellEstimate21A;
    }

    public int getSellNotBottomN_1A() {
        return sellNotBottomN_1A;
    }

    public void setSellNotBottomN_1A(int sellNotBottomN_1A) {
        this.sellNotBottomN_1A = sellNotBottomN_1A;
    }

    public int getSellDepartureA() {
        return sellDepartureA;
    }

    public void setSellDepartureA(int sellDepartureA) {
        this.sellDepartureA = sellDepartureA;
    }

    public int getSellTopPriceA() {
        return sellTopPriceA;
    }

    public void setSellTopPriceA(int sellTopPriceA) {
        this.sellTopPriceA = sellTopPriceA;
    }

    public int getSellSumA() {
        return sellSumA;
    }

    public void setSellSumA(int sellSumA) {
        this.sellSumA = sellSumA;
    }

    public int getSellA() {
        return sellA;
    }

    public void setSellA(int sellA) {
        this.sellA = sellA;
    }

    public double getSellPriceA() {
        return sellPriceA;
    }

    public void setSellPriceA(double sellPriceA) {
        this.sellPriceA = sellPriceA;
    }

    public int getFirst4B() {
        return first4B;
    }

    public void setFirst4B(int first4b) {
        first4B = first4b;
    }

    public int getBuySumB() {
        return buySumB;
    }

    public void setBuySumB(int buySumB) {
        this.buySumB = buySumB;
    }

    public int getBuyB() {
        return buyB;
    }

    public void setBuyB(int buyB) {
        this.buyB = buyB;
    }

    public double getBuyPriceB() {
        return buyPriceB;
    }

    public void setBuyPriceB(double buyPriceB) {
        this.buyPriceB = buyPriceB;
    }

    public int getSellSumB() {
        return sellSumB;
    }

    public void setSellSumB(int sellSumB) {
        this.sellSumB = sellSumB;
    }

    public int getSellB() {
        return sellB;
    }

    public void setSellB(int sellB) {
        this.sellB = sellB;
    }

    public double getSellPriceB() {
        return sellPriceB;
    }

    public void setSellPriceB(double sellPriceB) {
        this.sellPriceB = sellPriceB;
    }

    public int getEstimate3() {
        return estimate3;
    }

    public void setEstimate3(int estimate3) {
        this.estimate3 = estimate3;
    }

    public int getAccumulationTrend3() {
        return accumulationTrend3;
    }

    public void setAccumulationTrend3(int accumulationTrend3) {
        this.accumulationTrend3 = accumulationTrend3;
    }

    public int getNotFirst3() {
        return notFirst3;
    }

    public void setNotFirst3(int notFirst3) {
        this.notFirst3 = notFirst3;
    }

    public int getReduceTrend3() {
        return reduceTrend3;
    }

    public void setReduceTrend3(int reduceTrend3) {
        this.reduceTrend3 = reduceTrend3;
    }

    public int getChange20() {
        return change20;
    }

    public void setChange20(int change20) {
        this.change20 = change20;
    }

    public int getBuyEstimate21C() {
        return buyEstimate21C;
    }

    public void setBuyEstimate21C(int buyEstimate21C) {
        this.buyEstimate21C = buyEstimate21C;
    }

    public int getBuyEstimate10C() {
        return buyEstimate10C;
    }

    public void setBuyEstimate10C(int buyEstimate10C) {
        this.buyEstimate10C = buyEstimate10C;
    }

    public int getBuyNotTopN_1C() {
        return buyNotTopN_1C;
    }

    public void setBuyNotTopN_1C(int buyNotTopN_1C) {
        this.buyNotTopN_1C = buyNotTopN_1C;
    }

    public int getBuyDepartureC() {
        return buyDepartureC;
    }

    public void setBuyDepartureC(int buyDepartureC) {
        this.buyDepartureC = buyDepartureC;
    }

    public int getBuyTopPriceC() {
        return buyTopPriceC;
    }

    public void setBuyTopPriceC(int buyTopPriceC) {
        this.buyTopPriceC = buyTopPriceC;
    }

    public int getBuySumC() {
        return buySumC;
    }

    public void setBuySumC(int buySumC) {
        this.buySumC = buySumC;
    }

    public int getBuyC() {
        return buyC;
    }

    public void setBuyC(int buyC) {
        this.buyC = buyC;
    }

    public double getBuyPriceC() {
        return buyPriceC;
    }

    public void setBuyPriceC(double buyPriceC) {
        this.buyPriceC = buyPriceC;
    }

    public int getSellEstimate21C() {
        return sellEstimate21C;
    }

    public void setSellEstimate21C(int sellEstimate21C) {
        this.sellEstimate21C = sellEstimate21C;
    }

    public int getSellEstimate10C() {
        return sellEstimate10C;
    }

    public void setSellEstimate10C(int sellEstimate10C) {
        this.sellEstimate10C = sellEstimate10C;
    }

    public int getSellNotBottomN_1C() {
        return sellNotBottomN_1C;
    }

    public void setSellNotBottomN_1C(int sellNotBottomN_1C) {
        this.sellNotBottomN_1C = sellNotBottomN_1C;
    }

    public int getSellDepartureC() {
        return sellDepartureC;
    }

    public void setSellDepartureC(int sellDepartureC) {
        this.sellDepartureC = sellDepartureC;
    }

    public int getSellTopPriceC() {
        return sellTopPriceC;
    }

    public void setSellTopPriceC(int sellTopPriceC) {
        this.sellTopPriceC = sellTopPriceC;
    }

    public int getSellSumC() {
        return sellSumC;
    }

    public void setSellSumC(int sellSumC) {
        this.sellSumC = sellSumC;
    }

    public int getSellC() {
        return sellC;
    }

    public void setSellC(int sellC) {
        this.sellC = sellC;
    }

    public double getSellPriceC() {
        return sellPriceC;
    }

    public void setSellPriceC(double sellPriceC) {
        this.sellPriceC = sellPriceC;
    }

    public int getBp1() {
        return bp1;
    }

    public void setBp1(int bp1) {
        this.bp1 = bp1;
    }

    public int getBp2() {
        return bp2;
    }

    public void setBp2(int bp2) {
        this.bp2 = bp2;
    }

    public int getBp3() {
        return bp3;
    }

    public void setBp3(int bp3) {
        this.bp3 = bp3;
    }

    public int getBp4() {
        return bp4;
    }

    public void setBp4(int bp4) {
        this.bp4 = bp4;
    }

    public int getBp5() {
        return bp5;
    }

    public void setBp5(int bp5) {
        this.bp5 = bp5;
    }

    public int getBp6() {
        return bp6;
    }

    public void setBp6(int bp6) {
        this.bp6 = bp6;
    }

    public int getBp7() {
        return bp7;
    }

    public void setBp7(int bp7) {
        this.bp7 = bp7;
    }

    public int getBp8() {
        return bp8;
    }

    public void setBp8(int bp8) {
        this.bp8 = bp8;
    }

    public int getBp9() {
        return bp9;
    }

    public void setBp9(int bp9) {
        this.bp9 = bp9;
    }

    public double getBp() {
        return bp;
    }

    public void setBp(double bp) {
        this.bp = bp;
    }

    public int getSp1() {
        return sp1;
    }

    public void setSp1(int sp1) {
        this.sp1 = sp1;
    }

    public int getSp2() {
        return sp2;
    }

    public void setSp2(int sp2) {
        this.sp2 = sp2;
    }

    public int getSp3() {
        return sp3;
    }

    public void setSp3(int sp3) {
        this.sp3 = sp3;
    }

    public int getSp4() {
        return sp4;
    }

    public void setSp4(int sp4) {
        this.sp4 = sp4;
    }

    public int getSp5() {
        return sp5;
    }

    public void setSp5(int sp5) {
        this.sp5 = sp5;
    }

    public int getSp6() {
        return sp6;
    }

    public void setSp6(int sp6) {
        this.sp6 = sp6;
    }

    public int getSp7() {
        return sp7;
    }

    public void setSp7(int sp7) {
        this.sp7 = sp7;
    }

    public int getSp8() {
        return sp8;
    }

    public void setSp8(int sp8) {
        this.sp8 = sp8;
    }

    public int getSp9() {
        return sp9;
    }

    public void setSp9(int sp9) {
        this.sp9 = sp9;
    }

    public double getSp() {
        return sp;
    }

    public void setSp(double sp) {
        this.sp = sp;
    }

}
