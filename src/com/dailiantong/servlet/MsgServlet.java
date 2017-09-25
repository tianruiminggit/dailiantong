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
	 * �������й�����Ϣ
	 * @param request
	 * @param response
	 * @return msg.jsp
	 */
	public String getAllNotice(HttpServletRequest request,HttpServletResponse response){
		
		//�õ���ǰҳ��
		String page = request.getParameter("page");
		int i;
		if(page==null){
			i=1;
		}else{
			i=Integer.parseInt(page);
		}
		//��õ�ǰҳ
		PageUtils.page=i;
		//�����ݿ��ѯ������
		List<Notice> list=msgService.getAll();
		//�����������
		System.out.println(request.getQueryString());
		request.setAttribute("bar",PageUtils.getBar(request.getServletPath().substring(1),request.getQueryString()));
		request.setAttribute("msgList",list);
		return PROJECT_FORWARD+"WEB-INF/adminView/msg.jsp";
	}
	
	
	/**
	 * �����¹���
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
	 * ���ݹ��棨Notice��id ��ѯ ,��ת����ʾ��ϸ��Ϣҳ��
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
	 * ���ݹ��棨Notice��id ��ѯ .Ajax
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
	 * �޸Ĳ鿴������ϸ��Ϣ
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
	 * ɾ��������Ϣ
	 * @param request
	 * @param response
	 * @return
	 */
	public String delNotice(HttpServletRequest request,HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		msgService = new MsgServiceImpl();
		int notice_id=Integer.parseInt(request.getParameter("notice_id"));
		//ִ�а��չ���id ɾ��
		msgService.delNotice(notice_id);
		
	 PrintWriter out;
	try {
		out = response.getWriter();
		out.print("<script> alert('ɾ���ɹ���')</script>");
		out.print("<script> window.location.href='msgServlet?method=getAllNotice'</script>");
		out.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
		
		//���ص�������Ϣ����
		return getAllNotice(request,response);
	}

}
