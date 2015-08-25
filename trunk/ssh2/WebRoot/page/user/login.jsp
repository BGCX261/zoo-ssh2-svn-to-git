<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>   
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <center>
    <font color="red" size="7">用户登录</font> <br><br>
    <form action="user_login.do" method="post">  
	USERNAME:<input type="text" name="user.loginName" value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}" /><br/>  
	PASSWORD:<input type="password" name="user.pwd" value="" /><br/>  
	<input type="checkbox" name="spring_security_remember_me" />两周之内不必登陆<br/>  
	<input type="submit">        
	</form>
    </center> 
  </body>
</html>
