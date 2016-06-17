<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul class="aside-menu">
	<c:if test="${!tables.isEmpty()}">
		<li class="list-item">
			<div class="input-group search-box">
				<span class="input-group-addon">
					<span class="glyphicon glyphicon-search"></span>
				</span>
				<input type="text" class="form-control" placeholder="please input table name" name="tableName" >
			</div>
		</li>
		<c:forEach items="${tables}" var="table">
			<li class="list-item">
				<a href="javascript:void;" data-request-url="${basePath}/common/right.html?tableName=${table}" data-asyn-load="true" target="#table-info">${table}</a>
			</li>
		</c:forEach>
	</c:if>
</ul>
