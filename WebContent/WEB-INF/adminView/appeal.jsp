<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
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
          			<!-- 	<li><a href="forward.do?method=forward&&url=index.jsp"><i class="fa fa-dashboard"></i> 首页 </a></li>
						<li class="active"><a href="appeal.do?method=getListAdminAppeal"><i class="fa fa-table"></i> 申诉管理</a></li>
						<li><a href="forward.do?method=forward&&url=games.jsp"><i class="fa fa-edit"></i> 游戏管理</a></li>
						<li><a href="forward.do?method=forward&&url=order.jsp"><i class="fa fa-font"></i> 订单管理</a></li>
						<li><a href="user.do?method=getUser"><i class="fa fa-user"></i> 用户管理</a></li>
						<li><a href="forward.do?method=getAllNotice&&url=msg.jsp"><i class="fa fa-edit"></i> 平台信息管理</a></li>
						 -->
						<li ><a href="user.do?method=login"><i class="fa fa-dashboard"></i> 首页 </a></li>
						<li class="active"><a href="appeal.do?method=getListAdminAppeal"><i class="fa fa-table"></i> 申诉管理</a></li>
						<li><a href="gameServlet.do?method=getListGame"><i class="fa fa-edit"></i> 游戏管理</a></li>
						<li><a href="orderServlet.do?method=getListAdminOrder"><i class="fa fa-font"></i> 订单管理</a></li>
						<li><a href="user.do?method=getUser&&where=0"><i class="fa fa-user"></i> 用户管理</a></li>
						<li><a href="msgServlet?method=getAllNotice"><i class="fa fa-edit"></i> 平台信息管理</a></li>
						
         <!-- 
         				<li><a href="forward.do?method=forward&&url=index.jsp"><i class="fa fa-dashboard"></i> 首页 </a></li>
						<li  class="active"><a href="appeal.do?method=getListAdminAppeal"><i class="fa fa-table"></i> 申诉管理</a></li>
						<li><a href="gameServlet.do?method=getListGame"><i class="fa fa-edit"></i> 游戏管理</a></li>
						<li><a href="orderServlet.do?method=getListAdminOrder"><i class="fa fa-font"></i> 订单管理</a></li>
						<li><a href="user.do?method=getUser&&where=0"><i class="fa fa-user"></i> 用户管理</a></li>
						<li><a href="msgServlet?method=getAllNotice"><i class="fa fa-edit"></i> 平台信息管理</a></li>
          -->
         
            <!--<li><a href="index.html"><i class="fa fa-dashboard"></i> Dashboard</a></li>
            <li><a href="charts.html"><i class="fa fa-bar-chart-o"></i> Charts</a></li>
            <li><a href="tables.html"><i class="fa fa-table"></i> Tables</a></li>
            <li class="active"><a href="forms.html"><i class="fa fa-edit"></i> Forms</a></li>
            <li><a href="typography.html"><i class="fa fa-font"></i> Typography</a></li>
            <li><a href="bootstrap-elements.html"><i class="fa fa-desktop"></i> Bootstrap Elements</a></li>
            <li><a href="bootstrap-grid.html"><i class="fa fa-wrench"></i> Bootstrap Grid</a></li>
            <li><a href="blank-page.html"><i class="fa fa-file"></i> Blank Page</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-caret-square-o-down"></i> Dropdown <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="#">Dropdown Item</a></li>
                <li><a href="#">Another Item</a></li>
                <li><a href="#">Third Item</a></li>
                <li><a href="#">Last Item</a></li>
              </ul>
            </li>-->
          </ul>

          <ul class="nav navbar-nav navbar-right navbar-user">
          	<!--导航的messages下拉-->
