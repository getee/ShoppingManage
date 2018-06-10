<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="themes/icon.css">
    <link rel="stylesheet" type="text/css" href="css/demo.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<script type="text/javascript">
    function submit(value,name){
    	$.get("wine/WineAction!searchWine.action?searchValue="+value+"&searchKind="+name+"")
        alert(value+":"+name)
    }
</script>
<body>
	
<input id="ss" class="easyui-searchbox" style="width:300px"
        data-options="searcher:submit,prompt:'Please Input Value',menu:'#mm'"></input>
        
<div id="mm" style="width:120px">
    <div data-options="name:'kind',iconCls:'icon-ok'">种类搜索</div>
    <div data-options="name:'name'">名字搜索</div>
</div>


	<table id="dg" title="用户列表" style="width:100%;height:400px;margin: 0px;"
			data-options="rownumbers:true,singleSelect:true,pagination:true,url:'wine/WineAction!searchWine.action',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'wine_id',width:80,align:'left'">编号</th>
				<th data-options="field:'wine_name',width:120,align:'left'">酒名</th>
				<th data-options="field:'kind',width:120,align:'left'">种类</th>
				<th data-options="field:'price',width:120,align:'left'">价格</th>
				<th data-options="field:'detail',width:100,align:'left'">简介</th>
				<th data-options="field:'picture',width:80,align:'left'">照片</th>
				<th data-options="field:'picture4',width:80,align:'left'">更多照片</th>
			</tr>
		</thead>	
	</table>

</body>
</html>