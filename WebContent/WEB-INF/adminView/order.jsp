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

    <title>订单管理</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="css/sb-admin.css" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
    <!-- Page Specific CSS -->
    <link rel="stylesheet" href="css/morris-0.4.3.min.css">
  </head>
  <style>
    .tr1 th{
    	width:150px;
    	height:50px;
    }
 #special1, #special2, #special3, #special4, #special5{
      width:300px;
  }
  </style>
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
          				<!-- <li><a href="forward.do?method=forward&&url=index.jsp"><i class="fa fa-dashboard"></i> 首页 </a></li>
						<li><a href="appeal.do?method=getListAdminAppeal"><i class="fa fa-table"></i> 申诉管理</a></li>
						<li><a href="forward.do?method=forward&&url=games.jsp"><i class="fa fa-edit"></i> 游戏管理</a></li>
						<li class="active"><a href="orderServlet.do?method=getListAdminOrder"><i class="fa fa-font"></i> 订单管理</a></li>
						<li><a href="user.do?method=getUser&&where=0"><i class="fa fa-user"></i> 用户管理</a></li>
						<li><a href="msgServlet?method=getAllNotice"><i class="fa fa-edit"></i> 平台信息管理</a></li>
             -->
            
         				<li ><a href="user.do?method=login"><i class="fa fa-dashboard"></i> 首页 </a></li>
						<li><a href="appeal.do?method=getListAdminAppeal"><i class="fa fa-table"></i> 申诉管理</a></li>
						<li><a href="gameServlet.do?method=getListGame"><i class="fa fa-edit"></i> 游戏管理</a></li>
						<li class="active"><a href="orderServlet.do?method=getListAdminOrder"><i class="fa fa-font"></i> 订单管理</a></li>
						<li><a href="user.do?method=getUser&&where=0"><i class="fa fa-user"></i> 用户管理</a></li>
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
            <h1>账单管理 <small>管理员查询账单</small></h1>
            <ol class="breadcrumb">
              <li><a href="user.do?method=login"><i class="fa fa-dashboard"></i> 首页</a></li>
              <li class="active"><i class="fa fa-table"></i> 账单管理</li>
            </ol>
            
          </div>
        </div><!-- /.row -->

        <div class="row">
          <div class="col-lg-6" style="background-color:#fff">
                 <div class="form-group">
                <label>查询账单</label>
              <!--  <input class="form-control" value="输入账单号"> <button type="submit" class="btn btn-primary">搜索</button>-->
              <div class="form-group input-group" style="width: 300px;">
                <input type="text" class="form-control" placeholder="输入账单号" id="zhi">
                <span class="input-group-btn">
                  <button class="btn btn-default" type="button" onclick="query()"><i class="fa fa-search"></i></button>
                </span>
              
          </div>

              
               			<p class="help-block"><button onclick="alls()"  class="btn btn-default show-toggle">全部订单</button>
               			<span>&nbsp;&nbsp;</span><button onclick="wait()"    class="btn btn-default">等待验收</button>
                		<span>&nbsp;&nbsp;</span><button onclick="exception()"  class="btn btn-default">异常账单</button>
                		<span>&nbsp;&nbsp;</span><button onclick="ing()"        class="btn btn-default">正在代练</button>
                		<span>&nbsp;&nbsp;</span><button onclick="wad()"        class="btn btn-default">未接手账单</button>
                		<span>&nbsp;&nbsp;</span><button onclick="finish()"     class="btn btn-default">已完成账单</button>
              </div>
            <div class="table-responsive " style="overflow-x:auto">
              <table class="table table-bordered table-hover tablesorter" style="width:1600px;background-color:white;">
                <thead>
                  <tr class="tr1"  >
                    <th id="special5">账单编号  <i class="fa fa-sort"></i></th>
                    <th>发单人 <i class="fa fa-sort"></i></th>
                    <th>接单人 <i class="fa fa-sort"></i> </th>
                    <th>账单价格 <i class="fa fa-sort"></i></th>
                    <th id="special4">账单任务 <i class="fa fa-sort"></i></th>
                     <th id="special1">发单时间 <i class="fa fa-sort"></i></th>
                    <th>完成时限  <i class="fa fa-sort"></i></th>
                   
                    <th>下架时限 <i class="fa fa-sort"></i> </th>
             		<th id="special2">接单时间 <i class="fa fa-sort"></i> </th>
                    <th id="special3">完成时间 <i class="fa fa-sort"></i></th>
                    <th >账单状态 <i class="fa fa-sort"></i></th>
                   <!--   <th>操作 </th> -->
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${listOrder }" var="AllOrder">
                    <tr onclick="showInfo(${AllOrder.order_id})"  data-toggle="modal" data-target="#info" >
                    <td>${AllOrder.order_id }</td>
                    <td>${AllOrder.user_account }</td>
                    <td>${AllOrder.use_user_account }</td>
                    <td>${AllOrder.order_price }</td>
                     <td>${AllOrder.order_task }</td>
                    <td>${AllOrder.order_releaseTime }</td>
                    <td>${AllOrder.order_finishTime }</td>
                    <td>${AllOrder.order_deleteTime }</td>
                    <td>${AllOrder.order_receiveTime }</td>
                    <td>${AllOrder.order_returnTime }</td>
                    <td>${AllOrder.status }</td>
                   <!--  <td><a href="#">取消账单</a></td> -->
                  </tr>
                 </c:forEach>
                    
                </tbody>
              </table>
            </div>
            
             ${bar }
            
            
             <!--  <div class="text-center" id="fenye">
                  <ul class="pagination pagination-sm">
		                <li class=""><a href="#">&laquo;</a></li>
		                <li class="active"><a href="orderServlet.do?method=getListAdminOrder&&page=1">1</a></li>
		                <li><a href="orderServlet.do?method=getListAdminOrder&&page=2">2</a></li>
		                <li><a href="orderServlet.do?method=getListAdminOrder&&page=3">3</a></li>
		                <li><a href="orderServlet.do?method=getListAdminOrder&&page=4">4</a></li>
		                <li><a href="orderServlet.do?method=getListAdminOrder&&page=5">5</a></li>
		                <li><a href="#">&raquo;</a></li>
		          </ul>
                </div> -->
          
            
          </div>
    
    <!-- 订单详情显示 -->      
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
					订单详情显示
				</h4>
			</div>
			<div class="modal-body" style="height: 500px;overflow-y:auto ;">
			    
					
						<form action="">
							<label>账单编号</label>
							<input readonly  type="text" id="order_id"  class="form-control">
							<label>发单人</label>
							<input readonly  type="text" id="user_account"  class="form-control">
							<label>接单人</label>
							<input readonly  type="text" id="use_user_account"  class="form-control">
							<label>账单价格</label>
							<input readonly  type="text" id="order_price"  class="form-control">
							<label>保证金</label>
							<input readonly type="text" id="order_bond"  class="form-control">
							<label>账单任务</label>
							<input readonly type="text" id="order_task"  class="form-control">
							<label>游戏名称</label>
							<input readonly type="text" id="order_gameName"  class="form-control">
							<label>游戏信息</label>
							<textarea readonly class="form-control" rows="6" name="order_gameInfo"  id="order_gameInfo"></textarea>
							<label>账单内容要求</label>
							<textarea readonly class="form-control" rows="6" name="order_content"  id="order_content"></textarea>
							<!-- <input type="text" id="order_task"  class="form-control"> -->
							<label>发单时间</label>
							<input readonly type="text" id="order_releaseTime"  class="form-control">
							<label>完成时限</label>
							<input readonly type="text" id="order_finishTime"  class="form-control">
							<label>自动下架时限</label>
							<input readonly type="text" id="order_deleteTime"  class="form-control">
							<label>接单时间</label>
							<input readonly type="text" id="order_receiveTime"  class="form-control">
							<label>完成时间</label>
							<input readonly type="text" id="order_returnTime"  class="form-control">
							<label>账单状态</label>
							<input readonly type="text" id="status"  class="form-control">
							
						</form>
			
			</div>
			<div class="modal-footer">
				<!-- <button type="button" class="btn btn-primary"  data-dismiss="modal" style="margin-right:70%" onclick="del()">删除
				</button>
			 -->
				<button type="button" class="btn btn-primary"  data-dismiss="modal">
					确定
				</button>
			</div>
		</div>
	</div>
