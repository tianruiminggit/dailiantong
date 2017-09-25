<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="">

		<title>Dashboard - SB Admin</title>

		<!-- Bootstrap core CSS -->
		<link href="css/bootstrap.css" rel="stylesheet">

		<!-- Add custom CSS here -->
		<link href="css/sb-admin.css" rel="stylesheet">
		<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
		<!-- Page Specific CSS -->
		<link rel="stylesheet" href="css/morris-0.4.3.min.css">
		<script src="js/jquery-1.10.2.js"></script>
		 <script src="js/echarts.js"></script>
	</head>

	<body onload="charts()">

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
						<li class="active"><a href="user.do?method=login"><i class="fa fa-dashboard"></i> 首页 </a></li>
						<li><a href="appeal.do?method=getListAdminAppeal"><i class="fa fa-table"></i> 申诉管理</a></li>
						<li><a href="gameServlet.do?method=getListGame"><i class="fa fa-edit"></i> 游戏管理</a></li>
						<li><a href="orderServlet.do?method=getListAdminOrder"><i class="fa fa-font"></i> 订单管理</a></li>
						<li><a href="user.do?method=getUser&&where=0"><i class="fa fa-user"></i> 用户管理</a></li>
						<li><a href="msgServlet?method=getAllNotice"><i class="fa fa-edit"></i> 平台信息管理</a></li>

					</ul>

					<ul class="nav navbar-nav navbar-right navbar-user">
						<!--导航的messages下拉-->
						<!--alert下拉-->
						<li>
							<a href="appeal.do?method=getListAdminAppeal" class="dropdown-toggle"><i class="fa fa-bell"></i> 申诉消息 <span class="badge">${undoAppeal }</span></a>
							<!--下拉内容-->
							<!-- <ul class="dropdown-menu" id = "info">
								<li><a href="#">Default <span class="label label-default">Default</span></a></li>
								<li><a href="#">Primary <span class="label label-primary">Primary</span></a></li>
								<li><a href="#">Success <span class="label label-success">Success</span></a></li>
								<li><a href="#">Info <span class="label label-info">Info</span></a></li>
								<li><a href="#">Warning <span class="label label-warning">Warning</span></a></li>
								<li><a href="#">Danger <span class="label label-danger">Danger</span></a></li>
								<li class="divider"></li>
								<li><a href="#">View All</a></li>
							</ul> -->
						</li>
						<!-- <script>
							$("#undoAppeal").click(function(){
								$.ajax({
									url:"appeal.do",
									data:{"method":"getListUndoAppela"},
									dataType:"json",
									type:"post",
									success:function(result){
										var json = eval(result);
										for(var i = 0 ;i<3;i++){
											$("#info").append("<li><a href='#'>Default <span class='label label-default'>Default</span></a></li>")
										}
									}
									
								});
							});							
						</script> -->
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
				</div>
				<!-- /.navbar-collapse -->
			</nav>
			<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" title="网站模板">网站模板</a></div>
			<div id="page-wrapper">

				<div class="row">
					<div class="col-lg-12">
						<h1>首页 <small>manager</small></h1>
						<ol class="breadcrumb">
							<li class="active"><i class="fa fa-dashboard"></i> 首页</li>
						</ol>
									
									
<%-- 									
		<div class="col-lg-4">
            <div class="panel panel-primary">
              <div class="panel-heading">
                <h3 class="panel-title"><i class="fa fa-clock-o"></i> 最新公告</h3>
              </div>
              <div class="panel-body">
                <div class="list-group" >
                  <a class="list-group-item" >
                    <span class="badge">发布时间</span>
                    <i class="fa fa-calendar"></i> 公告标题
                    
                  </a>
                  
                  <c:forEach items="${notice }" var="msg">
                  
		                  <a href="msgServlet?method=findNotice&notice_id=${msg.notice_id }" class="list-group-item">
		                    <span class="badge">${msg.notice_time}</span>
		                    <i class="fa fa-comment"></i>${msg.notice_title}
		                  </a>
		           </c:forEach>
      
              </div>
            </div>
          </div>	
					 --%>				
								
									
									
									<div class="panel panel-primary" >
										<button type="button" class="close" data-dismiss="alert" aria-hidden="true" style="margin-top:5px;margin-right:10px">&times;</button> 
										
										<!-- 公告消息 -->
									 <div class="panel-heading">
			                			<h3 class="panel-title"><i class="fa fa-clock-o"></i> 最新公告</h3>
			              			</div>
			              			<div style="position:relative;">
			              				<c:forEach items="${notice }" var="msg">
			              					<form>
			              						<label>${msg.notice_title } </label><br>
			              						
			              						<textarea rows="5" readonly cols="120" style="margin-left:10%">${msg.notice_content }</textarea>
			              					
			              						<label style="margin-top:8%;margin-left:2%"> ${msg.notice_time }</label>
			              					
			              					</form>
			    								          				
							              				
			              						<!-- <table  cellspace="3px" style="padding-bottom:20px;width：100%">
			              							<thead >
				              							<tr style="margin-left:50px; aligin:center" >
					              							<th>公告标题</th>
					              							<th>发布时间</th>
					              							<th style="width:60%">公告详情</th>
				              							</tr>
			              							</thead >	
			              							<tbody>
			              							   <tr  style="margin-left:50px;background-color:#d9edf7" >
				              								<td> </td>
				              								<td> </td>
				              								<td></td>
			              							   </tr>
			              							</tbody>
			              						</table> -->
			              				</c:forEach>
								</div>				
									<%-- data-toggle="modal" data-target="#info" onclick="queryNotice(${msg.notice_id})"  --%>
									</div> 
									
									
					</div>
				</div>
				<!-- /.row -->
