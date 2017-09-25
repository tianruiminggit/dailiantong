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
            <li><a href="user.do?method=userLogin">首页</a></li>
            <li class="active"><a href="orderServlet.do?method=getListAllOrder&status=4">接单大厅</a></li>
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
          </div>
        </div><!-- /.row -->
          <div class="col-lg-4">
            <div class="panel panel-primary">
              <div class="panel-heading">
                <h3 class="panel-title"><i class="fa fa-money"></i>全部订单</h3>
              </div>
              <div class="panel-body">
              	<div class="col-lg-12 pull-left">
              		<div class="btn-group pull-left">
		                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                      	所有游戏<span class="caret"></span>
                    	</button>
	                    <ul class="dropdown-menu">
	                      	<c:forEach items="${listGameName }" var="listGameName">
	                      		<li><a href="orderServlet.do?method=getListOrderByGame_name&orderType=${listGameName.game_name }">${listGameName.game_name }</a></li>
                      		</c:forEach>
                     	</ul>
		            </div>
	              	<div class="form-group input-group pull-right" style="width: 20%;">
                      	<input type="text" class="form-control"  placeholder="请输入订单号查询" id='zhi'>
							<span class="input-group-btn">
								<button class="btn btn-default" type="button" id="query"><i class="fa fa-search"></i></button>
							</span>
					</div>
                  <div class="btn-group pull-left">
		                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                      	不限价格<span class="caret"></span>
	                    </button>
	                    <ul class="dropdown-menu">
	                    	<li><a href="orderServlet.do?method=getListOrderByPrice&order_MaxPrice=100&order_MinPrice=1">1-100元</a></li>
	                      	<li><a href="orderServlet.do?method=getListOrderByPrice&order_MaxPrice=300&order_MinPrice=100">101-300元</a></li>
	                      	<li><a href="orderServlet.do?method=getListOrderByPrice&order_MaxPrice=500&order_MinPrice=300">301-500元</a></li>
	                      	<li><a href="orderServlet.do?method=getListOrderByPrice&order_MaxPrice=10000&order_MinPrice=500">500元以上</a></li>
	                    </ul>
		            </div>
		            <label class="col-sm-2 control-label pull-left" style="color: red;">${msg }</label>
				</div>
                <div class="table-responsive col-lg-12" style="overflow-x:auto; ">
                  <table class="table table-bordered table-hover tablesorter" style="text-align: center; width: 1600px;">
                    <thead>
                      <tr>
                        <th style="text-align: center;">订单号<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">游戏名<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">任务<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">代练要求<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">价格<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">保证金<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">发单时间<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">总天数<i class="fa fa-sort"></i></th>
                      	<th style="text-align: center;">发布者ID<i class="fa fa-sort"></i></th>
                      </tr>
                    </thead>
                    <tbody>
                    	<c:forEach items="${listOrder }" var="listOrder">
	                      <tr onclick="showInfo(${listOrder.order_id})"  data-toggle="modal" data-target="#infoo">
	                      	<td>${listOrder.order_id }</td>
	                        <td>${listOrder.order_gameName }</td>
	                        <td>${listOrder.order_content }</td>
	                        <td>${listOrder.order_task }</td>
	                        <td>${listOrder.order_price }</td>
	                        <td>${listOrder.order_bond }</td>
	                        <td>${listOrder.order_releaseTime }</td>
	                        <td>${listOrder.order_finishTime }</td>
	                        <td>${listOrder.user_account }</td>
	                      </tr>
                      </c:forEach>
                    </tbody>
                  </table>
                </div>
                ${bar }
                <!-- <div class="text-center">
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
              </div>
            </div>
          </div>
          <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" id="hide" style="visibility: hidden;">
			开始演示模态框
			</button>
	        <div class="modal fade" id="infoo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
				<div class="modal-dialog">
					<div class="modal-content">
						<form role="form" id="recleOrder">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
								&times;
							</button>
							<h4 class="modal-title" id="myModalLabel">
								订单详情显示
							</h4>
						</div>
						<div class="modal-body" style="height: 500px;overflow-y:auto ;">
								<label>账单编号</label>
								<input readonly  type="text" id="order_id" name="order_id" class="form-control">
								<label>发单人</label>
								<input readonly  type="text" id="user_account"  class="form-control">
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
								<label>发单时间</label>
								<input readonly type="text" id="order_releaseTime"  class="form-control">
								<label>完成时限</label>
								<input readonly type="text" id="order_finishTime"  class="form-control">
								<label>接单时间</label>
								<input readonly type="text" id="order_receiveTime"  class="form-control">
								<label>完成时间</label>
								<input readonly type="text" id="order_returnTime"  class="form-control">
								<label>账单状态</label>
								<input readonly type="text" id="status"  class="form-control">
							
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary"  data-dismiss="modal">取消</button>
							<button type="button" class="btn btn-primary"  data-dismiss="modal"  data-toggle="modal" data-target="#inffoo">接单</button>
						</div>
						</form>
					</div>
				</div>
			</div>
			<div class="modal fade" id="inffoo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
				<div class="modal-dialog">
					<div class="modal-content">
						<form role="form" id="payPWD">
							<div class="modal-header alert-info">
								<label>输入支付密码</label>
							</div>
							<div class="modal-body">
								<input type="password" class="form-control" name="payPwd">
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary" data-dismiss="modal" id="receive">
									确定
								</button>
							</div>
						</form>
					</div><!-- /.modal-content -->
				</div><!-- /.modal -->
			</div><!-- /.model fade -->
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
	<script>
	$("#query").click(function(){
    	var order_id=parseInt(document.getElementById("zhi").value);
    	url="orderServlet.do?method=getOrder&type=hallOrder&order_id="+order_id;
    	window.location.href=url;
    });
    
    $("#receive").click(function(){
    	//var data = $.extend($("#addOrder").serialize(),$("#payPWD").serialize());
		 var $recleOrder = $("#recleOrder").serialize();
		 var $payPwd = $("#payPWD").serialize();
		 if($payPwd == null){
			 alert("密码为空");
			 return;
		 }
		 /* alert($("#addOrder").serialize());
		 alert($("#payPWD").serialize());
		 var json = DataDeal.formToJson($("#addOrder").serialize());
		 alert(json);
		 alert(data); */
		 /* alert($addOrder);
		 alert($payPwd); */
		 var data = $recleOrder+'&'+$payPwd;
		 /* alert(data); */
		$.ajax({
			type:"post",
			dataType:"json",
			url:"orderServlet.do?method=recevieOrder",
			data:data,
			success:function(result){
				alert(result);
				window.location.href="orderServlet.do?method=getListAllOrder&status=4";
			},
			error:function(e){
				alert("请求失败："+e.responseText);
			}
		});
    });
    
    function showInfo(id){
		$("#hide").click();
	 		$.ajax({
					url:"orderServlet.do",
					data:{"method":"getOrderAjax","order_id":id},
					datatype:"json",
					type:"post",
					success: function(result){
						var json = eval(result);
						$("#order_id").val(json[0].order_id);
						$("#user_account").val(json[0].user_account);
						$("#order_price").val(json[0].order_price);
						$("#order_bond").val(json[0].order_bond);
						$("#order_task").val(json[0].order_task);
						$("#order_gameName").val(json[0].order_gameName);
						$("#order_gameInfo").val(json[0].order_gameInfo);
						$("#order_content").val(json[0].order_content);
						$("#order_releaseTime").val(json[0].order_releaseTime);
						$("#order_finishTime").val(json[0].order_finishTime);
						$("#order_receiveTime").val(json[0].order_receiveTime);
						$("#order_returnTime").val(json[0].order_returnTime);
						$("#status").val(json[0].status);
						}
					}); 
	};
	</script>
  </body>
</html>
