<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人力资源管理系统Powered by qianfeng</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<link href="css/css.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.STYLE1 {
	font-size: 36px;
	color: #009999;
	font-family: "方正舒体";
}
-->
</style>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="147" background="images/top02.gif"><div align="center"><span class="STYLE1">人力资源管理系统</span></div></td>
  </tr>
</table>
<table width="562" border="0" align="center" cellpadding="0" cellspacing="0" class="right-table03">
  <tr>
    <td width="221"><table width="95%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
      
      <tr>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
          <tr>
            <td align="center"><img src="images/ico13.gif" width="107" height="97" /></td>
          </tr>
          <tr>
            <td height="40" align="center">&nbsp;</td>
          </tr>
          
        </table></td>
        <td><img src="images/line01.gif" width="5" height="292" /></td>
      </tr>
    </table></td>
    <td>
	
	<form name="usersForm" method="post" action="UserServlet?method=userLogin">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tr>
		<td colspan="2" align="center"><font color="red">${requestScope.error}</font></td>
      </tr>
      <tr>
        <td width="31%" height="35" class="login-text02">用户名：<br /></td>
        <td width="69%"><input name="username" type="text" id="username" size="20" /></td>
      </tr>
      <tr>
        <td height="35" class="login-text02">密　码：<br /></td>
        <td><input name="password" type="password" id="password" size="20" /></td>
      </tr>
      <tr>
        <td height="35">&nbsp;</td>
        <td><input type="submit" class="right-button01" value="确认登录"/>
          <input type="reset" class="right-button02" value="重 置" /></td>
      </tr>
    </table>
	</form>
	</td>
  </tr>
</table>
</body>
</html>
