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
     <div id="tb" style="padding:5px;height:auto;margin: 5px" >
	    <div style="margin-bottom:5px">
		<a href="addUsers.jsp" class="easyui-linkbutton"   iconCls="icon-add" plain="true"></a>
		<a href=""   class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="tb"></a>
	    <a href="searchUsers.jsp" class="easyui-linkbutton" iconCls="icon-search">搜索</a> 
		<a href="" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>
	     </div>
	</div>
	
      <table id="ttt" class="easyui-datagrid" style="width: 100%;height: 450px;margin: 5px"  title="用户列表"
                                singleSelect="true"
                                collapsible="true"
                                fitColumns="true"//自动适应宽度 
                                autoRowHeight:="true"//自动行高度  
                                url="UserAction!listUser.action?count=50&page=1"
                                toolbar="#tb"
                              >
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

</div>
<!-- <div id="aa" class="easyui-accordion" style="width:300px;height:200px;">
    <div title="基本资料" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">
		
    </div>
    <div title="头像" data-options="iconCls:'icon-reload'," style="padding:10px;">
		
    </div>
    
</div> -->
 <script type="text/javascript">
       var row = $('#ttt').datagrid('getSelected');
       if (row){
    	   alert(row.userid);
    	   $("#tb").datagrid(
       		    {
       		    	herf:"editUsers.jsp",
       		    	queryParams:{
       		    		userid:row.userid,
       		    		username:row.username,
       		    		province:row.province,
       		    		city:row.city,
       		    		phone:row.phone,
       		    		picture:row.picture
       		    	   }
       		    	}
           ); 
        } 
</script>
</body>
</html>