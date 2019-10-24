<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>学分列表管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/student/demoScore/">学分列表列表</a></li>
		<li class="active"><a href="${ctx}/student/demoScore/form?id=${demoScore.id}">学分列表<shiro:hasPermission name="student:demoScore:edit">${not empty demoScore.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="student:demoScore:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="demoScore" action="${ctx}/student/demoScore/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">学生信息：</label>
			<div class="controls">
				<sys:treeselect id="demoStudent" name="demoStudent.id" value="${demoScore.demoStudent.id}" labelName="demoStudent.username" labelValue="${demoScore.demoStudent.username}"
								title="学生" url="/student/demoStudent/treeData" cssClass="input-small required" allowClear="true"/>

				<%--<form:input path="studentId" htmlEscape="false" maxlength="64" class="input-xlarge "/>--%>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">科目信息：</label>
			<div class="controls">
				<sys:treeselect id="demoSubject" name="demoSubject.id" value="${demoScore.demoSubject.id}" labelName="demoSubject.subjectName" labelValue="${demoScore.demoSubject.subjectName}"
								title="科目" url="/student/demoSubject/treeData" cssClass="input-small required" allowClear="true"/>

			<%--<form:input path="subjectId" htmlEscape="false" maxlength="64" class="input-xlarge "/>--%>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">分数：</label>
			<div class="controls">
				<form:input path="score" htmlEscape="false" class="input-xlarge required" text="number"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="student:demoScore:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>