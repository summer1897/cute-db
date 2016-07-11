<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="./common.jsp" />
<script type="text/javascript" charset="utf-8" src="${basePath}/asserts/js/right.js"></script>
<style type="text/css">
	.layui-layer-content{
		min-width: 500px;
		max-width: 600px;
		max-height: 700px;
	}
	.layui-layer-setwin .layui-layer-close2{
		right: -160px;
	}
	.table-info-style {
		padding: 10px;
		background-color: #5FB878;
	}
	.table-info-style span{
		color: white;
		font-family: "Times New Roman";
	}
</style>
<!-- /input-group -->
<div class="row">
	<div class="col-sm-9" style="clear: both">
		<div class="input-group" style="margin-bottom:5px;">
			<div class="input-group-btn">
				<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					查询条件<!--<span class="caret"></span>-->
				</button>
				<!--<ul class="dropdown-menu">
					<li><a href="#">where</a></li>
					<li role="separator" class="divider"></li>
					<li><a href="#">SQL</a></li>
				</ul>-->
			</div>
			<!-- /btn-group -->
			<input type="text" class="form-control" placeholder="select *from tableName where id=? and name=?" name="sql">
			<span class="input-group-btn">
				<button class="btn btn-success" type="button">
					<span class="glyphicon glyphicon-search"></span>
					Go
				</button>
			</span>
		</div>
	</div>
	<div class="col-sm-3">
		<a href="javascript:void" class="btn btn-success" id="show-create-table" data-request-url="${basePath}/json/common/showCreateTable.json" data="${tableName}">
			<span class="glyphicon glyphicon-list"></span>
			查看表结构
		</a>
	</div>
</div>
<table class="table table-striped" style="clear: both;">
	<c:if test="${!records.isEmpty()}">
		<caption>
			<h3>
				<span class="label label-info">表名:${tableName}</span>
			</h3>
		</caption>
		<thead>
			<tr>
				<c:forEach items="${records.get(0).getFields()}" var="field">
					<td align="center">${field.getFieldName()}</td>
				</c:forEach>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${records}" var="record">
				<tr>
					<c:forEach items="${record.getFields()}" var="field">
						<td align="center">${field.getValue()}</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</tbody>
	</c:if>
</table>