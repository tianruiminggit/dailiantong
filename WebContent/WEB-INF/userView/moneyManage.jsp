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

    <title>Dashboard - SB Admin</title>

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
			<li class="active"><a href="moneyServlet.do?method=getListMoney">资金管理</a></li>
            <!-- <li><a href="gameSetting.html">游戏设置</a></li> -->
            <li><a href="employeeServlet.do?method=getListEmployee">员工管理</a></li>
            <li><a href="childUserServlet.do?method=getListChildUser">子帐号管理</a></li>
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

      </nav>
		<div class="copyrights">Collect from <a href="http://www.cssmoban.com/"  title="网站模板">网站模板</a></div>
      <div id="page-wrapper">

        <div class="row">
          <div class="col-lg-12">
            <h1>资金管理<small></small></h1>
            <ol class="breadcrumb">
              <li><a href="user.do?method=userLogin"><i class="fa fa-dashboard"></i> 首页</a></li>
              <li class="active"><i class="fa fa-edit"></i> 资金管理</li>
            </ol>
            <!-- <div class="alert alert-success alert-dismissable">
              <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
              Welcome to SB Admin by <a class="alert-link" href="http://startbootstrap.com">Start Bootstrap</a>! Feel free to use this template for your admin needs! We are using a few different plugins to handle the dynamic tables and charts, so make sure you check out the necessary documentation links provided.
            </div> -->
          </div>
        </div><!-- /.row -->
        
 <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" id="hide" style="visibility: hidden;">
		开始演示模态框
		</button>

<div class="modal fade" id="info"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button id="close" type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					充值
				</h4>
			</div>
			<div class="modal-body" style="height: 300px;overflow-y:auto; " >
			    
					
						<form action="">
							<label>充值金额</label>
							<input  type="text" id="addMoney"  class="form-control" value="20">
							<label>输入支付密码</label>
							<input  type="password" id="user_payPassword" value="" class="form-control">
						</form>
									
			</div>
									<div class="modal-footer" >
									
										<button onclick="sureAddMoney()" type="button" class="btn btn-primary"  data-dismiss="modal" >
											确定
										</button>
									</div>
			
		</div>
	</div>
</div> 

        
        
        
        
<div style="width:30%;margin-top:-5%" >
			<label>冻结资金 </label>
			<label style="margin-left:20%">${getPlatform_freezeMoney }0</label> <br>
			
			<label>当前可用资金 </label> 
			<label style="margin-left:10%"> ${getPlatform_usableMoney }0</label>
</div>
			 <div style="margin-top:-4%;margin-left:20%">
			 		<button onclick="congzhi()" type="button" class="btn btn-success">充值</button>
					<button onclick="tixian()" type="button" class="btn btn-info">提现</button>
			 </div>
<span id="cong" style="display:hidden" data-toggle="modal" data-target="#info"></span>	
<span id="addBank" style="display:hidden" data-toggle="modal" data-target="#infos"></span>		
<span id="tixians" style="display:hidden" data-toggle="modal" data-target="#infoss"></span>			
<script>
	function congzhi(){
		$("#addMoney").val("");
		$("#user_payPassword").val("");
		$.ajax({
			url:"user.do?method=getUserPay",
			dataType:"json",
			type:"post",
			success:function(result){
				
				//alert(result.user_payPassword); 
				if(result.user_payPassword=="" || result.user_payPassword== "undefinde"){
				//alert("请先添加银行卡账户"); 
					$("#close").click();
					$("#addBank").click();
					$("#bank_num").val("");
					$("#payPassword").val("");
					$("#payPassword2").val("");
				}
				else{
				/* 	alert("输入充值金额"); */
					$("#cong").click();
				}
				
			},
			error:function(){
				alert("请求失败");
			}
		});
	
	};
	
	//点击确定充值，判断金额是否够，判断支付密码是否正确
	function sureAddMoney(){
		/* alert("充值提交"); */
	
		
		$.ajax({
			url:"user.do?method=getUserPay",
			dataType:"json",
			type:"post",
			success:function(result){
				
				if($("#user_payPassword").val()==result.user_payPassword){
					/* alert("支付密码正确");	 */
					pdYue();
					
				}else{
					alert("支付密码不正确");
				}
			},
			error:function(){
				alert("请求参数失败");
			},
			/* complete:function(){
				window.location.href="moneyServlet.do?method=getListMoney";
			} */
				
		});
	
	};
	function pdYue(){
		//获得充值金额
		var money=$("#addMoney").val();
		//判断银行卡余额是否足够
		$.ajax({
			url:"moneyServlet.do",
			data:{"method":"pdMoney","money":money},
			dataType:"json",
			type:"post",
			success:function(result){
				alert(result);
				if("金额超出"==result)
				{	//关闭弹出框，清空值
					//alert(result);
					$("#addMoney").val("");
					$("#user_payPassword").val("");
				}
				else{
					window.location.href="moneyServlet.do?method=getListMoney";
				}
			},
			error:function(){
				alert("请求参数失败");
			},
			
		});
	}
	

