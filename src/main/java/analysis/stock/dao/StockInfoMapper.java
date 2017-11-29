package analysis.stock.dao;

import java.util.Date;
import java.util.List;

import analysis.stock.model.StockInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("stockInfoDao")
public interface StockInfoMapper {

    List<StockInfo> getStockInfoAsc(@Param("stockCode") String stockCode, @Param("date") Date date, @Param("limit") int limit);

}
