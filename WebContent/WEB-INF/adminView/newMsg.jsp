<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>接单管理</title>

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
         
            
            
            			<li ><a href="user.do?method=login"><i class="fa fa-dashboard"></i> 首页 </a></li>
						<li><a href="appeal.do?method=getListAdminAppeal"><i class="fa fa-table"></i> 申诉管理</a></li>
						<li><a href="gameServlet.do?method=getListType"><i class="fa fa-edit"></i> 游戏管理</a></li>
						<li><a href="orderServlet.do?method=getListAdminOrder"><i class="fa fa-font"></i> 订单管理</a></li>
						<li><a href="user.do?method=getUser&&where=0"><i class="fa fa-user"></i> 用户管理</a></li>
						<li class="active"><a href="msgServlet?method=getAllNotice"><i class="fa fa-edit"></i> 平台信息管理</a></li>
            
            
        <!--     
            <li ><a href="forward.do?method=forward&&url=index.jsp"><i class="fa fa-dashboard"></i> 首页 </a></li>						
		    <li><a href="appeal.do?method=getListAdminAppeal"><i class="fa fa-table"></i> 申诉管理</a></li>
			<li><a href="forward.do?method=forward&&url=games.jsp"><i class="fa fa-edit"></i> 游戏管理</a></li>
            <li><a href="orderServlet.do?method=getListAdminOrder"><i class="fa fa-bar-chart-o"></i> 订单管理</a></li>
            <li ><a href="user.do?method=getUser"><i class="fa fa-edit"></i> 用户管理</a></li>
            <li class="msgServlet?method=getAllNotice"><a href="msg.html"><i class="fa fa-edit"></i> 平台信息管理</a></li>
             -->
            
           <!-- <li><a href="typography.html"><i class="fa fa-font"></i> Typography</a></li>
            <li><a href="bootstrap-elements.html"><i class="fa fa-desktop"></i> Bootstrap Elements</a></li>
            <li><a href="bootstrap-grid.html"><i class="fa fa-wrench"></i> Bootstrap Grid</a></li>
            <li><a href="blank-page.html"><i class="fa fa-file"></i> Blank Page</a></li>-->
           
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
            <h1> <small>发布新公告</small></h1>
            <ol class="breadcrumb">
              <li><a href="user.do?method=login"><i class="fa fa-dashboard"></i> 首页</a></li>
              <li><a href="msgServlet?method=getAllNotice"><i class="fa fa-edit"></i> 公告</a></li>
              <li class="active"><i class="fa fa-edit"></i> 发布新公告</li>
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
 
            <form role="form" action="msgServlet" method="post">
				<input type="hidden" name="method" value="addNotice">
              <div class="form-group">
                <label>公告标题</label>
                <input class="form-control" name="msg_title">
                <p class="help-block">公告标题文本</p>
              </div>


              <div class="form-group">
                <label>公告内容</label>
                <textarea class="form-control" rows="6" name="msg_content"></textarea>
              </div>

              <button type="submit" class="btn btn-default">发布</button>
              <button type="reset" class="btn btn-default">撤销</button>  

            </form>

          <!--</div>-->
          <!--<div class="col-lg-6">
            <h1>Disabled Form States</h1>

            <form role="form">

              <fieldset disabled>

                <div class="form-group">
                  <label for="disabledSelect">Disabled input</label>
                <input class="form-control" id="disabledInput" type="text" placeholder="Disabled input" disabled>
                </div>

                <div class="form-group">
                  <label for="disabledSelect">Disabled select menu</label>
                  <select id="disabledSelect" class="form-control">
                    <option>Disabled select</option>
                  </select>
                </div>

                <div class="checkbox">
                  <label>
                    <input type="checkbox"> Disabled Checkbox
                  </label>
                </div>

                <button type="submit" class="btn btn-primary">Disabled Button</button>

              </fieldset>

            </form>

            <h1>Form Validation</h1>-->

            <!--<form role="form">

              <div class="form-group has-success">
                <label class="control-label" for="inputSuccess">Input with success</label>
                <input type="text" class="form-control" id="inputSuccess">
              </div>

              <div class="form-group has-warning">
                <label class="control-label" for="inputWarning">Input with warning</label>
                <input type="text" class="form-control" id="inputWarning">
              </div>

              <div class="form-group has-error">
                <label class="control-label" for="inputError">Input with error</label>
                <input type="text" class="form-control" id="inputError">
              </div>
            
            </form>
            
            <h1>Input Groups</h1>

            <form role="form">

              <div class="form-group input-group">
                <span class="input-group-addon">@</span>
                <input type="text" class="form-control" placeholder="Username">
              </div>

              <div class="form-group input-group">
                <input type="text" class="form-control">
                <span class="input-group-addon">.00</span>
              </div>

              <div class="form-group input-group">
                <span class="input-group-addon"><i class="fa fa-eur"></i></span>
                <input type="text" class="form-control" placeholder="Font Awesome Icon">
              </div>

              <div class="form-group input-group">
                <span class="input-group-addon">$</span>
                <input type="text" class="form-control">
                <span class="input-group-addon">.00</span>
              </div>
              
              <div class="form-group input-group">
                <input type="text" class="form-control">
                <span class="input-group-btn">
                  <button class="btn btn-default" type="button"><i class="fa fa-search"></i></button>
                </span>
              </div>

            </form>
            
            <p>For complete documentation, please visit <a href="http://getbootstrap.com/css/#forms">Bootstrap's Form Documentation</a>.</p>

          </div>-->
        </div>       

      </div><!-- /#page-wrapper -->

    </div><!-- /#wrapper -->

    <!-- JavaScript -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.js"></script>

  </body>
</html>
