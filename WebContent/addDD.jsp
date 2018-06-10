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

<table id="dg" class="easyui-datagrid" title="添加订单" style="width:100%;height:auto"
			data-options="
				iconCls: 'icon-edit',
				singleSelect: true,
				toolbar: '#tb',
				url: 'DingDanAction!updateDingdan.action',
				method: 'get',
				onClickRow: onClickRow
			">
		<thead>
			<tr>
				<th data-options="field:'user_id',width:150,align:'center'">用户</th>
				<th data-options="field:'dd_id',width:150,align:'center'">订单号</th>
				<th data-options="field:'wine_id',width:150,align:'center',editor:'numberbox'">商品号</th>
				<th data-options="field:'number',width:150,align:'center',editor:'numberbox'">总数量</th>
				<th data-options="field:'prices',width:300,align:'center',editor:'text'">总价</th>
				 <th data-options="field:'state',width:150,align:'center',
						editor:{
							type:'combobox',
							options:{
								data:getDate(),
								valueField:'state',
								textField:'text',
                           		 required: true
							}
						}">状态</th>
			</tr>
		</thead>
	</table>

	<div id="tb" style="height:auto">
	    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="accept()">添加</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="accept()">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true" onclick="reject()">返回</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="getChanges()">GetChanges</a>
	</div>
	
</body>

<script type="text/javascript">
		(function($){
			function getCacheContainer(t){
				var view = $(t).closest('div.datagrid-view');
				var c = view.children('div.datagrid-editor-cache');
				if (!c.length){
					c = $('<div class="datagrid-editor-cache" style="position:absolute;display:none"></div>').appendTo(view);
				}
				return c;
			}
			function getCacheEditor(t, field){
				var c = getCacheContainer(t);
				return c.children('div.datagrid-editor-cache-' + field);
			}
			function setCacheEditor(t, field, editor){
				var c = getCacheContainer(t);
				c.children('div.datagrid-editor-cache-' + field).remove();
				var e = $('<div class="datagrid-editor-cache-' + field + '"></div>').appendTo(c);
				e.append(editor);
			}
			
			var editors = $.fn.datagrid.defaults.editors;
			for(var editor in editors){
				var opts = editors[editor];
				(function(){
					var init = opts.init;
					opts.init = function(container, options){
						var field = $(container).closest('td[field]').attr('field');
						var ed = getCacheEditor(container, field);
						if (ed.length){
							ed.appendTo(container);
							return ed.find('.datagrid-editable-input');
						} else {
							return init(container, options);
						}
					}
				})();
				(function(){
					var destroy = opts.destroy;
					opts.destroy = function(target){
						if ($(target).hasClass('datagrid-editable-input')){
							var field = $(target).closest('td[field]').attr('field');
							setCacheEditor(target, field, $(target).parent().children());
						} else if (destroy){
							destroy(target);
						}
					}
				})();
			}
		})(jQuery);
	</script>
	<script type="text/javascript">
		var editIndex = undefined;
		function endEditing(){
			if (editIndex == undefined){return true}
			if ($('#dg').datagrid('validateRow', editIndex)){
				var ed = $('#dg').datagrid('getEditor', {index:editIndex,field:'state'});
				var text = $(ed.target).combobox('getText');
				$('#dg').datagrid('getRows')[editIndex]['text'] = text; 
				$('#dg').datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}
		function onClickRow(index){
			if (editIndex != index){
				if (endEditing()){
					$('#dg').datagrid('selectRow', index)
							.datagrid('beginEdit', index);
					editIndex = index;
				} else {
					$('#dg').datagrid('selectRow', editIndex);
				}
			}
		}
		function accept(){
			/* if (endEditing()){
				$('#dg').datagrid('acceptChanges');
				
			} */
			 var test="test";  
	            var rowsData = $('#dg').datagrid('getRows');  
	            var json = [];  
	            var loc;  
	            $.each(rowsData, function (i)  
	            {  
	                loc = {   
	                    "user_id":rowsData[i].user_id,  
	                    "dd_id": rowsData[i].dd_id,  
	                    "wine_id": rowsData[i].wine_id,  
	                    "number": rowsData[i].number,  
	                    "prices": rowsData[i].prices,  
	                    "state": rowsData[i].state  
	                };  
	                json.push(loc);  
	            });  
	            json = JSON.stringify(json); //转换成json数据   
	            alert(json);  
	            $('#dg').datagrid({  
	                url: 'Handler2.ashx?test=' + test+ "&jj=" + json,  
	                method: 'get'  
	            })  
		}
		function reject(){
			$('#dg').datagrid('rejectChanges');
			editIndex = undefined;
		}
		function getChanges(){
			var rows = $('#dg').datagrid('getChanges');
			alert(rows.length+' rows are changed!');
		}
		function getDate(){
			return [{ state: 0, text:'0' },{ state: 1, text:'1' },{ state: 2, text:'2' }];
		}
	</script>
</html>

