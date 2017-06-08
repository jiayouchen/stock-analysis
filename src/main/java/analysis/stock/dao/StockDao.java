package analysis.stock.dao;

import java.util.List;

import analysis.stock.model.Stock;

public interface StockDao {

    public List<Stock> getStockCodes();

    public String saveStock(Stock stock);

}
