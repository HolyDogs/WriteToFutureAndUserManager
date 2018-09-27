<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>index</title>
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
	<script type="text/javascript" src="js/login.js" ></script>

  </head>
  
<body class="templatemo-bg-gray">
	<div class="container">
		<div class="col-md-12">
				<h1  class="margin-bottom-15">写给未来的信</h1>
			<br><br><br><br>
			<form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30"  action="/WriteToFuture/LoginServlet" method="post">				
		        <div class="form-group">
		          <div class="col-xs-12">		            
		            <div class="control-wrapper">
		            	<label for="username" class="control-label fa-label"><i class="fa fa-user fa-medium"></i></label>
		            	<input type="text" class="form-control" id="usernum" name="usernum" onBlur="return checkUserName()" placeholder="用户名">
		            	<label id="username1" style="display:none;color:red;">×</label>
		            </div>		            	            
		          </div>              
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
		          	<div class="control-wrapper">
		            	<label for="password" class="control-label fa-label"><i class="fa fa-lock fa-medium"></i></label>
		            	<input type="password" class="form-control" id="password" name="password" onBlur="return checkPassWord()" placeholder="密码">
		            	<label id="passwordtext" style="display:none;color:red;">×</label>
		            </div>
		          </div>
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
		          	<div class="control-wrapper">
		          		<label for="password" class="control-label fa-label"><i class="fa fa-lock fa-medium"></i></label>
		          		<input type="text" class="form-control" style="width:220px;float:left;" id="checknum" name="checknum" placeholder="验证码">
		          		<img style="float:left;margin-left:30px;" src="/WriteToFuture/CreateImg" />
		          	</div>
		          </div>
		        </div> 
		        <div class="form-group">
		          <div class="col-md-12">
		          	<div class="control-wrapper" >
		          		<input type="submit" value="Log in" class="btn btn-info">
		          	</div>
		          </div>
		        </div>
		      </form>  
		</div>
	</div>
</body>
</html>