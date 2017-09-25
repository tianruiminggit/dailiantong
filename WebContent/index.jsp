<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en" class="no-js">

    <head>

        <meta charset="utf-8">
        <title>Fullscreen Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel="stylesheet" href="assets/css/reset.css">
        <link rel="stylesheet" href="assets/css/supersized.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        
          <!-- Bootstrap core CSS -->
<!--     <link href="css/bootstrap.css" rel="stylesheet">

    Add custom CSS here
    <link href="css/sb-admin.css" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css"> -->

    </head>

    <body>

        <div class="page-container">
            <h1>login</h1>
            <form action="user.do" method="post" style="position:relative;">
             <input type="hidden" name="method" value="userLogin" id="type">
                <input type="text" name="userAccount" class="username" placeholder="Username">
                <label style="color: red">${msg }</label>
                <input type="password" name="password" class="password" placeholder="Password">
                
                <div>
                 	<select id="select" onchange="loginType()" style="position:absolute;bottom:-30%;left:0;border-radius:5px" class="form-control select2"> 
  	  					<option selected="selected" value="userLogin">user</option>
  	  					<option value="login">admin</option>
  	  				</select>
  	  			</div>
                
                
                <button type="submit" style="position:absolute;bottom:-70%;left:0">登录</button>
                <div class="error"><span>+</span></div>
                
               <!--  
                <div class="btn-group">
                  <button type="button" class="btn btn-default">用户</button>
                  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"><span class="caret"></span></button>
                  <ul class="dropdown-menu">
                    <li><a href="#">管理员</a></li>
                   
                  </ul>
                </div>
                 -->
                 <div align="center" style="position:absolute;bottom:-110%;left:20%">还没有账号 <a href="regist.jsp" target="_blank" title="注册">注册代练通</a></div>
               
            </form>
            
            <div class="connect">
                <p></p>
                <p></p>
            </div>
        </div>
      
        <!-- Javascript -->
        <script src="assets/js/jquery-1.8.2.min.js"></script>
        <script src="assets/js/supersized.3.2.7.min.js"></script>
        <script src="assets/js/supersized-init.js"></script>
        <script src="assets/js/scripts.js"></script>
   <!--      <a href="gameServlet.do?method=getListEveryDayOrderNum">asd</a> -->
      <!--   <a href="gameServlet.do?method=getListEveryDayOrderNum">asd</a> -->

    </body>

<script>
/* function login(){
	var accountValue=$("#username").val();
	var pwd=$("#password").val();
	
	if(accountValue.trim()==""){
		alert("请输入用户名！");
		$("#username").focus();
		$("#username").select();
	}else if(pwd.trim()==""){
		alert("请输入密码！");
		document.getElementById("password").focus();
		document.getElementById("password").select();
	}
}
 */
function loginType(){
	 
		document.getElementById("type").value=document.getElementById("select").value;
		
	}
	function regist(){
		window.location.href="regist.jsp";
	}
	

</script>
</html>

