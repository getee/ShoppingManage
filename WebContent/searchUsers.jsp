<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="${pageContext.request.scheme }://${pageContext.request.serverName}:${pageContext.request.serverPort}/ShoppingManage/">
	
  <link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="themes/icon.css">
    <link rel="stylesheet" type="text/css" href="css/demo.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<title>搜索用户</title>
</head>
<body>
<div style="margin:20px 0;"></div>
	<input class="easyui-searchbox" data-options="prompt:' 请输入要搜索的内容 ',menu:'#mm',searcher:doSearch" style="width:300px"></input>
	<div id="mm">
		<div data-options="name:'userid'">用户id</div>
		<div data-options="name:'username'">用户名</div>
	    <div data-options="name:'province'">地区</div>
		<div data-options="name:'phone'">电话</div>
       
	</div>
    <!--   <div class="easyui-panel" style="width:100%;max-width:400px;padding:30px 60px;">
		<input class="easyui-searchbox" data-options="prompt:'请输入您要搜索的用户名',searcher:doSearch" style="width:100%">
	</div> -->
	
	  <table class="easyui-datagrid" style="width: 74%;height: 450px;margin: 5px"  id="aaa"
        data-options="singleSelect:true,collapsible:true,url:url1,method:'get'">
           <thead>
            <tr>
                    <th data-options="field:'userid',width:60,align:'left'">用户编号</th>
                    <th data-options="field:'username',width:100,align:'left'">用户名称</th>
                    <th data-options="field:'province',width:150,align:'left'">省份</th>
                    <th data-options="field:'city',width:100,align:'left'">城市</th>
                    <th data-options="field:'phone',width:100,align:'left'">电话</th>
                    <th data-options="field:'picture',width:150,align:'left'">头像</th>
            </tr>
            </thead>
        </table>
        	
<script type="text/javascript">
     function doSearch(value,name){
    	 var url1="'UserAction!searchUsers.action?&page=1&count=3&key='+name+'&val='+value";
         $("#aaa").datagrid("data-options",{url:url1});
	     //$("#mm").datagrid("data-options",{iconCls:'icon-ok'});
	  
	   //var Url="UserAction!searchUsers.action?&page=1&count=3&key=name&val=value";
	alert('You input: ' + value+'('+name+')');
}</script>
    
</body>
</html>