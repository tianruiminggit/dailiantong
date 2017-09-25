<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>代练通注册</title>
		<style>
		.regist{
			width: 400px;
			margin: 100px auto;
		}
			form label{
				display: block;
			}
			form input{
				width: 100%;
				margin-top: 10px;
			}
		</style>
	</head>

	<body>
		<div class="regist">
			<fieldset>
				<legend>代练通用户注册</legend>
				<form action="user.do" method="post">
					<input type="hidden" name="method" value="regist">
					<label>账号</label>
					<input type="text" name="userAccount" />
					<label>昵称</label>
					<input type="text" name="nickName" />
					<label>密码</label>
					<input type="password" name="password" />
					<label>邮箱</label>
					<input type="email" name="email"/>
					<label>联系电话</label>
					<input type="tel" name="tel" />
					<input type="submit" value="注册"/>
					<label>${msg }</label>
				</form>
			</fieldset>
		</div>
	</body>

</html>