<!--            <li class="dropdown messages-dropdown">   
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> 投诉消息 <span class="badge">7</span> <b class="caret"></b></a>
              下拉的内容
              <ul class="dropdown-menu">
                <li class="dropdown-header">投诉标题</li>
                <li class="message-preview">
                  <a href="#">
                    <span class="avatar"><img src="http://placehold.it/50x50"></span>
                    <span class="name">John Smith:</span>
                    <span class="message">Hey there, I wanted to ask you something...</span>
                    <span class="time"><i class="fa fa-clock-o"></i> 4:34 PM</span>
                  </a>
                </li>
                <li class="divider"></li>
                <li class="message-preview">
                  <a href="#">
                    <span class="avatar"><img src="http://placehold.it/50x50"></span>
                    <span class="name">John Smith:</span>
                    <span class="message">Hey there, I wanted to ask you something...</span>
                    <span class="time"><i class="fa fa-clock-o"></i> 4:34 PM</span>
                  </a>
                </li>
                <li class="divider"></li>
                <li class="message-preview">
                  <a href="#">
                    <span class="avatar"><img src="http://placehold.it/50x50"></span>
                    <span class="name">John Smith:</span>
                    <span class="message">Hey there, I wanted to ask you something...</span>
                    <span class="time"><i class="fa fa-clock-o"></i> 4:34 PM</span>
                  </a>
                </li>
                <li class="divider"></li>
                <li><a href="#">View Inbox <span class="badge">7</span></a></li>
              </ul>
            </li> -->
            <!--alert下拉-->
            <li>
				<a href="appeal.do?method=getListAdminAppeal" class="dropdown-toggle"><i class="fa fa-bell"></i> 申诉消息 <span class="badge">${undoAppeal }</span></a>
            </li>
            <!--个人下拉-->
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
            <h1>申诉管理 <small>被冻结用户进行申诉进行解冻</small></h1>
            <ol class="breadcrumb">
              <li><a href="user.do?method=login"><i class="fa fa-dashboard"></i> 首页</a></li>
              <li class="active"><i class="fa fa-edit"></i> 申诉管理</li>
            </ol>
          </div>
          		<label style="color: red">${msg }</label>
          	<div class="form-group input-group pull-right" style="width: 300px;">
				<input type="text" class="form-control"  placeholder="搜索" id="search">
				<span class="input-group-btn">
                	<button class="btn btn-default" type="button" onclick="showInfo($('#search').val())"><i class="fa fa-search"></i></button>
            	</span>
			</div>
        </div><!-- /.row -->
        
        <div class="row">
          <div class="col-lg-4">
            <div class="bs-example">
              <ul class="nav nav-tabs" style="margin-bottom: 15px;">
                <li class="${all }"><a href="appeal.do?method=getListAdminAppeal" >全部</a></li>
                <li class="${account }"><a href="appeal.do?method=getListTypeAppeal&&appeal_type=0" >账号冻结</a></li>
                <li class="${money }"><a href="appeal.do?method=getListTypeAppeal&&appeal_type=1" >资金异常</a></li>
              </ul>
              <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade active in" id="all">
                  <div >
        			<table class="table table-hover">
	        		<tr class="success">
		        		<th>申诉编号</th>
		        		<th>申诉账号</th>
		        		<th>申诉类型</th>
		        		<th>申诉状态</th>
		        		<th>申诉时间</th>
	        		</tr>
	        	<tbody>
	        		<c:forEach items="${list}" var="appeal">
	        			<tr onclick="showInfo(${appeal.appeal_id})">
							<td>${appeal.appeal_id }</td>
							<td>${appeal.user_account }</td>
							<td>${appeal.appeal_type }</td>
							<td>${appeal.appeal_status }</td>
							<td>${appeal.appeal_time }</td>
						</tr>
	        		</c:forEach>
        		</table> 
        		${bar }
        </div>
       </div>
              </div>
            </div>
          </div>
        </div><!-- /.row -->
		<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" id="hide" style="visibility: hidden;">
		开始演示模态框
		</button>
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
				<form action="appeal.do" method="get">
				 	<input type="hidden" name="method" value="updateAppeal">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							申诉详情
						</h4>
					</div>
					<div class="modal-body">
							<input type="hidden" name="appeal_id" id="id">
							<label>申诉账号</label>
							<input type="text" id="userAccount">
							<label>申诉类型</label>
							<input type="text" id="type">
							<label>申诉内容</label>
							<textarea rows="3" cols="41" id="content"></textarea>
							<label>申诉时间</label>
							<input type="text" id="time">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
						<button type="submit" class="btn btn-primary">
							完成处理
						</button>
					</div>
					</form>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
        </div><!-- /.row -->
      </div><!-- /#page-wrapper -->
    </div><!-- /#wrapper -->

    <!-- JavaScript -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.js"></script>
	<script>
		function showInfo(id){
			$("#hide").click();
			$.ajax({
				url:"appeal.do",
				data:{"method":"getListAppeal","appeal_id":id},
				datatype:"json",
				type:"POST",
				success: function(result){//result-->接收servlet层返回的参数
					console.log("未处理==="+result);
					var json = eval(result);/* JSON解析 */
					console.log("已处理==="+json);
					//获取JSON数据中的值
					$("#id").val(json[0].appeal_id);
					$("#userAccount").val(json[0].user_account);
					$("#type").val(json[0].appeal_type);
					$("#content").val(json[0].appeal_content);
					$("#time").val(json[0].appeal_time);
				}
			});
		}
	</script>
  </body>
</html>