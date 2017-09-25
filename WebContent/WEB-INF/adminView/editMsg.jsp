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

    <title>查看公告详情</title>

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
          <a class="navbar-brand" href="forward.do?method=forward&&url=index.jsp">代练通</a>
        </div>

        <!-- Collect the nav links, , and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
          <ul class="nav navbar-nav side-nav">
         
            
            
            <li ><a href="user.do?method=login"><i class="fa fa-dashboard"></i> 首页 </a></li>						
		    <li><a href="appeal.do?method=getListAdminAppeal"><i class="fa fa-table"></i> 申诉管理</a></li>
			<li><a href="forward.do?method=forward&&url=games.jsp"><i class="fa fa-edit"></i> 游戏管理</a></li>
            <li><a href="orderServlet.do?method=getListAdminOrder"><i class="fa fa-bar-chart-o"></i> 订单管理</a></li>
            <li ><a href="user.do?method=getUser&&where=0"><i class="fa fa-edit"></i> 用户管理</a></li>
            <li class="active"><a href="msgServlet?method=getAllNotice"><i class="fa fa-edit"></i> 平台信息管理</a></li>
            
            
         
           
          </ul>

          <ul class="nav navbar-nav navbar-right navbar-user">
<!--             <li class="dropdown messages-dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> 申诉 <span class="badge">7</span> <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li class="dropdown-header">7 New Messages</li>
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
            <h1> <small>公告详情</small></h1>
            <ol class="breadcrumb">
              <li><a href="msgServlet?method=getAllNotice"><i class="fa fa-dashboard"></i> 公告</a></li>
              
              <li class="active"><i class="fa fa-edit"></i> 公告详情</li>
            </ol>
            <!--<div class="alert alert-info alert-dismissable">
              <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
              Visit <a class="alert-link" target="_blank" href="http://getbootstrap.com/css/#forms">Bootstrap's Form Documentation</a> for more information.
            </div>-->
          </div>
        </div><!-- /.row -->

        <div class="row">
          <div class="col-lg-6">

 			</div>
 
            <form  action="msgServlet?method=updateNotice" method="post">
				<input type="hidden" name="notice_id" value="${notice.notice_id }">
              <div class="form-group">
                <label>公告标题</label>
                <input class="form-control" value="${notice.notice_title}" name="notice_title">
                <p class="help-block">公告标题文本</p>
              </div>
              
              
              <div class="form-group">
                <label>发表公告管理员名称</label>
                <input readonly class="form-control" value="${notice.manager_account}" name="${user }"> 
                <p class="help-block">发表公告管理员名称</p>
              </div>
              
               <div class="form-group">
                <label>发布时间</label>
                <input class="form-control" value="${notice.notice_time}" name="notice_time">
                <p class="help-block">发布时间</p>
              </div>
              
     

              <div class="form-group">
                <label>公告内容</label>
                <textarea class="form-control" rows="6" name="notice_content">${notice.notice_content }</textarea>
              </div>

            

              <button type="submit" class="btn btn-default">修改并重新发布</button>
             <button type="button" class="btn btn-default" onclick="del(${notice.notice_id})">删除</button>

            </form>

        </div>       

      </div><!-- /#page-wrapper -->

    </div><!-- /#wrapper -->

    <!-- JavaScript -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.js"></script>
    <script>
    function del(id){
    	var url="msgServlet?method=delNotice&notice_id="+id;
    	window.location.href=url;
    }
    </script>

  </body>
</html>
