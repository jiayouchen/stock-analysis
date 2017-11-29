package analysis.stock.dao;

import java.util.List;

import analysis.stock.model.Stock;
import org.springframework.stereotype.Repository;

@Repository()
public interface StockMapper {

    List<Stock> getStockCodes();

}
