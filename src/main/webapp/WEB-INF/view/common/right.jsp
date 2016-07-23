<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="./common.jsp" />
<script type="text/javascript" charset="utf-8" src="${basePath}/asserts/js/right.js"></script>
<style type="text/css">
	/**show create table style*/
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
<script type="text/javascript">
	$(function(){

	});
</script>
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
				<%--<button class="btn btn-success" type="button" target="#all-table-info" id="sql-query-btn" data-base-path="${basePath}" data-request-url="${basePath}/json/sql/query/result.json">
					<span class="glyphicon glyphicon-search"></span>
					Go
				</button>--%>
				<a class="btn btn-success" data-params="#sql" target="#content" data-asyn-load="true" data-request-url="${basePath}/html/sql/query/result.html">
					<span class="glyphicon glyphicon-search"></span>
					Go
				</a>
			</span>
		</div>
	</div>
	<!--col-md-9-->
	<div class="col-md-3">
		<c:if test="${tableName != null}">
			<a href="javascript:void(0);" class="btn btn-success" id="show-create-table" data-request-url="${basePath}/json/common/showCreateTable.json" data-table="${tableName}">
				<span class="glyphicon glyphicon-list"></span>
				查看表结构
			</a>
		</c:if>
		<c:if test="${tableName == null}">
			<a href="javascript:void(0);" class="btn btn-success disabled" id="show-create-table" data-request-url="${basePath}/json/common/showCreateTable.json">
				<span class="glyphicon glyphicon-list"></span>
				查看表结构
			</a>
		</c:if>
	</div>
	<!--col-sm-3-->
</div>
<!--end row-->
<div id="content">
	<table class="table table-striped" id="all-table-info" data-table-name="${tableName}" data-sql="${sql}">
		<c:if test="${tableName != null || ''.equals(tableName)}">
			<caption>
				<span class="badge badge-warning">
					<a href="javascript:void(0);" data-table="${tableName}" data-action="show-create-table" data-request-url="${basePath}/json/common/showCreateTable.json">${tableName}</a>
				</span>
			</caption>
		</c:if>
		<c:if test="${!records.isEmpty()}">
			<thead>
				<tr>
					<c:forEach items="${dbFieldNames}" var="fieldName">
						<td align="center" style="min-width:80px;" data-field-name="${fieldName}">
								${fieldName}
							<p>
								<span class="glyphicon glyphicon-hand-up cursor" data-request-url="${basePath}/json/sql/query/orderedResult.json" data-order="true" data-target="#all-table-info" data-order-name="ASC" data-field-name="${fieldName}"></span>
								<span class="glyphicon glyphicon-hand-down cursor" data-request-url="${basePath}/json/sql/query/orderedResult.json" data-order="true" data-target="#all-table-info" data-order-name="DESC" data-field-name="${fieldName}"></span>
							</p>
						</td>
					</c:forEach>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${records}" var="record">
					<tr>
						<c:forEach items="${record.dbFieldVoList}" var="field">
							<td align="center">${field.value}</td>
						</c:forEach>
					</tr>
				</c:forEach>
			</tbody>
		</c:if>
		<c:if test="${records.isEmpty() || null == records}">
			<tfoot>
				<tr>
					<td align="center" style="border:0px;">
						<div class="alert alert-warning">
							<p class="center-block">该表暂无数据!</p>
						</div>
					</td>
				</tr>
			</tfoot>
		</c:if>
	</table>
</div>
<nav>
	<ul class="pagination">
		<li>
			<a href="#" aria-label="Previous">
				<span aria-hidden="true">&laquo;</span>
			</a>
		</li>
		<li><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">5</a></li>
		<li>
			<a href="#" aria-label="Next">
				<span aria-hidden="true">&raquo;</span>
			</a>
		</li>
	</ul>
</nav>