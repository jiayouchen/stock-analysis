package analysis.stock.dao;

import java.util.Date;
import java.util.List;

import analysis.stock.model.StockInfo;

public interface StockInfoDao {

    public void saveStockInfo(StockInfo stockInfo);

    public List<StockInfo> getStockInfoAsc(String stockCode, Date date, int limit);

    public List<StockInfo> getStockInfoDesc(String stockCode, Date date, int limit);

    public Integer getCount(StockInfo stockInfo);

}
