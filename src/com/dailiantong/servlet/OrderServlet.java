package com.dailiantong.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dailiantong.pojo.Game;
import com.dailiantong.pojo.Order;
import com.dailiantong.service.GameService;
import com.dailiantong.service.OrderService;
import com.dailiantong.service.impl.GameServiceImpl;
import com.dailiantong.service.impl.OrderServiceImpl;
import com.dailiantong.util.OrderNum;
import com.dailiantong.util.PageUtils;
import com.google.gson.Gson;

@WebServlet("/orderServlet.do")
public class OrderServlet extends BaseServlet {
	
	private OrderService orderService = new OrderServiceImpl();
	private GameService gameService = new GameServiceImpl();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -959890972824638672L;
	
	/**
	 * ��ǰ�û���ӷ���
	 * @param request
	 * @param response
	 * @return
	 */
	public String insertOrder(HttpServletRequest request, HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8");
		String payPwd = request.getParameter("payPwd");
		String user_account = (String)request.getSession().getAttribute("userAccount");
		String order_gameName = request.getParameter("gameName");
		String order_gameAccount = request.getParameter("gameAccount");
		String order_content = request.getParameter("content");
		String order_gameInfo = request.getParameter("gameInfo");
		String order_task = request.getParameter("task");
		System.out.println(order_gameAccount);
		String order_gamePassword = request.getParameter("password");
		System.out.println(order_gamePassword);
		int order_finishTime = Integer.parseInt(request.getParameter("finishTime"));
		System.out.println(order_finishTime);
		double order_price = Double.parseDouble(request.getParameter("price"));
		double order_bond = Double.parseDouble(request.getParameter("bondPrice"));
		int order_deleteTime = Integer.parseInt(request.getParameter("deleteTime"));
		System.out.println(order_deleteTime);
		String order_id = OrderNum.getOrder();
		Order order = new Order(order_id, user_account, order_price, order_finishTime, 
				order_deleteTime, order_content, order_gameInfo, order_bond,
				order_gameName, order_gameAccount, order_gamePassword, order_task);
		try {
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			out.print(gson.toJson(gson.toJson(orderService.insertOrder(order,payPwd))));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	};
	
	/**
	 * ��õ�ǰ�û���ȫ������
	 * @param request
	 * @param response
	 * @return
	 */
	public String getListReleaseOrder(HttpServletRequest request, HttpServletResponse response ) {
		String user_account = (String)request.getSession().getAttribute("userAccount");
		List<Map<String, Object>> listOrder = orderService.getListReleaseOrder(user_account);
		List<Game> listGameName = gameService.getListAllGame();
		for(Map<String, Object> map :listOrder){
			System.out.println(map.get("order_gameInfo").toString());
			if(map.get("order_gameInfo").toString().length()>20){
				String order_gameInfo =map.get("order_gameInfo").toString().substring(0,20)+"...";
				map.remove("order_gameInfo");
				map.put("order_gameInfo", order_gameInfo);
				System.out.println(map.get("order_gameInfo"));
			}
		}
		request.setAttribute("listGameName", listGameName);
		request.setAttribute("listOrder", listOrder);
		return PROJECT_FORWARD+"/WEB-INF/userView/releaseOrderManage.jsp";
	};
	
	/**
	 * ��õ�ǰ�û���ȫ���ӵ�
	 * @param request
	 * @param response
	 * @return
	 */
	public String getListReceiveOrder(HttpServletRequest request, HttpServletResponse response ) {
		String use_user_account = (String)request.getSession().getAttribute("userAccount");
		List<Map<String, Object>> listOrder = orderService.getListReceiveOrder(use_user_account);
		for(Map<String, Object> map :listOrder){
			System.out.println(map.get("order_gameInfo").toString());
			if(map.get("order_gameInfo").toString().length()>20){
				String order_gameInfo =map.get("order_gameInfo").toString().substring(0,20)+"...";
				map.remove("order_gameInfo");
				map.put("order_gameInfo", order_gameInfo);
				System.out.println(map.get("order_gameInfo"));
			}
		}
		List<Game> listGameName = gameService.getListAllGame();
		request.setAttribute("listGameName", listGameName);
		request.setAttribute("listOrder", listOrder);
		return PROJECT_FORWARD+"/WEB-INF/userView/receiveOrderManage.jsp";
	};
	
	/**
	 * ���ȫ��δ���ֶ���������������
	 * @param request
	 * @param response
	 * @return
	 */
	public String getListAllOrder(HttpServletRequest request, HttpServletResponse response ) {
		String order_status = request.getParameter("status");
		String type = request.getParameter("type");
		String page = request.getParameter("page");
		int i;
		if(page==null){
			i=1;
		}
		else{
			i=Integer.parseInt(page);
		}
		PageUtils.page=i;
		
		String user_account = (String)request.getSession().getAttribute("userAccount");
		List<Map<String, Object>> listOrder = orderService.getListAllOrder(order_status, user_account, type);
		for(Map<String, Object> map :listOrder){
			System.out.println(map.get("order_gameInfo").toString());
			if(map.get("order_gameInfo").toString().length()>20){
				String order_gameInfo =map.get("order_gameInfo").toString().substring(0,20)+"...";
				map.remove("order_gameInfo");
				map.put("order_gameInfo", order_gameInfo);
				System.out.println(map.get("order_gameInfo"));
			}
		}
		List<Game> listGameName = gameService.getListAllGame();
		request.setAttribute("listGameName", listGameName);
		request.setAttribute("listOrder", listOrder);
		request.setAttribute("bar", PageUtils.getBar(request.getServletPath().substring(1), request.getQueryString()));
		if("releaseOrder".equals(type)){
			return PROJECT_FORWARD+"/WEB-INF/userView/releaseOrderManage.jsp";
		}
		if("receiveOrder".equals(type)){
			return PROJECT_FORWARD+"/WEB-INF/userView/receiveOrderManage.jsp";
		}
		return PROJECT_FORWARD+"/WEB-INF/userView/orderHall.jsp";
	};
	
	/**
	 * ��������Ϸ����
	 * @param request
	 * @param response
	 * @return
	 */
	public String getListOrderByGame_name(HttpServletRequest request, HttpServletResponse response ) {
		String orderType = request.getParameter("orderType");
		String type = request.getParameter("type");
		String user_account = (String)request.getSession().getAttribute("userAccount");
		List<Game> listGameName = gameService.getListAllGame();
		request.setAttribute("listGameName", listGameName);
		List<Map<String, Object>> listOrder = orderService.getListOrderByGame_name(orderType,user_account,type);
		for(Map<String, Object> map :listOrder){
			System.out.println(map.get("order_gameInfo").toString());
			if(map.get("order_gameInfo").toString().length()>20){
				String order_gameInfo =map.get("order_gameInfo").toString().substring(0,20)+"...";
				map.remove("order_gameInfo");
				map.put("order_gameInfo", order_gameInfo);
				System.out.println(map.get("order_gameInfo"));
			}
		}
		request.setAttribute("listOrder", listOrder);
		if("releaseOrder".equals(type)){
			return PROJECT_FORWARD+"/WEB-INF/userView/releaseOrderManage.jsp";
		}else if("receiveOrder".equals(type)){
			return PROJECT_FORWARD+"/WEB-INF/userView/receiveOrderManage.jsp";
		}
		return PROJECT_FORWARD+"/WEB-INF/userView/orderHall.jsp";
	};
	
	/**
	 * �޸Ķ���
	 * @param request
	 * @param response
	 * @return
	 */
	public String updateOrder(HttpServletRequest request, HttpServletResponse response ) {response.setContentType("text/html;charset=utf-8");
		String payPwd = request.getParameter("payPwd");
		String user_account = (String)request.getSession().getAttribute("userAccount");
		String order_gameName = request.getParameter("order_gameName");
		String order_gameAccount = request.getParameter("order_gameAccount");
		String order_content = request.getParameter("order_content");
		String order_gameInfo = request.getParameter("order_gameInfo");
		String order_task = request.getParameter("order_task");
		String order_gamePassword = request.getParameter("order_gamePassword");
		int order_finishTime = Integer.parseInt(request.getParameter("order_finishTime"));
		double order_price = Double.parseDouble(request.getParameter("order_price"));
		double order_bond = Double.parseDouble(request.getParameter("order_bond"));
		int order_deleteTime = 5;
		String order_id = request.getParameter("order_id");
		Order order = new Order(order_id, user_account, order_price, order_finishTime, 
				order_deleteTime, order_content, order_gameInfo, order_bond,
				order_gameName, order_gameAccount, order_gamePassword, order_task);
		try {
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			out.print(gson.toJson(gson.toJson(orderService.updateOrder(order, payPwd))));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	};
	
	/**
	 * ɾ������
	 * @param request
	 * @param response
	 * @return
	 */
	public String deleteOrder(HttpServletRequest request, HttpServletResponse response ) {
		String order_id = request.getParameter("order_id");
		String userType = request.getParameter("userType");
		String methodType = request.getParameter("methodType");
		String msg = orderService.deleteOrder(order_id, userType, methodType);
		request.setAttribute("msg", msg);
		String user_account = (String)request.getSession().getAttribute("userAccount");
		List<Game> listGameName = gameService.getListAllGame();
		request.setAttribute("listGameName", listGameName);
		if("releaseOrder".equals(userType)){
			List<Map<String, Object>> listOrder = orderService.getListReleaseOrder(user_account);
			for(Map<String, Object> map :listOrder){
				System.out.println(map.get("order_gameInfo").toString());
				if(map.get("order_gameInfo").toString().length()>20){
					String order_gameInfo =map.get("order_gameInfo").toString().substring(0,20)+"...";
					map.remove("order_gameInfo");
					map.put("order_gameInfo", order_gameInfo);
					System.out.println(map.get("order_gameInfo"));
				}
			}
			request.setAttribute("listOrder", listOrder);
			return PROJECT_FORWARD+"/WEB-INF/userView/releaseOrderManage.jsp";
		}
		if("receiveOrder".equals(userType)){
			List<Map<String, Object>> listOrder = orderService.getListReceiveOrder(user_account);
			for(Map<String, Object> map :listOrder){
				System.out.println(map.get("order_gameInfo").toString());
				if(map.get("order_gameInfo").toString().length()>20){
					String order_gameInfo =map.get("order_gameInfo").toString().substring(0,20)+"...";
					map.remove("order_gameInfo");
					map.put("order_gameInfo", order_gameInfo);
					System.out.println(map.get("order_gameInfo"));
				}
			}
			request.setAttribute("listOrder", listOrder);
			return PROJECT_FORWARD+"/WEB-INF/userView/receiveOrderManage.jsp";
		}
		return null;
	};
	
	/**
	 * �ӵ�
	 * @param request
	 * @param response
	 * @return
	 */
	public String recevieOrder(HttpServletRequest request, HttpServletResponse response ) {
		response.setContentType("text/html;charset=utf-8");
		String payPwd = request.getParameter("payPwd");
		String order_id = request.getParameter("order_id");
		String user_account = (String)request.getSession().getAttribute("userAccount");
		try {
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			out.print(gson.toJson(orderService.recevieOrder(order_id, user_account, payPwd)));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	};
	
	/**
	 * ͨ���۸������ѯ����
	 * @param request
	 * @param response
	 * @return
	 */
	public String getListOrderByPrice(HttpServletRequest request, HttpServletResponse response){
		String order_MaxPrice = request.getParameter("order_MaxPrice");
		String order_MinPrice = request.getParameter("order_MinPrice");
		String user_account = (String)request.getSession().getAttribute("userAccount");
		List<Map<String, Object>> listOrder = orderService.getListOrderByPrice(order_MinPrice, order_MaxPrice, 4, user_account);
		for(Map<String, Object> map :listOrder){
			System.out.println(map.get("order_gameInfo").toString());
			if(map.get("order_gameInfo").toString().length()>20){
				String order_gameInfo =map.get("order_gameInfo").toString().substring(0,20)+"...";
				map.remove("order_gameInfo");
				map.put("order_gameInfo", order_gameInfo);
				System.out.println(map.get("order_gameInfo"));
			}
		}
		request.setAttribute("listOrder", listOrder);
		List<Game> listGameName = gameService.getListAllGame();
		request.setAttribute("listGameName", listGameName);
		return PROJECT_FORWARD+"/WEB-INF/userView/orderHall.jsp";
	}
	
	/**
	 * ���ص������з����ļ���
	 * @param request
	 * @param response
	 * @return
	 */
	public String getListTodayAdminOrder(HttpServletRequest request, HttpServletResponse response){
		return null;
		
	}
	/***
	 * �����ڵ���������ɵĵ���
	 * @param request
	 * @param response
	 * @return
	 */
	public String getListTodayFinishAdminOrder(HttpServletRequest request, HttpServletResponse response){
		return null;
		
	}
	/***
	 * �������е��ӵļ���
	 * @param request
	 * @param response
	 * @return
	 */
	public String getListAdminOrder(HttpServletRequest request, HttpServletResponse response){
		//�õ���ǰҳ
		String s=request.getParameter("page");
		int i;
		if(s == null){
			i = 1;
		} else{
			i=Integer.parseInt(s);
		}
		PageUtils.page = i;
		
		
		//���ȫ������
		List<Map<String, Object>> listAllOrder = orderService.getListAdminOrder();
		
		//���ü�limit 
//		PageBean<Map<String, Object>> pageBean = new PageBean<Map<String,Object>>(i,listAllOrder);
		
		//����ƴ�Ӻõķ�ҳ
		request.setAttribute("bar", PageUtils.getBar(request.getServletPath().substring(1),request.getQueryString()));
		request.setAttribute("listOrder", listAllOrder);
		
		return PROJECT_FORWARD+"/WEB-INF/adminView/order.jsp";
		
	}
	
	/***
	 * �������е��ӵļ���
	 * @param request
	 * @param response
	 * @return
	 */
	public String getListAdminOrderType(HttpServletRequest request, HttpServletResponse response){
		int where = Integer.parseInt(request.getParameter("where"));
		String s = request.getParameter("page");
		int i;
		if(s==null){
			i=1;//s Ϊ��, ����Ĭ��Ϊ��һҳ
		}
		else{
			i=Integer.parseInt(s); //s ��Ϊ�գ�����ת����
		}
		//�õ���ǰҳ
		PageUtils.page=i;
		//�����ݿ�ȡ������
		List<Map<String, Object>> listAllOrder = orderService.getListAdminOrder(where);
		
		//orderServlet.do
		System.out.println(request.getServletPath().substring(1));
		//����ƴ�Ӻõķ�ҳ
		request.setAttribute("bar", PageUtils.getBar(request.getServletPath().substring(1),request.getQueryString()));
		
		request.setAttribute("listOrder", listAllOrder);
		
		return PROJECT_FORWARD+"/WEB-INF/adminView/order.jsp";
		
	}
	
	
	/**
	 * ����������ɵĵ��ӵļ���
	 * @param request
	 * @param response
	 * @return
	 */
	public String getListFinishAdminOrder(HttpServletRequest request, HttpServletResponse response){
		return null;
		
	}
	
	/**
	 * ���ձ�Ų�ѯ�˵�
	 * @param request
	 * @param response
	 * @return
	 */
	public String getOrder(HttpServletRequest request,HttpServletResponse response){
		String type = request.getParameter("type");
		String user_account = (String) request.getSession().getAttribute("userAccount");
		String order_id = request.getParameter("order_id");
		List<Game> listGameName = gameService.getListAllGame();
		request.setAttribute("listGameName", listGameName);
		List<Map<String, Object>> listOrder=orderService.findOrder(order_id,type,user_account);
		for(Map<String, Object> map :listOrder){
			System.out.println(map.get("order_gameInfo").toString());
			if(map.get("order_gameInfo").toString().length()>20){
				String order_gameInfo =map.get("order_gameInfo").toString().substring(0,20)+"...";
				map.remove("order_gameInfo");
				map.put("order_gameInfo", order_gameInfo);
				System.out.println(map.get("order_gameInfo"));
			}
		}
		request.setAttribute("listOrder", listOrder);
		if("releaseOrder".equals(type)){
			return PROJECT_FORWARD+"/WEB-INF/userView/releaseOrderManage.jsp";
		}
		if("receiveOrder".equals(type)){
			return PROJECT_FORWARD+"/WEB-INF/userView/receiveOrderManage.jsp";
		}
		if("hallOrder".equals(type)){
			return PROJECT_FORWARD+"/WEB-INF/userView/orderHall.jsp";
		}
		return PROJECT_FORWARD+"/WEB-INF/adminView/order.jsp";
	}
	
	
	/**
	 * Ajax���ձ�Ų�ѯ�˵�
	 * @param request
	 * @param response
	 * @return
	 */
	public String getOrderAjax(HttpServletRequest request,HttpServletResponse response){
		String order_id = request.getParameter("order_id");
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			out.print(gson.toJson(orderService.findOrder(order_id,"","")));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * ����ÿ����Ϸ����������
	 * ajax
	 * @param request
	 * @param response
	 * @return
	 */
	public String getMapOrderNumByGame(HttpServletRequest request,HttpServletResponse response){
		
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
//			JSONObject json = new JSONObject();
//			json.put();
//			Map<String, Object> map = new HashMap<>();
//			map.put("list",orderService.getListMapOrderNumByGame() );
			out.print(gson.toJson(gson.toJson(orderService.getListMapOrderNumByGame())));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
}
