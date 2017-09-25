package com.dailiantong.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dailiantong.service.AppealService;
import com.dailiantong.service.impl.AppealServiceImpl;
import com.dailiantong.util.PageUtils;
import com.google.gson.Gson;

@WebServlet("/appeal.do")
public class AppealServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AppealService appealService = new AppealServiceImpl();
	/***
	 * ����ѯ��������������Ϣ����ҳ��
	 * admin
	 * @param request
	 * @param response
	 * @return
	 */
	public String getListAdminAppeal(HttpServletRequest request, HttpServletResponse response){
		String s = request.getParameter("page");
		 
		int i;
		if(s == null){
			i = 1;
		} else{
			i=Integer.parseInt(s);
		}
		PageUtils.page = i;
		request.setAttribute("list",appealService.getListAdminAppeal()); 
//		request.setAttribute("accountList", appealService.getListTypeAppeal("0"));
//		request.setAttribute("moneyList", appealService.getListTypeAppeal("1"));
		request.setAttribute("all", "active");
		request.setAttribute("bar", PageUtils.getBar(request.getServletPath().substring(1),request.getQueryString()));
		return PROJECT_FORWARD+"WEB-INF/adminView/appeal.jsp";
		
	}
	/***
	 * ��ѯ��ͬ���͵�������Ϣ
	 * @param request
	 * @param response
	 * @return
	 */
	public String getListTypeAppeal(HttpServletRequest request, HttpServletResponse response){
		System.out.println("trm");
		String type = request.getParameter("appeal_type");
		String s = request.getParameter("page");
		int i;
		if(s == null){
			i = 1;
		} else{
			i=Integer.parseInt(s);
		}
		PageUtils.page = i;
		if("0".equals(type)){
			request.setAttribute("account", "active");
		} else request.setAttribute("money", "active");
		request.setAttribute("list", appealService.getListTypeAppeal(type));
		request.setAttribute("bar", PageUtils.getBar(request.getServletPath().substring(1),request.getQueryString()));
		return PROJECT_FORWARD + "WEB-INF/adminView/appeal.jsp";
		
	}
	/***
	 * ͨ��id������������Ϣ������ҳ��AJAX����
	 * admin
	 * @return
	 */
	public String getListAppeal(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("appeal_id");
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			System.out.println("����JSON��ʽ�ַ�����"+gson.toJson(appealService.getListAppeal(id)));
			out.print(gson.toJson(appealService.getListAppeal(id)));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;//null����AJAX����
		
	}
	/***
	 * ����������Ϣ
	 * @param request
	 * @param response
	 * @return
	 */
	public String updateAppeal(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("appeal_id");
		if(appealService.updateAppeal(id)>0){
			request.setAttribute("msg", "�����ɹ�");
		} else{
			request.setAttribute("msg", "�����ɹ�");
		}
		return getListAdminAppeal(request, response);
		
	}
	
	public String getListUndoAppela(HttpServletRequest request, HttpServletResponse response){
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			out.print(gson.toJson(appealService.getListUndoAppeal()));
			out.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}
