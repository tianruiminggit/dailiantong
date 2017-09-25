<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
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
            <li><a href="orderServlet.do?method=getListReleaseOrder">发单管理</a></li>
            <li><a href="orderServlet.do?method=getListReceiveOrder">接单管理</a></li>
            <li><a href="userAccount?method=getListUserAccount">个人资料</a></li>
			<li><a href="moneyServlet.do?method=getListMoney">资金管理</a></li>
            <!-- <li><a href="gameSetting.html">游戏设置</a></li> -->
            <li><a href="employeeServlet.do?method=getListEmployee">员工管理</a></li>
            <li class="active"><a href="childUserServlet.do?method=getListChildUser">子帐号管理</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right navbar-user">
            <li class="dropdown user-dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${nickName} <b class="caret"></b></a>
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
            <h1>子账号管理<small></small></h1>
            <ol class="breadcrumb">
              <li><a href="user.do?method=userLogin"><i class="fa fa-dashboard"></i> 首页</a></li>
              <li class="active"><i class="fa fa-edit"></i> 子帐号管理</li>
            </ol>
            <!-- <div class="alert alert-success alert-dismissable"> -->
          </div>
        </div><!-- /.row -->
          <div class="col-lg-4">
            <div class="panel panel-primary">
              <div class="panel-heading">
                <h3 class="panel-title"><i class="fa fa-money"></i>子账号管理</h3>
              </div>
              <div class="panel-body">
              	<div>
	              	<div class="form-group input-group pull-left" style="width: 20%;">
	              	<input type="text" class="form-control"  placeholder="请输入查询内容" id='zhi'>
									<span class="input-group-btn">
							        <button class="btn btn-default" type="button" onclick="query()"><i class="fa fa-search"></i></button>
							    </span>
							    </div>
							    <button type="button" class="btn btn-success" data-toggle="modal" data-target="#info">添加子账号</button>
	                <!-- <button type="button" class="btn btn-info">刷新</button> -->
								</div>
                <div class="table-responsive col-lg-12" style="overflow-x:auto; ">
                  <table class="table table-bordered table-hover tablesorter" style="text-align: center;width:1450px;">
                    <thead>
                      <tr>
                      	<th style="text-align: center;">序号<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">用户账号<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">子帐号<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">子帐号昵称<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">子帐号密码<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">子帐号资金<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">子帐号权限<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">子帐号创建时间<i class="fa fa-sort"></i></th>
                        <th style="text-align: center;">操作<i class="fa fa-sort"></i></th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${ListChildUser }" var="listChildUser">
                      <tr>
                      	<td>${listChildUser.child_id }</td>
                        <td>${listChildUser.user_account }</td>
                        <td>${listChildUser.child_account }</td>
                        <td>${listChildUser.child_name }</td>
                        <td>${listChildUser.child_password }</td>
                        <td>${listChildUser.child_money }</td>
                        <td>${listChildUser.child_root }</td>
                        <td>${listChildUser.child_time }</td>
                        <td>
                        	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#infoo" onclick="showInfo(${listChildUser.child_id})">修改</button>
                        	<button type="button" class="btn btn-danger" onclick="delChildUser(${listChildUser.child_id})">删除</button>
                        </td>
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
        </div><!-- /.row -->

      </div><!-- /#page-wrapper -->

    </div><!-- /#wrapper -->
    <div class="modal fade" id="infoo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" id="hide">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header alert-info">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
								&times;
							</button>
							<h4 class="modal-title" id="myModalLabel">
								请修改子帐号信息
							</h4>
						</div>
						<div class="modal-body" style="height: 500px;overflow-y:auto ;">
					    <form action="">
							<label>序号</label>
							<input readonly type="text" id="child_id"  class="form-control">
							<label>用户帐号</label>
							<input readonly  type="text" id="user_account"  class="form-control">
							<label>子帐号</label>
							<input readonly type="text" id="child_account"  class="form-control">
							<label>子帐号昵称</label>
							<input type="text" id="child_name"  class="form-control">
							<label>子帐号密码</label>
							<input type="text" id="child_password"  class="form-control">
							<label>子帐号资金</label>
							<input type="text" id="child_money"  class="form-control">
							<label>子帐号权限</label>
							<input type="text" id="child_root"  class="form-control">
							<label>子帐号创建时间</label>
							<input readonly type="text" id="child_time"  class="form-control">
						</form>
					</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">取消
							</button>
							<button type="button" class="btn btn-primary" onclick="updateChildUser()">
								提交修改
							</button>
						</div>
					</div><!-- /.modal-content -->
				</div><!-- /.modal -->
			</div><!-- /.model fade -->
			<div class="modal fade" id="info" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" id="hide">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header alert-info">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
								&times;
							</button>
							<h4 class="modal-title" id="myModalLabel">
								请填写子帐号信息
							</h4>
						</div>
						<div class="modal-body" style="height: 500px;overflow-y:auto ;">
					    <form action="">
						<!-- 	<label>序号</label>
							<input type="text" id="child_id"  class="form-control"> -->
							<!-- <label>用户帐号</label>
							<input  type="text" id="user_account"  class="form-control"> -->
							<label>子帐号</label>
							<input type="text" id="child_accounts"  class="form-control">
							<label>子帐号昵称</label>
							<input type="text" id="child_names"  class="form-control">
							<label>子帐号密码</label>
							<input type="text" id="child_passwords"  class="form-control">
							<label>子帐号资金</label>
							<input type="text" id="child_moneys"  class="form-control">
							<label>子帐号权限</label>
							<input type="text" id="child_roots"  class="form-control">
							<!-- <label>子帐号创建时间</label>
							<input readonly type="text" id="child_time"  class="form-control"> -->
						</form>
					</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">取消
							</button>
							<button type="button" class="btn btn-primary" onclick="addChildUser()">
								确定添加
							</button>
						</div>
					</div><!-- /.modal-content -->
				</div><!-- /.modal -->
			</div><!-- /.model fade -->
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
	
	function addChildUser() {
		$.ajax({
			url:"childUserServlet.do",
			data:{"method":"addChildUser","child_account":$("#child_accounts").val(),
				"child_name":$("#child_names").val(),"child_password":$("#child_passwords").val(),
				"child_money":$("#child_moneys").val(),"child_root":$("#child_roots").val()},
			dataType:"json",
			type:"post",
			success:function(result){
				if(1==result){
					alert("添加子账号成功！");
					window.location.href="childUserServlet.do?method=getListChildUser";
				}
				else{
					alert("添加子账号失败")
				}
			},
			error:function(){
				alert("请求参数失败");
			}
		});
	}
	
	
	
 	function query(){
    	var child_id=parseInt(document.getElementById("zhi").value);
    	url="childUserServlet.do?method=getChildUser&child_id="+child_id;
    	window.location.href=url;
    };
    function delChildUser(id){
    	url="childUserServlet.do?method=deleteChildUser&child_id="+id;
    	alert("删除成功")
    	window.location.href=url;
    };
    
    
    //修改子账号
	function updateChildUser(){
		alert("修改子帐号");
		$.ajax({
			url:"childUserServlet.do",
			data:{"method":"updateChildUser","child_id":$("#child_id").val(),"child_account":$("#child_account").val(),"child_name":$("#child_name").val(),"child_password":$("#child_password").val(),"child_money":$("#child_money").val(),"child_root":$("#child_root").val()},
			dataType:"json",
			type:"post",
			success:function(result){
				if(1==result){
					alert("资料修改成功！");
					window.location.href="childUserServlet.do?method=getListChildUser";
				}
				else{
					alert("修改失败")
				}
			},
			error:function(){
				alert("请求参数失败");
			}
		});
	};
	function showInfo(id){
		console.log("进入到修改点击事件");
		$("#hide").click();
	 		$.ajax({
					url:"childUserServlet.do",
					data:{"method":"getChildUserAjax","child_id":id},
					datatype:"json",
					type:"post",
					success: function(result){
						console.log("此时的结果是1"+result);
						 var json = eval('('+result+')'); 
					
						// var json = JSON.parse(result);
						 console.log("此时的json结果是1111111111111111111"+json);
						$("#child_id").val(json.child_id);
						$("#user_account").val(json.user_account);
						$("#child_account").val(json.child_account);
						$("#child_name").val(json.child_name);
						$("#child_password").val(json.child_password);
						$("#child_money").val(json.child_money);
						$("#child_root").val(json.child_root);
						$("#child_time").val(json.child_time);
 						},
					}); 
	}; 
	</script>

  </body>
</html>