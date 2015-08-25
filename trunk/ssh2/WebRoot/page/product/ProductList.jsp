<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>   
<%@ taglib uri="/struts-tags" prefix="s" %>   
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">   
<html>   
  <head>   
      
    <title>产品列表</title>   
       
    <meta http-equiv="pragma" content="no-cache">   
    <meta http-equiv="cache-control" content="no-cache">   
    <meta http-equiv="expires" content="0">       
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">   
    <meta http-equiv="description" content="This is my page">   
    <link rel="stylesheet" type="text/css" href="/css/fenye.css">   
  
  
  </head>   
     
  <body>   
  <center><h1><font color="red">Product List</font></h1></center>
  
  <table border="1" width="80%" align="center">
    	<tr>
    		<td colspan="7">
    			<table width="100%">
    				<tr>
    					<td align="left">
    						<form action="product_search.do" method="post">
    							产品名称：<input type="text" name="product.name" value="${product.name}"/><input type="submit" value="搜索">
    							<input type="button" value="统合搜索" onclick="javascript:window.location.href='product_queryProductUI.do'">
    						</form>     					
    					</td>
    					<td align="right"><a href="product_addUI.do">添加产品</a></td>
    				</tr>
    			</table>
    		</td>
    	</tr>
    	<tr>
    		<td>编号</td>
    		<td>产品名称</td>
    		<td>价格</td>
    		<td>折扣</td>
    		<td>库存</td>
    		<td>所属产品类型</td>
    		<td>编辑</td>
    	</tr>	
    	<s:iterator id="product" value="products">
    	<tr>
    		<td><s:property value="#product.id"/> </td>
    		<td><s:a href="product_view.do?product.id=%{#product.id}"><s:property value="#product.name"/></s:a></td>
    		<td><s:property value="#product.price"/></td>
    		<td><s:property value="#product.discount"/></td>
    		<td><s:property value="#product.inventories"/></td>
    		<td><s:property value="#product.type.name"/></td>
    		<td><s:a href="product_editUI.do?product.id=%{#product.id}">修改</s:a>｜<s:a href="product_del.do?product.id=%{#product.id}">删除</s:a></td>
    	</tr>
    	</s:iterator>
    	<tr>
    		<td colspan="7">${pagination}</td>
    	</tr>	
    </table>  
  </body>   
</html>