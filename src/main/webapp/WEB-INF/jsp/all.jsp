<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="refresh" content="120">
<%@ include file="/WEB-INF/jsp/common/js.jsp"%>
<title>HY思享汇 量化投资系统</title>
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
                onDblClickRow: function (row) {
                    window.location.href = "${pageContext.request.contextPath}/" + row.stockCode;
                 },
                columns: [{
                    field: 'stockName',
                    title: '股票名称'
                }, {
                    field: 'stockCode',
                    title: '股票代码'
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
                }],
            });
        });

  </script>
  <%@ include file="/WEB-INF/jsp/common/footer.jsp"%>
</body>
</html>