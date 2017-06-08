<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/jsp/common/js.jsp"%>
<title>HY思享汇 量化投资系统</title>
</head>
<body>
    <%@ include file="/WEB-INF/jsp/common/nav.jsp"%>
    <br><br><br><br>
    <div class="container" align="center">
        登录成功，正在跳转……<br> 10s后没有跳转，请<a href="${pageContext.request.contextPath}">点此跳转</a>
    </div>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <%@ include file="/WEB-INF/jsp/common/footer.jsp"%>
    <script language='javascript'>
    document.location = '${pageContext.request.contextPath}';
    </script>
</body>
</html>
