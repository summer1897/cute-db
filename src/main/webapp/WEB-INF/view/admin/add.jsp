<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<script type="text/javascript">
<!--
$(function(){
	$("#connect-test").bind('click',function(e){
		//$("#dbsource-form").
		e.preventDefault();
		var d = $("#dbsource-form").serialize();
		$.ajax({
			type : "post",
			url : "${basePath}/admin/dbsource/canConnect.html",
			data : d,
			dataType : "json",
			success : function(data){
				if(data.canConnect){
					layer.alert('连接成功!', {icon: 6});
				}
			}
		});
	});
});
//-->
</script>
<div class="" style="width:80%;margin:auto;padding-top:30px;">
	<fieldset>
		<legend>数据源添加</legend>
		<form class="form-horizontal" action="${basePath}/admin/dbsource/canConnect.html" method="post" id="dbsource-form">
			<div class="form-group">
				<label class="col-sm-2 control-label" for="dbName">数据源名称</label>
				 <div class="col-sm-10">
				 	<input type="text" name="dbName" class="form-control"/>
				 </div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="dbType">数据源类型</label>
				 <div class="col-sm-10">
				 	<select class="form-control" name="dbType">
					  <option value="MYSQL">MySQL</option>
					  <option value="ORACLE">Oracle</option>
					  <option value="DB2">DB2</option>
					  <option value="SYBASE">Sybase</option>
					  <option value="SQLServer">SQLServer</option>
					</select>
				 </div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="ip">IP地址</label>
				 <div class="col-sm-10">
				 	<input type="text" name="host" class="form-control"/>
				 </div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="port">端口</label>
				 <div class="col-sm-10">
				 	<input type="number" name="port" class="form-control"/>
				 </div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="user">用户名</label>
				 <div class="col-sm-10">
				 	<input type="text" name="user" class="form-control"/>
				 </div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="password">密码</label>
				 <div class="col-sm-10">
				 	<input type="password" name="password" class="form-control"/>
				 </div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="useUnicode">统一编码</label>
				 <div class="col-sm-10">
				 	<select class="form-control" name="useUnicode">
					  <option value="true" selected="selected">true</option>
					  <option value="false">false</option>
					</select>
				 </div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="charset">编码</label>
				 <div class="col-sm-10">
				 	<select class="form-control" name="charset">
					  <option value="utf-8" selected="selected">UTF-8</option>
					  <option value="GBK">GBK</option>
					  <option value="GB2312">GB2312</option>
					  <option value="GB8000">GB8000</option>
					  <option value="UNICODE">Unicode</option>
					  <option value="ISO-8859-1">ISO-8859-1</option>
					</select>
				 </div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-3">
					<button type="submit" class="btn btn-sm btn-info">
						<span class="glyphicon glyphicon-plus"></span>
						添加
					</button>
					<button class="btn btn-sm btn-success" id="connect-test">
						<span class="glyphicon glyphicon-transfer"></span>
						连接测试
					</button>
				</div>
			</div>
		</form>
	<!-- form-end -->
	</fieldset>
</div>
