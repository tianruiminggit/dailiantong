package com.dailiantong.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dailiantong.pojo.Manager;
import com.dailiantong.pojo.Notice;
import com.dailiantong.pojo.Order;
import com.dailiantong.pojo.UserAccount;
import com.dailiantong.service.AppealService;
import com.dailiantong.service.ManagerService;
import com.dailiantong.service.MsgService;
import com.dailiantong.service.OrderService;
import com.dailiantong.service.UserService;
import com.dailiantong.service.impl.AppealServiceImpl;
import com.dailiantong.service.impl.ManagerServiceImpl;
import com.dailiantong.service.impl.MsgServiceImpl;
import com.dailiantong.service.impl.OrderServiceImpl;
import com.dailiantong.service.impl.UserServiceImpl;
import com.dailiantong.util.PageUtils;
import com.google.gson.Gson;
import com.sun.org.apache.bcel.internal.generic.NEW;


@WebServlet("/user.do")
public class UserServlet extends BaseServlet {
	
	
	private static final long serialVersionUID = 1L;	
	private UserService userService = new UserServiceImpl();
	private ManagerService managerService = new ManagerServiceImpl();
	private AppealService appealService = new AppealServiceImpl();
	private OrderService orderService = new OrderServiceImpl();
	private MsgService msgService = new MsgServiceImpl();
	
