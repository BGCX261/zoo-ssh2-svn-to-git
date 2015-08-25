<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>   
<%@ taglib uri="/struts-tags" prefix="s" %>   
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">   
<html>   
  <head>   
      
    <title>产品分类列表</title>   
       
    <meta http-equiv="pragma" content="no-cache">   
    <meta http-equiv="cache-control" content="no-cache">   
    <meta http-equiv="expires" content="0">       
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">   
    <meta http-equiv="description" content="This is my page">   

    <link rel="stylesheet" type="text/css" href="/css/fenye.css">   
  
  </head>   
     
  <body>   
  <center><h1><font color="red">ProductType List</font></h1></center>
  <s:form method="post" action="producttype_action_list.do">
  <s:hidden name="parentID"></s:hidden>
  <table border="1" width="80%" align="center">
    	<tr>
    		<td colspan="6" align="right"><s:a href="producttype_addUI.do?parentID=%{parentID}">添加分类</s:a></td>
    	</tr>
    	<tr>
    		<td>编号</td>
    		<td>修改</td>
    		<td>产品分类名称</td>
    		<td>创建下级类别</td>
    		<td>所属父类</td>
    		<td>备注</td>
    	</tr>	
    	<s:iterator id="type" value="productTypes">
    	<tr>
    		<td>${type.typeid} </td>
    		<td><s:a href="producttype_action_editUI.do?productType.typeid=%{#type.typeid}">修改</s:a></td>
    		<td><s:a href="producttype_action_list.do?parentID=%{#type.typeid}">${type.name}</s:a></td>
    		<td><s:a href="producttype_action_addUI.do?parentID=%{#type.typeid}">创建子类别</s:a></td>
    		<td>&nbsp;${type.parent.name}</td>
    		<td>&nbsp;${type.note}</td>
    	</tr>
    	</s:iterator>
    	<tr>
    		<td colspan="6" align="center">
    			${pagination}	
    		</td>
    	</tr>
    </table>  
    </s:form>
  </body>   
</html>