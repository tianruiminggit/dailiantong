<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Forms - SB Admin</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="css/sb-admin.css" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
  </head>

  <body>

    <div id="wrapper">

      <!-- Sidebar -->
      <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.html">代练通首页</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
          <ul class="nav navbar-nav side-nav">
            <li><a href="user.do?method=userLogin">首页</a></li>
            <li><a href="orderServlet.do?method=getListAllOrder&status=4">接单大厅</a></li>
            <li><a href="orderServlet.do?method=getListReleaseOrder">发单管理</a></li>
            <li><a href="orderServlet.do?method=getListReceiveOrder">接单管理</a></li>
            <li class="active"><a href="userAccount?method=getListUserAccount">个人资料</a></li>
			<li><a href="moneyServlet.do?method=getListMoney">资金管理</a></li>
            <!-- <li><a href="gameSetting.html">游戏设置</a></li> -->
            <li><a href="employeeServlet.do?method=getListEmployee">员工管理</a></li>
            <li><a href="childUserServlet.do?method=getListChildUser">子帐号管理</a></li>
          </ul>

    
            <ul class="nav navbar-nav navbar-right navbar-user">
            <li class="dropdown user-dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${nickName} <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <!-- <li><a href="#"><i class="fa fa-user"></i> Profile</a></li>
                <li><a href="#"><i class="fa fa-envelope"></i> Inbox <span class="badge">7</span></a></li>
                <li><a href="#"><i class="fa fa-gear"></i> Settings</a></li>
                <li class="divider"></li> -->
                <li><a href="#"><i class="fa fa-power-off"></i> Log Out</a></li>
              </ul>
            </li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </nav>
      <div id="page-wrapper">
        <div class="row">
          <div class="col-lg-12">
            <h1>个人资料<small></small></h1>
            <ol class="breadcrumb">
              <li><a href="user.do?method=userLogin"><i class="fa fa-dashboard"></i> 首页</a></li>
              <li class="active"><i class="fa fa-edit"></i> 个人资料</li>
            </ol>
            <!-- <div class="alert alert-info alert-dismissable">
              <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
              Visit <a class="alert-link" target="_blank" href="http://getbootstrap.com/css/#forms">Bootstrap's Form Documentation</a> for more information.
            </div> -->
          </div>
        </div><!-- /.row -->
        
        <div class="row">
          <form role="form">
	          <div class="col-lg-6">
	            <h1>基本信息</h1>
		            <table class="table table-bordered table-hover tablesorter">
		                <tbody>
		                	<tr>
		                    <td>我的账号：</td>
		                    <td>${ListUserAccount[0].user_account}</td>
		                  </tr>
		                  <tr>
		                    <td>我的昵称：</td>
		                    <td>${ListUserAccount[0].user_nickName }</td>
		                  </tr>
		                  <tr>
		                    <td>邮箱：</td>
		                    <td>${ListUserAccount[0].user_email }</td>
		                  </tr>
		                  <tr>
		                    <td>电话：</td>
		                    <td>${ListUserAccount[0].user_tel }</td>
		                  </tr>
		                  <tr>
		                    <td>我的积分：</td>
		                    <td>${ListUserAccount[0].user_score }</td>
		                  </tr>
		                  <tr>
		                    <td>我的状态：</td>
		                    <td>${ListUserAccount[0].user_status }</td>
		                  </tr>
		                  <tr>
		                    <td>我的身份：</td>
		                    <td>${ListUserAccount[0].user_root }</td>
		                  </tr>
		                  <tr>
		                    <td>我的发单数量：</td>
		                    <td>${ListUserAccount[0].user_fcount }</td>
		                  </tr>
		                  <tr>
		                    <td>我的接单数量：</td>
		                    <td>${ListUserAccount[0].user_jcount }</td>
		                  </tr>
		                  <tr>
		                  	<td colspan="2" style="text-align: center;">
		                  		<a href="#" data-toggle="modal" data-target="#infoo">修改基本信息</a>
		                  		<a href="#" id="pass" data-toggle="modal" data-target="#info">修改密码</a>
		                  	</td>
		                  </tr>
		                </tbody>
		             </table>
          	</div>
          	<!-- <div class="col-lg-6">
	            <h1>信誉度</h1>
		            <table class="table table-bordered table-hover tablesorter">
		                <tbody>
		                	<tr>
		                    <td rowspan="2" style="text-align: center;">来自上家评价</td>
		                    <td>1265</td>
		                    <td>邮箱：</td>
		                  </tr>
		                  <tr>
		                    <td>邮箱：</td>
		                    <td>邮箱：</td>
		                  </tr>
		                  <tr>
		                    <td rowspan="2" style="text-align: center;">来自下家评价</td>
		                    <td>1265</td>
		                    <td>邮箱：</td>
		                  </tr>
		                  <tr>
		                    <td>邮箱：</td>
		                    <td>邮箱：</td>
		                  </tr>
		                </tbody>
		             </table>
          	</div> -->
          </form>
          <div class="modal fade" id="infoo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" id="hide">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header alert-info">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
								&times;
							</button>
							<h4 class="modal-title" id="myModalLabel">
								请修改个人信息
							</h4>
						</div>
						<div class="modal-body" style="height: 500px;overflow-y:auto ;">
					    <form action="">
							<label>我的帐号</label>
							<input readonly type="text" id="user_account"  class="form-control" value="${ListUserAccount[0].user_account}">
							<label>我的昵称</label>
							<input type="text" id="user_nickName"  class="form-control" value="${ListUserAccount[0].user_nickName }">
							<label>邮箱</label>
							<input type="text" id="user_email"  class="form-control" value="${ListUserAccount[0].user_email }">
							<label>电话</label>
							<input type="text" id="user_tel"  class="form-control" value="${ListUserAccount[0].user_tel }">
							<label>我的积分</label>
							<input readonly type="text" id="user_score"  class="form-control" value="${ListUserAccount[0].user_score }">
							<label>我的状态</label>
							<input readonly type="text" id="user_status"  class="form-control" value="${ListUserAccount[0].user_status }">
							<label>我的身份</label>
							<input readonly type="text" id="user_root"  class="form-control" value="${ListUserAccount[0].user_root }">
							<label>我的发单数量</label>
							<input readonly type="text" id="user_fcount"  class="form-control" value="${ListUserAccount[0].user_fcount }">
							<label>我的接单数量</label>
							<input readonly type="text" id="user_jcount"  class="form-control" value="${ListUserAccount[0].user_jcount }">
						</form>
					</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">取消
							</button>
							<button onclick="upUseraccount(${ListUserAccount[0].user_account})" type="button" class="btn btn-primary">
								提交
							</button>
						</div>
					</div><!-- /.modal-content -->
				</div><!-- /.modal -->
			</div><!-- /.model fade -->  
			<div class="modal fade" id="info" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" id="hide">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header alert-info">
							<button type="button" id="close" class="close" data-dismiss="modal" aria-hidden="true">
								&times;
							</button>
							<h4 class="modal-title" id="myModalLabel">
								请修改个人密码
							</h4>
						</div>
						<div class="modal-body" style="height: 500px;overflow-y:auto ;">
					    <form action="">
							<label>旧密码</label>
							<input type="text" id="user_password" onchange="pdPwd()" class="form-control">
							<label>新密码</label>
							<input type="text" id="user_newPassword"  class="form-control">
							<label>确认密码</label>
							<input type="text" id="user_newPassword2" onchange="pd()" class="form-control">
						</form>
					</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">取消
							</button>
							<button type="button" onclick="upPwd(${ListUserAccount[0].user_account})" class="btn btn-primary">
								提交
							</button>
						</div>
					</div><!-- /.modal-content -->
				</div><!-- /.modal -->
			</div><!-- /.model fade -->          
      </div><!-- /#page-wrapper -->
    </div><!-- /#wrapper -->

    <!-- JavaScript -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.js"></script>
	<script>
