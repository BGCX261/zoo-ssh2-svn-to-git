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
	<script type='text/javascript' src='/dwr/interface/DWRUser.js'></script>  
	<script type='text/javascript' src='/dwr/engine.js'></script>  
	<script type='text/javascript' src='/dwr/util.js'></script>
	<script type='text/javascript'>  
		function regUserChked(){			
			//var username=$("username").value;
			var username=document.getElementsByName("user.loginName")[0].value;
			DWRUser.isExist(username,showData);//showData回调函数   
		}   
		function showData(data){
			if (typeof window['DWRUtil'] == 'undefined')
                window.DWRUtil = dwr.util; 
			if(data){   
	        	DWRUtil.setValue("userMsg","该用户名已经被注册，请更换您的用户名！");   
	     	}else{   
	          	DWRUtil.setValue("userMsg","恭喜您，该用户名尚未被注册！");         
	     	}   
	 	}   
	</script>
  </head>
  
  <body>
    <center>
    <font color="red" size="7">用户登录</font> <br><br>
    <s:form  action="user_login.do" method="post">
    	用户名称：<s:textfield name="user.loginName" onblur="regUserChked()"/><span id="userMsg"></span><br>
    	用户密码：<s:textfield name="user.pwd"/><br>
    	<input type="submit" value="提交"/>  
    </s:form>
    </center> 
  </body>
</html>
