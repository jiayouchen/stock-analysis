package analysis.stock.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import analysis.stock.dao.StockInfoDao;
import analysis.stock.model.StockInfo;
import analysis.stock.util.DateUtil;
import analysis.stock.util.DbUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("stockInfoDao")
public class StockInfoDaoImpl implements StockInfoDao {

    public void saveStockInfo(StockInfo stockInfo) {
        SqlSession sqlSession = null;
        try {
            sqlSession = DbUtil.getSqlSession("mybatis-config.xml");
            sqlSession.selectOne("stockInfoMapper.addStockInfo", stockInfo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public List<StockInfo> getStockInfoAsc(String stockCode, Date date, int limit) {
        List<StockInfo> stockInfos = new ArrayList<StockInfo>();
        SqlSession sqlSession = null;
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("stockCode", stockCode);
            map.put("date", DateUtil.formatDate(date));
            map.put("limit", limit);
            sqlSession = DbUtil.getSqlSession("mybatis-config.xml");
            stockInfos = sqlSession.selectList("stockInfoMapper.getStockInfoAsc", map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return stockInfos;
    }

    public List<StockInfo> getStockInfoDesc(String stockCode, Date date, int limit) {
        List<StockInfo> stockInfos = new ArrayList<StockInfo>();
        SqlSession sqlSession = null;
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("stockCode", stockCode);
            map.put("date", DateUtil.formatDate(date));
            map.put("limit", limit);
            sqlSession = DbUtil.getSqlSession("mybatis-config.xml");
            stockInfos = sqlSession.selectList("stockInfoMapper.getStockInfoDesc", map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return stockInfos;
    }

    public Integer getCount(StockInfo stockInfo) {
        Integer count = 0;
        SqlSession sqlSession = null;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("stockName", stockInfo.getStockName());
            map.put("stockCode", stockInfo.getStockCode());
            map.put("date", DateUtil.formatDate(stockInfo.getDate()));
            map.put("time", DateUtil.formatTime(stockInfo.getTime()));
            map.put("openningPrice", stockInfo.getOpenningPrice());
            map.put("closingPrice", stockInfo.getClosingPrice());
            map.put("currentPrice", stockInfo.getCurrentPrice());
            map.put("hPrice", stockInfo.gethPrice());
            map.put("lPrice", stockInfo.getlPrice());
            sqlSession = DbUtil.getSqlSession("mybatis-config.xml");
            count = sqlSession.selectOne("stockInfoMapper.getCount", map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return count;
    }

}
