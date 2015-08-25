<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>   
<%@ taglib uri="/struts-tags" prefix="s" %>   
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">   
<html>   
  <head>   
      
    <title>用户列表</title>   
       
    <meta http-equiv="pragma" content="no-cache">   
    <meta http-equiv="cache-control" content="no-cache">   
    <meta http-equiv="expires" content="0">       
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">   
    <meta http-equiv="description" content="This is my page">   

    <link rel="stylesheet" type="text/css" href="/css/fenye.css">   
  
  </head>   
     
  <body>   
  <center><h1><font color="red">User List</font></h1></center>
  <s:form method="post" action="user_list.do">
  <table border="1" width="80%" align="center">
    	<tr>
    		<td colspan="6" align="right"><s:a href="user_addUI.do">添加用户</s:a></td>
    	</tr>
    	<tr>
    		<td>编号</td>
    		<td>修改</td>
    		<td>用户登录名</td>
    		<td>用户真实姓名</td>
    		<td>用户地址</td>
    	</tr>	
    	<s:iterator id="type" value="productTypes">
    	<tr>
    		<td>&nbsp;${user.id} </td>
    		<td><s:a href="user_editUI.do?user.id=%{#user.id}">修改</s:a></td>
    		<td><s:a href="user_view.do?user.id=%{#user.id}">${user.loginName}</s:a></td>
    		<td>&nbsp;${user.realName}</td>
    		<td>&nbsp;${user.address}</td>
    	</tr>
    	</s:iterator>
    	<tr>
    		<td colspan="5" align="center">
    			${pagination}	
    		</td>
    	</tr>
    </table>  
    </s:form>
  </body>   
</html>