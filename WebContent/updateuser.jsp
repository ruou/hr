<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="utils.*"%>
<%@ page import="pojo.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人力资源管理系统</title>
<link rel="stylesheet" rev="stylesheet" href="css/style.css " type="text/css" media="all" />
<script type="text/javascript" src="Js/typem.js"></script>
<script type="text/javascript" src="Js/js.js"></script>
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>
<body class="ContentBody">
<form name="userForm" method="post" action="UserServlet?method=updateUser" onSubmit="return userValidate();">
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >人员信息更新</th>
  </tr>
  <% User u=(User)request.getAttribute("user");
  	if(u!=null){
  %>
  <input type="hidden" name="id" value="<%=u.getId()%>"/>
  <tr>
    <td class="CPanel">
		
		<table width="90%" border="0" cellpadding="0" cellspacing="0" style="width:80%" align="center">
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>人员信息</legend>
					  <table width="100%" border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
					    <td nowrap align="right" width="9%">用户名：</td>
					    <td width="36%"><input name="username" type="text" class="input" id="username" value="<%=u.getUsername()%>">
						<span class="red">*</span></td>
					    <td width="12%"><div align="right">登陆密码：</div></td>
					    <td width="43%"><input name="password" type="text" class="input" id="password" value="<%=u.getPassword()%>"/>
				        <span class="red">*</span></tr>
					  <tr>
					    <td nowrap align="right" width="9%">性别：</td>
					    <td><input name="sex" type="radio" value="1" <%=new Byte("1").equals(u.getSex())?"checked":""%>> 男
							<input name="sex" type="radio" value="0" <%=new Byte("1").equals(u.getSex())?"":"checked"%>>女</td>
					    <td><div align="right">出生日期：</div></td>
					    <td><input name="birthday" type="text" class="input" id="birthday" value="<%=StringUtil.notNull(DateUtil.parseToString(u.getBirthday(),DateUtil.yyyyMMdd))%>">
				        <span class="red">*</span></td>
					  </tr>
					<%--   <tr>
					    <td nowrap align="right">是否管理员：</td>
					    <td><input name="isadminhelp" type="checkbox" <%=new Byte("1").equals(u.getIsadmin())?"checked":""%>  onClick="javascript:adminChecked();" >
						<input type="hidden"  name="isadmin" value="<%=u.getIsadmin()%>"></td>
					    <td>&nbsp;</td>
					    <td>&nbsp;</td>
					  </tr> --%>
					  <tr>
					    <td nowrap align="right">人员简介：</td>
					    <td colspan="3"><textarea name="content" cols="100" rows="6" class="input" id="content"><%=u.getContent()%></textarea></td>
					    </tr>
					  </table>
			 		 <br />
				</fieldset>
				</TD>
		</TR>
		</TABLE>
	 </td>
  </tr>
    <%
  }else{
  %>
  <tr>
    <td height="22" colspan="2" align="center" >没有查到该人员信息！！！</td>
    </tr>
  <%}%>
		<TR>
			<TD colspan="2" align="center" height="50px">
			<input type="submit" class="button" value="更新"/>　
			<input type="reset" class="button" value="重置"/></TD>
		</TR>
	</TABLE>
</div>
</form>
</body>
</html>