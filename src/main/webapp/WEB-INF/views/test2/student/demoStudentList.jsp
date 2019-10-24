<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>学生列表管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/student/demoStudent/">学生列表列表</a></li>
		<shiro:hasPermission name="student:demoStudent:edit"><li><a href="${ctx}/student/demoStudent/form">学生列表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="demoStudent" action="${ctx}/student/demoStudent/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>学生姓名：</label>
				<form:input path="username" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>班级名称：</label>
				<form:input path="className" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>性别：</label>
				<form:select path="sex" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('sex')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>班级名称</th>
				<th>学生姓名</th>
				<th>性别</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="student:demoStudent:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="demoStudent">
			<tr>
				<td><a href="${ctx}/student/demoStudent/form?id=${demoStudent.id}">
					${demoStudent.demoClass.name}
				</a></td>
				<td>
					${demoStudent.username}
				</td>
				<td>
					${fns:getDictLabel(demoStudent.sex, 'sex', '')}
				</td>
				<td>
					<fmt:formatDate value="${demoStudent.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${demoStudent.remarks}
				</td>
				<shiro:hasPermission name="student:demoStudent:edit"><td>
    				<a href="${ctx}/student/demoStudent/form?id=${demoStudent.id}">修改</a>
					<a href="${ctx}/student/demoStudent/delete?id=${demoStudent.id}" onclick="return confirmx('确认要删除该学生列表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>