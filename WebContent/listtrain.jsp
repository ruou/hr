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
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.tabfont01 {	
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}
.font051 {font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}
.font201 {font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}
html { overflow-x: auto; overflow-y: auto; border:0;} 
-->
</style>

<link href="css/css.css" rel="stylesheet" type="text/css" />
<script type="text/JavaScript">

</script>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  
  <tr>
    <td height="30">      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="62" background="images/nav04.gif">&nbsp;</td>
        </tr>
    </table></td></tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
          	 <tr>
               <td height="20"><span class="newfont07">	<%
	String educate=null;
	try{
		educate=request.getParameter("educate").toString();
	}catch(Exception e){
		educate="0";
	}
	if("1".equals(educate)){
		out.print("培训总结查看");
	  }else{
		out.print("培训计划查看");
	  }
	%></span></td>
          	 </tr>
              <tr>
                <td height="40" class="font42">
				<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
				 <tr class="CTitle" >
                    	<td height="22" colspan="8" align="center" style="font-size:16px">
                    	<%
	if("1".equals(educate)){
		out.print("培训总结");
	  }else{
		out.print("培训计划");
	  }
	%>列表</td>
                  </tr>
                  <tr bgcolor="#EEEEEE">
				        <td height="22" align="center" >培训名称</td>
						<td height="22" align="center" >讲师</td>
						<td height="22" align="center" >培训人员</td>
						<td height="22" align="center" >开始时间</td>
						<td height="22" align="center" >结束时间</td>
						<td height="22" align="center" >执行操作</td>
                  </tr>
				  <% List list=(List)request.getAttribute("trainList");
					 if(list!=null&&list.size()>0){
						Iterator it = list.iterator();
						   while (it.hasNext()) {
							   Train j = (Train) it.next();
				  %>
				  <tr  bgcolor="#FFFFFF">
					<td height="22" align="center" ><%=j.getName()%></td>
					<td height="22" align="center" ><%=j.getTeacher()%></td>
					<td height="22" align="center" ><%=j.getStudent()%></td>
					<td height="22" align="center" ><%=StringUtil.notNull(DateUtil.parseToString(j.getBegintime(),DateUtil.yyyyMMdd))%></td>
					<td height="22" align="center" ><%=StringUtil.notNull(DateUtil.parseToString(j.getEndtime(),DateUtil.yyyyMMdd))%></td>
					<td height="22" align="center" ><a href="TrainServlet?method=trainDetail&id=<%=j.getId()%>&educate=<%=j.getEducate()%>">详细</a>&nbsp;&nbsp;<a href="TrainServlet?method=deleteTrain&id=<%=j.getId()%>&educate=<%=j.getEducate()%>">删除</a><%if(!"1".equals(educate)){%>&nbsp;&nbsp;<a href="TrainServlet?method=toUpdatePage&id=<%=j.getId()%>">培训完成</a><%}%></td>
				  </tr>
				  <%		}
				   }else{
				  %>
				  <tr  bgcolor="#FFFFFF">
					<td height="22" colspan="6" align="center" >对不起，没有信息！！！</td>
				  </tr>
				  <%}%>
            </table></td>
        </tr>
      </table>
          </td>
        </tr>
</table>
</body>
</html>