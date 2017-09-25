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
    <script src="js/echarts.js"></script>
    <title>Forms - SB Admin</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="css/sb-admin.css" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
    <script src="js/jquery-1.10.2.js"></script>
    <style type="text/css">
    	form  label{
			display: block;
		}	
		form  input{
			width: 50%;
		}
    </style>
  </head>

  <body onload="drawCharts()">

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
						<li><a href="appeal.do?method=getListAdminAppeal"><i class="fa fa-table"></i> 申诉管理</a></li>
						<li class="active"><a href="forward.do?method=forward&&url=games.jsp"><i class="fa fa-edit"></i> 游戏管理</a></li>
						<li><a href="orderServlet.do?method=getListAdminOrder"><i class="fa fa-font"></i> 订单管理</a></li>
						<li><a href="user.do?method=getUser"><i class="fa fa-user"></i> 用户管理</a></li>
						<li><a href="msgServlet?method=getAllNotice"><i class="fa fa-edit"></i> 平台信息管理</a></li>
            -->
           
           				<li><a href="user.do?method=login"><i class="fa fa-dashboard"></i> 首页 </a></li>
						<li><a href="appeal.do?method=getListAdminAppeal"><i class="fa fa-table"></i> 申诉管理</a></li>
						<li class="active"><a href="gameServlet.do?method=getListGame"><i class="fa fa-edit"></i> 游戏管理</a></li>
						<li><a href="orderServlet.do?method=getListAdminOrder"><i class="fa fa-font"></i> 订单管理</a></li>
						<li><a href="user.do?method=getUser&&where=0"><i class="fa fa-user"></i> 用户管理</a></li>
						<li><a href="msgServlet?method=getAllNotice"><i class="fa fa-edit"></i> 平台信息管理</a></li>
           
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
            <h1>游戏管理 <small>操作游戏数据</small></h1>
            <ol class="breadcrumb">
              <li><a href="user.do?method=login"><i class="fa fa-dashboard"></i> 首页</a></li>
              <li class="active"><i class="fa fa-edit"></i> 游戏管理</li>
            </ol>
          </div>
        </div><!-- /.row -->
        
        <div class="form-group input-group pull-left" style="width: 300px;">
						<input type="text" class="form-control"  placeholder="搜索" id="search">
						<span class="input-group-btn">
                  <button class="btn btn-default" type="button" onclick="show($('#search').val())"><i class="fa fa-search"></i></button>
           </span>
					</div>
					
					<div class=" form-group input-group-btn" align="right">
						<button type="button" class="btn btn-success" id="add">添加游戏</button>
					</div>
        
       <div class="row">
          <div class="col-lg-4">
            <div class="bs-example">
              <ul class="nav nav-tabs" style="margin-bottom: 15px;">
                <li class="dropdown">
                  <a class="small dropdown-toggle" data-toggle="dropdown" href="#">
                    	请选择游戏类型 <span class="caret"></span>
                  </a><label style="color: red">${msg }</label>
                  <ul class="dropdown-menu">
                  		<li><a href="gameServlet.do?method=getListGame">全部游戏</a></li>
                  		<li class="divider"></li>
                  	<c:forEach items="${type }" var="t">
                  		<li><a href="gameServlet.do?method=getListGameByType&&gameType=${t.game_typeId}">${t.game_typeName }</a></li>
                  		<li class="divider"></li>
                  	</c:forEach>
                  </ul>
                </li>
              </ul>
              <div id="myTabContent" class="tab-content">
                  <div >
        			<table class="table table-hover">
        			<tr class="success">
		        		<th>游戏编号</th>
		        		<th>游戏名称</th>
		        		<th>游戏类型</th>
	        		</tr>
	        	<tbody>
	        		<c:forEach items="${game}" var="x">
	        				<tr onclick="show(${x.game_id})">
							<td>${x.game_id }</td>
							<td>${x.game_name }</td>
							<td>${x.game_typeId }</td>
						</tr>
	        		</c:forEach>
        		</table> 
        		${bar}
	        </div>
              </div>
              	<div class="pull-right" id="charts" style="width: 100%;height: 500px;">
        			
       			 </div>
            </div>
          </div>
          
          
         <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" id="hide" style="visibility: hidden;">
		开始演示模态框
		</button>
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
				<form action="gameServlet.do" method="get">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							游戏信息
						</h4>
					</div>
					<div class="modal-body">
							<label>游戏编号</label>
							<input type="text" id="game_id" name="game_id">
							<label>游戏类型</label>
							<input type="text" id="game_type" name="game_type">
							<label>游戏名称</label>
							<input type="text" id="game_name" name="game_name">
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-danger pull-left" id="delete">删除</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
						<input type="hidden" id="method" name="method" value="">
						<button type="submit" class="btn btn-primary">
							提交更改
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
    <script src="js/bootstrap.js"></script>
    <script type="text/javascript">
    	/* json */
    	
    	function drawCharts(){
    		var myChart = echarts.init(document.getElementById("charts"));
			var option = {
				    title : {
				        text: '各游戏订单统计',
				        subtext: '代练通',
				        x:'left'
				    },
				    tooltip : {
				        trigger: 'item',
				        formatter: "{a} <br/>{b} : {c} ({d}%)"
				    },
				    legend: {
				        orient: 'horizontal',
				        left: 'right',
				        data: []
				    },
				    series : [
				        {
				            name: '订单数量',
				            type: 'pie',
				            radius : '55%',
				            center: ['50%', '60%'],
				            data:[
				              ],
				            itemStyle: {
				                emphasis: {
				                    shadowBlur: 10,
				                    shadowOffsetX: 0,
				                    shadowColor: 'rgba(0, 0, 0, 0.5)'
				                }
				            }
				        }
				    ]
				};
			$.ajax({
				url:"orderServlet.do?method=getMapOrderNumByGame",
				datatype:"JSON",
				type:"POST",
				async: false, 
				success:function(result){
					/* alert(eval(result)) */
					console.log("未处理==》"+result);
					console.log("处理一次===》"+eval(result));
					var json = eval(eval(result));
					console.log("处理两次===》"+json);
					option.series[0].data = json
					var s="";
					for ( var j in json) {
						s+=","+json[j].name
					}
					s=s.substr(1);
					option.legend.data=s.split(",");
					myChart.setOption(option);
				}
			});
    	}
		
    	function show(id){
    		$("#hide").click();
    		$("#delete").show();
    		$("#method").val("updateGame");
    		$.ajax({
    			url:"gameServlet.do",
    			data:{"method":"getListGameById","game_id":id},
    			datatype:"json",
    			type:"POST",
    			success:function(result){
    				var json = eval(result);
    				$("#game_id").val(json[0].game_id);
    				$("#game_type").val(json[0].game_typeId)
    				$("#game_name").val(json[0].game_name);
    			},
    			error:function(msg){
    				alert("哇！！！爆炸")
    			}
    			
    		});
    	}
    	$("#add").click(function(){
    		$("#game_id").val(null);
			$("#game_type").val(null)
			$("#game_name").val(null);
			$("#delete").hide();
    		$("#method").val("addGame");
    		$("#hide").click();
    	});
    	$("#delete").click(function(){
    		$("#method").val("deleteGameById");
    	});
    </script>

  </body>
</html>