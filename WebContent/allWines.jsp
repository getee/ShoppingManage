<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Basic DataGrid - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>

<body style="margin: 0px;padding: 5px;">
	<table id="dg" title="用户列表" style="width:100%;height:400px;margin: 0px;"
			data-options="rownumbers:true,singleSelect:true,pagination:true,url:'wine/WineAction!listWinesByPage.action',method:'get'">
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
	<script type="text/javascript">
		$(document).ready(function(){
			$('#dg').datagrid({
				onClickCell: function(index,field,value){
					if(field=='picture'){
						imageDetail(value);
					}else if(field=='picture4'){
						value=value.replace("/>","controls='controls' />");
						imageDetail(value);
					}
				}
			});
			
			$('#w').window('close')
			
			
			$(function(){
				var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
				pager.pagination({
					buttons:[{
						iconCls:'icon-search',
						handler:function(){
							alert('search');
						}
					},{
						iconCls:'icon-edit',
						handler:function(){
							alert('edit');
						}
					},{
						iconCls:'icon-remove',
						handler:function(){
							var n=$("#dg").datagrid('getSelected');
							var i=$('#dg').datagrid('getRowIndex', $("#dg").datagrid('getSelected'));
							if(n==null){
								$.messager.alert('温馨提示','必须选中要删除的行才能删除!','error');
							}else
							{
								$.messager.confirm('确认信息', '确认删除编号为:'+n.wine_id+'的酒信息吗?', function(r){
									if (r){
										$.get("wine/WineAction!deleteWineInfoByWineId.action?id="+n.wine_id,function(data){
												var noticeMessage='删除失败!';
												if(data==true){
													noticeMessage='删除成功!'
													$("#dg").datagrid('deleteRow',i)
												    $('#t1').datagrid('reload');  
													//alert(noticeMessage);
												}
												$.messager.show({
													title:'操作提示',
													msg:noticeMessage,
													timeout:2000,
													showType:'slide'
												});
												
												
										})
									}
								});
							}s						}
					},{
						iconCls:'icon-add',
						handler:function(){
							alert('add');
						}
					}]
				});			
			})
			
			
		})
		
		function imageDetail(src){
			src=src.replace("20px","100%");
			src=src.replace("20px","100%");
			$("#w").html(src);
			$('#w').window('open');
		}
	</script>
	<!-- 用来显示照片详情的window -->
	<div id="w" class="easyui-window" title="酒详情" data-options="iconCls:'icon-large-picture',modal:true,minimizable:false" style="width:600px;height:400px;padding:10px;">
	</div>


</body>
</html>