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
	<div class="container-fluid" style="margin:0px;padding:0px;">
		<div class="row" style="padding:0px;margin:0px;">
			<div class="col-md-3">
				<iframe src="common/left.html" frameborder="0" width="100%" height="630" style="margin-left:0px;"></iframe>
			</div>
			<div class="col-md-9" style="">
				<iframe src="common/right.html?tableName=" name="db-content" frameborder="0" style="width:100%;min-height:630px;s"></iframe>
			</div>
		</div>
	</div>
</body>
</html>