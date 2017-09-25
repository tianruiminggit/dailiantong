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
	
	public static String PROJECT_REDIRECT; //��Ŀ���ض���ĸ�·���������ض���ʱ�����http404����
	public static String PROJECT_FORWARD; //��Ŀ��ת���ĸ�·����������ת���Ĺ������Ҳ���ҳ��
	
	@Override
	public void init() throws ServletException {
		PROJECT_REDIRECT = "r:" + getServletContext().getContextPath();
		PROJECT_FORWARD = "f:";
	}
	/***
	 * ǰ�ο�����
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //����������������
		String name = request.getParameter("method"); //��������ҵ��������ķ���������ʲô
		Class clazz = getClass(); //ҵ��������ķ�����
		Method method = null; //ҵ��������ķ���
		if (name == null) {
			return; //�ҵ�������������ֹ
		}
		try {
			method = clazz.getMethod(name, HttpServletRequest.class, HttpServletResponse.class);
			String path = (String) method.invoke(this, request, response); //����ҵ��������ķ���
			if (path == null) {
				return; //Ajax�ĵ���
			}
			if ("r:".equals(path.substring(0, 2))) { //redirect,�ض���
				response.sendRedirect(path.substring(2));
			} else if ("f:".equals(path.substring(0, 2))) { //forword,ת��
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
