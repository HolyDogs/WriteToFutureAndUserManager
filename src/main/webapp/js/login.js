function checkUserName(){
	var usernamelength = document.getElementById("usernum").value.length;
	if(usernamelength>10||usernamelength<2){
		document.getElementById("username1").style.display="block";
		document.getElementById("usernum").focus();
		return false;
	}
	else{
		document.getElementById("username1").style.display="none";
	}
	
}

function checkPassWord(){
	var regs = /^[a-zA-Z0-9]+$/;
	if(document.getElementById("password").value.length<3||document.getElementById("password").value.length>18||!regs.test(document.getElementById("password").value))
	{
		document.getElementById("passwordtext").style.display="block";
		return false;
	}
	else{
		document.getElementById("passwordtext").style.display="none";
	}
}