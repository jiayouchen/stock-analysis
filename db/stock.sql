CREATE TABLE `stock_analysis` (
    id bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    stockName CHAR(8) COMMENT '股票名称',
    stockCode CHAR(8) COMMENT '股票代码',
    date DATE COMMENT '日期',
    time TIME COMMENT '时间',
    openningPrice DOUBLE COMMENT '今日开盘价',
    closingPrice DOUBLE COMMENT '昨日收盘价',
    currentPrice DOUBLE COMMENT '当前价格',
    hPrice DOUBLE COMMENT '今日最高价',
    lPrice DOUBLE COMMENT '今日最低价',
    insertTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间戳',
    PRIMARY KEY USING BTREE (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create index index_stockCode_date_time on stock_analysis(stockCode, date, time);
