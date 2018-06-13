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
<title>搜索评论</title>
</head>
<body style="margin: 0px;padding: 5px;">

	<input class="easyui-searchbox" data-options="prompt:' 请输入要搜索的内容 ',menu:'#mm',searcher:doSearch" style="width:300px"></input>
	<div id="mm">
		<div data-options="name:'user_id'">用户id</div>
		<div data-options="name:'wine_id'">商品id</div>
	    <div data-options="name:'state'">评论等级</div>
		
	</div>
	
	  <table class="easyui-datagrid" style="width: 100%;height: 450px"  id="aaa"
        data-options="singleSelect:true,collapsible:true,method:'get'">
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
     function doSearch(value,name){
    	   var url1="CommentAction!searchCommentByCondition.action?key="+name+"&val="+value;    	
           $("#aaa").datagrid(
        		    {
        		    	url:"CommentAction!searchCommentByCondition.action",
        		    	queryParams:{
        		    		key:name,
        		    		val:value
        		    		}
        		    }
           );        
}
</script>
    
</body>
</html>