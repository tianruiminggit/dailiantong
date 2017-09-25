package com.dailiantong.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dailiantong.pojo.Game;
import com.dailiantong.pojo.GameType;
import com.dailiantong.service.GameService;
import com.dailiantong.service.OrderService;
import com.dailiantong.service.impl.GameServiceImpl;
import com.dailiantong.service.impl.OrderServiceImpl;
import com.dailiantong.util.PageUtils;
import com.google.gson.Gson;


@WebServlet("/gameServlet.do")
public class GameServlet extends BaseServlet {
	
	private GameService gameService = new GameServiceImpl();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1132246366527180466L;
	
	/**
	 * 获得全部游戏
	 * @param request
	 * @param response
	 * @return
	 */
	public String getListGameName(HttpServletRequest request, HttpServletResponse response) {
		List<Game> listGameName = gameService.getListGame();
		request.setAttribute("listGameName", listGameName);
		return PROJECT_FORWARD+"";
	};
	/**
	 * 返回所有游戏信息
	 * @param request
	 * @param response
	 * @return
	 */
	public String getListGame(HttpServletRequest request, HttpServletResponse response){
		String s = request.getParameter("page");
		int i;
		if(s == null){
			i = 1;
		} else{
			i=Integer.parseInt(s);
		}
		PageUtils.page = i;
		request.setAttribute("type", gameService.getListType());
		request.setAttribute("game", gameService.getListGame());
		request.setAttribute("bar", PageUtils.getBar(request.getServletPath().substring(1),request.getQueryString()));
		return PROJECT_FORWARD + "/WEB-INF/adminView/games.jsp";
	}
	/**
	 * 返回不同类型的游戏信息
	 * @param request
	 * @param response
	 * @return
	 */
	public String getListGameByType(HttpServletRequest request, HttpServletResponse response){
		String type = request.getParameter("gameType");
		String s = request.getParameter("page");
		int i;
		if(s == null){
			i = 1;
		} else{
			i=Integer.parseInt(s);
		}
		PageUtils.page = i;
		request.setAttribute("type", gameService.getListType());
		request.setAttribute("game", gameService.getListGameByType(type));
		request.setAttribute("bar", PageUtils.getBar(request.getServletPath().substring(1),request.getQueryString()));
		return PROJECT_FORWARD + "/WEB-INF/adminView/games.jsp";
		
	}
	/***
	 * 通过ID查询返回游戏信息
	 * @param request
	 * @param response
	 * @return
	 */
	public String getListGameById(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("game_id");
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			out.print(gson.toJson(gameService.getListGameById(id)));
//			System.out.println(gson.toJson(gameService.getListGameById(id)));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	/***
	 * 通过ID来删除游戏信息
	 * @return
	 */
	public String deleteGameById(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("game_id");
		gameService.deleteGameById(id);
		return getListGame(request,response);
		
	}
	/***
	 * 添加游戏信息
	 * @param request
	 * @param response
	 * @return
	 */
	public String addGame(HttpServletRequest request, HttpServletResponse response){
		String name = request.getParameter("game_name");
		String id = request.getParameter("game_id");
		String type = request.getParameter("game_type");
		try {
			name=new String(name.getBytes("iso-8859-1"), "utf-8");
			id=new String(id.getBytes("iso-8859-1"), "utf-8");
			type=new String(type.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		if(gameService.addGame(id, name, type)>0) request.setAttribute("msg", "操作成功");
		else request.setAttribute("msg", "操作失败");
//		return getListGame(request,response);
		return PROJECT_FORWARD + "/WEB-INF/adminView/games.jsp";
		
	}
	/***
	 * 更新游戏信息
	 * @param request
	 * @param response
	 * @return
	 */
	public String updateGame(HttpServletRequest request, HttpServletResponse response){
		String name = request.getParameter("game_name");
		String id = request.getParameter("game_id");
		String type = request.getParameter("game_type");
		if(gameService.updateGame(id, name, type)>0) request.setAttribute("msg", "操作成功");
		else request.setAttribute("msg", "操作失败");
		return getListGame(request,response);
	}
	/**
	 * 获取每天不同游戏订单的数量
	 * 用于画图
	 * @param request
	 * @param response
	 * @return
	 */
	public String getListEveryDayOrderNum(HttpServletRequest request, HttpServletResponse response){
		OrderService orderService = new OrderServiceImpl();
		List<Game> gameList = gameService.getListAllGame();
		Gson gson = new Gson();
		Map<String,Object> map = new HashMap<>();
		Map<String,Object> js = new HashMap<>();
		String gameName = "" ;
		List<Map<String,Object>> list;
		List<Object> intList=new ArrayList<>();
//		String value = "" ;
//		System.out.println(gson.toJson(gameList));
//		map.put("name", gameName);
//		map.put("value", value);
//		System.out.println(gson.toJson(map));
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out;
			out=response.getWriter();
			for (Game name : gameList) {
				gameName += ","+name.getGame_name();
				list=orderService.getListMapOrderNumByGanmeName(name.getGame_name());
				
				for(Map<String,Object> m : list){
					
					intList.add(m.get("value"));
				}
				map.put("name", name.getGame_name());
				map.put("type", "bar");
				map.put("data", intList);
				out.write(gson.toJson(map)+"&");
				intList.clear();
//				out.write(gson.toJson(orderService.getListMapOrderNumByGanmeName(name.getGame_name()))+"&");
//				value += ","+gson.toJson(orderService.getListMapOrderNumByGanmeName(name.getGame_name()));
//			System.out.println(gson.toJson(orderService.getListMapOrderNumByGanmeName(name.getGame_name())));
			}
//			js.put("json", map);
			gameName=gameName.substring(1);
//			out.write(gson.toJson(js));
//			value=value.substring(1);
			out.write("&"+gson.toJson(gameName));
//			out.write("&");
//			out.write(gson.toJson(map));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}