<script>
/* 	function queryNotice(id){
		
		
		
		
		
		$.ajax({
			url:"msgServlet",
			data:{"method":"findAjaxNotice","notice_id":id},
			datatype:"json",
			type:"POST",
			success:function(result){
				console.log(result);
				
				$(result).each(function(i,d) {
					console.log(i);
				});
				 */
				
				/* var json = eval(result);
				console.log("json == " + json); */
				//$("#notice_titles").val(result.notice_title);
				//$("#notice_times").val(json[0].notice_time);
				//$("#notice_contents").val(json[0].notice_content);
				
			/* },
			error:function(){
				alert("请求参数失败");
			}
		});  */
		
		
	/* } */
</script>



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
					公告详细信息
				</h4>
			</div>
			<div class="modal-body" style="height: 300px;overflow-y:auto; " >
			    
				
						
							<label>公告标题</label>
							<input readonly type="text" id="notice_titles"  class="form-control" >
							<label>公告发布时间</label>
							<input readonly type="text" id="notice_times"  class="form-control">
							<label>公告内容</label>
							<textarea readonly rows="5" cols="41" class="form-control" id="notice_contents"></textarea>
					
					
									
			</div>
									<div class="modal-footer" >
										
										<button type="button" class="btn btn-primary"  data-dismiss="modal" style="transition:all,4s" onclick="upUserStatus()">
											确定
										</button>
									</div>
			
		</div>
	</div>
</div> 

		









				<div class="row">
					<div class="col-lg-3">
						<div class="panel panel-info">
							<div class="panel-heading">
								<div class="row">
									<div class="col-xs-6">
										<i class="fa fa-comments fa-5x"></i>
									</div>
									<div class="col-xs-6 text-right">
										<p class="announcement-heading">${todayOrder }</p>
										<p class="announcement-text">今日发单</p>
									</div>
								</div>
							</div>
							<a href="orderServlet.do?method=getListAdminOrder">
								<div class="panel-footer announcement-bottom">
									<div class="row">
										<div class="col-xs-6">
											查看详情
										</div>
										<div class="col-xs-6 text-right">
											<i class="fa fa-arrow-circle-right"></i>
										</div>
									</div>
								</div>
							</a>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="panel panel-warning">
							<div class="panel-heading">
								<div class="row">
									<div class="col-xs-6">
										<i class="fa fa-check fa-5x"></i>
									</div>
									<div class="col-xs-6 text-right">
										<p class="announcement-heading">${todayFinishOrder }</p>
										<p class="announcement-text">今日结单</p>
									</div>
								</div>
							</div>
							<a href="orderServlet.do?method=getListAdminOrder">
								<div class="panel-footer announcement-bottom">
									<div class="row">
										<div class="col-xs-6">
											查看详情
										</div>
										<div class="col-xs-6 text-right">
											<i class="fa fa-arrow-circle-right"></i>
										</div>
									</div>
								</div>
							</a>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="panel panel-danger">
							<div class="panel-heading">
								<div class="row">
									<div class="col-xs-6">
										<i class="fa fa-tasks fa-5x"></i>
									</div>
									<div class="col-xs-6 text-right">
										<p class="announcement-heading">${order }</p>
										<p class="announcement-text">发单数量</p>
									</div>
								</div>
							</div>
							<a href="orderServlet.do?method=getListAdminOrder">
								<div class="panel-footer announcement-bottom">
									<div class="row">
										<div class="col-xs-6">
											查看全部
										</div>
										<div class="col-xs-6 text-right">
											<i class="fa fa-arrow-circle-right"></i>
										</div>
									</div>
								</div>
							</a>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="panel panel-success">
							<div class="panel-heading">
								<div class="row">
									<div class="col-xs-6">
										<i class="fa fa-comments fa-5x"></i>
									</div>
									<div class="col-xs-6 text-right">
										<p class="announcement-heading">${finishOrder }</p>
										<p class="announcement-text">结单数量</p>
									</div>
								</div>
							</div>
							<a href="orderServlet.do?method=getListAdminOrder">
								<div class="panel-footer announcement-bottom">
									<div class="row">
										<div class="col-xs-6">
											查看全部
										</div>
										<div class="col-xs-6 text-right">
											<i class="fa fa-arrow-circle-right"></i>
										</div>
									</div>
								</div>
							</a>
						</div>
					</div>
				</div>
				<!-- /.row -->

				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title"><i class="fa fa-bar-chart-o"></i> 每日发单数量</h3>
							</div>
							<div id="charts" style="width: 100%;height:600px">
								<!-- <div id="morris-chart-area"></div> -->
							</div>
						</div>
					</div>
				</div>
				<!-- /.row -->
