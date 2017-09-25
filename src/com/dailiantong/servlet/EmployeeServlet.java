package com.dailiantong.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailiantong.pojo.ChildUser;
import com.dailiantong.pojo.Employee;
import com.dailiantong.service.impl.EmployeeServiceImpl;
import com.google.gson.Gson;

@WebServlet("/employeeServlet.do")
public class EmployeeServlet extends BaseServlet {
	
	private EmployeeServiceImpl employeeservice = new EmployeeServiceImpl();
	/**
	 * 插入员工信息到页面
	 * @param request
	 * @param response
	 * @return
	 */
	public String insertEmployee(HttpServletRequest request,HttpServletResponse response) {
		String user_account = request.getParameter("user_account");
		String employee = request.getParameter("employee");
//		String order_id = (String) request.getAttribute("order_id");
		Employee employee1 = new Employee();
		employee1.setEmployer(user_account);
		employee1.setEmployee(employee);
//		employee1.setOrder_id(order_id);
		return getListEmployee(request,response);
	}
	/**
	 * 将查询到的员工信息传到页面
	 * @param request
	 * @param response
	 * @return
	 */
	public String getListEmployee(HttpServletRequest request,HttpServletResponse response) {
		String employee = (String) request.getSession().getAttribute("userAccount");
		System.out.println(employee);
		List<Map<String, Object>> ListEmployee = employeeservice.getListEmployee(employee);
		request.setAttribute("i", "全部");
		request.setAttribute("ListEmployee", ListEmployee);
		return PROJECT_FORWARD+"/WEB-INF/userView/employeeManage.jsp";
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
//	public String selectEmployee(HttpServletRequest request,HttpServletResponse response) {
//		String order_id = (String) request.getSession().getAttribute("userAccount");
//		int id=Integer.parseInt(request.getParameter("order_id"));
//		List<Map<String,Object>> object = employeeservice.getListEmployee(order_id);
//		request.setAttribute(order_id, object);
//		if("employee".equals(order_id)) {
//			return PROJECT_FORWARD+"WEB-INF/userView/employeeManage.jsp";
//		}
//		return PROJECT_FORWARD+"WEB-INF/userView/employeeManage.jsp";
//	}
	public String getEmployee(HttpServletRequest request,HttpServletResponse response) {
		String employee = request.getParameter("employee");
		List<Map<String,Object>> ListEmployee = employeeservice.findEmployee(employee);
		System.out.println(ListEmployee.toString());
		request.setAttribute("userAccount", request.getSession().getAttribute("userAccount"));
		request.setAttribute("i", "子账号");
		request.setAttribute("ListEmployee", ListEmployee);
		return PROJECT_FORWARD+"/WEB-INF/userView/employeeManage.jsp";
	}
	/**
	 * 删除员工并刷新页面
	 * @param request
	 * @param response
	 * @return
	 */
	public String deleteEmployee(HttpServletRequest request,HttpServletResponse response) {
		String employee = request.getParameter("employee");
		String user_account = (String)request.getSession().getAttribute("userAccount");
		int i = employeeservice.deleteEmployee(employee,user_account);
		return getListEmployee(request,response);
	}
	/**
	 * Ajax按照用户帐号查询员工
	 * @param request
	 * @param response
	 * @return
	 */
	public String getEmployeeAjax(HttpServletRequest request,HttpServletResponse response){
		String user_account = request.getParameter("user_account");
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			out.print(gson.toJson(employeeservice.findEmployee(user_account)));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}