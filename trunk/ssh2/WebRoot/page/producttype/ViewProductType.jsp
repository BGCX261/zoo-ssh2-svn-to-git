<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>   
<%@ taglib uri="/struts-tags" prefix="s" %>   
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">   
<html>   
  <head>   
      
    <title>查看产品类型</title>   
       
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
    <font color="red" size="7">查看产品类型</font> <br/><br/>
    	分类名称：${productType.name}&nbsp;<br/>
    	分类备注：${productType.note}&nbsp;<br/>
    	上级分类: ${productType.parenttype==null?"无":productType.parenttype.name}&nbsp;<br/>
    <a href="producttype_action_list.do">返回列表</a>
    </center> 
  </body>   
</html>  