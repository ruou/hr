<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="pojo.Train"%>
<%@ page import="utils.*"%>
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
<form name="educateForm" method="post" action="modifyeducate.do?action=addeducate" onsubmit="return educateValidate();">
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >
      	<%
		String educate=null;
		try{
			educate=request.getParameter("educate").toString();
		}catch(Exception e){
			educate="0";
		}
		if("1".equals(educate)){
			out.print("培训详细总结");
		  }else{
			out.print("培训详细计划");
		  }
		%>
      </th>
  </tr>
    <%
    Train e=(Train)request.getAttribute("train");
	  if(e!=null){
  	%>
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
					  <table border="0" cellpadding="8" cellspacing="1" style="width:100%">
					  <tr>
					    <td nowrap align="right" width="11%">培训名称：</td>
					    <td colspan="3"><%=e.getName()%>
					    </td>
					    </tr>
					  <tr>
					    <td nowrap align="right" width="11%">培训目的：</td>
					    <td colspan="3"><%=e.getPurpose()%>
					    </td>
					    </tr>
					  <tr>
					    <td nowrap align="right">培训开始时间：</td>
					    <td width="29%"><%=StringUtil.notNull(DateUtil.parseToString(e.getBegintime(),DateUtil.yyyyMMdd))%>
					    	</td>
					    <td width="18%">培训结束时间：</td>
					    <td width="42%"><%=StringUtil.notNull(DateUtil.parseToString(e.getEndtime(),DateUtil.yyyyMMdd))%>
					    </td>
					  </tr>
					  <tr>
					    <td nowrap align="right">讲师：</td>
					    <td><%=e.getTeacher()%>
					    </td>
					    <td>培训人员：</td>
					    <td><%=e.getStudent()%>
						</td>
					  </tr>
					    
					  <tr>
					    <td width="11%" nowrap align="right">培训材料：</td>
					    <td colspan="3"><%=e.getDatum()%></td>
					  </tr>
					   <%if("1".equals(educate)){%>
						  <tr>
						    <td width="11%" nowrap align="right">培训效果：</td>
						    <td colspan="3"><%=StringUtil.notNull(e.getEffect())%>&nbsp;</td>
						  </tr>
						  <tr>
						    <td width="11%" nowrap align="right">培训总结：</td>
						    <td colspan="3"><%=StringUtil.notNull(e.getSummarize())%>&nbsp;</td>
						  </tr>
						 <%}%>
					  </table>
				</fieldset>			
				</TD>
		</TR>
    <%}else{ %>
  	<tr>
    <td height="22" colspan="4" align="center" >该信息不存在！！！</td>
  	</tr>
  	<%}%>
</TABLE>	
</div>
</form>
</body>
</html>

