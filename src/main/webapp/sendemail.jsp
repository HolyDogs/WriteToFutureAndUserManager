<%@page import="com.me.domain.User"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="css/base.css" rel="stylesheet">
	<link href="css/index.css" rel="stylesheet">
	<link href="css/m.css" rel="stylesheet">
<title>WRITE</title>
<style type="text/css">
.item_submit
{
background-color:#8C7853;
width:150px;
height:40px;
font-size:15px;
color:#215E21;
font-weight:bold;
border-radius:10px;
}
.item_txt
{
border:1px solid green;
width:200px;
height:40px;
font-size:16px;
font-weight:bold;
}
</style>
</head>
<body>
<form action="/WriteToFuture/EmailSendServlet" method="post">
<header>
	<%
		User user=(User) request.getSession().getAttribute("loginUser");
		String username=user.getUserName();
	%>
  <div id="mnav">
    <div class="logo"><h3> <%=username %>| Write And Send It~</h3></div>
  </div>
</header>


<div class="line46"></div>
<div class="blank"></div>
<article>
  <div class="leftbox">
	<main>
    <div class="infos">
      <div class="newsview">
        <h2 class="intitle">WRITE TO FUTURE</h2>
        <h3 class="news_title">你想写一封信送给未来的自己或他人吗？</h3>
			<div class="news_author">
			<span class="au01"><a>今天</a></span>
			<span class="au02"><%=(new SimpleDateFormat("yyyy-MM-dd").format(new Date())) %>></span>
			<span class="au03">---WriteNow---</span>
			</div>
        <div class="tags"></div>
        <div class="news_about"><strong>这里写你的邮件标题(title):</strong><input class="item_txt" id="emailtitle" name="emailtitle" type="text" /></div>
        <div class="news_infos">
			<textarea id="emailbody" name="emailbody" style="margin: 0px; width: 732px; height: 373px;"></textarea>
		</div>
     </div>
 </div>
    <div class="news_pl">
      <h2>别忘了在右方填写发送地址和选择你想发送的那一天哦~</h2>
		<br/>
    </div>
	</main>
  </div>
<aside class="rightbox">

    <div class="paihang">
      <h2 class="ab_title"><a>DreamHere</a></h2>
      <ul>
	    <li align="center">
			<h2>年&nbsp;&nbsp;&nbsp;&nbsp;  			 	 月 	&nbsp;&nbsp;&nbsp;&nbsp;     	  		日</h2>
        </li>
        <li align="center">
			<select name="year">
				<option>2018</option>
				<%
					for(int i=1;i<20;i++){
						out.print("<option>"+(i+2018)+"</option>");
					}
				%>
			</select>
			<select name="month">
				<%
					for(int i=1;i<13;i++){
						if(i<10){
							out.print("<option>"+"0"+i+"</option>");
						}else{
						out.print("<option>"+i+"</option>");
						}
					}
				%>
			</select>
			<select name="day">
				<%
					for(int i=1;i<32;i++){
						
						if(i<10){
							out.print("<option>"+"0"+i+"</option>");
						}else{
						out.print("<option>"+i+"</option>");
						}
					}
				%>
			</select>
        </li>
		<li align="center">
			<h3>下面填上邮箱嗷^_^</h3>
        </li>
		<li align="center">
			<input class="item_txt" type="text" id="addr" name="addr" placeholder="exp:123456789@163.com"/>
		</li>
		<li align="center">
			<input class="item_submit" name="submit" type="submit" value="ClickMeToSend"/> 
		</li>
		<li align="center">
			<h4>或者您想要现在就发...</h4>
			<input class="item_submit" name="submit" type="submit" value="SendNow"/>
		</li>
      </ul>
    </div>
</aside>
</article>
<footer>
  <p>Design by <a href="/">--@github(HolyDogs)--</a> <a href="http://www.HolyDogs.github.io/" target="_blank">XFFFFF</a> <a href="http://www.HolyDogs.github.io/" target="_blank">------NoID-----</a><a href="http://www.HolyDogs.github.io/" target="_blank">WelCome~</a></p>
</footer>
</form>
</body>
</html>