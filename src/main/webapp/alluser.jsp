<%@page import="com.me.domain.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/aa.css">

<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<User> al=null;
	al=(ArrayList<User>) request.getAttribute("alluser");
%>

	<ul>
		<li>id----type----name---sex----password</li>
		<%
			for(User user:al){
				out.print("<li>");
				out.print(user.getUserId()+"--");
				out.print(user.getUserType()+"--");
				out.print(user.getUserName()+"--");
				out.print(user.getSex()+"--");
				out.print(user.getPassword());
				out.print("</li>");
			}
		%>
	</ul>

</body>
</html>