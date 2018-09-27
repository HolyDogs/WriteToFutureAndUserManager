<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

	<link href="css/aa.css" rel="stylesheet" type="text/css">

<title>Find</title>
</head>
<body>
<form action="/WriteToFuture/UserIdReturn" method="post">
	<table align="center">
	<tr>
			<td><input id="userid" name="userid" type="text"></td>
			<td><em id="userna" >用户ID</em> </td>
	</tr>
	<tr>
		<td><button class="yes" type="submit">按id查</button></td>
		<td></td>
	</tr>
	</table>
</form>
<form action="/WriteToFuture/UserNameReturn" method="post">
	<table align="center">
	<tr>
			<td><input id="username" name="username" type="text"></td>
			<td><em id="username1" >用户名</em> </td>
	</tr>
	<tr>
		<td><button class="ok" type="submit">按名字查</button></td>
		<td></td>
	</tr>
	</table>

</form>
</body>
</html>