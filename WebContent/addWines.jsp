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
	    <form id="ff" action="Wine!addWine.action"  class="easyui-form" method="post" enctype="multipart/form-data" data-options="novalidate:true">
	    	<table cellpadding="5">
	    	
	    		<tr>
	    			<td>商品名称:</td>
	    			<td><input class="easyui-textbox" type="text" id="name" name="w.name" data-options="required:true,validType:'text'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>商品种类:</td>
	    			<td><input class="easyui-textbox" type="text" id="kind" name="w.kind" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>商品价格:</td>
	    			<td><input class="easyui-textbox" type="number" id="price" name="w.price" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>商品详情:</td>
	    			<td><input class="easyui-textbox" name="w.detail" id="detail" data-options="multiline:true" style="height:60px"></input></td>
	    		</tr>
	    		<tr>
	    			<td>商品图片:</td>
	    			<td><input id="picture" class="easyui-filebox" name="myFile" data-options="prompt:'Choose a file...'" style="width:100%"></td>
	    		</tr>
	    		<tr>
	    			<td>更多图片:</td>
	    			<td><input class="easyui-textbox" name="w.picture4" id="detail" data-options="multiline:true" style="height:60px"></input></td>
	    		</tr>
	    		
	    	
	    	
	    	</table>
	    </form>
	    
<!-- <form method="post" enctype="multipart/form-data" >
   <div class="easyui-panel" style="width:400px;padding:30px 70px 50px 70px">
		
		<div style="margin-bottom:20px">
			<div>商品主图:</div>
			<input id="file1" class="easyui-filebox" name="file1" data-options="prompt:'Choose a file...'" style="width:100%">
		</div>
		<div style="margin-bottom:20px">
			<div>File2:</div>
			<input id="file2" class="easyui-filebox" name="file2" data-options="prompt:'Choose another file...'" style="width:100%">
		</div>
		<div>
			<a href="javascript:void(0)" class="easyui-linkbutton" style="width:100%" onclick="uploadFile()">Upload</a>
		</div>
	</div>
</form> -->
	    
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">Submit</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">Clear</a>
	    </div>
	    </div>
	</div>
	<script>
	//上传
	
	
		function submitForm(){
			$('#ff').form('submit',{
				onSubmit:function(){
					// var file =$("#picture").filebox('getValue');  
					$.get('Wine!addWine.action',function(data){
							$.messager.alert('Info','操作成功');
					
					});
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