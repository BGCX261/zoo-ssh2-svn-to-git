<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>   
<%@ taglib uri="/struts-tags" prefix="s" %>   
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">   
<html>   
  <head>   
      
    <title>添加产品</title>   
       
    <meta http-equiv="pragma" content="no-cache">   
    <meta http-equiv="cache-control" content="no-cache">   
    <meta http-equiv="expires" content="0">       
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">   
    <meta http-equiv="description" content="This is my page">   
  </head>   
     
  <body>
    <center>
    <font color="red" size="7">修改产品</font> <br><br>
    <s:form action="" method="post">
    	产品名称：<s:textfield name="product.name" readonly="true"></s:textfield><br/>
    	产品价格：<s:textfield name="product.price" readonly="true"></s:textfield><br/>
    	产品折扣：<s:textfield name="product.discount" readonly="true"></s:textfield><br/>
    	产品库存：<s:textfield name="product.inventories" readonly="true"></s:textfield><br/>
    	产品类型：<s:textfield name="product.type.name" readonly="true"></s:textfield><br/>
    	产品备注：<s:textarea name="product.note" cols="17" rows="5" readonly="true"></s:textarea><br/>
    </s:form>
    <a href="product_list.do">返回列表</a>
    </center> 
  </body>   
</html>  