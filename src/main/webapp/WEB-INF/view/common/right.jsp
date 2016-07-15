<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="./common.jsp" />
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

	.badge-add{
		padding: 6px 10px;
		background-color: #eea236;
	}
</style>
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
		<c:if test="${tableName != null}">
			<a href="javascript:void(0);" class="btn btn-success" id="show-create-table" data-request-url="${basePath}/json/common/showCreateTable.json" data="${tableName}">
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
<table class="table table-striped" id="all-table-info" data-table-name="${tableName}">
	<c:if test="${!records.isEmpty()}">
		<caption>
			<span class="badge badge-add">${tableName}</span>
		</caption>
		<thead>
			<tr>
				<c:forEach items="${records.get(0).getFields()}" var="field">
					<td align="center" style="min-width:80px;">
						${field.getFieldName()}
						<p>
							<span class="glyphicon glyphicon-hand-up"></span>
							<span class="glyphicon glyphicon-hand-down"></span>
						</p>
					</td>
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