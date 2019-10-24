<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>学分列表管理</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
        $(document).ready(function () {

        });

        function page(n, s) {
            $("#pageNo").val(n);
            $("#pageSize").val(s);
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/student/demoScore/">学分列表列表</a></li>
    <shiro:hasPermission name="student:demoScore:edit">
        <li><a href="${ctx}/student/demoScore/form">学分列表添加</a></li>
    </shiro:hasPermission>
</ul>
<form:form id="searchForm" modelAttribute="demoScore" action="${ctx}/student/demoScore/list2" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li><label>学生姓名：</label>
            <form:input path="demoStudent.username" htmlEscape="false" maxlength="255" class="input-medium"/>
        </li>
        <li><label>科目名称：</label>
            <form:input path="demoSubject.subjectName" htmlEscape="false" maxlength="64" class="input-medium"/>
        </li>
        <li><label>分值范围：</label>
            <form:input path="scoreStart" htmlEscape="false" maxlength="64" class="input-medium"/>
            -
            <form:input path="scoreEnd" htmlEscape="false" maxlength="64" class="input-medium"/>
        </li>


        <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
        <li class="clearfix"></li>
    </ul>
</form:form>
<sys:message content="${message}"/>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th>学生姓名</th>
        <th>科目名称</th>
        <th>分数</th>
        <th>更新时间</th>
        <th>备注信息</th>
        <shiro:hasPermission name="student:demoScore:edit">
            <th>操作</th>
        </shiro:hasPermission>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="demoScore">
        <tr>
            <td><a href="${ctx}/student/demoScore/form?id=${demoScore.id}">
                    ${demoScore.studentName}
            </a></td>
            <td>
                    ${demoScore.subjectName}
            </td>
            <td>
                    ${demoScore.score}
            </td>
            <td>
                <fmt:formatDate value="${demoScore.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <td>
                    ${demoScore.remarks}
            </td>
            <shiro:hasPermission name="student:demoScore:edit">
                <td>
                    <a href="${ctx}/student/demoScore/form?id=${demoScore.id}">修改</a>
                    <a href="${ctx}/student/demoScore/delete?id=${demoScore.id}"
                       onclick="return confirmx('确认要删除该学分列表吗？', this.href)">删除</a>
                </td>
            </shiro:hasPermission>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>