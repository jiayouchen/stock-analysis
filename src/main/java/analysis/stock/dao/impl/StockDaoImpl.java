package analysis.stock.dao.impl;

import java.util.ArrayList;
import java.util.List;

import analysis.stock.model.Stock;
import analysis.stock.util.DbUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import analysis.stock.dao.StockDao;

@Repository("stockDao")
public class StockDaoImpl implements StockDao {

    /**
     * @return 股票代码列表
     */
    public List<Stock> getStockCodes() {
        List<Stock> stocks = new ArrayList<Stock>();
        SqlSession sqlSession = null;
        try {
            sqlSession = DbUtil.getSqlSession("mybatis-config.xml");
            stocks = sqlSession.selectList("stockMapper.getStockCodes");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return stocks;
    }

    public String saveStock(Stock stock) {
        SqlSession sqlSession = null;
        try {
            sqlSession = DbUtil.getSqlSession("mybatis-config.xml");
            sqlSession.selectOne("stockMapper.addStock", stock);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return "done";
    }

}
