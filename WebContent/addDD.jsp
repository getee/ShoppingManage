<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	

    <title>订单添加</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="themes/icon.css">
    <link rel="stylesheet" type="text/css" href="css/demo.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>

	<body style="margin: 0px; padding: 5px;">

	<table id="dg" style="width:100%;height:300px" class="easyui-datagrid" fitColumns="true" fit="true"
			data-options="rownumbers:true,pagination:true,url:'DingDanAction!listDeliveryByPage.action',method:'get',toolbar:'#tb',footer:'#ft'">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'user_id',width:170,align:'center'">用户ID</th>
				<th data-options="field:'dd_id',width:170,align:'center'">订单ID</th>
				<th data-options="field:'wine_id',width:170,align:'center'">商品号</th>
				<th data-options="field:'number',width:170,align:'center'">数量</th>
				<th data-options="field:'prices',width:170,align:'center'">价格</th>
				<th data-options="field:'state',width:170,align:'center'">状态</th>
			</tr>
		</thead>
	</table>
	
	<!-- 这是上面选择框的设计 -->
	<div id="tb" style="padding:2px 5px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newDingDan()">添加订单</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editDingDan()">修改订单</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteDingDan()">删除订单</a>
	</div>

	<div id="dlg" class="easyui-dialog" style="width:400px;height:300px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <form id="fm" method="post">
        	<table cellspacing="10px;">
        		<tr>
        			<td>user_id(用户ID)</td>
        			<td><input name="user_id" class="easyui-validatebox" required="true" style="width: 100px;"></td>
        		</tr>
            <tr>
        			<td>dd_id(订单ID)</td>
        			<td><input name="dd_id" class="easyui-validatebox" required="true" style="width: 100px;"></td>
        		</tr>
        		<tr>
        			<td>wine_id(商品号)</td>
        			<td><input name="wine_id" class="easyui-validatebox"  required="true" style="width: 100px;"></td>
        		</tr>
        		<tr>
        			<td>number(数量)</td>
        			<td><input name="number" class="easyui-validatebox" required="true" style="width: 100px;"></td>
        		</tr>
        		<tr>
        			<td>price(价格)</td>
        			<td><input name="prices" class="easyui-validatebox" required="true" style="width: 100px;"></td>
        		</tr>
        		<tr>
        			<td>status(商品状态)</td>
        			<td><input name="state" class="easyui-validatebox" required="true" style="width: 100px;"></td>
        		</tr>
        	</table>
        </form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveDD()">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">关闭</a>
	</div>

<script type="text/javascript">
	var url;
	function deleteDingDan(){
		var row=$('#dg').datagrid('getSelected');
		if(row){
			$.messager.confirm("系统提示","您确定要删除这条记录吗?",function(r){
				if(r){
					$.post('DingDanAction!delDD.action',{delId:row.dd_id},function(r){
						if(r.result=="true"){
							$.messager.alert("系统提示","已成功删除这条记录!");
							$("#dg").datagrid("reload");
						}else{
							$.messager.alert("系统提示",result.errorMsg);
						}
					},'json');
				}
			});
		}
	}
	//添加新的订单
	function newDingDan(){
		$("#dlg").dialog('open').dialog('setTitle','添加订单');
		$('#fm').form('clear');
		url='DingDanAction!addDD.action';
	}

	
	//保存
	function saveDD(){
		$('#fm').form('submit',{
			url:url,
			onSubmit:function(){
				return $(this).form('validate');
			},
			success:function(result){
				var result=eval('('+result+')');
				if(result.errorMsg){
					$.messager.alert("系统提示",result.errorMsg);
					return;
				}else{
					$.messager.alert("系统提示","保存成功");
					$('#dlg').dialog('close');
					$("#dg").datagrid("reload");
				}
			}
		});
	}
	
	$(function(){
		var pager = $('#dg').datagrid().datagrid('getPager');	//得到页码
	})
		
</script>
	
	</body>
</html>

