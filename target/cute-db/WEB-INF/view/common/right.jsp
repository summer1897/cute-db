<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="./common.jsp" />
<style type="text/css">
	.table-info-style{
		padding: 10px;
		background-color: #5FB878;
	}
</style>
<script type="text/javascript">
	$(function () {
		$('#show-create-table').on('click',function () {
			var tableName = $(this).attr('data');
			var _this = $(this);
			$.ajax({
				type : 'get',
				url : '${basePath}/common/showCreateTable.html',
				data : {'tableName' : tableName},
				dataType : 'json',
				success : function(data){
//					alert(data);
//					alert(data);
					//html = "<div class='alert alert-success'>"+data+"</div>";
					var html = "<div class='table-info-style'>";
					for(var i = 0; i < data.length; ++i)
						html += "<span>"+data[i]+"</span><br>";
					html += "</div>";
					//$(".table-info-style").html(html);
					layer.open({
						//area : ['600px','800px'],
						type: 1,
						shade: false,
						title: false, //不显示标题
						content: html, //捕获的元素
						cancel: function(index){
							layer.close(index);
							this.content.show();
							//layer.msg('捕获就是从页面已经存在的元素上，包裹layer的结构', {time: 5000, icon:6});
						}
					});
				}
			});
		});
	});
</script>

<!-- /input-group -->
<div class="row">
	<div class="col-sm-9">
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
			<!-- /btn-group -->
			<input type="text" class="form-control" aria-label="...">
			<span class="input-group-btn">
				<button class="btn btn-success" type="button">
					<span class="glyphicon glyphicon-search"></span>
					Go
				</button>
			</span>
		</div>
	</div>
	<div class="col-sm-3">
		<a href="javascript:void" class="btn btn-success" id="show-create-table" data="${tableName}">
			<span class="glyphicon glyphicon-list"></span>
			查看表结构
		</a>
	</div>
</div>
<table class="table table-striped">
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