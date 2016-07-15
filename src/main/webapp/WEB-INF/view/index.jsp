<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="common/common.jsp"/>
<script type="text/javascript" charset="utf-8" src="${basePath}/asserts/js/index.js"></script>
<title>首页</title>
</head>
<body>
	<div>
		<jsp:include page="common/header.jsp"/>
	</div>
	<div class="container margin-clear padding-clear width-all">
		<div class="row margin-clear padding-clear">
			<div class="col-md-2 left padding-clear" id="table-list">
				<jsp:include page="./common/left.jsp"/>
			</div>
			<div class="col-md-10 right" id="table-info">
                <div class="alert alert-warning" role="alert">选择表查看数据!</div>
			</div>
		</div>
	</div>
</body>
</html>