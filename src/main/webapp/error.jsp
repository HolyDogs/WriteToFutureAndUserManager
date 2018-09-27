<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ERROR</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
 
 	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="css/templatemo_style.css" rel="stylesheet" type="text/css">
	<link href="css/aa.css" rel="stylesheet" type="text/css">
</head>
<body class="templatemo-bg-gray">
<%
 	String str="";
	if(request!=null){
		 str=request.getAttribute("err").toString(); 
	} 
%>
	<div class="container">
		<div class="col-md-12">
			<h1 class="margin-bottom-15">!Error:<%=str %></h1>
			<a href="/WriteToFuture/index.jsp">返回重新登陆</a>
		</div>
	</div>

</body>
</html>