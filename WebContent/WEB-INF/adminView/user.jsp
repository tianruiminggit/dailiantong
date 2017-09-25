<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Tables - SB Admin</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="css/sb-admin.css" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
        <style>
    	form label {
			display: block;
}
		form input {
		width: 50%;
}
    </style>

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
          <a class="navbar-brand" href="user.do?method=login">代练通</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
          <ul class="nav navbar-nav side-nav">
          	
       			<!-- 		<li><a href="forward.do?method=forward&&url=index.jsp"><i class="fa fa-dashboard"></i> 首页 </a></li>
						<li><a href="appeal.do?method=getListAdminAppeal"><i class="fa fa-table"></i> 申诉管理</a></li>
						<li><a href="forward.do?method=forward&&url=games.jsp"><i class="fa fa-edit"></i> 游戏管理</a></li>
						<li><a href="orderServlet.do?method=getListAdminOrder"><i class="fa fa-font"></i> 订单管理</a></li>
						<li class="active"><a href="user.do?method=getUser&&where=0"><i class="fa fa-user"></i> 用户管理</a></li>
						<li><a href="msgServlet?method=getAllNotice"><i class="fa fa-edit"></i> 平台信息管理</a></li>
       -->
      
      					<li><a href="user.do?method=login"><i class="fa fa-dashboard"></i> 首页 </a></li>
						<li><a href="appeal.do?method=getListAdminAppeal"><i class="fa fa-table"></i> 申诉管理</a></li>
						<li><a href="gameServlet.do?method=getListGame"><i class="fa fa-edit"></i> 游戏管理</a></li>
						<li><a href="orderServlet.do?method=getListAdminOrder"><i class="fa fa-font"></i> 订单管理</a></li>
						<li  class="active"><a href="user.do?method=getUser&&where=0"><i class="fa fa-user"></i> 用户管理</a></li>
						<li><a href="msgServlet?method=getAllNotice"><i class="fa fa-edit"></i> 平台信息管理</a></li>
      					
          </ul>

              <ul class="nav navbar-nav navbar-right navbar-user">
           <li>
							<a href="appeal.do?method=getListAdminAppeal" class="dropdown-toggle"><i class="fa fa-bell"></i> 申诉消息 <span class="badge">${undoAppeal }</span></a>
            </li>
            <li class="dropdown user-dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${user } <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<!--<li><a href="#"><i class="fa fa-user"></i> Profile</a></li>
								<li><a href="#"><i class="fa fa-envelope"></i> Inbox <span class="badge">7</span></a></li>-->
								<!-- <li><a href="#"><i class="fa fa-gear"></i> 修改登录密码</a></li> -->
								<li class="divider"></li>
								<li><a href="user.do?method=logout"><i class="fa fa-power-off"></i> Log Out</a></li>
							</ul>
						</li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </nav>

      <div id="page-wrapper">

        <div class="row">
          <div class="col-lg-12">
            <h1>用户管理 <small>管理员查询用户信息</small></h1>
            <ol class="breadcrumb">
              <li><a href="user.do?method=login"><i class="fa fa-dashboard"></i> 首页</a></li>
              <li class="active"><i class="fa fa-table"></i> 用户管理</li>
            </ol>
         
          </div>
        </div><!-- /.row -->
	
	
	 <div class="form-group input-group" style="width: 300px;">
                <input type="text" class="form-control" placeholder="输入用户账号" id="zhi">
                <span class="input-group-btn">
                  <button id="query" class="btn btn-default"  type="button" data-toggle="modal" data-target="#info"><i class="fa fa-search" ></i></button>
                </span>
              
          </div>
	
        <div class="row">
          <div class="col-lg-6">
        
 <div class="row">
          <div class="col-lg-4">
            <!--<h2 id="nav-tabs">Tabs</h2>-->
            <div class="bs-example">
              <ul class="nav nav-tabs" style="margin-bottom: 15px;">
                
                <li class="${all}"><a href="user.do?method=getUser&&where=0" >全部普通用户</a></li>
                <li class="${dong}"><a href="user.do?method=getUserDong&&where=2" >已被冻结用户</a></li>
                <li class="${online}"><a href="user.do?method=getUserOnline&&where=1" >当前在线用户</a></li>
        
        
           <%--      <li class="dropdown">
                  <a id="aaa" class="dropdown-toggle" data-toggle="dropdown" href="#">
                    	全部普通用户 <span class="caret"></span>
                  </a>
                  <ul class="dropdown-menu">
                  	<li id="alluser" class="${all}"> <a href="user.do?method=getUser&&where=0" data-toggle="tab">全部普通用户</a></li>
                  	<li class="divider" ></li>
                    <li id="foreignuser"  class="${dong}"><a href="user.do?method=getUserDong&&where=2"  data-toggle="tab">已被冻结用户</a></li>
                    <li class="divider"></li>
                    <li id="onlineuser"  class="${online }"><a href="user.do?method=getUserOnline&&where=1"  data-toggle="tab">当前在线用户</a></li>
                    
                  </ul>
                </li> --%>
             </ul>
              
              
              	
              
              
         <div id="myTabContent" class="tab-content">
              	
              	<!--全部普通用户-->
		<div class="tab-pane fade active in" id="home">
		<p>
			<div class="table-responsive">
				     	   
		         
		              <table class="table table-bordered table-hover tablesorter" >
				         
				                <thead>
				                  <tr class="success" >
				                  	
				                    <th>账号 <i class="fa fa-sort"></i></th>
				                    <th>昵称 <i class="fa fa-sort"></i></th>
				                    <th>邮箱<i class="fa fa-sort"></i></th>
				                    <th>电话 <i class="fa fa-sort"></i></th>
				                    <th>用户等级 <i class="fa fa-sort"></i></th>
				                    <th>可用资金 <i class="fa fa-sort"></i></th>
				                    <th>冻结资金 <i class="fa fa-sort"></i></th>
				                    <th>用户状态<i class="fa fa-sort"></i></th>
				                   <!--   <th>操作<i class="fa fa-sort"></i></th> -->
				                  </tr>
				                </thead>
		                <tbody>
		             <c:forEach items="${userList}" var="userlists">
		             	  <tr onclick="showInfo(${userlists.user_account})" data-toggle="modal" data-target="#info">
		                    <td>${userlists.user_account } </td>
		                    <td>${userlists.user_nickName } </td>
		                    <td>${userlists.user_email }</td>
		                    <td>${userlists.user_tel } </td>
		                    <td>${userlists.user_score }</td>
		                    <td>${userlists.platform_usableMoney }</td>
		                    <td>${userlists.platform_freezeMoney }</td>
		                    <td>${userlists.status } </td>
		                  </tr>
		             
		             </c:forEach>
		                
		                </tbody>
		              </table>
		                     
            </div>
		 ${bar }
 </div>
 
		 </div>
		</div>
	</div>
	</div>			                
				                
         
            
  
    
                   
          


      </div><!-- /#page-wrapper -->

    </div><!-- /#wrapper -->
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" id="hide" style="visibility: hidden;">
		开始演示模态框
		</button>

