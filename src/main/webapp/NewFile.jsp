<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>实验二</title>
</head>
<body>
<h1 style="text-align:center;color:red;">用户注册</h1>
<form action="">
	<table align="center">
		<tr>
			<td><em style="color:red;">*</em>用户名:</td>
			<td><input id="username" type="text" onBlur="return checkUserName()"></td>
			<td><em id="username1" >用户名由3-5个字节组成</em> </td>
		</tr>
		<tr>
			<td><em style="color:red;">*</em>密码:</td>
			<td><input id="password" type="password" onBlur="return checkPassWord()"></td>
			<td><em id="password1">请输入8-12位密码</em> </td>
		</tr>
		<tr>
			<td><em style="color:red;">*</em>确认密码:</td>
			<td><input id="password2" type="password" onBlur="return checkPassWord()"></td>
			<td><em id="password3" >确认密码</em> </td>
		</tr>
		<tr>
			<td><em style="color:red;">*</em>email</td>
			<td><input id="email" type="text"></td>
			<td><em id="email1" >格式示例:XXXXXXXXX@163.com</em> </td>
		</tr>
		<tr>
			<td><em style="color:red;">*</em>手机号码</td>
			<td><input id="phone" onBlur="return checkPhone()" type="text" onkeypress="return event.keyCode>=48&&event.keyCode<=57"  /></td>
			<td><em id="phone1">格式示例：13892384299</em> </td>
		</tr>
		<tr>
			<td><a style="color:red;">*</a>真实姓名:</td>
			<td><input id="name" onBlur="return checkName()" type="text"></td>
			<td><em id="name1" >由2-5个中文组成</em> </td>
		</tr>
		<tr>
			<td><em style="color:red;">*</em> 省份:</td>
			<td><select>
			<option value="value1">江西</option>
			<option value="value1">贵州</option>
			<option value="value1">河南</option>
			<option value="value1">北京</option>
			</select></td>
			<td><em id="province" >请选择省份</em> </td>
		</tr>
		<tr>
			<td><em style="color:red;">*</em>技术方向:</td>
			<td colspan="2">
				<input type="radio" name="tech" checked="checked">Java
				<input type="radio" name="tech">.NET
				<input type="radio" name="tech">PHP
				<input type="radio" name="tech">网页
				<input type="radio" name="tech">IOS
				<input type="radio" name="tech">Android
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" name="submit" value="注册"/>
				<input type="reset" name="reset" value="重置"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>