<!-- <div class="col-lg-4">
            <div class="panel panel-primary">
              <div class="panel-heading">
                <h3 class="panel-title"><i class="fa fa-money"></i> 近期注册用户</h3>
              </div> -->
      <!--         <div class="panel-body">
                <div class="table-responsive">
                  <table class="table table-bordered table-hover table-striped tablesorter">
                    <thead>
                      <tr>
                        <th>用户名称</th>
                        <th>注册时间</th>
                        <th>用户手机号</th>
                        <th>用户邮箱 </th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>3326</td>
                        <td>10/21/2013</td>
                        <td>12312312</td>
                        <td>$321.33</td>
                      </tr>
                      <tr>
                        <td>3325</td>
                        <td>10/21/2013</td>
                        <td>12312312</td>
                        <td>$234.34</td>
                      </tr>
                      <tr>
                        <td>3324</td>
                        <td>10/21/2013</td>
                      <td>12312312</td>
                        <td>$724.17</td>
                      </tr>
                      <tr>
                        <td>3323</td>
                        <td>10/21/2013</td>
                          <td>12312312</td>
                        <td>$23.71</td>
                      </tr>
                      <tr>
                        <td>3322</td>
                        <td>10/21/2013</td>
                         <td>12312312</td>
                        <td>$8345.23</td>
                      </tr>
                      <tr>
                        <td>3321</td>
                        <td>10/21/2013</td>
                          <td>12312312</td>
                        <td>$245.12</td>
                      </tr>
                      <tr>
                        <td>3320</td>
                        <td>10/21/2013</td>
                        <td>12312312</td>
                        <td>$5663.54</td>
                      </tr>
                      <tr>
                        <td>3319</td>
                        <td>10/21/2013</td>
                         <td>12312312</td>
                        <td>$943.45</td>
                      </tr>
                    </tbody>
                  </table>
                </div> -->

			</div>

		</div> -->
		<!-- /#wrapper -->

		<!-- JavaScript -->
		
		<script>
			function charts(){
				var myChart = echarts.init(document.getElementById("charts"));
				var option = {
					    tooltip : {
					        trigger: 'axis',
					        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
					            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
					        }
					    },
					    legend: {
					        data:[]
					    },
					    grid: {
					        left: '3%',
					        right: '4%',
					        bottom: '3%',
					        containLabel: true
					    },
					    xAxis : [
					        {
					            type : 'category',
					            data : ['周一','周二','周三','周四','周五','周六','周日']
					        }
					    ],
					    yAxis : [
					        {
					            type : 'value'
					        }
					    ],
					    series : [
					        {
					            
					        },
					        {
					            
					        },
					    ]
					};
				$.ajax({
					url:"gameServlet.do?method=getListEveryDayOrderNum",
					datatype:"JSON",
					type:"POST",
					async: false, 
					success:function(result){
						/* alert(result); */
						var json=option.series;
						var str=result.split("&");
						var x =option.xAxis[0].data;
						/* alert(option.series) */
						var len = str.length;
						for(var i =0;i<len-2;i++){
							json[i]=eval('(' + str[i] + ')')
						
						}
						/* alert(json); */
						/* alert(eval('(' + str[0] + ')')); */
						for(var i=1;i<=30;i++){
							x[i-1]=i+"号"
						}
						option.xAxis.data=x;
						var s=str[len-1].substring(1,str[len-1].length-1);
						option.legend.data=s.split(",");/* =str[len-1]; */
						option.series=json;
						myChart.setOption(option);
					}
				});
			}
		</script>
		<script src="js/bootstrap.js"></script>

		<!-- Page Specific Plugins -->
		<script src="js/raphael-min.js"></script>
		<script src="js/morris-0.4.3.min.js"></script>
		<script src="js/morris/chart-data-morris.js"></script>
		<script src="js/tablesorter/jquery.tablesorter.js"></script>
		<script src="js/tablesorter/tables.js"></script>

	</body>

</html>