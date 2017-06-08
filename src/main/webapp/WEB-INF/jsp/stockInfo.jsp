<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="refresh" content="120">
<%@ include file="/WEB-INF/jsp/common/js.jsp"%>
<title>${stockName}-${stockCode}</title>
</head>
<body>
  <%@ include file="/WEB-INF/jsp/common/nav.jsp"%>
  <div class="container" align="center">
    <!-- 
    <div id="toolbar">
      <button id="buttonShow" class="btn btn-default">显示</button>
      <button id="buttonHide" class="btn btn-default">隐藏</button>
    </div>
     -->
    <table id="table"></table>
  </div>
  <script type="text/javascript">

        var $table = $('#table'),
            $buttonShow = $('#buttonShow'),
            $buttonHide = $('#buttonHide');

        $(function () {
            $buttonShow.click(function () {
                $table.bootstrapTable('showColumn', 'date');
                $table.bootstrapTable('showColumn', 'time');
            });
            $buttonHide.click(function () {
                $table.bootstrapTable('hideColumn', 'date');
                $table.bootstrapTable('hideColumn', 'time');
            });
        });

        $(function() {
        	$table.bootstrapTable({
                data: ${jsonString},
                striped: true,
                pagination: true,
                paginationVAlign: 'top',
                pageNumber: 1,
                pageSize: 500,
                pageList: [10, 20, 50, 100, 500],
                idField: 'stockCode',
                columns: [{
                    field: 'stockName',
                    title: '股票名称'
                }, {
                    field: 'stockCode',
                    title: '股票代码'
                }, {
                    field: 'date',
                    title: '日期'
                }, {
                    field: 'time',
                    title: '时间'
                }, {
                    field: 'buySumC',
                    title: '买和C'
                }, {
                    field: 'buyPriceC',
                    title: '买入价C'
                }, {
                    field: 'sellSumC',
                    title: '卖和C'
                }, {
                    field: 'sellPriceC',
                    title: '卖出价C'
                }, {
                    field: 'buySumB',
                    title: '买和B'
                }, {
                    field: 'buyPriceB',
                    title: '买入价B'
                }, {
                    field: 'sellSumB',
                    title: '卖和B'
                }, {
                    field: 'sellPriceB',
                    title: '卖出价B'
                }, {
                    field: 'buySumA',
                    title: '买和A'
                }, {
                    field: 'buyPriceA',
                    title: '买入价A'
                }, {
                    field: 'sellSumA',
                    title: '卖和A'
                }, {
                    field: 'sellPriceA',
                    title: '卖出价A'
                }, {
                    field: 'bp',
                    title: 'BP'
                }, {
                    field: 'sp',
                    title: 'SP'
                }, {
                    field: 'openningPrice',
                    title: '今日开盘价'
                }, {
                    field: 'currentPrice',
                    title: '当前价格'
                }, {
                    field: 'hPrice',
                    title: '今日最高价'
                }, {
                    field: 'lPrice',
                    title: '今日最低价'
                }, {
                    field: 'averagePrice5',
                    title: '5日均价'
                }, {
                    field: 'averagePrice10',
                    title: '10日均价'
                }, {
                    field: 'change',
                    title: '长短期线判断'
                }, {
                    field: 'isChangeN',
                    title: 'N涨跌判断'
                }, {
                    field: 'trendN',
                    title: 'N趋势力度'
                }, {
                    field: 'isChangeCountN',
                    title: 'N累计涨跌'
                }, {
                    field: 'hPriceN',
                    title: 'N高价'
                }, {
                    field: 'lPriceN',
                    title: 'N低价'
                }, {
                    field: 'isChangeN_1',
                    title: 'N-1涨跌判断'
                }, {
                    field: 'trendN_1',
                    title: 'N-1趋势力度'
                }, {
                    field: 'isChangeCountN_1',
                    title: 'N-1累计涨跌'
                }, {
                    field: 'hPriceN_1',
                    title: 'N-1高价'
                }, {
                    field: 'lPriceN_1',
                    title: 'N-1低价'
                }, {
                    field: 'isChangeN_2',
                    title: 'N-2涨跌判断'
                }, {
                    field: 'trendN_2',
                    title: 'N-2趋势力度'
                }, {
                    field: 'isChangeCountN_2',
                    title: 'N-2累计涨跌'
                }, {
                    field: 'hPriceN_2',
                    title: 'N-2高价'
                }, {
                    field: 'lPriceN_2',
                    title: 'N-2低价'
                }, {
                    field: 'isChangeN_3',
                    title: 'N-3涨跌判断'
                }, {
                    field: 'trendN_3',
                    title: 'N-3趋势力度'
                }, {
                    field: 'isChangeCountN_3',
                    title: 'N-3累计涨跌'
                }, {
                    field: 'hPriceN_3',
                    title: 'N-3高价'
                }, {
                    field: 'lPriceN_3',
                    title: 'N-3低价'
                }, {
                    field: 'estimate4',
                    title: '4跌涨跌判断'
                }, {
                    field: 'accumulationTrend4',
                    title: '4累计趋势判断'
                }, {
                    field: 'first4A',
                    title: '4第一个A'
                }, {
                    field: 'reduceTrend4',
                    title: '4趋势缩小'
                }, {
                    field: 'change31',
                    title: '31数量变化'
                }, {
                    field: 'buyEstimate32A',
                    title: '买32高低判断A'
                }, {
                    field: 'buyEstimate21A',
                    title: '买21高低判断A'
                }, {
                    field: 'buyNotTopN_1A',
                    title: '买N-1非最高A'
                }, {
                    field: 'buyDepartureA',
                    title: '买背驰A'
                }, {
                    field: 'buyTopPriceA',
                    title: '买高地价A'
                }, {
                    field: 'buyA',
                    title: '买入操作A'
                }, {
                    field: 'sellEstimate32A',
                    title: '卖32高低判断A'
                }, {
                    field: 'sellEstimate21A',
                    title: '卖21高低判断A'
                }, {
                    field: 'sellNotBottomN_1A',
                    title: '卖N-1非最低A'
                }, {
                    field: 'sellDepartureA',
                    title: '卖背驰A'
                }, {
                    field: 'sellTopPriceA',
                    title: '卖高地价A'
                }, {
                    field: 'sellA',
                    title: '卖出操作A'
                }, {
                    field: 'first4B',
                    title: '4第一个B'
                }, {
                    field: 'buyB',
                    title: '买入操作B'
                }, {
                    field: 'sellB',
                    title: '卖出操作B'
                }, {
                    field: 'estimate3',
                    title: '3跌涨跌判断'
                }, {
                    field: 'accumulationTrend3',
                    title: '3累计趋势判断'
                }, {
                    field: 'notFirst3',
                    title: '3非第一个'
                }, {
                    field: 'reduceTrend3',
                    title: '3趋势缩小'
                }, {
                    field: 'change20',
                    title: '20数量变化'
                }, {
                    field: 'buyEstimate21C',
                    title: '买21高低判断C'
                }, {
                    field: 'buyEstimate10C',
                    title: '买10高低判断C'
                }, {
                    field: 'buyNotTopN_1C',
                    title: '买N-1非最高C'
                }, {
                    field: 'buyDepartureC',
                    title: '买背驰C'
                }, {
                    field: 'buyTopPriceC',
                    title: '买高地价C'
                }, {
                    field: 'buyC',
                    title: '买入操作C'
                }, {
                    field: 'sellEstimate21C',
                    title: '卖21高低判断C'
                }, {
                    field: 'sellEstimate10C',
                    title: '卖10高低判断C'
                }, {
                    field: 'sellNotBottomN_1C',
                    title: '卖N-1非最低C'
                }, {
                    field: 'sellDepartureC',
                    title: '卖背驰C'
                }, {
                    field: 'sellTopPriceC',
                    title: '卖高地价C'
                }, {
                    field: 'sellC',
                    title: '卖出操作C'
                }, {
                    field: 'bp1',
                    title: 'BP1'
                }, {
                    field: 'bp2',
                    title: 'BP2'
                }, {
                    field: 'bp3',
                    title: 'BP3'
                }, {
                    field: 'bp4',
                    title: 'BP4'
                }, {
                    field: 'bp5',
                    title: 'BP5'
                }, {
                    field: 'bp6',
                    title: 'BP6'
                }, {
                    field: 'bp7',
                    title: 'BP7'
                }, {
                    field: 'bp8',
                    title: 'BP8'
                }, {
                    field: 'bp9',
                    title: 'BP9'
                }, {
                    field: 'sp1',
                    title: 'SP1'
                }, {
                    field: 'sp2',
                    title: 'SP2'
                }, {
                    field: 'sp3',
                    title: 'SP3'
                }, {
                    field: 'sp4',
                    title: 'SP4'
                }, {
                    field: 'sp5',
                    title: 'SP5'
                }, {
                    field: 'sp6',
                    title: 'SP6'
                }, {
                    field: 'sp7',
                    title: 'SP7'
                }, {
                    field: 'sp8',
                    title: 'SP8'
                }, {
                    field: 'sp9',
                    title: 'SP9'
                }],
            });
        });

  </script>
  <%@ include file="/WEB-INF/jsp/common/footer.jsp"%>
</body>
</html>