	/***
	 * ����Ա��¼ҵ���߼�������
	 * @param request
	 * @param response
	 * @return
	 */
	public String login(HttpServletRequest request, HttpServletResponse response){
		
		System.out.println("����Ա��¼");
		List<Order> orderList = null;
		if(request.getSession().getAttribute("user") == null){
			
			String userAccount = request.getParameter("userAccount");
			String password = request.getParameter("password");
			Manager manager = managerService.getManager(userAccount);
			if(manager == null){
				request.setAttribute("msg", "�˻������ڣ�");
				return PROJECT_FORWARD + "/index.jsp";
			} 
			if(!password.equals(manager.getManager_password())){
				request.setAttribute("msg", "�˻����������");
				return PROJECT_FORWARD + "/index.jsp";
			}
	
			request.getSession().setAttribute("user", manager.getManager_nickName());
			request.getSession().setAttribute("undoAppeal", appealService.getUndoAppealNum());
			
			request.setAttribute("todayOrder",  orderService.getListTodayAdminOrder().size());
			request.setAttribute("order", orderService.getListAdminOrder().size());
			request.setAttribute("todayFinishOrder", orderService.getListTodayFinishAdminOrder().size());
			request.setAttribute("finishOrder", orderService.getListFinishAdminOrder().size());
			request.setAttribute("order", orderService.getOrderNum());
			
//			request.setAttribute("todayAppeal", appealService.getTodayAppeal().size() );
//			request.setAttribute("undoOrder",  orderService.getListTodayAdminOrder().size());//δ������������
//			request.setAttribute("todayAppeal", appealService.getTodayAppeal().size() );
//			request.getSession().setAttribute("undoAppeal", appealService.getUndoAppealNum());//δ������������
//			request.setAttribute("todayOrder",  orderService.getListTodayAdminOrder().size());
//			request.setAttribute("order", orderService.getListAdminOrder().size());
			
			
			//��ù���
			Notice notice=msgService.getOne();
			/*String notice_content = notice.getNotice_content();
			if(notice_content.length()>20){
				notice_content=notice_content.substring(0,20)+"...";
			}
			notice.setNotice_content(notice_content);*/
			List<Notice> list= new ArrayList<Notice>();
			list.add(notice);
			
			request.setAttribute("notice",list);
			return PROJECT_FORWARD + "/WEB-INF/adminView/index.jsp";
		} else{
			//��ù���
			Notice notice=msgService.getOne();
			/*String notice_content = notice.getNotice_content();
			if(notice_content.length()>20){
				notice_content=notice_content.substring(0,20)+"...";
			}
			notice.setNotice_content(notice_content);*/
			List<Notice> list= new ArrayList<Notice>();
			list.add(notice);
			
			request.setAttribute("notice",list);
			request.setAttribute("todayOrder",  orderService.getListTodayAdminOrder().size());
			request.setAttribute("order", orderService.getListAdminOrder().size());
			request.setAttribute("todayFinishOrder", orderService.getListTodayFinishAdminOrder().size());
			request.setAttribute("finishOrder", orderService.getListFinishAdminOrder().size());
			request.setAttribute("order", orderService.getOrderNum());
			return PROJECT_FORWARD + "/WEB-INF/adminView/index.jsp";
		}
	}
	
	
	/***
	 * �û���¼ҵ���߼�������
	 * @param request
	 * @param response
	 * @return
	 */
	public String userLogin(HttpServletRequest request, HttpServletResponse response){
		String user_account = (String) request.getSession().getAttribute("userAccount");
		System.out.println(user_account);
		if(user_account == null) {
			String userAccount = request.getParameter("userAccount");
			String password = request.getParameter("password");
			UserAccount user =  userService.getUserAccount(userAccount);
			if(user == null){
				request.setAttribute("msg", "�˻������ڣ�");
				return PROJECT_FORWARD + "/index.jsp";
			} 
			if(!password.equals(user.getUser_password())){
				request.setAttribute("msg", "�˻����������");
				return PROJECT_FORWARD + "/index.jsp";
			}
		
			request.setAttribute("msg", "��¼�ɹ���");

			request.getSession().setAttribute("user", user.getUser_account());
			request.getSession().setAttribute("userAccount", user.getUser_account());
			//��ù���
			Notice notice=msgService.getOne();
			/*String notice_content = notice.getNotice_content();
			if(notice_content.length()>20){
				notice_content=notice_content.substring(0,20)+"...";
			}
			notice.setNotice_content(notice_content);*/
			List<Notice> list= new ArrayList<Notice>();
			list.add(notice);
			
			request.setAttribute("notice",list);
			request.getSession().setAttribute("userAccount", user.getUser_account());
			request.getSession().setAttribute("nickName", user.getUser_nickName());
			request.setAttribute("releaseOrder", orderService.getListReleaseOrder(userAccount).size());
			request.setAttribute("receiveOrder", orderService.getListReceiveOrder(userAccount).size());
			return PROJECT_FORWARD + "/WEB-INF/userView/index.jsp";
		} else {
			//��ù���
			Notice notice=msgService.getOne();
			/*String notice_content = notice.getNotice_content();
			if(notice_content.length()>20){
				notice_content=notice_content.substring(0,20)+"...";
			}
			notice.setNotice_content(notice_content);*/
			List<Notice> list= new ArrayList<Notice>();
			list.add(notice);
			
			request.setAttribute("notice",list);
			int es = orderService.getListReleaseOrder(user_account).size();
			System.out.println(es);
			int s = orderService.getListReceiveOrder(user_account).size();
			request.setAttribute("releaseOrder", es );
			request.setAttribute("receiveOrder", s);
			return PROJECT_FORWARD + "/WEB-INF/userView/index.jsp";
		}
		
	}
	
	
	/****
	 * �û�ע��ҵ���߼�������
	 * @param request
	 * @param response
	 * @return
	 */
	public String regist(HttpServletRequest request, HttpServletResponse response){
		UserAccount user = new UserAccount();
		String userAccount = request.getParameter("userAccount");
		user.setUser_account(userAccount);
		String password = request.getParameter("passwrod");
		user.setUser_password(password);
		String nickName = request.getParameter("nickName");
		user.setUser_nickName(nickName);
		String email =request.getParameter("email");
		user.setUser_email(email);
		String tel = request.getParameter("tel");
		user.setUser_tel(tel);
		int i = userService.addUserAccount(user);
		if(i != 1){
			request.setAttribute("msg", "ע��ʧ�ܣ�");
			return PROJECT_FORWARD + "/regist.jsp";
		} else{
			return PROJECT_FORWARD + "/index.jsp";
		}
	}
	
