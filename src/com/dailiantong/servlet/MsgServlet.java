package com.dailiantong.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dailiantong.pojo.Notice;
import com.dailiantong.service.MsgService;
import com.dailiantong.service.impl.MsgServiceImpl;
import com.dailiantong.util.PageUtils;
import com.google.gson.Gson;

@WebServlet("/msgServlet")
public class MsgServlet extends BaseServlet {

	
	private static final long serialVersionUID = 7050596480252077263L;
	private MsgService msgService = new MsgServiceImpl();
	
	/**
	 * 返回所有公告信息
	 * @param request
	 * @param response
	 * @return msg.jsp
	 */
	public String getAllNotice(HttpServletRequest request,HttpServletResponse response){
		
		//得到当前页数
		String page = request.getParameter("page");
		int i;
		if(page==null){
			i=1;
		}else{
			i=Integer.parseInt(page);
		}
		//获得当前页
		PageUtils.page=i;
		//从数据库查询出数据
		List<Notice> list=msgService.getAll();
		//返回请求参数
		System.out.println(request.getQueryString());
		request.setAttribute("bar",PageUtils.getBar(request.getServletPath().substring(1),request.getQueryString()));
		request.setAttribute("msgList",list);
		return PROJECT_FORWARD+"WEB-INF/adminView/msg.jsp";
	}
	
	
	/**
	 * 发布新公告
	 * @param request
	 * @param response
	 * @return
	 */
	public String addNotice(HttpServletRequest request,HttpServletResponse response){
		msgService= new MsgServiceImpl();
		System.out.println("servlet");
		String managerNameString= (String)request.getSession().getAttribute("user");
		String msg_title=request.getParameter("msg_title");
		String msg_content=request.getParameter("msg_content");
		Notice notice =new Notice();
		notice.setManager_account(managerNameString);
		notice.setNotice_title(msg_title);
		notice.setNotice_content(msg_content);
		msgService.addNotice(notice);
		
		return getAllNotice(request,response);
		
	}
	
	/**
	 * 根据公告（Notice）id 查询 ,跳转到显示详细信息页面
	 * @param request
	 * @param response
	 * @return
	 */
	public String findNotice(HttpServletRequest request,HttpServletResponse response){
		int id = Integer.parseInt(request.getParameter("notice_id"));
		
		msgService = new MsgServiceImpl();
		Notice notice=msgService.findNotice(id);
		request.setAttribute("notice", notice);
		
		return PROJECT_FORWARD+"WEB-INF/adminView/editMsg.jsp";
	}
	
	/**
	 * 根据公告（Notice）id 查询 .Ajax
	 * @param request
	 * @param response
	 * @return
	 */
	public String findAjaxNotice(HttpServletRequest request,HttpServletResponse response){
		int id = Integer.parseInt(request.getParameter("notice_id"));
		msgService = new MsgServiceImpl();
		Notice notice=msgService.findNotice(id);
		try {
			System.out.println("servlet");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			out.println(gson.toJson(notice));
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	/**
	 * 修改查看公告详细信息
	 * @param request
	 * @param response
	 * @return
	 */
	public String updateNotice(HttpServletRequest request , HttpServletResponse response){
		Notice notice = new Notice();
		     System.out.println("MsgServlet");
		
			int notice_id=Integer.parseInt(request.getParameter("notice_id"));
			String notice_title=request.getParameter("notice_title");
			String notice_content = request.getParameter("notice_content");
			String manager_account =  (String)request.getSession().getAttribute("user");
			
		
			
				notice.setNotice_title(notice_title);
				notice.setNotice_id(notice_id);
				notice.setNotice_content(notice_content);
				notice.setManager_account(manager_account);
			
			msgService = new MsgServiceImpl();
			
				msgService.updateNotice(notice);
		return getAllNotice(request,response);
		
	}
	
	/**
	 * 删除公告信息
	 * @param request
	 * @param response
	 * @return
	 */
	public String delNotice(HttpServletRequest request,HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		msgService = new MsgServiceImpl();
		int notice_id=Integer.parseInt(request.getParameter("notice_id"));
		//执行按照公告id 删除
		msgService.delNotice(notice_id);
		
	 PrintWriter out;
	try {
		out = response.getWriter();
		out.print("<script> alert('删除成功！')</script>");
		out.print("<script> window.location.href='msgServlet?method=getAllNotice'</script>");
		out.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
		
		//返回到公告信息界面
		return getAllNotice(request,response);
	}

}
