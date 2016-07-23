<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${basePath}/asserts/js/common.js"></script>
<script type="text/javascript" src="${basePath}/asserts/js/left.js"></script>
<c:if test="${!tables.isEmpty()}">
	<div class="input-group search-box">
		<span class="input-group-addon">
			<span class="glyphicon glyphicon-search"></span>
		</span>
		<input type="text" class="form-control" id="table-name" data-request-url="${basePath}/json/common/queryTablesMatchesName.json" placeholder="please input table name" name="tableName" >
	</div>
	<ul class="aside-menu" id="tables-list">
		<c:forEach items="${tables}" var="table">
			<li class="list-item">
				<a href="javascript:void(0);" data-request-url="${basePath}/common/right.html?tableName=${table}" data-asyn-load="true" target="#table-info">${table}</a>
			</li>
		</c:forEach>
	</ul>
</c:if>