/* 	$("#close").click(function(){
		$("#user_password").attr("onBlur")=" ";
	}); */
		function upUseraccount(id){
			$.ajax({
				url:"userAccount",
				data:{"method":"upUser","userAccount":id,"nickName":$("#user_nickName").val(),"user_email":$("#user_email").val(),"user_tel":$("#user_tel").val()},
				dataType:"json",
				type:"post",
				success:function(result){
					if(1==result){
						alert("资料修改成功！");
						window.location.href="userAccount?method=getListUserAccount";
					}
				},
				error:function(){
					alert("请求参数失败");
				}
			});
		};
	/*修改密码  */	
	function upPwd(id){
		$.ajax({
			url:"userAccount",
			data:{"method":"upUserPwd","userAccount":id,"pass":$("#user_newPassword2").val()},
			dataType:"json",
			type:"post",
			success:function(result){
				if(1==result){
					alert("密码修改成功！");
					window.location.href="userAccount?method=getListUserAccount";
				}
			},
			error:function(){
				alert("请求参数失败");
			}
		});
	}
		
	function pdPwd(){
		//获得旧密码
		var pwd = $("#user_password").val();
		/*  alert(pwd);  */
		$.ajax({
			url:"user.do?method=getUserPay",
			dataType:"json",
			type:"post",
			success:function(result){
				 console.log(result); 
				if(pwd!=result.user_password){
					alert("旧密码错误！");
					$("#user_password").select();
					return;
				}
			},
			error:function(){
				alert("请求参数失败");
			},
		});
		
	}
	function pd(){
		var p1=$("#user_newPassword").val();
		var p2=$("#user_newPassword2").val();
		if(p1!=p2){
			alert("两次密码输入不相同");
			$("#user_newPassword2").select();
		}
	}
	
		
	$("#pass").click(function(){
		$("#user_password").val("");
		$("#user_newPassword").val("");
		$("#user_newPassword2").val("");
	});	
	</script>
  </body>
</html>