package com.dailiantong.servlet;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dailiantong.dao.MsgDao;
import com.dailiantong.dao.impl.MsgDaoImpl;
import com.dailiantong.pojo.Notice;
import com.dailiantong.service.MsgService;
import com.dailiantong.service.impl.MsgServiceImpl;

/**
 * Ò³ÃæÌø×ªServlet
 * @author Administrator
 *
 */
@WebServlet("/forward.do")
public class WebForwardServlet extends BaseServlet {


	private static final long serialVersionUID = 1L;
	
	public String forward(HttpServletRequest request, HttpServletResponse response){
		String url = request.getParameter("url");
		
		return PROJECT_FORWARD+"/WEB-INF/adminView/"+url;
	}
	
}
