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

    <title>公告</title>

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
          <a class="navbar-brand" href="user.do?method=login">代练通</a>
        </div>

        <!-- Collect the nav links, , and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
          <ul class="nav navbar-nav side-nav">
          	
          				<li><a href="user.do?method=login"><i class="fa fa-dashboard"></i> 首页 </a></li>
						<li><a href="appeal.do?method=getListAdminAppeal"><i class="fa fa-table"></i> 申诉管理</a></li>
						<li><a href="gameServlet.do?method=getListGame"><i class="fa fa-edit"></i> 游戏管理</a></li>
						<li><a href="orderServlet.do?method=getListAdminOrder"><i class="fa fa-font"></i> 订单管理</a></li>


						<li><a href="user.do?method=getUser&&where=0"><i class="fa fa-user"></i> 用户管理</a></li>
						 <li class="active"><a href="msgServlet?method=getAllNotice"><i class="fa fa-edit"></i> 平台信息管理</a></li>

           <!-- <li><a href="typography.html"><i class="fa fa-font"></i> Typography</a></li>
            <li><a href="bootstrap-elements.html"><i class="fa fa-desktop"></i> Bootstrap Elements</a></li>
            <li><a href="bootstrap-grid.html"><i class="fa fa-wrench"></i> Bootstrap Grid</a></li>
            <li><a href="blank-page.html"><i class="fa fa-file"></i> Blank Page</a></li>-->
           
          </ul>

         
					<ul class="nav navbar-nav navbar-right navbar-user">
						<li>
							<a href="appeal.do?method=getListAdminAppeal" class="dropdown-toggle"><i class="fa fa-bell"></i> 申诉消息 <span class="badge">${undoAppeal }</span></a>
						</li>
						<!--个人下拉-->
						<li class="dropdown user-dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${user } <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<!--<li><a href="#"><i class="fa fa-user"></i> Profile</a></li>
								<li><a href="#"><i class="fa fa-envelope"></i> Inbox <span class="badge">7</span></a></li>-->
							<!-- 	<li><a href="#"><i class="fa fa-gear"></i> 修改登录密码</a></li> -->
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
            <h1>公告 <small>平台公告信息管理</small></h1>
            <ol class="breadcrumb">
              <li><a href="user.do?method=login"><i class="fa fa-dashboard"></i> 首页</a></li>
              <li class="active"><i class="fa fa-edit"></i> 公告</li>
            </ol>
            
          </div>
        </div><!-- /.row -->

        <div class="row">
         <div class="col-lg-6">
 <p><a href="forward.do?method=forward&&url=newMsg.jsp"><button type="submit" class="btn btn-primary">发布新公告</button></a></p>
 		</div>
 
         <div class="col-lg-4">
            <div class="panel panel-primary">
              <div class="panel-heading">
                <h3 class="panel-title"><i class="fa fa-clock-o"></i> 近期公告</h3>
              </div>
              <div class="panel-body">
                <div class="list-group" >
                  <a class="list-group-item" >
                    <span class="badge">发布时间</span>
                    <i class="fa fa-calendar"></i> 公告标题
                    
                  </a>
                  
                  <c:forEach items="${msgList }" var="msg">
                  
		                  <a href="msgServlet?method=findNotice&notice_id=${msg.notice_id }" class="list-group-item">
		                    <span class="badge">${msg.notice_time}</span>
		                    <i class="fa fa-comment"></i>${msg.notice_title}
		                  </a>
		           </c:forEach>
                  
               ${bar }
           
              <!--     <div class="text-center" id="fenye">
				                  <ul class="pagination pagination-sm">
						                <li class=""><a href="#">&laquo;</a></li>
						                <li class="active"><a href="#">1</a></li>
						                <li><a href="#">2</a></li>
						                <li><a href="#">3</a></li>
						                <li><a href="#">4</a></li>
						                <li><a href="#">5</a></li>
						                <li><a href="#">&raquo;</a></li>
						          </ul>
                		</div> -->
            
                <!--<div class="text-right">
                  <a href="#">View All Activity <i class="fa fa-arrow-circle-right"></i></a>
                </div>-->
              </div>
            </div>
          </div>

      </div><!-- /#page-wrapper -->

    </div><!-- /#wrapper -->

    <!-- JavaScript -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.js"></script>


  </body>
</html>