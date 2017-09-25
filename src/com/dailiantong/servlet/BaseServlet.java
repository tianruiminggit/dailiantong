package com.dailiantong.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static String PROJECT_REDIRECT; //项目做重定向的根路径，避免重定向时候出现http404错误
	public static String PROJECT_FORWARD; //项目做转发的根路径，避免在转发的过程中找不到页面
	
	@Override
	public void init() throws ServletException {
		PROJECT_REDIRECT = "r:" + getServletContext().getContextPath();
		PROJECT_FORWARD = "f:";
	}
	/***
	 * 前段控制器
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //解析中文乱码问题
		String name = request.getParameter("method"); //参数定义业务控制器的方法名称是什么
		Class clazz = getClass(); //业务控制器的反射类
		Method method = null; //业务控制器的方法
		if (name == null) {
			return; //找到方法名称则终止
		}
		try {
			method = clazz.getMethod(name, HttpServletRequest.class, HttpServletResponse.class);
			String path = (String) method.invoke(this, request, response); //调用业务控制器的方法
			if (path == null) {
				return; //Ajax的调用
			}
			if ("r:".equals(path.substring(0, 2))) { //redirect,重定向
				response.sendRedirect(path.substring(2));
			} else if ("f:".equals(path.substring(0, 2))) { //forword,转发
				request.getRequestDispatcher(path.substring(2)).forward(request, response);
			}
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