<div class="modal fade" id="info" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					用户详细信息显示
				</h4>
			</div>
			<div class="modal-body" style="height: 300px;overflow-y:auto; " >
			    
					
						<form action="">
							<label>用户账号</label>
							<input readonly type="text" id="user_account"  class="form-control">
							<label>用户昵称</label>
							<input readonly type="text" id="user_nickName"  class="form-control">
							<label>用户状态</label>
							<select class="form-control"  id="userStatus" > 
								
								
							
							
							
							
							</select>
							<!-- <input readonly type="text" id="user_status"  class="form-control"> -->
							<label>用户邮箱</label>
							<input readonly type="text" id="user_email"  class="form-control">
							<label>用户电话</label>
							<input readonly type="text" id="user_tel"  class="form-control">
							<label>用户等级</label>
							<input  type="text" id="user_score"  class="form-control">
							<label>可用资金</label>
							<input  type="text" id="platform_usableMoney"  class="form-control">
							<label>冻结资金</label>
							<input  type="text" id="platform_freezeMoney"  class="form-control">
							<label>最近登录时间</label>
							<input readonly type="text" id="user_loginTime"  class="form-control">
							
						</form>
									
			</div>
									<div class="modal-footer" >
										<button type="button" class="btn btn-danger"  data-dismiss="modal" style="margin-right:70%" onclick="del()">删除
										</button>
									
										<button type="button" class="btn btn-primary"  data-dismiss="modal" style="transition:all,4s" onclick="upUserStatus()">
											提交更改
										</button>
									</div>
			
		</div>
	</div>