	/**
	 * �û����������ѯ�û�
	 * @param request
	 * @param response
	 * @return
	 */

	public String  getUser(HttpServletRequest request, HttpServletResponse response){
		userService = new UserServiceImpl();
		//String whereString = request.getParameter("where");
		String s = request.getParameter("page");
		int i;
		if(s == null){
			i = 1;
		} else{
			i=Integer.parseInt(s);
		}
		PageUtils.page = i;
		
		String where =request.getParameter("where");
		
		System.out.println(where);
		//��������
		List<Map<String,Object>> map = userService.getListMapUser(where);
		System.out.println(map);
		
		request.setAttribute("bar", PageUtils.getBar(request.getServletPath().substring(1),request.getQueryString()));
		request.setAttribute("all", "active");
		request.setAttribute("userList", map);
		/*request.setAttribute("dongMaps", dongMaps);
		request.setAttribute("onlineMaps", onlineMaps);
		*/
		return PROJECT_FORWARD+"WEB-INF/adminView/user.jsp";
	}
	
	
	
	/**
	 * �û�����,��ѯ�����û�
	 * @param request
	 * @param response
	 * @return
	 */

	public String  getUserDong(HttpServletRequest request, HttpServletResponse response){
		System.out.println("�����˻�");
		userService = new UserServiceImpl();
		//String whereString = request.getParameter("where");
		String s = request.getParameter("page");
		int i;
		if(s == null){
			i = 1;
		} else{
			i=Integer.parseInt(s);
		}
		PageUtils.page = i;
		String where =request.getParameter("where");
		System.out.println(where);
		//�����û�
		List<Map<String,Object>> dongMaps = userService.getListMapUser(where);
		//·������
		System.out.println(request.getQueryString());
		request.setAttribute("bar", PageUtils.getBar(request.getServletPath().substring(1),request.getQueryString()));
		request.setAttribute("dong", "active");
		request.setAttribute("userList", dongMaps);
		/*request.setAttribute("dongMaps", dongMaps);
		request.setAttribute("onlineMaps", onlineMaps);
		*/
		return PROJECT_FORWARD+"WEB-INF/adminView/user.jsp";
	}
	

	/**
	 * �û�����,��ѯ�����û�
	 * @param request
	 * @param response
	 * @return
	 */

	public String getUserOnline(HttpServletRequest request, HttpServletResponse response){
		System.out.println("�����û�");
		userService = new UserServiceImpl();
		String s = request.getParameter("page");
		int i;
		if(s == null){
			i = 1;
		} else{
			i=Integer.parseInt(s);
		}
		PageUtils.page = i;
		String where =request.getParameter("where");
		System.out.println(where);
		//�����û�
		List<Map<String,Object>> onlineMaps = userService.getListMapUser(where);
		//·������
		System.out.println(request.getQueryString());
		request.setAttribute("bar", PageUtils.getBar(request.getServletPath().substring(1),request.getQueryString()));
		request.setAttribute("online", "active");
		request.setAttribute("userList", onlineMaps);
		return PROJECT_FORWARD+"WEB-INF/adminView/user.jsp";
	}
	
	
	
	
	//�ж��û��Ƿ���֧�����룬û�о�������п����˻���
	public String getUserPay(HttpServletRequest request,HttpServletResponse response){
		String user_account=(String)request.getSession().getAttribute("userAccount");
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			out.print(gson.toJson(userService.getUserAccount(user_account)));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	
	
	
	
	public String logout(HttpServletRequest request,HttpServletResponse response){
		request.getSession().invalidate();
		return PROJECT_REDIRECT + "/index.jsp";
		
	}
	
	
	
	

	/**
	 * ɾ���û�
	 * @param request
	 * @param response
	 * @return
	 */
	public String delUser(HttpServletRequest request,HttpServletResponse response){
		String account=request.getParameter("account");
		userService.delUser(account);
		
	
		
		return PROJECT_FORWARD+"user.do?method=getUser&&where=0";
	}
	
	

	
	
	
}
