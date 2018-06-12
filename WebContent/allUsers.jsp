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
<title>所有用户</title>
</head>
<body>
       <table id="tt" class="easyui-datagrid" style="width: 74%;height: 450px;margin: 5px"  
        data-options="
          
				                singleSelect: true,
				                pagination:true,
                                url:'UserAction!listUser.action?count=2&page=1',
                              ">
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
   var pager = $('#tt').datagrid('getPager');   
	pager.pagination({
		showPageList:false,
		
		onBeforeRefresh:function(){
			alert('before refresh');
			return true;
		}
	});
   </script>
   
</body>
</html>