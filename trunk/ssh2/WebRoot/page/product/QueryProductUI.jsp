<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<title>查询产品</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="JavaScript" src="/js/jquery-1.6.1.min.js"></script>
<script language="JavaScript" src="/js/common.js"></script>
</head>

<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<form action="product_search.do" method="post">
  <input type="hidden" name="typeid"/>
  <table width="98%" border="0" cellspacing="1" cellpadding="3" align="center">
    <tr bgcolor="6f8ac4"> 
      <td colspan="2" ><font color="#FFFFFF">查询产品：</font></td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="25%"> <div align="right">产品名称  ：</div></td>
      <td width="75%"> <input type="text" name="query.name" size="50" maxlength="40"/></td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="25%"> <div align="right">产品类别  ：</div></td>
      <td width="75%"> <input type="text" name="typename" disabled="disabled" size="30" value="${product.type.name}"/> 
        <input type="button" name="select" value="选择..." onClick="winOpen('product_selectTypeUI.do','产品类型列表',600,400)">
      </td>
    </tr>
	<tr bgcolor="f5f5f5"> 
      <td width="25%"> <div align="right">产品价格 ：</div></td>
      <td width="75%"> 在<input type="text" name="query.startprice" size="10" maxlength="10"/>与<input type="text" name="query.endprice" size="10" maxlength="10"/>之间
</td>
    </tr>
	<tr bgcolor="f5f5f5"> 
      <td width="25%"> <div align="right">折扣 ：</div></td>
      <td width="75%"> 在<input type="text" name="query.startdiscount" size="10" maxlength="10"/>与<input type="text" name="query.enddiscount" size="10" maxlength="10"/>之间
      </td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td colspan="2"> <div align="center"><input type="submit" value=" 确 认 ">&nbsp;&nbsp;<input type="button" value=" 返 回 " onclick="javascript:history.back()"></div>
      </td>
    </tr>
  </table>
</form>
<br>
</body>
</html>