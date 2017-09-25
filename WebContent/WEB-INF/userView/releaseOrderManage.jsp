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
            <li><a href="orderServlet.do?method=getListAllOrder&status=4">接单大厅</a></li>
            <li class="active"><a href="orderServlet.do?method=getListReleaseOrder">发单管理</a></li>
            <li><a href="orderServlet.do?method=getListReceiveOrder">接单管理</a></li>
            <li><a href="userAccount?method=getListUserAccount">个人资料</a></li>
			<li><a href="moneyServlet.do?method=getListMoney">资金管理</a></li>
            <!-- <li><a href="gameSetting.html">游戏设置</a></li> -->
            <li><a href="employeeServlet.do?method=getListEmployee">员工管理</a></li>
            <li><a href="childUserServlet.do?method=getListChildUser">子帐号管理</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right navbar-user">
            <li class="dropdown user-dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i>  ${nickName }  <b class="caret"></b></a>
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
      </nav><!-- /.nav -->
		<div class="copyrights">Collect from <a href="http://www.cssmoban.com/"  title="网站模板">网站模板</a></div>
      <div id="page-wrapper">

        <div class="row">
          <div class="col-lg-12">
            <h1>发单管理<small></small></h1>
            <ol class="breadcrumb">
              <li><a href="user.do?method=userLogin"><i class="fa fa-dashboard"></i> 首页</a></li>
              <li class="active"><i class="fa fa-edit"></i> 发单管理</li>
            </ol>
          </div>
        </div><!-- /.row -->
        <div class="col-lg-4">
            <div class="panel panel-primary">
              <div class="panel-heading">
                <h3 class="panel-title"><i class="fa fa-money"></i>已发订单</h3>
              </div>
              <div class="panel-body">
              	<div class="col-lg-12 pull-left">
              		<div class="btn-group pull-left">
		                <button type="button" class="btn btn-default dropdown-toggle orderType" data-toggle="dropdown">
                      	所有游戏<span class="caret"></span>
	                    </button>
	                    <ul class="dropdown-menu">
	                      	<c:forEach items="${listGameName }" var="listGameName">
		                      <li><a href="orderServlet.do?method=getListOrderByGame_name&orderType=${listGameName.game_name }&type=releaseOrder"
		                      class="orderType">${listGameName.game_name }</a></li>
	                      	</c:forEach>
	                     </ul>
		            </div>
		            <div class="btn-group pull-left">
		                <button type="button" class="btn btn-default dropdown-toggle orderType" data-toggle="dropdown" id="orderType" value="0">
                      	全部发单<span class="caret"></span>
                    	</button>
	                    <ul class="dropdown-menu">
	                    	<li class="orderType"><a href="orderServlet.do?method=getListAllOrder&status=6&type=releaseOrder">完成</a></li>
	                      	<li class="orderType"><a href="orderServlet.do?method=getListAllOrder&status=5&type=releaseOrder">进行中</a></li>
	                      	<li class="orderType"><a href="orderServlet.do?method=getListAllOrder&status=1&type=releaseOrder">需要验单</a></li>
	                      	<li class="orderType"><a href="orderServlet.do?method=getListAllOrder&status=3&type=releaseOrder">异常订单</a></li>
	                      	<li class="orderType"><a href="orderServlet.do?method=getListAllOrder&status=4&type=releaseOrder">未接手订单</a></li>
	                     </ul>
		            </div>
	              	<div class="form-group input-group pull-left" style="width: 20%;">
		              	<input type="text" class="form-control"  placeholder="请输入订单号查询" id="zhi">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button" id="query"><i class="fa fa-search"></i></button>
						</span>
					</div>
					<button type="button" class="btn btn-success" data-toggle="modal" data-target="#info">我要发单</button>
					<label class="col-sm-2 control-label" style="color: red;">${msg }</label>
				</div>				
                <div class="table-responsive col-lg-12" style="overflow-x:auto; ">
                  <table class="table table-bordered table-hover tablesorter" style="text-align: center;width:1600px;">
                    <thead>
                      <tr>
                      	<th style="text-align: center;">订单号<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">游戏名<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">任务<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">游戏信息<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">代练要求<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">状态<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">价格<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">保证金<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">发单时间<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">接单时间<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">总天数<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">接单人ID<i class="fa fa-sort"></i></th>                  
                      </tr>
                    </thead>
                    <tbody>
                    	<c:forEach items="${listOrder }" var="listOrder">
	                     	<tr onclick="showInfo(${listOrder.order_id})"  data-toggle="modal" data-target="#infoo">
		                      	<td>${listOrder.order_id }</td>
		                        <td>${listOrder.order_gameName }</td>
		                        <td>${listOrder.order_content }</td>
		                        <td>${listOrder.order_gameInfo }</td>
	                        	<td>${listOrder.order_task }</td>
		                        <td>${listOrder.status }</td>
		                        <td>${listOrder.order_price }</td>
		                        <td>${listOrder.order_bond }</td>
		                        <td>${listOrder.order_releaseTime }</td>
		                        <td>${listOrder.order_receiveTime }</td>
		                        <td>${listOrder.order_finishTime }</td>
		                        <td>${listOrder.use_user_account }</td>
                      		</tr>
                      	</c:forEach>
                    </tbody>
                  </table>
                  ${bar }
                </div>
              <!--   <div class="text-center">
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
            <!-- model fade -->
            <div class="modal fade" id="info" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
				<div class="modal-dialog">
					<div class="modal-content">
					<form role="form" id="addOrder">
						<div class="modal-header alert-info">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
								&times;
							</button>
							<h4 class="modal-title" id="myModalLabel">
								请填写订单信息
							</h4>
						</div>
						<div class="modal-body" style="height:350px;">
							<div class="form-group">
								<label class="col-sm-2 control-label">选择游戏</label>
								<div class="col-sm-4 btn-group pull-left">
			                		<select class="form-control" name="gameName">
				                		<c:forEach items="${listGameName }" var="listGameName">
									      	<option>${listGameName.game_name }</option>
										</c:forEach>
    								</select>
								</div>
								<label class="col-sm-2 control-label">自动下架</label>
								<div class="col-sm-4 btn-group pull-left">
			                		<select class="form-control" name="deleteTime">
		                    				<option>7</option>
									      	<option>5</option>
									      	<option>3</option>
									      	<option>1</option>
				                    </select>
								</div>
								
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">游戏账号</label>
								<div class="col-sm-4">
									<input class="form-control" name="gameAccount">
								</div>
								<label class="col-sm-2 control-label">游戏密码</label>
								<div class="col-sm-4">
									<input class="form-control" type="password" name="password">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">电话</label>
								<div class="col-sm-4">
									<input class="form-control" name="tel">
								</div>
								<label class="col-sm-2 control-label">时限(天)</label>
								<div class="col-sm-4">
									<input class="form-control" name="finishTime">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">订单价格</label>
								<div class="col-sm-4">
									<input class="form-control" name="price">
								</div>
								<label class="col-sm-2 control-label">保证金</label>
								<div class="col-sm-4">
									<input class="form-control" name="bondPrice">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="col-sm-2 control-label">订单任务</label>
								<div class="col-sm-10">
									<textarea class="form-control" rows="1" name="task"></textarea>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="col-sm-2 control-label">当前角色信息</label>
								<div class="col-sm-10">
									<textarea class="form-control" rows="3" name="gameInfo"></textarea>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="col-sm-2 control-label">代练要求</label>
								<div class="col-sm-10">
									<textarea class="form-control" rows="3" name="content">我账号被异常冻结了</textarea>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">取消
							</button>
							<button type="submit" class="btn btn-primary" data-dismiss="modal" data-toggle="modal" data-target="#inffoo">
								发布订单
							</button>
						</div>
					</form>
					</div><!-- /.modal-content -->
				</div><!-- /.modal -->
			</div><!-- /.model fade -->
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
								<button type="button" class="btn btn-primary" data-dismiss="modal" id="insert">
									确定
								</button>
							</div>
						</form>
					</div><!-- /.modal-content -->
				</div><!-- /.modal -->
			</div><!-- /.model fade -->
			<div class="modal fade" id="inffooo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
				<div class="modal-dialog">
					<div class="modal-content">
						<form role="form" id="payPWDD">
							<div class="modal-header alert-info">
								<label>输入支付密码</label>
							</div>
							<div class="modal-body">
								<input type="password" class="form-control" name="payPwd">
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary" data-dismiss="modal" id="payUpdate">
									确定
								</button>
							</div>
						</form>
					</div><!-- /.modal-content -->
				</div><!-- /.modal -->
			</div><!-- /.model fade -->
			
			<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" id="hide" style="visibility: hidden;">
			开始演示模态框
			</button>
	        <div class="modal fade" id="infoo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
				<div class="modal-dialog">
					<div class="modal-content">
						<form role="form" id="updateOrder">
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
								<label>账单价格</label>
								<input type="text" id="order_price" name="order_price" class="form-control">
								<label>保证金</label>
								<input type="text" id="order_bond" name="order_bond" class="form-control">
								<label>游戏名称</label>
								<input readonly type="text" id="order_gameName" name="order_gameName" class="form-control">
								<label>游戏账号</label>
								<input readonly type="text" id="order_gameAccount" name="order_gameName" class="form-control">
								<label>游戏密码</label>
								<input readonly type="password" id="order_gamePassword" name="order_gamePassword" class="form-control">
								<label>游戏信息</label>
								<textarea class="form-control" rows="6" name="order_gameInfo"  id="order_gameInfo"></textarea>
								<label>账单内容要求</label>
								<textarea class="form-control" rows="6" name="order_content"  id="order_content"></textarea>
								<label>账单任务</label>
								<input type="text" id="order_task" name="order_task" class="form-control">
								<label>发单时间</label>
								<input readonly type="text" id="order_releaseTime" name="order_releaseTime" class="form-control">
								<label>完成时限</label>
								<input type="text" id="order_finishTime" name="order_finishTime" class="form-control">
								<label>完成时间</label>
								<input readonly type="text" id="order_returnTime" name="order_returnTime" class="form-control">
								<label>账单状态</label>
								<input readonly type="text" id="status" name="status" class="form-control">	
								<label>接单人</label>
								<input readonly  type="text" id="user_user_account" name="user_user_account" class="form-control">
								<label>接单时间</label>
								<input readonly type="text" id="order_receiveTime" name="order_receiveTime" class="form-control">
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary"  data-dismiss="modal">取消</button>
								<button type="button" class="btn btn-primary"  data-dismiss="modal" data-toggle="modal" data-target="#inffooo">更新订单</button>
								<button type="button" class="btn btn-primary"  data-dismiss="modal" id="repeal">撤单</button>
								<button type="button" class="btn btn-primary"  data-dismiss="modal" id="del">删除订单</button>
								<button type="button" class="btn btn-primary"  data-dismiss="modal" id="finish">完成订单</button>
							</div>
						</form>
					</div>
				</div>
			</div>  
          </div><!-- /.col-lg-4 -->
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
			/* $.ajaxSetup({  
			    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
			});  
			var DataDeal = {  
			//将从form中通过$('#form').serialize()获取的值转成json  
			           formToJson: function (data) {  
			               data=data.replace(/&/g,"\",\"");  
			               data=data.replace(/=/g,"\":\"");  
			               data="{\""+data+"\"}";  
			               return data;  
			            },  
			};  */
		$("#insert").click(function(){
			 //var data = $.extend($("#addOrder").serialize(),$("#payPWD").serialize());
			 var $addOrder = $("#addOrder").serialize();
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
			 var data = $addOrder+'&'+$payPwd;
			$.ajax({
				type:"post",
				dataType:"json",
				url:"orderServlet.do?method=insertOrder",
				data:data,
				success:function(result){
					alert(result);
				},
				error:function(e){
					alert("请求失败："+e.responseText);
				}
			});
		});
		$("#query").click(function(){
	    	var order_id=parseInt(document.getElementById("zhi").value);
	    	url="orderServlet.do?method=getOrder&type=releaseOrder&order_id="+order_id;
	    	window.location.href=url;
	    });
	    $("#repeal").click(function(){
	    	var order_id=parseInt(document.getElementById("order_id").value);
	    	url="orderServlet.do?method=deleteOrder&userType=releaseOrder&order_id="+order_id+"&methodType=repeal";
	    	window.location.href=url;
	    });
	    $("#del").click(function(){
	    	var order_id=parseInt(document.getElementById("order_id").value);
	    	url="orderServlet.do?method=deleteOrder&userType=releaseOrder&order_id="+order_id;
	    	window.location.href=url;
	    });
	    $("#finish").click(function(){
	    	var order_id=parseInt(document.getElementById("order_id").value);
	    	url="orderServlet.do?method=deleteOrder&userType=releaseOrder&order_id="+order_id+"&methodType=finish";
	    	window.location.href=url;
	    });
	    $("#payUpdate").click(function(){
	    	 var $updateOrder = $("#updateOrder").serialize();
			 var $payPwd = $("#payPWDD").serialize();
			 if($payPwd == null){
				 alert("密码为空");
				 return;
			 }
			 var data = $updateOrder+'&'+$payPwd;
	    	$.ajax({
	    		url:"orderServlet.do?method=updateOrder",
	    		type:"post",
	    		dataType:"json",
	    		data:data,
	    		success:function(result){
	    			alert(result);
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
							$("#user_user_account").val(json[0].use_user_account);
							$("#order_gameAccount").val(json[0].order_gameAccount);
							$("#order_gamePassword").val(json[0].order_gamePassword);
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
							$("#update").hide();
							$("#repeal").hide();
							$("#finish").hide();
							$("#del").hide();
							if(json[0].order_status == 6){
								$("#del").show();
							};
							if(json[0].order_status == 5){
								$("#update").show();
								$("#repeal").show();
							};
							if(json[0].order_status == 4){
								$("#del").show();
								$("#update").show();
							};
							if(json[0].order_status == 3 || json[0].order_status == 1){
								$("#finish").show();
							};
						}
					}); 
			};
	</script>
  </body>
</html>