</div> 



    <!-- JavaScript -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.js"></script>

    <!-- Page Specific Plugins -->
    <script src="js/tablesorter/jquery.tablesorter.js"></script>
    <script src="js/tablesorter/tables.js"></script>
 <script>
 	$("#query").click(function(){
				
					 $.ajax({
						url:"userAccount",
						data:{"method":"getUser","where":$("#zhi").val()},
						datatype:"json",
						type:"post",
						success: function(result){
							/* alert(result); */
							var json = eval(result);
							
							$("#user_account").val(json[0].user_account);
							$("#user_nickName").val(json[0].user_nickName);
							$("#userStatus").val(json[0].status);
							$("#user_email").val(json[0].user_email);
							$("#user_tel").val(json[0].user_tel);
							$("#user_score").val(json[0].user_score);
							$("#platform_usableMoney").val(json[0].platform_usableMoney);
							$("#platform_freezeMoney").val(json[0].platform_freezeMoney);
							$("#user_loginTime").val(json[0].user_loginTime);
							
							
							}
						}); 
			});
				
				
		function showInfo(id){
			/* var userStatus= document.getElementById("userStatus");
			 */
			 $.ajax({
						url:"userAccount",
						data:{"method":"getUser","where":id},
						datatype:"json",
						type:"post",
						success: function(result){
							var json = eval(result);
							$("#user_account").val(json[0].user_account);
							$("#user_nickName").val(json[0].user_nickName);
							$("#user_status").val(json[0].status);
							$("#user_email").val(json[0].user_email);
							$("#user_tel").val(json[0].user_tel);
							$("#user_score").val(json[0].user_score);
							$("#platform_usableMoney").val(json[0].platform_usableMoney);
							$("#platform_freezeMoney").val(json[0].platform_freezeMoney);
							$("#user_loginTime").val(json[0].user_loginTime);
							
							/* alert(json[0].status); */
							
							if("被冻结"==json[0].status){
									$("#userStatus").empty();
									$("#userStatus").append("<option select='selected'>"+json[0].status+"</option>"+
													"<option> 正常</option> "); 
							}else{
									$("#userStatus").empty();
									$("#userStatus").append("<option select='selected'>"+json[0].status+"</option>"); 
							}
							
							},
							error:function(){
								alert("请求参数失败");
							}
						}); 
		};
		
		function upUserStatus(){
		
		    var user_account=$("#user_account").val();
			var user_status = $("#userStatus").val();
			var user_score= $("#user_score").val();
			var platform_usableMoney = $("#platform_usableMoney").val();
			var platform_freezeMoney = $("#platform_freezeMoney").val();
			/* alert(userStatus);
			 */
			$.ajax({
				url:"userAccount",
				data:{"method":"updateUser","user_account":user_account,
					"user_status":user_status,"user_score":user_score,"platform_usableMoney":platform_usableMoney
					,"platform_freezeMoney":platform_freezeMoney},
				dateType:"json",
				type:"post",
				success:function(result){
					if(result!=null){
						alert("修改成功!");
						window.location.href="user.do?method=getUser&&where=0";
					}
				},
				error:function(){
				alert("请求参数失败!");
				}
				
			});
		}
		
		
		function del(){
		alert("删除成功");
			var account=document.getElementById("user_account").value;
			window.location.href="user.do?method=delUser&&account="+account;
		
		};		
					
			
			
			
		
    </script>
  </body>
</html>



