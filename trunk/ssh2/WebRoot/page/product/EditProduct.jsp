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
    <!--   
    <link rel="stylesheet" type="text/css" href="styles.css">   
    -->   
  	<script language="JavaScript" src="/js/jquery-1.6.1.min.js"></script>
  	<script language="JavaScript" src="/js/common.js"></script>
  </head>   
     
  <body>
    <center>
    <font color="red" size="7">修改产品</font> <br><br>
    <s:form action="product_edit.do" method="post">
    	<s:hidden name="type.typeid"/>
    	<s:hidden name="product.id"/>
    	产品名称：<s:textfield name="product.name"></s:textfield><br/>
    	产品价格：<s:textfield name="product.price"></s:textfield><br/>
    	产品折扣：<s:textfield name="product.discount"></s:textfield><br/>
    	产品库存：<s:textfield name="product.inventories"></s:textfield><br/>
    	产品类型：<s:textfield name="product.type.name" readonly="true"></s:textfield> <input type="button" name="select" value="选择..." onClick="winOpen('product_selectTypeUI.do','产品类型列表',600,400)"><br/>
    	产品备注：<s:textarea name="product.note" cols="17" rows="5"></s:textarea><br/>
    	<s:submit value="提交"/>
    </s:form>
    <a href="product_list.do">返回列表</a>
    </center> 
  </body>   
</html>  