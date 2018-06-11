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
<body>
<div class="easyui-panel"  style="width:100%">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff" action="Wine!updateWine.action"  class="easyui-form" method="post" enctype="multipart/form-data" data-options="novalidate:true">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>商品编号:</td>
	    			<td><input id="tt"  name="id" style="width:100%" data-options="
			prompt: '请输入修改的ID!',
			required:true,
			icons:[{
				iconCls:'icon-search',
				handler: function(e){
					var v = $(e.data.target).textbox('getValue');
					//alert('The inputed value is ' + (v ? v : '空'));
					$.get('Wine!searchWine.action?w.id='+v,function(data){
					if(data!='null'){
					//$.messager.alert('Info','查询到的名称为：'+data[0].name);
					$('#name').textbox('setValue',data[0].name)
					$('#kind').textbox('setValue',data[0].kind)
					$('#price').textbox('setValue',data[0].price)
					$('#detail').textbox('setValue',data[0].detail)
					}else{
					$.messager.alert('Info','没有该商品');
					}
					
					
					}); 
				}
			}]
			">
	<script>
		$.extend($.fn.textbox.methods, {
			addClearBtn: function(jq, iconCls){
				return jq.each(function(){
					var t = $(this);
					var opts = t.textbox('options');
					opts.icons = opts.icons || [];
					opts.icons.unshift({
						iconCls: iconCls,
						handler: function(e){
							$(e.data.target).textbox('clear').textbox('textbox').focus();
							$(this).css('visibility','hidden');
						}
					});
					t.textbox();
					if (!t.textbox('getText')){
						t.textbox('getIcon',0).css('visibility','hidden');
					}
					t.textbox('textbox').bind('keyup', function(){
						var icon = t.textbox('getIcon',0);
						if ($(this).val()){
							icon.css('visibility','visible');
						} else {
							icon.css('visibility','hidden');
						}
					});
				});
			}
		});
		
		$(function(){
			$('#tt').textbox().textbox('addClearBtn', 'icon-clear');
		});
	</script></td>
	    		</tr>
	    		<tr>
	    			<td>新商品名称:</td>
	    			<td><input  class="easyui-textbox" type="text" id="name" name="w.name" data-options="validType:'text'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>新商品种类:</td>
	    			<td><input class="easyui-textbox" type="text" id="kind" name="w.kind"></input></td>
	    		</tr>
	    		<tr>
	    			<td>新商品价格:</td>
	    			<td><input class="easyui-textbox" type="number" id="price" name="w.price" ></input></td>
	    		</tr>
	    		<tr>
	    			<td>新商品详情:</td>
	    			<td><input class="easyui-textbox" name="w.detail" id="detail" data-options="multiline:true" style="height:60px"></input></td>
	    		</tr>
	    		<tr>
	    			<td>新商品图片:</td>
	    			<td><input id="picture" class="easyui-filebox" name="myFile" data-options="prompt:'Choose a file...'" style="width:100%"></td>
	    		</tr>
	    		<tr>
	    			<td>更多图片:</td>
	    			<td><input class="easyui-filebox" name="w.picture4" id="picture4" data-options="multiline:true" style="height:60px"></input></td>
	    		</tr>
	    		
	    	
	    	
	    	</table>
	    </form>
	    

	    
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">Submit</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">Clear</a>
	    </div>
	    </div>
	</div>
	<script>
	
		function findWine(){
			$.messager.alert('Info',$("#wineid").val())
		}	
	
		function submitForm(){
			$('#ff').form('submit',{
				onSubmit:function(){
					// var file =$("#picture").filebox('getValue');  
					$.messager.alert('Info','操作成功');
					return $(this).form('enableValidation').form('validate');
				}
			});
		}
		function clearForm(){
			$('#ff').form('clear');
		
		}
	</script>

</body>
</html>