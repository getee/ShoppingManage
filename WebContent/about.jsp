<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <base href="${pageContext.request.scheme }://${pageContext.request.serverName}:${pageContext.request.serverPort}/ShoppingManage/">
	<title>系统公告</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="themes/icon.css">
    <link rel="stylesheet" type="text/css" href="css/demo.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>
<p>Click AJAX panel header to load content via AJAX.</p>
    <div style="margin:20px 0 10px 0;"></div>
    <div class="easyui-accordion" style="width:500px;height:300px;">
        <div title="About" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
            <h3 style="color:#0099FF;">Accordion for jQuery</h3>
            <p>Accordion is a part of easyui framework for jQuery. It lets you define your accordion component on web page more easily.</p>
        </div>
        <div title="Help" data-options="iconCls:'icon-help'" style="padding:10px;">
            <p>The accordion allows you to provide multiple panels and display one or more at a time. Each panel has built-in support for expanding and collapsing. Clicking on a panel header to expand or collapse that panel body. The panel content can be loaded via ajax by specifying a 'href' property. Users can define a panel to be selected. If it is not specified, then the first panel is taken by default.</p>      
        </div>
        <div title="Ajax" data-options="href:'_content.html'" style="padding:10px">
        </div>
    </div>
</body>
</html>