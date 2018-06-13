<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="${pageContext.request.scheme }://${pageContext.request.serverName}:${pageContext.request.serverPort}/ShoppingManage/">
	<title>登录界面</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="themes/icon.css">
    <link rel="stylesheet" type="text/css" href="css/demo.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    
</head>
<body>
<canvas id="c_n9" width="1920" height="990" style="position: fixed; top: 0px; left: 0px; z-index: -1; opacity: 0.5;"></canvas>
<script src="js/bg66.js"></script>
<div style="width: 400px;margin: auto;margin-top: 100px;">
        <div class="easyui-panel" title="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;商城后台管理系统"  region="center" style="width:400px;max-width:400px;padding:30px 60px;margin: auto">
    
        <form id="ff" method="post" action="UserAction!login.action">
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" name="u.name" style="width:100%" data-options="label:'账户:',required:true">
            </div>
            <div style="margin-bottom:20px">
                <input class="easyui-passwordbox" name="u.password"  style="width:100%" data-options="label:'密码:',required:true">
            </div>
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" name="code"  maxlength="4" style="width:60%" data-options="label:'验证码:'">
               <!--  <img id="code" src="admin/CodeAction.action" style="width: 90px;height: 30px;position: relative;top: 11px;margin-left: 10px;" /> -->
               </div>
        </form>
        <div style="text-align:center;padding:5px 0">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">登陆</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">清空</a>
        </div>
    </div>
</div>
<script>
	function submitForm(){
	    $('#ff').submit();
	}
	function clearForm(){
	    $('#ff').form('clear');
	}
	$(document).ready(function(){
	    $('#dlg').dialog('close');//网页一打开让提示框消失

	    $("#code").click(function(){
	    //   $(this).attr("src","admin/CodeAction.action?time="+new Date())
	    })
	    
	})
</script>
</body>
</html>