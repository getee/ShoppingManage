<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="${pageContext.request.scheme }://${pageContext.request.serverName}:${pageContext.request.serverPort}/ShoppingManage/">
	<title>管理首页</title>
    <link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="themes/icon.css">
    <link rel="stylesheet" type="text/css" href="css/demo.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>
<div class="easyui-layout" style="width:100%;height:700px;">
        <div data-options="region:'north'" style="height:80px; margin: auto; padding:auto">
                <h1>后台管理系统</h1>
        </div>
        <div data-options="region:'south',split:true" style="height:50px;">
        <a href="#">前台网站</a>
        </div>
        <div data-options="region:'west',split:true" title="系统菜单" style="width:200px;">
            <ul class="easyui-tree"  id="sysmenu">
                <li>
                    <span>所有功能</span>
                    <ul>
                        <li>
                            <span>用户管理</span>
                            <ul>
                                <li>
                                    <span>用户添加</span><!-- 以及上传头像 -->
                                </li>
                                <li>
                                    <span>所有用户</span><!-- 显示小头像 -->
                                </li>
                                <li>
                                    <span>搜索用户</span><!-- 存在显示用户购物车按钮 -->
                                </li>
                                <li>
                                    <span>修改用户</span><!-- 可修改用户收货地省市级联，头像 -->
                                </li>
                            </ul>
                        </li>
                        <li data-options="state:'closed'">
                            <span>商品管理</span>
                            <ul>
                                <li>
                                    <span>商品添加</span><!-- 图片名0-9.jpg -->
                                </li>
                                <li>
                                    <span>所有商品</span><!-- 显示一张小图，其余4张在商品详情 -->
                                </li>
                                <li>
                                    <span>搜索商品</span><!-- 搜索被多少用户添加购物车 -->
                                </li>
                                <li>
                                    <span>修改商品</span><!-- 修改图片，对用户购物车同时修改 -->
                                </li>
                                <li>
                                    <span>删除商品</span><!-- 对用户购物车同时删除 -->
                                </li>
                            </ul>
                        </li>
                        <li data-options="state:'closed'">
                            <span>订单管理</span>
                            <ul>
                                <li>
                                    <span>订单添加</span><!-- 用户id,酒id,数量，状态：发货 -->
                                </li>
                                <li>
                                    <span>搜索订单</span><!-- 按用户，按商品 -->
                                </li>
                                <li>
                                    <span>修改订单</span>
                                </li>
                                <li>
                                    <span>删除订单</span>
                                </li>
                            </ul>
                        </li>
                        <li data-options="state:'closed'">
                            <span>评论管理</span>
                            <ul>
                                <li>
                                    <span>评论添加</span><!-- 酒id,用户id，状态：好坏评，内容 -->
                                </li>
                                <li>
                                    <span>搜索评论</span><!-- 按用户，按商品，有分页 -->
                                </li>
                                <li>
                                    <span>删除评论</span>
                                </li>
                            </ul>
                        </li>
                        <li>系统公告</li>
                    </ul>
                </li>
            </ul>
                
        
        
        </div>
        <div data-options="region:'center',iconCls:'icon-ok'">
                <div id="tt" class="easyui-tabs" data-options="tools:'#tab-tools'" style="width:100%;height:100%">
                        <div title="系统消息" style="padding:10px">
                            <p style="font-size:14px">jQuery EasyUI framework helps you build your web pages easily.</p>
                            <ul>
                                <li>easyui is a collection of user-interface plugin based on jQuery.</li>
                                <li>easyui provides essential functionality for building modem, interactive, javascript applications.</li>
                                <li>using easyui you don't need to write many javascript code, you usually defines user-interface by writing some HTML markup.</li>
                                <li>complete framework for HTML5 web page.</li>
                                <li>easyui save your time and scales while developing your products.</li>
                                <li>easyui is very easy but powerful.</li>
                            </ul>
                        </div>
                                        
                </div>
        </div>
    </div>
<script type="text/javascript">
//用easyui的事件注入方法来对菜单上所有操作菜单添加功能
$('#sysmenu').tree({
    onClick: function(node){
        if(node.text=='所有用户')
        {
            addPanel(node.text,'allUsers.jsp');
        }else if(node.text=='用户添加'){
            addPanel(node.text,'addUsers.jsp');
        }else if(node.text=='搜索用户'){
        	addPanel(node.text,'searchUsers.jsp');
        }else if(node.text=='修改用户'){
        	addPanel(node.text,'editUsers.jsp');
        }else if(node.text=='商品添加'){
        	addPanel(node.text,'addWines.jsp');
        }else if(node.text=='所有商品'){
        	addPanel(node.text,'allWines.jsp');
        }else if(node.text=='搜索商品'){
        	addPanel(node.text,'searchWines.jsp');
        }else if(node.text=='修改商品'){
        	addPanel(node.text,'editWines.jsp');
        }else if(node.text=='删除商品'){
            addPanel(node.text,'delWines.jsp');
        }else if(node.text=='订单添加'){
            addPanel(node.text,'addDD.jsp');
        }else if(node.text=='搜索订单'){
            addPanel(node.text,'searchDD.jsp');
        }else if(node.text=='修改订单'){
            addPanel(node.text,'editDD.jsp');
        }else if(node.text=='删除订单'){
            addPanel(node.text,'delDD.jsp');
        }else if(node.text=='评论添加'){
            addPanel(node.text,'addComment.jsp');
        }else if(node.text=='搜索评论'){
            addPanel(node.text,'searchComment.jsp');
        }else if(node.text=='删除评论'){
            addPanel(node.text,'delComment.jsp');
        }else if(node.text=='系统公告'){
        	addPanel(node.text,'about.jsp');
        }
        //alert(node.text);  // alert node text property when clicked
    }
});
</script>


<!-- 这里是动态管理选项卡的js函数 -->

<script type="text/javascript">
        var index = 1;
        function addPanel(title,url){
            index++;
            if ($('#tt').tabs('exists', title)){
                $('#tt').tabs('select', title);
            } else {
                var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
                $('#tt').tabs('add',{
                    title:title,
                    content:content,
                    closable:true
                });
            }
            
        }
        function removePanel(){
            var tab = $('#tt').tabs('getSelected');
            if (tab){
                var index = $('#tt').tabs('getTabIndex', tab);
                $('#tt').tabs('close', index);
            }
        }
    </script>
</body>
</html>