<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="${pageContext.request.scheme }://${pageContext.request.serverName}:${pageContext.request.serverPort}/ShoppingManage/">
<title>添加评论</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="themes/icon.css">
    <link rel="stylesheet" type="text/css" href="css/demo.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body style="margin: 0px;padding: 5px;">
	 <div class="easyui-panel" style="width:600px;max-width:100%;padding:30px 60px;">
			<form id="ff" method="post" action="CommentAction!addComment.action">				
				<div style="margin-bottom:20px">
					<input class="easyui-textbox" name="com.user_id" style="width:300px" data-options="label:'用户ID:',required:true">					
				</div>
				<div style="margin-bottom:20px">
					<input class="easyui-textbox" name="com.wine_id" style="width:300px" data-options="label:'商品ID:',required:true">
				</div>
				<div style="margin-bottom:20px">
					<input class="easyui-textbox" name="com.state" style="width:300px" data-options="label:'评论状态:',required:true">
					
				</div>
				<div style="margin-bottom:20px">
					<input class="easyui-textbox" name="com.content" style="width:300px;height:60px" data-options="label:'评论详情:',multiline:true">
				</div>
			</form>
			<div style="padding:5px 0;left: 200px">
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px;position: absolute;left:140px">提交</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px;position: absolute;left:260px">重置</a>
			</div>
	</div>
	<c:if test="${requestScope.result!=null }">
	<c:choose>
		<c:when test="${requestScope.result==true }">
			<script type="text/javascript">
			$.messager.alert('提示','添加成功!','info');
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
			$.messager.alert('提示','添加失败!','error');
			</script>
		</c:otherwise>
	</c:choose>
	</c:if>
		<script>
		
			function submitForm(){
				$('#ff').submit();
			}
			function clearForm(){
				$('#ff').form('clear');
			}
	
		</script>

</body>
</html>
