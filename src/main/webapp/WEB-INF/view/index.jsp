<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="common/common.jsp"/>
<title>首页</title>
</head>
<body>
	<div>
		<jsp:include page="common/header.jsp"/>
	</div>
	<div class="container margin-clear padding-clear">
		<div class="row margin-clear padding-clear">
			<div class="col-md-3 left padding-clear" id="table-list">
				<jsp:include page="./common/left.jsp"/>
			</div>
			<div class="col-md-9 right" id="table-info">
			</div>
		</div>
	</div>
</body>
</html>