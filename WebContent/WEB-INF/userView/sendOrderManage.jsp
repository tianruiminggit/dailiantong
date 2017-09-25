<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>代练通</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="css/sb-admin.css" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
    <!-- Page Specific CSS -->
    <link rel="stylesheet" href="css/morris-0.4.3.min.css">
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
          <a class="navbar-brand" href="user.do?method=userLogin">代练通首页</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
          <ul class="nav navbar-nav side-nav">
            <li class="active"><a href="user.do?method=userLogin">首页</a></li>
            <li><a href="orderServlet.do?method=getListAllOrder&status=4">接单大厅</a></li>
            <li><a href="orderServlet.do?method=getListReleaseOrder">发单管理</a></li>
            <li><a href="orderServlet.do?method=getListReceiveOrder">接单管理</a></li>
            <li><a href="userAccount?method=getListUserAccount">个人资料</a></li>
			<li><a href="moneyServlet.do?method=getListMoney">资金管理</a></li>
            <!-- <li><a href="gameSetting.html">游戏设置</a></li> -->
            <li><a href="employeeServlet.do?method=getListEmployee">员工管理</a></li>
            <li><a href="childUserServlet.do?method=getListChildUser">子帐号管理</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right navbar-user">
            <li class="dropdown user-dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${nickName } <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <!-- <li><a href="#"><i class="fa fa-user"></i> Profile</a></li>
                <li><a href="#"><i class="fa fa-envelope"></i> Inbox <span class="badge">7</span></a></li>
                <li><a href="#"><i class="fa fa-gear"></i> Settings</a></li>
                <li class="divider"></li> -->
                <li><a href="user.do?method=logout"><i class="fa fa-power-off"></i> Log Out</a></li>
              </ul>
            </li>
          </ul>
        </div>
      </nav>
		<div class="copyrights">Collect from <a href="http://www.cssmoban.com/"  title="网站模板">网站模板</a></div>
      <div id="page-wrapper">

        <div class="row">
          <div class="col-lg-12">
            <h1>接单大厅<small></small></h1>
            <ol class="breadcrumb">
              <li><a href="user.do?method=userLogin"><i class="fa fa-dashboard"></i> 首页</a></li>
              <li class="active"><i class="fa fa-edit"></i> 接单大厅</li>
            </ol>
            <div class="alert alert-success alert-dismissable">
              <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
              Welcome to SB Admin by <a class="alert-link" href="http://startbootstrap.com">Start Bootstrap</a>! Feel free to use this template for your admin needs! We are using a few different plugins to handle the dynamic tables and charts, so make sure you check out the necessary documentation links provided.
            </div>
          </div>
        </div><!-- /.row -->
          <div class="col-lg-4">
            <div class="panel panel-primary">
              <div class="panel-heading">
                <h3 class="panel-title"><i class="fa fa-money"></i>全部订单</h3>
              </div>
              <div class="panel-body">
              	<div>
              		<div class="btn-group pull-left">
		                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                      	所有游戏<span class="caret"></span>
                    	</button>
	                    <ul class="dropdown-menu">
	                      <li><a href="#">英雄联盟</a></li>
	                      <li><a href="#">王者荣耀</a></li>
	                      <li><a href="#">守望先锋</a></li>
                     	</ul>
		            </div>
		              <div class="btn-group pull-left">
		                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                      		所有段位<span class="caret"></span>
	                    </button>
	                    <ul class="dropdown-menu">
	                    	<li><a href="#">青铜</a></li>
	                      	<li><a href="#">白银</a></li>
	                      	<li><a href="#">黄金</a></li>
	                      	<li><a href="#">白金</a></li>
	                      	<li><a href="#">钻石</a></li>
	                      	<li><a href="#">大师</a></li>
	                      	<li><a href="#">王者</a></li>
	                     </ul>
		              </div>
	              	<div class="form-group input-group pull-right" style="width: 20%;">
                      <input type="text" class="form-control"  placeholder="请输入订单号查询">
										  <span class="input-group-btn">
											   <button class="btn btn-default" type="button"><i class="fa fa-search"></i></button>
										  </span>
									</div>
                  <div class="btn-group pull-left">
		                  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                      	不限价格<span class="caret"></span>
	                    </button>
	                    <ul class="dropdown-menu">
	                    	<li><a href="#">1-100元</a></li>
	                      	<li><a href="#">101-300元</a></li>
	                      	<li><a href="#">301-500元</a></li>
	                      	<li><a href="#">500元以上</a></li>
	                    </ul>
		            </div>
				      </div>
                <div class="table-responsive">
                  <table class="table table-bordered table-hover table-striped tablesorter" style="text-align: center;">
                    <thead>
                      <tr>
                        <th style="text-align: center;">订单号<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">游戏名<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">任务<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">状态<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">价格<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">保证金<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">发单时间<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">总小时<i class="fa fa-sort"></i></th>
                      	<th style="text-align: center;">发布者ID<i class="fa fa-sort"></i></th>
                      	<th style="text-align: center;">操作<i class="fa fa-sort"></i></th>
                      </tr>
                    </thead>
                    <tbody>
                    	<c:forEach items="${listAllOrder }" var="listAllOrder">
	                      <tr>
	                      	<td>${listReceiveOrder.order_id }</td>
	                        <td>${listReceiveOrder.order_gameName }</td>
	                        <td>${listReceiveOrder.order_content }</td>
	                        <td>${listReceiveOrder.order_status }</td>
	                        <td>${listReceiveOrder.order_price }</td>
	                        <td>${listReceiveOrder.order_bond }</td>
	                        <td>${listReceiveOrder.order_receiveTime }</td>
	                        <td>${listReceiveOrder.order_finishTime }</td>
	                        <td>${listReceiveOrder.user_account }</td>
	                        <td>
	                        	<button type="button" class="btn btn-primary">接单</button>
	                        </td>
	                      </tr>
                      </c:forEach>
                    </tbody>
                  </table>
                </div>
                <div class="text-center">
                  <ul class="pagination pagination-sm">
		                <li class=""><a href="#">&laquo;</a></li>
		                <li class="active"><a href="#">1</a></li>
		                <li><a href="#">2</a></li>
		                <li><a href="#">3</a></li>
		                <li><a href="#">4</a></li>
		                <li><a href="#">5</a></li>
		                <li><a href="#">&raquo;</a></li>
		              </ul>
                </div>
              </div>
            </div>
          </div>
        </div><!-- /.row -->

      </div><!-- /#page-wrapper -->

    </div><!-- /#wrapper -->

    <!-- JavaScript -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.js"></script>

    <!-- Page Specific Plugins -->    
    <script src="js/raphael-min.js"></script>
    <script src="js/morris-0.4.3.min.js"></script>
    <script src="js/morris/chart-data-morris.js"></script>
    <script src="js/tablesorter/jquery.tablesorter.js"></script>
    <script src="js/tablesorter/tables.js"></script>

  </body>
</html>
