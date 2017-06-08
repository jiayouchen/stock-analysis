package analysis.stock.service;

import java.util.Date;
import java.util.List;

import analysis.stock.model.StockInfo;

public interface StockInfoService {

    public List<String> getStockCodes();

    public List<StockInfo> getStockInfo(String stockCode, Date date, int limit);

    public StockInfo getStockInfoByDate(List<StockInfo> stockInfos, Date date, int limit);

}