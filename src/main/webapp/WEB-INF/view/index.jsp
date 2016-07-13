<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<div class="col-md-3 left padding-clear" id="table-list">
				<jsp:include page="./common/left.jsp"/>
			</div>
			<div class="col-md-9 right">
				<!--row-->
                <div class="row">
                    <div class="col-md-9">
                        <div class="input-group" style="margin-bottom:5px;">
                            <div class="input-group-btn">
                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    查询条件<span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu">
                                    <li><a href="#">where</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">SQL</a></li>
                                </ul>
                            </div>
                            <input type="text" class="form-control" id="sql" placeholder="select *from tableName where id=? and name=?" name="sql">
                            <span class="input-group-btn">
                                <button class="btn btn-success" type="button" target="#table-info" id="sql-query-btn" data-request-url="${basePath}/json/sql/query/result.json">
                                    <span class="glyphicon glyphicon-search"></span>
                                    Go
                                </button>
                            </span>
                        </div>
                    </div>
                    <!--col-md-9-->
                    <div class="col-md-3">
                        <a href="javascript:void" class="btn btn-success" id="show-create-table" data-request-url="${basePath}/json/common/showCreateTable.json" data="${tableName}">
                            <span class="glyphicon glyphicon-list"></span>
                            查看表结构
                        </a>
                    </div>
                    <!--col-sm-3-->
                </div>
                <!--end row-->
                <div class="" id="table-info">
                </div>
			</div>
		</div>
	</div>
</body>
</html>