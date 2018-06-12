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
    	
    	 $("#tt").datagrid(
     		    {
     		    	url:"wine/WineAction!searchWine.action",
     		    	queryParams:{
     		    		searchKind:name,
     		    		searchValue:value
     		    	}
     		    }
        ); 
        //alert(value+":"+name)
    }
</script>
<body>
	
<input id="ss" class="easyui-searchbox" style="width:300px"
        data-options="searcher:submit,prompt:'Please Input Value',menu:'#mm'"></input>
        
<div id="mm" style="width:120px">
    <div data-options="name:'kind',iconCls:'icon-ok'">种类搜索</div>
    <div data-options="name:'name'">名字搜索</div>
</div>

	
	<table id="tt" class="easyui-datagrid" style="width:100%;height:400px"

		title="搜索商品" iconCls="icon-save"
		rownumbers="true" pagination="true">
	<thead>
		<tr>
			<th field="wine_id" width="80">编号</th>
			<th field="wine_name" width="120">酒名</th>
			<th field="kind" width="120" align="right">种类</th>
			<th field="price" width="120" align="right">价格</th>
			<th field="detail" width="100">简介</th>
			<th field="picture" width="80" align="center">照片</th>
			<th field="picture4" width="80" align="center">更多照片</th>
		</tr>
	</thead>
</table>
	
</body>
</html>
<script type="text/javascript">
		$(document).ready(function(){
			$('#tt').datagrid({
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
				var pager = $('#tt').datagrid().datagrid('getPager');	// get the pager of datagrid
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
							var n=$("#tt").datagrid('getSelected');
							var i=$('#tt').datagrid('getRowIndex', $("#dg").datagrid('getSelected'));
							if(n==null){
								$.messager.alert('温馨提示','必须选中要删除的行才能删除!','error');
							}else
							{
								$.messager.confirm('确认信息', '确认删除编号为:'+n.wine_id+'的酒信息吗?', function(r){
									if (r){
										$.get("admin/WineAction!deleteWineInfoByWineId.action?id="+n.wine_id,function(data){
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