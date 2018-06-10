<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
  <%@taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	 <link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="themes/icon.css">
    <link rel="stylesheet" type="text/css" href="css/demo.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	<div style="margin:20px 0;"></div>
	<div style="width:800px;margin: auto;">
		<form id="ff" action="AddUserAction!AddUser.action" method="post">
			<div style="margin-bottom:20px;width:200px;height:400px;">
			<img alt="" src="themes/icons/moren.jpg" width=200px height=300px>
			<input type="file" name="add.picture"/>
			</div>
			<div style="width:400px;position:relative;left:300px;top:-350px;">
				<div style="margin-bottom:20px">
					<input class="easyui-textbox" name="add.name" style="width:100%" data-options="label:'用户名:',required:true">
				</div>
				<div style="margin-bottom:20px">
					<input class="easyui-passwordbox" name="add.password" style="width:100%" data-options="label:'密码:',required:true">
				</div>
				<div style="margin-bottom:20px">
					<input class="easyui-textbox" name="add.phone" style="width:100%" data-options="label:'电话:',required:true">
				</div>
				<div style="margin-bottom:20px">
					<select id="shen" class="easyui-combobox" name="add.province" label="省份:" style="width:100%">
						<option value="">请选择省份</option>
						<c:forEach var="p" items="${sessionScope.shen }">
							<option value="${p }">${p }</option>
						</c:forEach>
					</select>
				</div>
				<div style="margin-bottom:20px">
					<select id="shi" class="easyui-combobox" name="add.city " label="城市:" style="width:100%" >
						<option value="">请选择城市</option>
					</select>
				</div>
				<div style="text-align:center;padding:5px 0">
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">Submit</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">Clear</a>
				</div>
			</div>
		</form>
		</div>
		<%-- <s:iterator  value='#session.shenshi' id='entry'>
				<s:iterator value="#entry.value" id="s">
					
					<s:property value="s"/>
				</s:iterator>
				<br>
		</s:iterator> --%>
		<script type="text/javascript">
		
			$(document).ready(function () {

				$("#shen").combobox({

				onChange: function () {
					var shen=$(this).val();
					$("#shi").html("");
					"<s:iterator  value='#session.shenshi' id='entry'>"
						if(shen=="<s:property value='key'/>"){
								/* alert("<s:property value='key'/>"); */
								
						"<s:iterator value='#entry.value' id='s'>"	
							$("#shi").append("<option value='<s:property value='s'/>'><s:property value='s'/></option>");
							
							"</s:iterator>"
							}
					"</s:iterator>"
						$("#shi").combobox({});
					
				}

				});
				});
		
		</script>
	<script>
		function submitForm(){
			$('#ff').submit();
		}
		function clearForm(){
			$('#ff').form('clear');
		}
	</script>
	<c:if test="${sessionScope.shen == null }">
	
		<script type="text/javascript">
			$(document).ready(function(){
			$.get("ProCityAction!getProCityMess.action",function(data){
				location.href="addUsers.jsp";
			});
		});
		
		</script>
	
	</c:if>



</body>
</html>