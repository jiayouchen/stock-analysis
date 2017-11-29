package analysis.stock.service.impl;

import static java.lang.Double.parseDouble;

import analysis.stock.dao.StockInfoMapper;
import analysis.stock.service.StockInfoService;
import analysis.stock.util.DateUtil;
import analysis.stock.model.StockInfo;
import analysis.stock.service.CalculateService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("stockInfoService")
public class StockInfoServiceImpl implements StockInfoService {

    @Resource(name = "stockInfoDao")
    private StockInfoMapper stockInfoDao;

    @Resource(name = "calculateService")
    private CalculateService calculateService;

    /**
     * @param stockCode
     *            股票代码
     * @param date
     *            日期
     * @param limit
     *            天数
     * @return 返回多条股票信息
     */
    public List<StockInfo> getStockInfo(String stockCode, Date date, int limit) {
        List<StockInfo> stockInfos = stockInfoDao.getStockInfoAsc(stockCode, date, limit);

        BigDecimal trendN = BigDecimal.ZERO;// N趋势力度
        int isChangeCountN = 0;// N累计涨跌

        BigDecimal lastChange = BigDecimal.ZERO;// 上次长短期线判断
        int lastIsChangeN = 0;// 上次N涨跌判断
        BigDecimal lastTrendN = BigDecimal.ZERO;// 上次N趋势力度
        int lastIsChangeCountN = 0;// 上次N累计涨跌
        double lasthPriceN = 0;// 上次N高价
        double lastlPriceN = 0;// 上次N低价

        int lastIsChangeN_1 = 0;// 上次N-1涨跌判断
        BigDecimal lastTrendN_1 = BigDecimal.ZERO;// N-1趋势力度
        int lastIsChangeCountN_1 = 0;// 上次N-1累计涨跌
        double lasthPriceN_1 = 0;// 上次N-1高价
        double lastlPriceN_1 = 0;// 上次N-1低价

        int lastIsChangeN_2 = 0;// 上次N-2涨跌判断
        BigDecimal lastTrendN_2 = BigDecimal.ZERO;// N-2趋势力度
        int lastIsChangeCountN_2 = 0;// 上次N-2累计涨跌
        double lasthPriceN_2 = 0;// 上次N-2高价
        double lastlPriceN_2 = 0;// 上次N-2低价

        int lastIsChangeN_3 = 0;// 上次N-3涨跌判断
        BigDecimal lastTrendN_3 = BigDecimal.ZERO;// N-3趋势力度
        int lastIsChangeCountN_3 = 0;// 上次N-3累计涨跌
        double lasthPriceN_3 = 0;// 上次N-3高价
        double lastlPriceN_3 = 0;// 上次N-3低价

        for (StockInfo stockInfo : stockInfos) {
            // 5日均价
            stockInfo.setAveragePrice5(calculateService.calAveragePrice(stockInfos, stockInfo.getDate(), 5));
            // 10日均价
            stockInfo.setAveragePrice10(calculateService.calAveragePrice(stockInfos, stockInfo.getDate(), 10));

            if (stockInfo.getAveragePrice5() != null && stockInfo.getAveragePrice10() != null) {
                // 长短期线判断
                stockInfo.setChange(stockInfo.getAveragePrice5().subtract(stockInfo.getAveragePrice10()));
                // N涨跌判断
                stockInfo.setIsChangeN(stockInfo.getChange().compareTo(BigDecimal.ZERO) > 0 ? 1 : -1);
                // N趋势力度
                trendN = calculateService.calTrendN(stockInfo, lastIsChangeN, trendN);
                stockInfo.setTrendN(trendN);
                // N累计涨跌
                isChangeCountN = calculateService.calIsChangeCountN(stockInfo, lastIsChangeN, isChangeCountN);
                stockInfo.setIsChangeCountN(isChangeCountN);
                // N高价
                stockInfo.sethPriceN(calculateService.calhPriceN(stockInfo, lastIsChangeN, lasthPriceN));
                // N低价
                stockInfo.setlPriceN(calculateService.callPriceN(stockInfo, lastIsChangeN, lastlPriceN));

                // N-1涨跌判断
                stockInfo.setIsChangeN_1(stockInfo.getIsChangeN() == lastIsChangeN ? lastIsChangeN_1 : lastIsChangeN);
                // N-1趋势力度
                stockInfo.setTrendN_1(stockInfo.getIsChangeN() == lastIsChangeN ? lastTrendN_1 : lastTrendN);
                // N-1累计涨跌
                stockInfo.setIsChangeCountN_1(stockInfo.getIsChangeN() == lastIsChangeN ? lastIsChangeCountN_1 : lastIsChangeCountN);
                // N-1高价
                stockInfo.sethPriceN_1(stockInfo.getIsChangeN() == lastIsChangeN ? lasthPriceN_1 : lasthPriceN);
                // N-1低价
                stockInfo.setlPriceN_1(stockInfo.getIsChangeN() == lastIsChangeN ? lastlPriceN_1 : lastlPriceN);

                // N-2涨跌判断
                stockInfo.setIsChangeN_2(stockInfo.getIsChangeN() == lastIsChangeN ? lastIsChangeN_2 : lastIsChangeN_1);
                // N-2趋势力度
                stockInfo.setTrendN_2(stockInfo.getIsChangeN() == lastIsChangeN ? lastTrendN_2 : lastTrendN_1);
                // N-2累计涨跌
                stockInfo.setIsChangeCountN_2(stockInfo.getIsChangeN() == lastIsChangeN ? lastIsChangeCountN_2 : lastIsChangeCountN_1);
                // N-2高价
                stockInfo.sethPriceN_2(stockInfo.getIsChangeN() == lastIsChangeN ? lasthPriceN_2 : lasthPriceN_1);
                // N-2低价
                stockInfo.setlPriceN_2(stockInfo.getIsChangeN() == lastIsChangeN ? lastlPriceN_2 : lastlPriceN_1);

                // N-3涨跌判断
                stockInfo.setIsChangeN_3(stockInfo.getIsChangeN() == lastIsChangeN ? lastIsChangeN_3 : lastIsChangeN_2);
                // N-3趋势力度
                stockInfo.setTrendN_3(stockInfo.getIsChangeN() == lastIsChangeN ? lastTrendN_3 : lastTrendN_2);
                // N-3累计涨跌
                stockInfo.setIsChangeCountN_3(stockInfo.getIsChangeN() == lastIsChangeN ? lastIsChangeCountN_3 : lastIsChangeCountN_2);
                // N-3高价
                stockInfo.sethPriceN_3(stockInfo.getIsChangeN() == lastIsChangeN ? lasthPriceN_3 : lasthPriceN_2);
                // N-3低价
                stockInfo.setlPriceN_3(stockInfo.getIsChangeN() == lastIsChangeN ? lastlPriceN_3 : lastlPriceN_2);

                // 4跌涨跌判断
                stockInfo.setEstimate4(stockInfo.getIsChangeN() + stockInfo.getIsChangeN_1() + stockInfo.getIsChangeN_2() + stockInfo.getIsChangeN_3()
                        + Integer.signum(stockInfo.getIsChangeN_1()));
                // 4累计趋势判断
                stockInfo.setAccumulationTrend4(
                        stockInfo.getTrendN_1().add(stockInfo.getTrendN_2()).add(stockInfo.getTrendN_3()).compareTo(BigDecimal.ZERO));
                // 4第一个A
                stockInfo.setFirst4A(calculateService.calFirst4A(stockInfo, lastIsChangeN));
                // 4趋势缩小
                stockInfo.setReduceTrend4(calculateService.calReduceTrend4(stockInfo, lastChange));
                // 31数量变化
                stockInfo.setChange31(Math.abs(stockInfo.getIsChangeCountN_1()) < Math.abs(stockInfo.getIsChangeCountN_3())
                        ? Integer.signum(stockInfo.getIsChangeCountN_1()) : 0);

                // 买32高低判断A
                stockInfo.setBuyEstimate32A(stockInfo.gethPriceN_3() > stockInfo.gethPriceN_2() ? -1 : 0);
                // 买21高低判断A
                stockInfo.setBuyEstimate21A(stockInfo.gethPriceN_2() > stockInfo.getlPriceN_1() ? -1 : 0);
                // 买N-1非最高A
                stockInfo.setBuyNotTopN_1A(stockInfo.gethPriceN_2() < stockInfo.gethPriceN_3() ? -1 : 0);
                // 买背驰A
                stockInfo.setBuyDepartureA(
                        stockInfo.getTrendN_1().abs().compareTo(stockInfo.getTrendN_3().abs().multiply(new BigDecimal("1.2"))) < 0 ? -1 : 0);
                // 买高地价A
                stockInfo.setBuyTopPriceA(calculateService.calBuyTopPriceA(stockInfo));
                // 买和A
                stockInfo.setBuySumA(stockInfo.getEstimate4() + stockInfo.getAccumulationTrend4() + stockInfo.getFirst4A()
                        + stockInfo.getReduceTrend4() + stockInfo.getChange31() + stockInfo.getBuyEstimate32A() + stockInfo.getBuyEstimate21A()
                        + stockInfo.getBuyNotTopN_1A() + stockInfo.getBuyDepartureA() + stockInfo.getBuyTopPriceA());
                // 买入操作A
                stockInfo.setBuyA(stockInfo.getBuySumA() == -10 ? 1 : 0);
                // 买入价A
                stockInfo.setBuyPriceA(stockInfo.getCurrentPrice() * stockInfo.getBuyA());

                // 卖32高低判断A
                stockInfo.setSellEstimate32A(stockInfo.getlPriceN_3() < stockInfo.getlPriceN_2() ? 1 : 0);
                // 卖21高低判断A
                stockInfo.setSellEstimate21A(stockInfo.getlPriceN_2() < stockInfo.gethPriceN_1() ? 1 : 0);
                // 卖N-1非最低A
                stockInfo.setSellNotBottomN_1A(stockInfo.getlPriceN_2() > stockInfo.getlPriceN_3() ? 1 : 0);
                // 卖背驰A
                stockInfo.setSellDepartureA(
                        stockInfo.getTrendN_1().abs().compareTo(stockInfo.getTrendN_3().abs().multiply(new BigDecimal("1.2"))) < 0 ? 1 : 0);
                // 卖高地价A
                stockInfo.setSellTopPriceA(calculateService.calSellTopPriceA(stockInfo));
                // 卖和A
                stockInfo.setSellSumA(stockInfo.getEstimate4() + stockInfo.getAccumulationTrend4() + stockInfo.getFirst4A()
                        + stockInfo.getReduceTrend4() + stockInfo.getChange31() + stockInfo.getSellEstimate32A() + stockInfo.getSellEstimate21A()
                        + stockInfo.getSellNotBottomN_1A() + stockInfo.getSellDepartureA() + stockInfo.getSellTopPriceA());
                // 卖出操作A
                stockInfo.setSellA(stockInfo.getSellSumA() == 10 ? 1 : 0);
                // 卖出价A
                stockInfo.setSellPriceA(stockInfo.getCurrentPrice() * stockInfo.getSellA());

                // 4第一个B
                stockInfo.setFirst4B(stockInfo.getIsChangeN() == lastIsChangeN ? 0 : -stockInfo.getIsChangeN());
                // 买和B
                stockInfo.setBuySumB(stockInfo.getBuySumA() - stockInfo.getFirst4A() + stockInfo.getFirst4B() - stockInfo.getReduceTrend4());
                // 买入操作B
                stockInfo.setBuyB((stockInfo.getBuySumB() == -9 ? 1 : 0) * (Math.abs(stockInfo.getIsChangeCountN()) == 1 ? 1 : 0));
                // 买入价B
                stockInfo.setBuyPriceB(stockInfo.getCurrentPrice() * stockInfo.getBuyB());
                // 卖和B
                stockInfo.setSellSumB(stockInfo.getEstimate4() + stockInfo.getAccumulationTrend4() + stockInfo.getChange31()
                        + stockInfo.getSellEstimate32A() + stockInfo.getSellEstimate21A() + stockInfo.getSellNotBottomN_1A()
                        + stockInfo.getSellDepartureA() + stockInfo.getSellTopPriceA() + stockInfo.getFirst4B());
                // 卖出操作B
                stockInfo.setSellB((stockInfo.getSellSumB() == 9 ? 1 : 0) * (Math.abs(stockInfo.getIsChangeCountN()) == 1 ? 1 : 0));
                // 卖出价B
                stockInfo.setSellPriceB(stockInfo.getCurrentPrice() * stockInfo.getSellB());

                // 3跌涨跌判断
                stockInfo.setEstimate3(stockInfo.getIsChangeN() + stockInfo.getIsChangeN_1() + stockInfo.getIsChangeN_2());
                // 3累计趋势判断
                stockInfo.setAccumulationTrend3(
                        stockInfo.getTrendN().add(stockInfo.getTrendN_1()).add(stockInfo.getTrendN_2()).compareTo(BigDecimal.ZERO));
                // 3非第一个
                stockInfo.setNotFirst3(stockInfo.getIsChangeN() == lastIsChangeN ? Integer.signum(stockInfo.getIsChangeN()) : 0);
                // 3趋势缩小
                stockInfo.setReduceTrend3(
                        stockInfo.getChange().abs().compareTo(lastChange.abs()) < 0 ? stockInfo.getChange().compareTo(BigDecimal.ZERO) : 0);
                // 20数量变化
                stockInfo.setChange20(Math.abs(stockInfo.getIsChangeCountN()) < Math.abs(stockInfo.getIsChangeCountN_2())
                        ? Integer.signum(stockInfo.getIsChangeCountN()) : 0);

                // 买32高低判断C
                stockInfo.setBuyEstimate21C(stockInfo.gethPriceN_2() > stockInfo.gethPriceN_1() ? -1 : 0);
                // 买21高低判断C
                stockInfo.setBuyEstimate10C(stockInfo.gethPriceN_1() > stockInfo.getlPriceN() ? -1 : 0);
                // 买N-1非最高C
                stockInfo.setBuyNotTopN_1C(stockInfo.gethPriceN_1() < stockInfo.gethPriceN_2() ? -1 : 0);
                // 买背驰C
                stockInfo.setBuyDepartureC(stockInfo.getTrendN().abs().compareTo(stockInfo.getTrendN_2().abs()) < 0 ? -1 : 0);
                // 买高地价C
                stockInfo.setBuyTopPriceC(
                        (stockInfo.gethPriceN_2() > stockInfo.gethPriceN() ? -1 : 0) * (stockInfo.gethPriceN_2() > stockInfo.gethPriceN_1() ? 1 : 0));
                // 买和C
                stockInfo.setBuySumC(stockInfo.getEstimate3() + stockInfo.getAccumulationTrend3() + stockInfo.getNotFirst3()
                        + stockInfo.getReduceTrend3() + stockInfo.getChange20() + stockInfo.getBuyEstimate21C() + stockInfo.getBuyEstimate10C()
                        + stockInfo.getBuyNotTopN_1C() + stockInfo.getBuyDepartureC() + stockInfo.getBuyTopPriceC());
                // 买入操作C
                stockInfo.setBuyC((stockInfo.getBuySumC() == -10 ? 1 : 0) * (Math.abs(stockInfo.getIsChangeCountN()) == 1 ? 0 : 1));
                // 买入价C
                stockInfo.setBuyPriceC(stockInfo.getCurrentPrice() * stockInfo.getBuyC());

                // 卖21高低判断C
                stockInfo.setSellEstimate21C(stockInfo.getlPriceN_2() < stockInfo.getlPriceN_1() ? 1 : 0);
                // 卖10高低判断C
                stockInfo.setSellEstimate10C(stockInfo.getlPriceN_1() < stockInfo.gethPriceN() ? 1 : 0);
                // 卖N-1非最低C
                stockInfo.setSellNotBottomN_1C(stockInfo.getlPriceN_1() > stockInfo.getlPriceN_2() ? 1 : 0);
                // 卖背驰C
                stockInfo.setSellDepartureC(stockInfo.getTrendN().abs().compareTo(stockInfo.getTrendN_2().abs()) < 0 ? 1 : 0);
                // 卖高地价C
                stockInfo.setSellTopPriceC(
                        (stockInfo.getlPriceN_2() < stockInfo.getlPriceN() ? 1 : 0) * (stockInfo.getlPriceN_2() < stockInfo.getlPriceN_1() ? 1 : 0));
                // 卖和C
                stockInfo.setSellSumC(stockInfo.getEstimate3() + stockInfo.getAccumulationTrend3() + stockInfo.getNotFirst3()
                        + stockInfo.getReduceTrend3() + stockInfo.getChange20() + stockInfo.getSellEstimate21C() + stockInfo.getSellEstimate10C()
                        + stockInfo.getSellNotBottomN_1C() + stockInfo.getSellDepartureC() + stockInfo.getSellTopPriceC());
                // 卖出操作C
                stockInfo.setSellC((stockInfo.getSellSumC() == 10 ? 1 : 0) * (Math.abs(stockInfo.getIsChangeCountN()) == 1 ? 0 : 1));
                // 卖出价C
                stockInfo.setSellPriceC(stockInfo.getCurrentPrice() * stockInfo.getSellC());

                // 存储本次数据，以供下次循环使用
                // 长短期线判断
                lastChange = stockInfo.getChange();
                // N涨跌判断
                lastIsChangeN = stockInfo.getIsChangeN();
                // N趋势力度
                lastTrendN = stockInfo.getTrendN();
                // N累计涨跌
                lastIsChangeCountN = stockInfo.getIsChangeCountN();
                // N高价
                lasthPriceN = stockInfo.gethPriceN();
                // N低价
                lastlPriceN = stockInfo.getlPriceN();

                // N-1涨跌判断
                lastIsChangeN_1 = stockInfo.getIsChangeN_1();
                // N-1趋势力度
                lastTrendN_1 = stockInfo.getTrendN_1();
                // N-1累计涨跌
                lastIsChangeCountN_1 = stockInfo.getIsChangeCountN_1();
                // N-1高价
                lasthPriceN_1 = stockInfo.gethPriceN_1();
                // N-1低价
                lastlPriceN_1 = stockInfo.getlPriceN_1();

                // N-2涨跌判断
                lastIsChangeN_2 = stockInfo.getIsChangeN_2();
                // N-2趋势力度
                lastTrendN_2 = stockInfo.getTrendN_2();
                // N-2累计涨跌
                lastIsChangeCountN_2 = stockInfo.getIsChangeCountN_2();
                // N-2高价
                lasthPriceN_2 = stockInfo.gethPriceN_2();
                // N-2低价
                lastlPriceN_2 = stockInfo.getlPriceN_2();

                // N-3涨跌判断
                lastIsChangeN_3 = stockInfo.getIsChangeN_3();
                // N-3趋势力度
                lastTrendN_3 = stockInfo.getTrendN_3();
                // N-3累计涨跌
                lastIsChangeCountN_3 = stockInfo.getIsChangeCountN_3();
                // N-3高价
                lasthPriceN_3 = stockInfo.gethPriceN_3();
                // N-3低价
                lastlPriceN_3 = stockInfo.getlPriceN_3();

                // --------------------------------模型2--------------------------------
                // BP
                stockInfo.setBp1(stockInfo.getCurrentPrice() < getStockInfoByDate(stockInfos, stockInfo.getDate(), 4).getCurrentPrice() ? 1 : 0);
                stockInfo.setBp2(getStockInfoByDate(stockInfos, stockInfo.getDate(), 1)
                        .getCurrentPrice() > getStockInfoByDate(stockInfos, stockInfo.getDate(), 5).getCurrentPrice() ? 1 : 0);
                stockInfo.setBp3(stockInfo.getBp1() + stockInfo.getBp2() == 2 ? 1 : 0);
                stockInfo.setBp4(getStockInfoByDate(stockInfos, stockInfo.getDate(), 8).getBp3() == 1
                        ? (stockInfo.getlPrice() < getStockInfoByDate(stockInfos, stockInfo.getDate(), 4).getlPrice() ? 1 : 0) : 0);
                stockInfo.setBp5(
                        getStockInfoByDate(stockInfos, stockInfo.getDate(), 8).getBp3() == 1 ? (getStockInfoByDate(stockInfos, stockInfo.getDate(), 1)
                                .getlPrice() < getStockInfoByDate(stockInfos, stockInfo.getDate(), 5).getlPrice() ? 1 : 0) : 0);
                stockInfo.setBp6(
                        getStockInfoByDate(stockInfos, stockInfo.getDate(), 8).getBp3() == 1 ? (getStockInfoByDate(stockInfos, stockInfo.getDate(), 2)
                                .getlPrice() < getStockInfoByDate(stockInfos, stockInfo.getDate(), 6).getlPrice() ? 1 : 0) : 0);
                stockInfo.setBp7(
                        getStockInfoByDate(stockInfos, stockInfo.getDate(), 8).getBp3() == 1 ? (getStockInfoByDate(stockInfos, stockInfo.getDate(), 3)
                                .getlPrice() < getStockInfoByDate(stockInfos, stockInfo.getDate(), 7).getlPrice() ? 1 : 0) : 0);
                stockInfo.setBp8(
                        getStockInfoByDate(stockInfos, stockInfo.getDate(), 8).getBp3() == 1 ? (getStockInfoByDate(stockInfos, stockInfo.getDate(), 4)
                                .getlPrice() < getStockInfoByDate(stockInfos, stockInfo.getDate(), 8).getlPrice() ? 1 : 0) : 0);
                stockInfo.setBp9(
                        ((stockInfo.getBp4() + stockInfo.getBp5() + stockInfo.getBp6() + stockInfo.getBp7() + stockInfo.getBp8()) == 5 ? 1 : 0)
                                * (Math.min(stockInfo.getlPrice(), getStockInfoByDate(stockInfos, stockInfo.getDate(), 1).getlPrice()) < Math.min(
                                        getStockInfoByDate(stockInfos, stockInfo.getDate(), 2)
                                                .getlPrice(),
                                        getStockInfoByDate(stockInfos, stockInfo.getDate(), 3).getlPrice()) ? 1 : 0));
                stockInfo.setBp(
                        getStockInfoByDate(stockInfos, stockInfo.getDate(), 8).getBp3() + stockInfo.getBp9() == 2 ? stockInfo.getCurrentPrice() : 0);

                // SP
                stockInfo.setSp1(stockInfo.getCurrentPrice() > getStockInfoByDate(stockInfos, stockInfo.getDate(), 4).getCurrentPrice() ? 1 : 0);
                stockInfo.setSp2(getStockInfoByDate(stockInfos, stockInfo.getDate(), 1)
                        .getCurrentPrice() < getStockInfoByDate(stockInfos, stockInfo.getDate(), 5).getCurrentPrice() ? 1 : 0);
                stockInfo.setSp3(stockInfo.getSp1() + stockInfo.getSp2() == 2 ? 1 : 0);
                stockInfo.setSp4(getStockInfoByDate(stockInfos, stockInfo.getDate(), 8).getSp3() == 1
                        ? (stockInfo.gethPrice() > getStockInfoByDate(stockInfos, stockInfo.getDate(), 4).gethPrice() ? 1 : 0) : 0);
                stockInfo.setSp5(
                        getStockInfoByDate(stockInfos, stockInfo.getDate(), 8).getSp3() == 1 ? (getStockInfoByDate(stockInfos, stockInfo.getDate(), 1)
                                .gethPrice() > getStockInfoByDate(stockInfos, stockInfo.getDate(), 5).gethPrice() ? 1 : 0) : 0);
                stockInfo.setSp6(
                        getStockInfoByDate(stockInfos, stockInfo.getDate(), 8).getSp3() == 1 ? (getStockInfoByDate(stockInfos, stockInfo.getDate(), 2)
                                .gethPrice() > getStockInfoByDate(stockInfos, stockInfo.getDate(), 6).gethPrice() ? 1 : 0) : 0);
                stockInfo.setSp7(
                        getStockInfoByDate(stockInfos, stockInfo.getDate(), 8).getSp3() == 1 ? (getStockInfoByDate(stockInfos, stockInfo.getDate(), 3)
                                .gethPrice() > getStockInfoByDate(stockInfos, stockInfo.getDate(), 7).gethPrice() ? 1 : 0) : 0);
                stockInfo.setSp8(
                        getStockInfoByDate(stockInfos, stockInfo.getDate(), 8).getSp3() == 1 ? (getStockInfoByDate(stockInfos, stockInfo.getDate(), 4)
                                .gethPrice() > getStockInfoByDate(stockInfos, stockInfo.getDate(), 8).gethPrice() ? 1 : 0) : 0);
                stockInfo.setSp9(
                        ((stockInfo.getSp4() + stockInfo.getSp5() + stockInfo.getSp6() + stockInfo.getSp7() + stockInfo.getSp8()) == 5 ? 1 : 0)
                                * (Math.max(stockInfo.gethPrice(), getStockInfoByDate(stockInfos, stockInfo.getDate(), 1).gethPrice()) > Math.max(
                                        getStockInfoByDate(stockInfos, stockInfo.getDate(), 2)
                                                .gethPrice(),
                                        getStockInfoByDate(stockInfos, stockInfo.getDate(), 3).gethPrice()) ? 1 : 0));
                stockInfo.setSp(
                        getStockInfoByDate(stockInfos, stockInfo.getDate(), 8).getSp3() + stockInfo.getSp9() == 2 ? stockInfo.getCurrentPrice() : 0);

            }
        }
        Collections.sort(stockInfos);// 按日期倒序
        return stockInfos;
    }

    /**
     * @param stockInfos
     *            股票信息列表
     * @param date
     *            制定日期
     * @param limit
     *            天数
     * @return stockInfos 指定日期最后几天的股票信息列表
     */
    public StockInfo getStockInfoByDate(List<StockInfo> stockInfos, Date date, int limit) {
        for (StockInfo stockInfo : stockInfos) {
            if (stockInfo.getDate() == date) {
                if (stockInfos.indexOf(stockInfo) >= limit) {
                    return stockInfos.get(stockInfos.indexOf(stockInfo) - limit);
                }
            }
        }
        return new StockInfo();
    }

    /**
     * @return 股票代码列表
     */
    public List<String> getStockCodes() {
        List<String> stockCodes = new ArrayList<String>();
        String path = new File(this.getClass().getResource("").getPath()).toString();
        path = path.substring(0, path.indexOf("io"));
        String fileName = "stockCode.txt";
        File file = new File(path + fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String readLine = null;
            while ((readLine = reader.readLine()) != null) {
                stockCodes.add(readLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stockCodes;
    }

}