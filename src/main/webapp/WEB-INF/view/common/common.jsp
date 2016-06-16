<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://" + 
				  request.getServerName() + ":" + 
				  request.getServerPort() +
				  request.getContextPath();
	request.setAttribute("basePath", basePath);
%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/asserts/css/bootstrap.min.css" /> 
<link rel="stylesheet" type="text/css" href="<%=basePath%>/asserts/css/base.css" /> 
<link rel="stylesheet" type="text/css" href="<%=basePath%>/asserts/css/aside.menu.css" />
<script type="text/javascript" src="<%=basePath%>/asserts/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/asserts/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/asserts/layer/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>/asserts/js/common.js"></script>
<script type="text/javascript" src="<%=basePath%>/asserts/js/aside.menu.js"></script>
