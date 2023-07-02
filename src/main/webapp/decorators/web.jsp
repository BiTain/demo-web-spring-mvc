<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	  <link href="<c:url value='/template/web/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">
</head>
<body>
	<!-- header -->
	<%@include file="/common/web/header.jsp" %>
	<!-- end header -->
	
	<!-- body -->
	<decorator:body/>
	<!-- end body -->
	
	<!-- footer -->
	<%@include file="/common/web/footer.jsp" %>
	<!-- end footer -->
	
	<script src="<c:url value='/template/web/vendor/jquery/jquery.min.js'/>"></script>
	<script src="<c:url value='/template/web/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
</body>
</html>