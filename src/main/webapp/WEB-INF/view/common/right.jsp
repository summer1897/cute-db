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
</style>
<!-- /input-group -->
<table class="table table-striped" id="all-table-info" data-table-name="${tableName}">
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