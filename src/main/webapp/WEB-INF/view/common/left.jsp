<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="./common.jsp"/>
<div style="height:100%;">
	<ul class="list-group">
		<c:if test="${!tables.isEmpty()}">
			<li class="list-group-item">
				<div class="input-group">
  					<span class="input-group-addon">
  						<span class="glyphicon glyphicon-search"></span>
  					</span>
  					<input type="text" class="form-control" placeholder="please input table name" name="tableName" >
				</div>
			</li>
			<c:forEach items="${tables}" var="table">
		  		<li class="list-group-item">
		  			<a href="javascript:void;" data-request-url="${basePath}/right.html?tableName=${table}" data-asyn-load="true" target="#table-info">${table}</a>
		  		</li>
			</c:forEach>
		</c:if>
	</ul>	
</div>