<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="${pageContext.request.scheme }://${pageContext.request.serverName}:${pageContext.request.serverPort}/ShoppingManage/">
<title>查看评论</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="themes/icon.css">
    <link rel="stylesheet" type="text/css" href="css/demo.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body style="margin: 0px;padding: 5px;">
	<table id="dg" class="easyui-datagrid"  style="width:100%;height:400px;margin: 5px;"
		data-options="rownumbers:true,pagination:true,url:'CommentAction!scanComment.action',method:'get',toolbar:'#tb',footer:'#ft'">
		<thead>
			<tr>
				<th data-options="field:'com_id',width:100,align:'left'">评论ID</th>
				<th data-options="field:'user_id',width:100,align:'left'">用户ID</th>
				<th data-options="field:'wine_id',width:100,align:'left'">商品ID</th>				
				<th data-options="field:'state',width:100,align:'left'">评论等级</th>
				<th data-options="field:'content',width:200,align:'left'">评论详情</th>
			</tr>
		</thead>		
	</table>
<script type="text/javascript">
	function submitForm(){
		$('#ff').submit();
	}
	function clearForm(){
		$('#ff').form('clear');
	}
 		
	$("#w").window("close");
	 $(function(){
			var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
			pager.pagination({
				buttons:[{
					iconCls:'icon-search',
					handler:function(){
						$("#w").panel({'title':'搜索评论','width':600,'height':400});
						$("#w").html('<iframe scrolling="auto" frameborder="0"  src="searchComment.jsp" style="width:100%;height:100%;"></iframe>');
						$("#w").window("open");
					}
				},{
					iconCls:'icon-remove',
					handler:function(){
						var com=$("#dg").datagrid('getSelected');
						var i=$('#dg').datagrid('getRowIndex', $("#dg").datagrid('getSelected'));
						if(com==null){
							$.messager.alert('温馨提示','必须选中要删除的行才能删除!','error');
						}else
						{
							$.messager.confirm('确认信息', '确认删除编号为:'+com.com_id+'的评论信息吗?', function(r){
								if (r){			
									$.get("CommentAction!deleteCommentByComid.action?com.com_id="+com.com_id,function(data){
										
											var noticeMessage='删除失败!';
											if(data==true){
												noticeMessage='删除成功!'
												$("#dg").datagrid('deleteRow',i)
											    $('#t1').datagrid('reload');  								
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
						}
					} 
				},{
					iconCls:'icon-add',
					handler:function(){
						$("#w").panel({'title':'添加评论','width':600,'height':400});
						$("#w").html('<iframe scrolling="auto" frameborder="0"  src="addComment.jsp" style="width:100%;height:100%;"></iframe>');
						$("#w").window("open");
					}
				}]
			});			
		})
		
		

	
</script>
<div id="w" class="easyui-window" closed="true" style="width:600px;height:400px;padding:10px">
</div>
</body>
</html>
