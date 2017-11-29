package analysis.stock.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import analysis.stock.dao.StockMapper;
import analysis.stock.model.Stock;
import analysis.stock.model.StockInfo;
import analysis.stock.service.StockInfoService;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

@Controller
public class StockInfoController {

    @Autowired
    private StockMapper stockDao;

    @Resource(name = "stockInfoService")
    private StockInfoService stockInfoService;

    @RequestMapping(path = "/all/{limit:[0-9]*}", method = RequestMethod.GET)
    public ModelAndView stockInfo(@PathVariable int limit, ModelAndView modelAndView) {
        System.out.println("all/{limit:[0-9]*} method ... ");
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
        long startTime = System.currentTimeMillis();

        final List<StockInfo> stockInfoAll = new ArrayList<StockInfo>();
        List<Stock> stocks = stockDao.getStockCodes();

//        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(10,
//                new BasicThreadFactory.Builder().namingPattern("scheduled-thread-pool-%d").daemon(true).build());
//
//        for (Stock stock : stocks) {
//            final String stockCode = stock.getStockCode();
//            scheduledExecutorService.schedule(new Runnable() {
//                public void run() {
//                    List<StockInfo> stockInfos = stockInfoService.getStockInfo(stockCode, new Date(), 500);
//                    if (stockInfos.size() > 0) {
//                        stockInfoAll.add(stockInfos.get(0));
//                    }
//                }
//            }, 0, TimeUnit.MILLISECONDS);
//        }
//
//        // 关闭启动线程
//        scheduledExecutorService.shutdown();
//        try{
//            // 等待子线程结束，再继续执行下面的代码
//            scheduledExecutorService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

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

        System.out.println("*************************:查询耗时"
                + (System.currentTimeMillis() - startTime) / 1000
                + " 秒*************************");
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
