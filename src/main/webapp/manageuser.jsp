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
<form action="/WriteToFuture/AddUser" method="post">
	<table align="center">
	<tr>
			<td><input id="userid" name="userid" type="text"></td>
			<td><em id="userna" >用户ID</em> </td>
	</tr>
	<tr>
			<td><input id="userType" name="userType" type="text"></td>
			<td><em >userType</em> </td>
	</tr>
	<tr>
			<td><input id="username" name="username" type="text"></td>
			<td><em >userName</em> </td>
	</tr>
	<tr>
			<td><input id="password" name="password" type="text"></td>
			<td><em >PASSWORD</em> </td>
	</tr>
	<tr>
			<td><input id="sex" name="sex" type="text"></td>
			<td><em >sex</em> </td>
	</tr>
	<tr>
		<td><button class="yes" type="submit">添加</button></td>
		<td></td>
	</tr>
	</table>
</form>
<form action="/WriteToFuture/DeleteUser" method="post">
	<table align="center">
	<tr>
			<td><input id="userid" name="userid" type="text"></td>
			<td><em >INPUT USERID TO DELETE</em> </td>
	</tr>
	<tr>
		<td><button class="ok" type="submit">删除</button></td>
		<td></td>
	</tr>
	</table>

</form>
<form action="/WriteToFuture/UpDateUser" method="post">
	<table align="center">
	<tr>
			<td><input id="userid" name="userid" type="text"></td>
			<td><em id="userna" >用户ID</em> </td>
	</tr>
	<tr>
			<td><input id="userType" name="userType" type="text"></td>
			<td><em >userType</em> </td>
	</tr>
	<tr>
			<td><input id="username" name="username" type="text"></td>
			<td><em >userName</em> </td>
	</tr>
	<tr>
			<td><input id="password" name="password" type="text"></td>
			<td><em >PASSWORD</em> </td>
	</tr>
	<tr>
			<td><input id="sex" name="sex" type="text"></td>
			<td><em >sex</em> </td>
	</tr>
	<tr>
		<td><button class="cancel" type="submit">更新</button></td>
		<td></td>
	</tr>
	</table>

</form>
</body>
</html>