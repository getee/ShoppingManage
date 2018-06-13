<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="${pageContext.request.scheme }://${pageContext.request.serverName}:${pageContext.request.serverPort}/ShoppingManage/">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="themes/icon.css">
    <link rel="stylesheet" type="text/css" href="css/demo.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>

</head>
<body>
	<input class="easyui-searchbox" data-options="prompt:'Please Input Value',searcher:doSearch" style="width:100%">
	<table id="test" class="easyui-datagrid"  style="width:100%;height:auto"
			data-options="singleSelect:true,collapsible:true,method:'get'">
		<thead>
			<tr>
				<th data-options="field:'user_id',width:150,align:'center'">用户</th>
				<th data-options="field:'dd_id',width:150,align:'center'">订单号</th>
				<th data-options="field:'wine_id',width:150,align:'center'">商品号</th>
				<th data-options="field:'number',width:150,align:'center'">总数量</th>
				<th data-options="field:'prices',width:300,align:'center'">总价</th>
				<th data-options="field:'state',width:150,align:'center'">状态</th> 
			</tr>
		</thead>
	</table>
</body>

<script>
	function doSearch(value){
	
	$('#test').datagrid({
        url: 'DingDanAction!searchDingdan.action?user_id='+value
        });
	}
</script>
</html>