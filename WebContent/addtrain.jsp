<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form name="educateForm" method="post" action="TrainServlet?method=trainAdd" onSubmit="return trainValidate();">
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >培训计划录入</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:80%" align="center">
		
		
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>培训计划</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
					    <td nowrap align="right" width="11%">培训名称：</td>
					    <td colspan="3"><input name="name" type="text" class="input"/>
					    <span class="red">*</span></td>
					    </tr>
					  <tr>
					    <td nowrap align="right" width="11%">培训目的：</td>
					    <td colspan="3"><input type="text" name="purpose" class="input"/>
					    <span class="red">*</span></td>
					    </tr>
					  <tr>
					    <td nowrap align="right">培训开始时间：</td>
					    <td width="29%"><input type="text" name="begintime" class="input"/>
					    	<span class="red">*</span></td>
					    <td width="18%">培训结束时间：</td>
					    <td width="42%"><input type="text" name="endtime" class="input"/>
					    <span class="red">*</span></td>
					  </tr>
					  <tr>
					    <td nowrap align="right">讲师：</td>
					    <td><input type="text" name="teacher" class="input"/>
					    <span class="red">*</span></td>
					    <td>培训人员：</td>
					    <td><input type="text" name="student" class="input"/>
					    <span class="red">*</span>
						</td>
					  </tr>
					    
					  <tr>
					    <td width="11%" nowrap align="right">培训材料：</td>
					    <td colspan="3"><textarea name="datum" cols="100" rows="6" class="input"></textarea></td>
					  </tr>
					  </table>
				</fieldset>			
			</TD>
		</TR>
		</TABLE>
	 </td>
  </tr>
		<TR>
			<TD colspan="2" align="center" height="50px">
			<input name="提交" type="submit" class="button" value="保存"/>　
			<input name="重置" type="reset" class="button" value="重置"/></TD>
		</TR>
	</TABLE>	
</div>
</form>
</body>
</html>

