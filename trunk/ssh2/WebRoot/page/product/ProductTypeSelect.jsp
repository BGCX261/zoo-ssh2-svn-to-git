<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<title> 类别选择 </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/vip.css" type="text/css">
<script language="JavaScript" src="/js/product/ProductTypeSelect.js"></script>
</head>

<body>
<c:set var="menuout" value=""/>
<c:forEach items="${menutypes}" var="menu">
	<c:set var="menuout" value="&gt;&gt;<a href='product_selectTypeUI.do?type.typeid=${menu.typeid}'>${menu.name}</a> ${menuout}"/>
</c:forEach>
产品类别列表,请选择分类:<br>
导航:<a href='product_selectTypeUI.do'>顶级目录</a> <c:out value="${menuout}" escapeXml="false"/>
<form method="post" name="main" action="">
<input type="hidden" name="typeId"/>
<input type="hidden" name="typeName"/>
<table width="100%" border="0" cellspacing="1" cellpadding="1">  
	<tr><td id="typecontent">
	<table width="100%" border="0">
	<tr>
	<c:forEach items="${types}" var="type" varStatus="loop">		
	    <td>
		<c:if test="${fn:length(type.childtypes)>0}">
		<a href="product_selectTypeUI.do?type.typeid=${type.typeid}"><b><input type="radio" name="type" onclick="clickType('${type.typeid}','${type.name}')">${type.name}</b></a>
		</c:if>
		<c:if test="${fn:length(type.childtypes)==0}"> 
		<input type="radio" name="type" onclick="clickType('${type.typeid}','${type.name}')">${type.name}
		</c:if>
		</td>
	</c:forEach>
	</tr></table>
	</td>
	</tr>
	<tr><td colspan="2" align="center">
		<input type='button' name='create' value=" 确 认 " onclick="sureType()">
		<input type='button' name="cancel" value=" 取 消 " onclick="javaScript:window.close()"> 
    </td></tr>
</table>
</form>
</body>
</html>