function pdPassword(){
	console.log($("#bank_name").val());
	console.log($("#bank_num").val());
	console.log($("#payPassword").val());
	console.log($("#payPassword2").val());
	
	if($("#payPassword").val()!=$("#payPassword2").val()){
		alert("两次输入密码不正确！ ");
		
		/* $("#payPassword2").focus(); */
		$("#payPassword2").select();
		return;
	}
	
}

$("#reduice").click(function(){
	$("#payPassword2").attr("onBlur")="";
})


function addBank(){
	//获得银行卡名字
	var bank_name=document.getElementById("bank_name").value;
	//获得银行卡号
	var bank_num= document.getElementById("bank_num").value;
	//获得密码
	var pay_password = document.getElementById("payPassword2").value;
	

	$.ajax({
		url:"moneyServlet.do",
		data:{"method":"addBank","bank_num":bank_num,"bank_name":bank_name,"pay_password":pay_password},
		dataType:"json",
		type:"post",
		success:function(result){
		
			if(result==1){
				alert("添加银行卡成功");
			}
		},
		error:function(){
			alert("请求参数失败！");
		},
		
		
	});
}

</script>			
				
    
    
  <!-- 添加银行卡 -->  
 <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" id="hides" style="visibility: hidden;">
		开始演示模态框
		</button>

<div class="modal fade" id="infos"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" id=" reduice"   class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					添加银行卡
				</h4>
			</div>
			<div class="modal-body" style="height: 300px;overflow-y:auto; " >
			    
							<label>选择银行卡</label>
							<select id="bank_name" >
								<option  selected="selected" value="建设银行卡">建设银行卡 </option>
								<option value="农行卡">农行卡 </option>
								<option value="商业银行">商业银行 </option>
							</select>
							<br>
							<label>银行卡号</label>
							<input  type="text" id="bank_num"  class="form-control">
							<label>支付密码</label>
							<input  type="password" id="payPassword"  class="form-control">
							<label>再次输入支付密码</label>
							<input  type="password" id="payPassword2" onBlur="pdPassword()" class="form-control">
						
									
			</div>
									<div class="modal-footer" >
										
						<button onclick="addBank()" type="button" class="btn btn-primary"  data-dismiss="modal" >
											确定
						</button>
									</div>
			
		</div>
	</div>
</div> 

        
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" id="hidess" style="visibility: hidden;">
		开始演示模态框
		</button>

<div class="modal fade" id="infoss"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" id="close2" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					提现
				</h4>
			</div>
			<div class="modal-body" style="height: 300px;overflow-y:auto; " >
			    
					
						<form action="">
							
							<label>提现金额</label>
							<input  type="text" id="tixian_money"  class="form-control">
							<label>支付密码</label>
							<input  type="password" id="pay_pwd"  class="form-control">
						</form>
									
			</div>
									<div class="modal-footer" >
										
										<button onclick="cash()"  type="button" class="btn btn-primary"  data-dismiss="modal" >
											确定
										</button>
									</div>
			
		</div>
	</div>
</div> 

<!-- 提现 -->    
<script>
/* $(function(){

	
}); */


function tixian(){
	$.ajax({
		url:"user.do?method=getUserPay",
		dataType:"json",
		type:"post",
		success:function(result){
			
			//alert(result.user_payPassword); 
			if(result.user_payPassword=="" || result.user_payPassword== "undefinde"){
			//alert("请先添加银行卡账户"); 
				$("#close2").click();
				$("#addBank").click();
				$("#bank_num").val("");
				$("#payPassword").val("");
				$("#payPassword2").val("");
				
			}
			else{
				//提现弹框
				$("#tixians").click();
			}
			
		},
		error:function(){
			alert("请求失败");
		}
	});

	
	
};

//点击提现
function cash(){
	

	//判断支付密码是否正确
	$.ajax({
		url:"user.do?method=getUserPay",
		dataType:"json",
		type:"post",
		success:function(result){
			
			if($("#pay_pwd").val()==result.user_payPassword){
				//判断平台资金余额是否足够
				tixiancaozuo();
			}
			else{
				alert("支付密码不正确");
			}			
		},
		error:function(){
			alert("请求参数失败");
		},
		/* complete:function(){
			window.location.href="moneyServlet.do?method=getListMoney";
		} */
		
		
});
		
function tixiancaozuo(){
	var platMoney =$("#tixian_money").val();
	$.ajax({
		url:"moneyServlet.do",
		data:{"method":"pdPlatMoney","money":platMoney},
		dataType:"json",
		type:"post",
		success:function(result){
			alert(result);
			if("金额超出"==result)
			{	//关闭弹出框，清空值
				
				$("#tixian_money").val("");
				$("#pay_pwd").val("");
			
			}
			else{
				window.location.href="moneyServlet.do?method=tRecord";
			}
		},
		error:function(){
			alert("请求参数失败");
		}
	});
	
}	
	
	
}