</div>        
</div><!-- /#page-wrapper -->
</div><!-- /#wrapper -->
</div>

    <!-- JavaScript -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.js"></script>

    <!-- Page Specific Plugins -->
    <script src="js/tablesorter/jquery.tablesorter.js"></script>
    <script src="js/tablesorter/tables.js"></script>
    
    <script>
    
    function alls(){
		var surl="orderServlet.do?method=getListAdminOrder";
		window.location.href=surl;
	};
    
    
	var status=0;
	var url="orderServlet.do?method=getListAdminOrderType&&where=";
	
    function wait(){
    	
    	status=1;
    	url=url+status;
		window.location.href=url;
    };
    function exception(){
    	status=3;
    	url=url+status;
		window.location.href=url;
    };
    function ing(){
    	status=5;
    	url=url+status;
		window.location.href=url;
    };
    function wad(){
    	status=4;
    	url=url+status;
		window.location.href=url;
    };
   function finish(){
    	status=6;
    	url=url+status;
		window.location.href=url;
    } 

    
    function showInfo(id){
		/* alert(id); */
		$("#hide").click();
	 		$.ajax({
					url:"orderServlet.do",
					data:{"method":"getOrderAjax","order_id":id},
					datatype:"json",
					type:"post",
					success: function(result){
						/* alert(result) */
						var json = eval(result);
						$("#order_id").val(json[0].order_id);
						$("#user_account").val(json[0].user_account);
						$("#use_user_account").val(json[0].use_user_account);
						$("#order_price").val(json[0].order_price);
						$("#order_bond").val(json[0].order_bond);
						$("#order_task").val(json[0].order_task);
						$("#order_gameName").val(json[0].order_gameName);
						$("#order_gameInfo").val(json[0].order_gameInfo);
						$("#order_content").val(json[0].order_content);
						$("#order_releaseTime").val(json[0].order_releaseTime);
						$("#order_finishTime").val(json[0].order_finishTime);
						$("#order_deleteTime").val(json[0].order_deleteTime);
						$("#order_receiveTime").val(json[0].order_receiveTime);
						$("#order_returnTime").val(json[0].order_returnTime);
						$("#status").val(json[0].status);
						}
					}); 
	
	
	};
    
    
    
    
    
    function query(){
    	var order_id=parseInt(document.getElementById("zhi").value);
    	alert(order_id);
    	url="orderServlet.do?method=getOrder&&order_id="+order_id;
    	window.location.href=url;	
    };

    </script>

 </body>
</html>