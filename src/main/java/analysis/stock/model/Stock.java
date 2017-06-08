package analysis.stock.model;

public class Stock {

    private String stockCode; // 股票代码，SZ指在深圳交易的股票
    private String stockName; // 股票名称

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

}