</script>              
	          

          <div class="row"  style="margin-top:-5%">
          <div class="col-lg-4">
            <h2 id="nav-tabs"></h2>
            <div class="bs-example">
              <ul class="nav nav-tabs" >
                <li class="${congzhi}"><a href="moneyServlet.do?method=getListMoney" >充值明细</a></li>
                <li  class="${tixian}"><a href="moneyServlet.do?method=tRecord">提现明细</a></li>
                <li  class="${dongjie}"><a href="moneyServlet.do?method=dongjie" >冻结明细</a></li>
              </ul>
              
              
              <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade active in">
                  <div class="panel panel-primary">	
              <div class="panel-heading">
                <h3 class="panel-title"><i class="fa fa-money"></i>${ctName }明细</h3>
              </div>
              <div class="panel-body">
                <div class="table-responsive">
                  <table class="table table-bordered table-hover table-striped tablesorter">
                    <thead>
                      <tr>
                      	<!-- <th>编号<i class="fa fa-sort"></i></th> -->
                        <th>${ctName }时间<i class="fa fa-sort"></i></th>
                        <th>${ctName }金额<i class="fa fa-sort"></i></th>
                        <th>操作<i class="fa fa-sort"></i></th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${clogs }" var="log"> 
                   		<c:if test="${ctName=='充值'}"> 
                   				<tr>
		                       <%--  <td>${log.addMoney_id }</td> --%>
		                        <td>${log.congzhi_time }</td>
		                        <td>${log.addMoney }</td>
		                        <td><button onclick="del(${log.addMoney_id})" type="button" class="btn btn-danger">删除</button></td>
		           			 </tr>
           				 </c:if>
           				 <c:if test="${ctName=='提现'}"> 
                   				<tr>
		                       <%--  <td>${log.tixian_id }</td> --%>
		                        <td>${log.tixian_time }</td>
		                        <td>${log.tixian_money }</td>
		                        <td><button onclick="delTixian(${log.tixian_id})" type="button" class="btn btn-danger">删除</button></td>
		           			 </tr>
           				 </c:if>
           				 <c:if test="${ctName=='冻结'}"> 
                   				<tr>
		                       <%--  <td>${log.tixian_id }</td> --%>
		                        <td>${log.dongjie_time }</td>
		                        <td>${log.dongjie_money }</td>
		                        <td><button onclick="deldongjie(${log.dongjie_id})" type="button" class="btn btn-danger">删除</button></td>
		           			 </tr>
           				 </c:if>
                     </c:forEach>
                    </tbody>
                  </table>
                	${bar }
            	</div>
            </div>
          </div>
        </div>
                </div>
                </div>
              
          </div>
            
        </div><!-- /.row -->
          

    <!-- JavaScript -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.js"></script>

    <!-- Page Specific Plugins -->    <script src="js/raphael-min.js"></script>
    <script src="js/morris-0.4.3.min.js"></script>
    <script src="js/morris/chart-data-morris.js"></script>
    <script src="js/tablesorter/jquery.tablesorter.js"></script>
    <script src="js/tablesorter/tables.js"></script>
	<script>
	function del(id){
		if(confirm("确定删除？")){
			
			$.ajax({
				url:"moneyServlet.do",
				data:{"method":"del","addMoney_id":id},
				dataType:"json",
				type:"post",
				success:function(result){
					if(1==result){
						alert("删除成功");
						window.location.href="moneyServlet.do?method=getListMoney";
					}
					else{
						alert("删除失败");
					}
				},
				error:function(){
					alert("请求参数失败");
				}
			});
		};
	
	};
	
	
	
	
		function delTixian(id){
			if(confirm("确定删除？")){
				
				$.ajax({
					url:"moneyServlet.do",
					data:{"method":"delTixian","tixian_id":id},
					dataType:"json",
					type:"post",
					success:function(result){
						if(1==result){
							alert("删除成功");
							window.location.href="moneyServlet.do?method=getListMoney";
						}
						else{
							alert("删除失败")
						}
					},
					error:function(){
						alert("请求参数失败");
					}
				});
			};
		
		};
	
		

		function deldongjie(id){
			if(confirm("确定删除？")){
				
				$.ajax({
					url:"moneyServlet.do",
					data:{"method":"delDongjie","dongjie_id":id},
					dataType:"json",
					type:"post",
					success:function(result){
						if(1==result){
							alert("删除成功");
							window.location.href="moneyServlet.do?method=getListMoney";
						}
						else{
							alert("删除失败")
						}
					},
					error:function(){
						alert("请求参数失败");
					}
				});
			};
		
		};
	</script>
  </body>
</html>