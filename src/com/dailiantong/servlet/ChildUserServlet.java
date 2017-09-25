package com.dailiantong.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dailiantong.pojo.ChildUser;
import com.dailiantong.service.impl.ChildUserServiceImpl;
import com.dailiantong.util.DataUtils;
import com.dailiantong.util.PageUtils;
import com.google.gson.Gson;

@WebServlet("/childUserServlet.do")
public class ChildUserServlet extends BaseServlet {
	
	private ChildUserServiceImpl childuserservice = new ChildUserServiceImpl();
	/**
	 * 插入子帐号信息
	 * @param request
	 * @param response
	 * @return
	 */
	public String insertChildUser(HttpServletRequest request,HttpServletResponse response) {
		String child_id = request.getParameter("child_id");
		String user_account = request.getParameter("user_account");
		String child_account = request.getParameter("child_account");
		String child_name = request.getParameter("child_name");
		String child_password = request.getParameter("child_password");
		double child_money = (double) request.getAttribute("child_money");
		String child_root = request.getParameter("child_root");
		Date child_time = (Date) request.getAttribute("child_time");
		ChildUser childuser = new ChildUser();
		childuser.setChild_id(child_id);
		childuser.setUser_account(user_account);
		childuser.setChild_account(child_account);
		childuser.setChild_name(child_name);
		childuser.setChild_password(child_password);
		childuser.setChild_money(child_money);
		childuser.setChild_root(child_root);
		childuser.setChild_time(child_time);
		return getListChildUser(request, response);
	}
	/**
	 * 将查询到的所有子帐号信息传到页面
	 * @param request
	 * @param response
	 * @return
	 */
	public String getListChildUser(HttpServletRequest request,HttpServletResponse response) {
		String childuser = (String) request.getSession().getAttribute("userAccount");
		//获得当前页数
		String page = request.getParameter("page");
		int i;
		if(page==null){
			i=1;
		}
		else{
			i=Integer.parseInt(page);
		}
		PageUtils.page=i;
		List<ChildUser> ListChildUser = childuserservice.getListChildUser(childuser);
		System.out.println(ListChildUser);
		request.setAttribute("bar",PageUtils.getBar(request.getServletPath().substring(1),request.getQueryString()));
		request.setAttribute("ListChildUser", ListChildUser);
		return PROJECT_FORWARD+"/WEB-INF/userView/smallAccount.jsp";
	}
	/**
	 * 修改子帐号信息传到页面
	 * @param request
	 * @param response
	 * @return
	 */
	public String updateChildUser(HttpServletRequest request, HttpServletResponse response ) {
		System.out.println("进入修改子帐号servlet");
		
		
		String user_account = (String) request.getSession().getAttribute("userAccount");
		String child_id = request.getParameter("child_id");
//		String child_account = request.getParameter("child_account");
		String child_name = request.getParameter("child_name");
		String child_password = request.getParameter("child_password");
		int child_money = Integer.parseInt(request.getParameter("child_money"));
		String child_root = request.getParameter("child_root");
		
		//获得当前对象的信息
		ChildUser childuser = childuserservice.findByChildUser(child_id);
		
		//传入当前对象修改的信息
		childuser.setUser_account(user_account);
//		childuser.setChild_account(child_account);
		childuser.setChild_name(child_name);
		childuser.setChild_password(child_password);
		childuser.setChild_money(child_money);
		childuser.setChild_root(child_root);
		
		//执行修改
		int i = childuserservice.updateChildUser(childuser);
		
		//执行更新成功
		if(i==1){
			try {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				Gson gson = new Gson();
				out.print(gson.toJson("1"));
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		else{
			System.out.println("更新子帐号失败");
		}
		
		return null;
	};
	/**
	 * 删除子帐号信息并刷新页面
	 * @param request
	 * @param response
	 * @return
	 */
	public String deleteChildUser(HttpServletRequest request,HttpServletResponse response) {
		String child_id = request.getParameter("child_id");
		//执行删除子帐号
		childuserservice.deleteChildUser(child_id);
		
		System.out.println("删除子帐号执行");
	/*	List<ChildUser> getListChildUser = (List<ChildUser>) childuserservice.findChildUser(child_id);
		System.out.println(child_id);
		request.setAttribute("ListChildUser", getListChildUser);
		return PROJECT_FORWARD+"/WEB-INF/userView/smallAccount.jsp";*/
		
		return getListChildUser(request,response);
	}
	public String getChildUser(HttpServletRequest request,HttpServletResponse response) {
		String child_id = request.getParameter("child_id");
		List<ChildUser> getListChildUser = (List<ChildUser>) childuserservice.findChildUser(child_id);
		System.out.println(getListChildUser.toString());
		request.setAttribute("ListChildUser", getListChildUser);
		return PROJECT_FORWARD+"/WEB-INF/userView/smallAccount.jsp";
	}
	/**
	 * Ajax按照用户帐号查询子帐号
	 * @param request
	 * @param response
	 * @return
	 */
	public String getChildUserAjax(HttpServletRequest request,HttpServletResponse response){
		String child_id = request.getParameter("child_id");
		System.out.println(child_id);
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			ChildUser childUser = childuserservice.findByChildUser(child_id);
			/*for(ChildUser u:childUser){
				System.out.println(u.getChild_account());
			}*/
//			System.out.println(childUser);
			out.print(gson.toJson(childUser));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String addChildUser(HttpServletRequest request,HttpServletResponse response){
		String user_account = (String) request.getSession().getAttribute("userAccount");
		String child_account = request.getParameter("child_account");
		String child_name = request.getParameter("child_name");
		String child_password = request.getParameter("child_password");
		double child_money = Double.parseDouble(request.getParameter("child_money"));
		String child_root = request.getParameter("child_root");
		
		//实例化对象
		ChildUser childuser = new ChildUser();
		
		//传入当前对象修改的信息
		childuser.setUser_account(user_account);
		childuser.setChild_account(child_account);
		childuser.setChild_name(child_name);
		childuser.setChild_password(child_password);
		childuser.setChild_money(child_money);
		childuser.setChild_root(child_root);
		childuser.setChild_time(DataUtils.getDate());
		int i = childuserservice.insertChildUser(childuser);
		if(i==1){
			try {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				Gson gson = new Gson();
				out.print(gson.toJson("1"));
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		else{
			System.out.println("添加子帐号失败");
		}
		return null;
	}
}
