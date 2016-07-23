<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/common.jsp" />
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
</style>
<table class="table table-striped">
    <c:if test="${!tableNames.isEmpty()}">
        <caption>
            <c:forEach items="${tableNames}" var="tableName">
                <span class='badge badge-warning' style='margin:0px 5px;'>
                    <a href="javascript:void(0);" data-action="show-create-table" data-table="${tableName}" data-request-url="${basePath}/json/common/showCreateTable.json">
                        ${tableName}
                    </a>
                </span>
            </c:forEach>
        </caption>
        <c:choose>
            <c:when test="${!fieldNames.isEmpty()}">
                <thead>
                    <tr>
                        <c:forEach items="${fieldNames}" var="fieldName">
                            <td align="center" style="min-width:80px;">
                                ${fieldName}
                                <p>
                                    <span class="glyphicon glyphicon-hand-up cursor"></span>
                                    <span class="glyphicon glyphicon-hand-down cursor"></span>
                                </p>
                            </td>
                        </c:forEach>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${dbRecords.result}" var="record">
                        <tr>
                            <c:forEach items="${record.dbFieldVoList}" var="field">
                                <td align="center">${field.value}</td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                </tbody>
            </c:when>
            <c:otherwise>
                <div class="alert alert-warning">
                    <p class="center-block">没有查询结果!</p>
                </div>
            </c:otherwise>
        </c:choose>
    </c:if>
</table>
