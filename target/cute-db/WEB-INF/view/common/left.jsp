<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${basePath}/asserts/js/common.js"></script>
<script type="text/javascript">
	$(function(){
		$("#table-name").keyup(function(){
			var tableName = $(this).val();
			$.ajax({
				type : 'get',
				url : '${basePath}/common/queryTablesMatchesName.html',
				data : {'tableName' : tableName},
				dataType : 'json',
				success : function (data) {
//					alert(data);
					var html = "";
					for(var i = 0; i < data.length; ++i){
						html += "<li class='list-item'>" +
								"<a href='javascript:void' data-request-url='${basePath}/common/right.html?tableName="+data[i]+"'" +
								"data-asyn-load='true' target='#table-info'>" + data[i] + "</a></li>";
					}
					$('#tables-list').html(html);
				}
			});
		});
	});
</script>
<c:if test="${!tables.isEmpty()}">
	<div class="input-group search-box">
		<span class="input-group-addon">
			<span class="glyphicon glyphicon-search"></span>
		</span>
		<input type="text" class="form-control" id="table-name" placeholder="please input table name" name="tableName" >
	</div>
	<ul class="aside-menu" id="tables-list">
		<c:forEach items="${tables}" var="table">
			<li class="list-item">
				<a href="javascript:void;" data-request-url="${basePath}/common/right.html?tableName=${table}" data-asyn-load="true" target="#table-info">${table}</a>
			</li>
		</c:forEach>
	</ul>
</c:if>
