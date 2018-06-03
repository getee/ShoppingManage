<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- 	<base href="${pageContext.request.scheme }://${pageContext.request.serverName}:${pageContext.request.serverPort}/ShoppingManage/">
 --%>	
    <title>订单添加</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="themes/icon.css">
    <link rel="stylesheet" type="text/css" href="css/demo.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>

<div class="easyui-layout" style="width:100%;height:700px;">
<div data-options="region:'center',iconCls:'icon-ok'">
			<table class="easyui-datagrid"
					data-options="url:'datagrid_data1.json',method:'get',border:false,singleSelect:true,fit:true,fitColumns:true">
				<thead>
					<tr>
						<th data-options="field:'itemid',align:'center'" width="16%">订单编号</th>
						<th data-options="field:'productid',align:'center'" width="16%">用户编号 </th>
						<th data-options="field:'listprice',align:'center'" width="16%">商品编号</th>
						<th data-options="field:'unitcost',align:'center'" width="16%">数量</th>
						<th data-options="field:'attr1',align:'center'" width="18%">总价格</th>
						<th data-options="field:'status',align:'center'" width="18%">商品状态</th>
					</tr>
				</thead>
			</table>
		</div>
		</div>
</div>
</body>
</html>