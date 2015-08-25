<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>   
<%@ taglib uri="/struts-tags" prefix="s" %>   
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">   
<html>   
  <head>   
      
    <title>添加产品类型</title>   
       
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
    <font color="red" size="7">添加产品分类</font> <br><br>
    <s:form action="producttype_add.do">
    	<s:hidden name="parentID" value="%{parentID}" ></s:hidden>
    	分类名称：<s:textfield name="productType.name"></s:textfield><br>
    	分类备注：<s:textarea name="productType.note"></s:textarea><br>
    	<input type="submit" value="提交"/>  
    </s:form>
    <a href="producttype_list.do">返回列表</a>
    </center> 
  </body>   
</html>  