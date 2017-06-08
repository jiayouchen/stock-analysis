<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/jsp/common/js.jsp"%>
<title>Stock</title>
</head>
<body>
  <%@ include file="/WEB-INF/jsp/common/nav.jsp"%>
  <jsp:forward page="all"></jsp:forward>
  <div class="container" align="center">
    <table id="table"></table>
  </div>
  <script type="text/javascript">
			$(function() {
				$('#table')
						.bootstrapTable(
								{
									data : [ {
										"stockName" : "上证指数",
										"stockCode" : "sh000001"
									}, {
										"stockName" : "晨光文具",
										"stockCode" : "sh603899"
									}, {
										"stockName" : "福斯特",
										"stockCode" : "sh603806"
									}, {
										"stockName" : "海天味业",
										"stockCode" : "sh603288"
									}, {
										"stockName" : "共进股份",
										"stockCode" : "sh603118"
									}, {
										"stockName" : "金隅股份",
										"stockCode" : "sh601992"
									}, {
										"stockName" : "凤凰传媒",
										"stockCode" : "sh601928"
									}, {
										"stockName" : "中国国旅",
										"stockCode" : "sh601888"
									}, {
										"stockName" : "皖新传媒",
										"stockCode" : "sh601801"
									}, {
										"stockName" : "力帆股份",
										"stockCode" : "sh601777"
									}, {
										"stockName" : "中国人寿",
										"stockCode" : "sh601628"
									}, {
										"stockName" : "上海医药",
										"stockCode" : "sh601607"
									}, {
										"stockName" : "工商银行",
										"stockCode" : "sh601398"
									}, {
										"stockName" : "中国平安",
										"stockCode" : "sh601318"
									}, {
										"stockName" : "骆驼股份",
										"stockCode" : "sh601311"
									}, {
										"stockName" : "深圳燃气",
										"stockCode" : "sh601139"
									}, {
										"stockName" : "中国国航",
										"stockCode" : "sh601111"
									}, {
										"stockName" : "中南传媒",
										"stockCode" : "sh601098"
									}, {
										"stockName" : "中国神华",
										"stockCode" : "sh601088"
									}, {
										"stockName" : "大秦铁路",
										"stockCode" : "sh601006"
									}, {
										"stockName" : "招商证券",
										"stockCode" : "sh600999"
									}, {
										"stockName" : "马应龙",
										"stockCode" : "sh600993"
									}, {
										"stockName" : "四创电子",
										"stockCode" : "sh600990"
									}, {
										"stockName" : "宜华生活",
										"stockCode" : "sh600978"
									}, {
										"stockName" : "福成股份",
										"stockCode" : "sh600965"
									}, {
										"stockName" : "中航动力",
										"stockCode" : "sh600893"
									}, {
										"stockName" : "伊利股份",
										"stockCode" : "sh600887"
									}, {
										"stockName" : "航天电子",
										"stockCode" : "sh600879"
									}, {
										"stockName" : "创业环保",
										"stockCode" : "sh600874"
									}, {
										"stockName" : "梅花生物",
										"stockCode" : "sh600873"
									}, {
										"stockName" : "通化东宝",
										"stockCode" : "sh600867"
									}, {
										"stockName" : "世茂股份",
										"stockCode" : "sh600823"
									}, {
										"stockName" : "东方集团",
										"stockCode" : "sh600811"
									}, {
										"stockName" : "东方通信",
										"stockCode" : "sh600776"
									}, {
										"stockName" : "安徽合力",
										"stockCode" : "sh600761"
									}, {
										"stockName" : "长江传媒",
										"stockCode" : "sh600757"
									}, {
										"stockName" : "锦江股份",
										"stockCode" : "sh600754"
									}, {
										"stockName" : "江中药业",
										"stockCode" : "sh600750"
									}, {
										"stockName" : "华域汽车",
										"stockCode" : "sh600741"
									}, {
										"stockName" : "中航资本",
										"stockCode" : "sh600705"
									}, {
										"stockName" : "三安光电",
										"stockCode" : "sh600703"
									}, {
										"stockName" : "大商股份",
										"stockCode" : "sh600694"
									}, {
										"stockName" : "青岛海尔",
										"stockCode" : "sh600690"
									}, {
										"stockName" : "中船防务",
										"stockCode" : "sh600685"
									}, {
										"stockName" : "强生控股",
										"stockCode" : "sh600662"
									}, {
										"stockName" : "福耀玻璃",
										"stockCode" : "sh600660"
									}, {
										"stockName" : "东方明珠",
										"stockCode" : "sh600637"
									}, {
										"stockName" : "大众公用",
										"stockCode" : "sh600635"
									}, {
										"stockName" : "青岛啤酒",
										"stockCode" : "sh600600"
									}, {
										"stockName" : "北大荒",
										"stockCode" : "sh600598"
									}, {
										"stockName" : "海螺水泥",
										"stockCode" : "sh600585"
									}, {
										"stockName" : "卧龙电气",
										"stockCode" : "sh600580"
									}, {
										"stockName" : "康恩贝",
										"stockCode" : "sh600572"
									}, {
										"stockName" : "康缘药业",
										"stockCode" : "sh600557"
									}, {
										"stockName" : "山东黄金",
										"stockCode" : "sh600547"
									}, {
										"stockName" : "天士力",
										"stockCode" : "sh600535"
									}, {
										"stockName" : "菲达环保",
										"stockCode" : "sh600526"
									}, {
										"stockName" : "贵州茅台",
										"stockCode" : "sh600519"
									}, {
										"stockName" : "康美药业",
										"stockCode" : "sh600518"
									}, {
										"stockName" : "方大特钢",
										"stockCode" : "sh600507"
									}, {
										"stockName" : "烽火通信",
										"stockCode" : "sh600498"
									}, {
										"stockName" : "江淮汽车",
										"stockCode" : "sh600418"
									}, {
										"stockName" : "国电南瑞",
										"stockCode" : "sh600406"
									}, {
										"stockName" : "抚顺特钢",
										"stockCode" : "sh600399"
									}, {
										"stockName" : "中文传媒",
										"stockCode" : "sh600373"
									}, {
										"stockName" : "上海家化",
										"stockCode" : "sh600315"
									}, {
										"stockName" : "平高电气",
										"stockCode" : "sh600312"
									}, {
										"stockName" : "万华化学",
										"stockCode" : "sh600309"
									}, {
										"stockName" : "安琪酵母",
										"stockCode" : "sh600298"
									}, {
										"stockName" : "广汇汽车",
										"stockCode" : "sh600297"
									}, {
										"stockName" : "恒瑞医药",
										"stockCode" : "sh600276"
									}, {
										"stockName" : "外运发展",
										"stockCode" : "sh600270"
									}, {
										"stockName" : "全柴动力",
										"stockCode" : "sh600218"
									}, {
										"stockName" : "紫江企业",
										"stockCode" : "sh600210"
									}, {
										"stockName" : "复星医药",
										"stockCode" : "sh600196"
									}, {
										"stockName" : "雅戈尔",
										"stockCode" : "sh600177"
									}, {
										"stockName" : "航天机电",
										"stockCode" : "sh600151"
									}, {
										"stockName" : "金发科技",
										"stockCode" : "sh600143"
									}, {
										"stockName" : "中青旅",
										"stockCode" : "sh600138"
									}, {
										"stockName" : "上汽集团",
										"stockCode" : "sh600104"
									}, {
										"stockName" : "特变电工",
										"stockCode" : "sh600089"
									}, {
										"stockName" : "同仁堂",
										"stockCode" : "sh600085"
									}, {
										"stockName" : "冠城大通",
										"stockCode" : "sh600067"
									}, {
										"stockName" : "宇通客车",
										"stockCode" : "sh600066"
									}, {
										"stockName" : "古越龙山",
										"stockCode" : "sh600059"
									}, {
										"stockName" : "保利地产",
										"stockCode" : "sh600048"
									}, {
										"stockName" : "中直股份",
										"stockCode" : "sh600038"
									}, {
										"stockName" : "歌华有线",
										"stockCode" : "sh600037"
									}, {
										"stockName" : "招商银行",
										"stockCode" : "sh600036"
									}, {
										"stockName" : "中信证券",
										"stockCode" : "sh600030"
									}, {
										"stockName" : "宝钢股份",
										"stockCode" : "sh600019"
									}, {
										"stockName" : "上港集团",
										"stockCode" : "sh600018"
									}, {
										"stockName" : "民生银行",
										"stockCode" : "sh600016"
									}, {
										"stockName" : "上海机场",
										"stockCode" : "sh600009"
									}, {
										"stockName" : "创业板指",
										"stockCode" : "sz399006"
									}, {
										"stockName" : "深证成指",
										"stockCode" : "sz399001"
									}, {
										"stockName" : "掌趣科技",
										"stockCode" : "sz300315"
									}, {
										"stockName" : "光线传媒",
										"stockCode" : "sz300251"
									}, {
										"stockName" : "雷曼股份",
										"stockCode" : "sz300162"
									}, {
										"stockName" : "宋城演艺",
										"stockCode" : "sz300144"
									}, {
										"stockName" : "华策影视",
										"stockCode" : "sz300133"
									}, {
										"stockName" : "汇川技术",
										"stockCode" : "sz300124"
									}, {
										"stockName" : "长盈精密",
										"stockCode" : "sz300115"
									}, {
										"stockName" : "乐视网",
										"stockCode" : "sz300104"
									}, {
										"stockName" : "三聚环保",
										"stockCode" : "sz300072"
									}, {
										"stockName" : "碧水源",
										"stockCode" : "sz300070"
									}, {
										"stockName" : "星辉娱乐",
										"stockCode" : "sz300043"
									}, {
										"stockName" : "金龙机电",
										"stockCode" : "sz300032"
									}, {
										"stockName" : "华谊兄弟",
										"stockCode" : "sz300027"
									}, {
										"stockName" : "红日药业",
										"stockCode" : "sz300026"
									}, {
										"stockName" : "银江股份",
										"stockCode" : "sz300020"
									}, {
										"stockName" : "网宿科技",
										"stockCode" : "sz300017"
									}, {
										"stockName" : "爱尔眼科",
										"stockCode" : "sz300015"
									}, {
										"stockName" : "探路者",
										"stockCode" : "sz300005"
									}, {
										"stockName" : "乐普医疗",
										"stockCode" : "sz300003"
									}, {
										"stockName" : "永兴特钢",
										"stockCode" : "sz002756"
									}, {
										"stockName" : "万达院线",
										"stockCode" : "sz002739"
									}, {
										"stockName" : "葵花药业",
										"stockCode" : "sz002737"
									}, {
										"stockName" : "奥瑞金",
										"stockCode" : "sz002701"
									}, {
										"stockName" : "克明面业",
										"stockCode" : "sz002661"
									}, {
										"stockName" : "雪迪龙",
										"stockCode" : "sz002658"
									}, {
										"stockName" : "史丹利",
										"stockCode" : "sz002588"
									}, {
										"stockName" : "好想你",
										"stockCode" : "sz002582"
									}, {
										"stockName" : "洽洽食品",
										"stockCode" : "sz002557"
									}, {
										"stockName" : "司尔特",
										"stockCode" : "sz002538"
									}, {
										"stockName" : "老板电器",
										"stockCode" : "sz002508"
									}, {
										"stockName" : "广田集团",
										"stockCode" : "sz002482"
									}, {
										"stockName" : "立讯精密",
										"stockCode" : "sz002475"
									}, {
										"stockName" : "天齐锂业",
										"stockCode" : "sz002466"
									}, {
										"stockName" : "欧菲光",
										"stockCode" : "sz002456"
									}, {
										"stockName" : "誉衡药业",
										"stockCode" : "sz002437"
									}, {
										"stockName" : "科伦药业",
										"stockCode" : "sz002422"
									}, {
										"stockName" : "海康威视",
										"stockCode" : "sz002415"
									}, {
										"stockName" : "海普瑞",
										"stockCode" : "sz002399"
									}, {
										"stockName" : "康力电梯",
										"stockCode" : "sz002367"
									}, {
										"stockName" : "富临运业",
										"stockCode" : "sz002357"
									}, {
										"stockName" : "格林美",
										"stockCode" : "sz002340"
									}, {
										"stockName" : "洋河股份",
										"stockCode" : "sz002304"
									}, {
										"stockName" : "圣农发展",
										"stockCode" : "sz002299"
									}, {
										"stockName" : "奥飞娱乐",
										"stockCode" : "sz002292"
									}, {
										"stockName" : "世联行",
										"stockCode" : "sz002285"
									}, {
										"stockName" : "东方雨虹",
										"stockCode" : "sz002271"
									}, {
										"stockName" : "联化科技",
										"stockCode" : "sz002250"
									}, {
										"stockName" : "九阳股份",
										"stockCode" : "sz002242"
									}, {
										"stockName" : "歌尔股份",
										"stockCode" : "sz002241"
									}, {
										"stockName" : "天威视讯",
										"stockCode" : "sz002238"
									}, {
										"stockName" : "塔牌集团",
										"stockCode" : "sz002233"
									}, {
										"stockName" : "科大讯飞",
										"stockCode" : "sz002230"
									}, {
										"stockName" : "鱼跃医疗",
										"stockCode" : "sz002223"
									}, {
										"stockName" : "怡亚通",
										"stockCode" : "sz002183"
									}, {
										"stockName" : "艾派克",
										"stockCode" : "sz002180"
									}, {
										"stockName" : "露天煤业",
										"stockCode" : "sz002128"
									}, {
										"stockName" : "威海广泰",
										"stockCode" : "sz002111"
									}, {
										"stockName" : "金螳螂",
										"stockCode" : "sz002081"
									}, {
										"stockName" : "双鹭药业",
										"stockCode" : "sz002038"
									}, {
										"stockName" : "华帝股份",
										"stockCode" : "sz002035"
									}, {
										"stockName" : "丽江旅游",
										"stockCode" : "sz002033"
									}, {
										"stockName" : "分众传媒",
										"stockCode" : "sz002027"
									}, {
										"stockName" : "亿帆鑫富",
										"stockCode" : "sz002019"
									}, {
										"stockName" : "大族激光",
										"stockCode" : "sz002008"
									}, {
										"stockName" : "招商蛇口",
										"stockCode" : "sz001979"
									}, {
										"stockName" : "华润三九",
										"stockCode" : "sz000999"
									}, {
										"stockName" : "隆平高科",
										"stockCode" : "sz000998"
									}, {
										"stockName" : "新大陆",
										"stockCode" : "sz000997"
									}, {
										"stockName" : "华东医药",
										"stockCode" : "sz000963"
									}, {
										"stockName" : "双汇发展",
										"stockCode" : "sz000895"
									}, {
										"stockName" : "新希望",
										"stockCode" : "sz000876"
									}, {
										"stockName" : "张裕Ａ",
										"stockCode" : "sz000869"
									}, {
										"stockName" : "顺鑫农业",
										"stockCode" : "sz000860"
									}, {
										"stockName" : "五粮液",
										"stockCode" : "sz000858"
									}, {
										"stockName" : "承德露露",
										"stockCode" : "sz000848"
									}, {
										"stockName" : "启迪桑德",
										"stockCode" : "sz000826"
									}, {
										"stockName" : "盐湖股份",
										"stockCode" : "sz000792"
									}, {
										"stockName" : "北新建材",
										"stockCode" : "sz000786"
									}, {
										"stockName" : "大冶特钢",
										"stockCode" : "sz000708"
									}, {
										"stockName" : "湖北广电",
										"stockCode" : "sz000665"
									}, {
										"stockName" : "格力电器",
										"stockCode" : "sz000651"
									}, {
										"stockName" : "仁和药业",
										"stockCode" : "sz000650"
									}, {
										"stockName" : "长安汽车",
										"stockCode" : "sz000625"
									}, {
										"stockName" : "海螺型材",
										"stockCode" : "sz000619"
									}, {
										"stockName" : "兴蓉环境",
										"stockCode" : "sz000598"
									}, {
										"stockName" : "云南白药",
										"stockCode" : "sz000538"
									}, {
										"stockName" : "江南红箭",
										"stockCode" : "sz000519"
									}, {
										"stockName" : "丽珠集团",
										"stockCode" : "sz000513"
									}, {
										"stockName" : "鄂武商Ａ",
										"stockCode" : "sz000501"
									}, {
										"stockName" : "晨鸣纸业",
										"stockCode" : "sz000488"
									}, {
										"stockName" : "徐工机械",
										"stockCode" : "sz000425"
									}, {
										"stockName" : "东阿阿胶",
										"stockCode" : "sz000423"
									}, {
										"stockName" : "小天鹅Ａ",
										"stockCode" : "sz000418"
									}, {
										"stockName" : "合肥百货",
										"stockCode" : "sz000417"
									}, {
										"stockName" : "潍柴动力",
										"stockCode" : "sz000338"
									}, {
										"stockName" : "美的集团",
										"stockCode" : "sz000333"
									}, {
										"stockName" : "华数传媒",
										"stockCode" : "sz000156"
									}, {
										"stockName" : "宜华健康",
										"stockCode" : "sz000150"
									}, {
										"stockName" : "深圳机场",
										"stockCode" : "sz000089"
									}, {
										"stockName" : "华侨城Ａ",
										"stockCode" : "sz000069"
									}, {
										"stockName" : "中兴通讯",
										"stockCode" : "sz000063"
									}, {
										"stockName" : "泛海控股",
										"stockCode" : "sz000046"
									}, {
										"stockName" : "国药一致",
										"stockCode" : "sz000028"
									}, {
										"stockName" : "万科Ａ",
										"stockCode" : "sz000002"
									} ],
									striped : true,
									pagination : true,
									paginationVAlign : 'top',
									pageNumber : 1,
									pageSize : 20,
									pageList : [ 10, 25, 50, 100 ],
									showToggle : true,
									idField : 'stockCode',
									onDblClickRow : function(row) {
										window.location.href = "${pageContext.request.contextPath}/"
												+ row.stockCode;
									},
									columns : [ {
										field : 'stockName',
										title : '股票名称'
									}, {
										field : 'stockCode',
										title : '股票代码'
									} ],
								});
			});
		</script>
  <%@ include file="/WEB-INF/jsp/common/footer.jsp"%>
</body>
</html>
