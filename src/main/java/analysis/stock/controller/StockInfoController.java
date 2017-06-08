package analysis.stock.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import analysis.stock.dao.StockDao;
import analysis.stock.model.Stock;
import analysis.stock.model.StockInfo;
import analysis.stock.service.StockInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

@Controller
public class StockInfoController {

    @Resource(name = "stockDao")
    private StockDao stockDao;

    @Resource(name = "stockInfoService")
    private StockInfoService stockInfoService;

    @RequestMapping(path = "/all/{limit:[0-9]*}", method = RequestMethod.GET)
    public ModelAndView stockInfo(@PathVariable int limit, ModelAndView modelAndView) {
        List<StockInfo> stockInfoAll = new ArrayList<StockInfo>();
        List<Stock> stocks = stockDao.getStockCodes();
        for (Stock stock : stocks) {
            List<StockInfo> stockInfos = stockInfoService.getStockInfo(stock.getStockCode(), new Date(), limit);
            if (stockInfos.size() > 0) {
                stockInfoAll.add(stockInfos.get(0));
            }
        }
        Collections.sort(stockInfoAll);
        String jsonString = JSON.toJSONString(stockInfoAll);
        modelAndView.addObject("jsonString", jsonString);
        modelAndView.setViewName("all");
        return modelAndView;
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ModelAndView stockInfo(ModelAndView modelAndView) {
        List<StockInfo> stockInfoAll = new ArrayList<StockInfo>();
        List<Stock> stocks = stockDao.getStockCodes();
        for (Stock stock : stocks) {
            List<StockInfo> stockInfos = stockInfoService.getStockInfo(stock.getStockCode(), new Date(), 500);
            if (stockInfos.size() > 0) {
                stockInfoAll.add(stockInfos.get(0));
            }
        }
        Collections.sort(stockInfoAll);
        String jsonString = JSON.toJSONString(stockInfoAll);
        modelAndView.addObject("jsonString", jsonString);
        modelAndView.setViewName("all");
        return modelAndView;
    }

    @RequestMapping(path = "/{stockCode}/{limit:[0-9]*}", method = RequestMethod.GET)
    public ModelAndView stockInfo(@PathVariable String stockCode, @PathVariable int limit, ModelAndView modelAndView) {
        List<StockInfo> stockInfos = stockInfoService.getStockInfo(stockCode, new Date(), limit);
        String jsonString = JSON.toJSONString(stockInfos);
        modelAndView.addObject("stockName", stockInfos.size() > 0 ? stockInfos.get(0).getStockName() : "无记录");
        modelAndView.addObject("jsonString", jsonString);
        modelAndView.setViewName("stockInfo");
        return modelAndView;
    }

    @RequestMapping(path = "/{stockCode}", method = RequestMethod.GET)
    public ModelAndView stockInfo(@PathVariable String stockCode, ModelAndView modelAndView) {
        List<StockInfo> stockInfos = stockInfoService.getStockInfo(stockCode, new Date(), 200);
        String jsonString = JSON.toJSONString(stockInfos);
        modelAndView.addObject("stockName", stockInfos.size() > 0 ? stockInfos.get(0).getStockName() : "无记录");
        modelAndView.addObject("jsonString", jsonString);
        modelAndView.setViewName("stockInfo");
        return modelAndView;
    }

}
