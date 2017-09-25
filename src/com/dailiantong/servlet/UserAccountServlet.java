package com.dailiantong.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailiantong.pojo.PlatformMoney;
import com.dailiantong.pojo.UserAccount;
import com.dailiantong.service.PlatformMoneyService;
import com.dailiantong.service.impl.PlatformMoneyServiceImpl;
import com.dailiantong.service.impl.UserAccountServiceImpl;
import com.google.gson.Gson;

@WebServlet("/userAccount")
public class UserAccountServlet extends BaseServlet {
	
	private UserAccountServiceImpl useraccountservice = new UserAccountServiceImpl();
	private PlatformMoneyService PlatformMoney = new PlatformMoneyServiceImpl();
	/**
	 * ����ȡ���ĸ������ϴ���ҳ��
	 * @param request
	 * @param response
	 * @return
	 */
	public String getListUserAccount(HttpServletRequest request,HttpServletResponse response) {
		String useraccount = (String) request.getSession().getAttribute("userAccount");
		List<Map<String, Object>> ListUserAccount = useraccountservice.getListUserAccount(useraccount);
		request.setAttribute("ListUserAccount", ListUserAccount);
		return PROJECT_FORWARD+"/WEB-INF/userView/forms.jsp";
	}
	
	
	public String getUser(HttpServletRequest request,HttpServletResponse response){
		String where = request.getParameter("where");
	
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			out.print(gson.toJson(useraccountservice.getListUserAccount(where)));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
//		return PROJECT_FORWARD+"WEB-INF/adminView/user.jsp";
		
	}
	/**
	 * �û��޸ĸ�������
	 * @param request
	 * @param response
	 * @return
	 */
	public String upUser(HttpServletRequest request,HttpServletResponse response){
		System.out.println("�޸ĸ�������");
		
		//��ø��û��˺�
		String  user_account = request.getParameter("userAccount");
		//���ݸ��û���ѯ�����û�������Ϣ
		UserAccount userAccount=useraccountservice.getUserAccount(user_account);
		
		//�������л������
		String user_nickName=request.getParameter("nickName");
		String user_emailString = request.getParameter("user_email");
		String user_tel= request.getParameter("user_tel");
		
		//���¸��ö���ֵ
		userAccount.setUser_nickName(user_nickName);
		userAccount.setUser_email(user_emailString);
		userAccount.setUser_tel(user_tel);
		
		//�����޸ĸ�������
		int i=useraccountservice.updateUser(userAccount);
		if(i==1){
			try {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				Gson gson = new Gson();
				out.print(gson.toJson(1));
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		return null;
		
	}
	
	/**
	 * �û��޸ĸ��˵�¼����
	 * @param request
	 * @param response
	 * @return
	 */
	public String upUserPwd(HttpServletRequest request,HttpServletResponse response){
		System.out.println("�޸ĸ��˵�¼����");
		
		//��ø��û��˺�
		String  user_account = request.getParameter("userAccount");
		//���ݸ��û���ѯ�����û�������Ϣ
		UserAccount userAccount=useraccountservice.getUserAccount(user_account);
		
		//�������л������
		String password=request.getParameter("pass");
		
		
		//���¸��ö���ֵ
		userAccount.setUser_password(password);
		//�����޸ĸ�������
		int i=useraccountservice.updateUser(userAccount);
		if(i==1){
			try {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				Gson gson = new Gson();
				out.print(gson.toJson(1));
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		return null;
		
	}
	
	public String updateUser(HttpServletRequest request,HttpServletResponse response){
		int i=0;
		String user_account= request.getParameter("user_account");
		String user_status= request.getParameter("user_status");
		if("����".equals(user_status)){
			i=4;//�û�״̬���4������
		}
		int user_score=Integer.parseInt(request.getParameter("user_score"));
		Double platform_usableMoney= Double.parseDouble(request.getParameter("platform_usableMoney"));
		Double platform_freezeMoney= Double.parseDouble(request.getParameter("platform_freezeMoney"));
		
		System.out.println(user_account);
		//�û����ѯ������
		UserAccount userAccount=useraccountservice.getUserAccount(user_account);
		
		userAccount.setUser_status(i);//���¸�ֵ״̬
		userAccount.setUser_score(user_score);//���¸�ֵ����

		
		//�����޸�����
		int user_i=useraccountservice.updateUser(userAccount);
		
		//��ѯ���ʽ������
		PlatformMoney pMoney=PlatformMoney.getMoney(user_account);
		pMoney.setPlatform_usableMoney(platform_usableMoney);//�޸Ŀ����ʽ�
		pMoney.setPlatform_freezeMoney(platform_freezeMoney);//�޸Ķ����ʽ�
	
		//�޸��ʽ������
		int mon_i=PlatformMoney.updateMoney(pMoney);
		
		if(user_i==1  && mon_i==1){
			try {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				Gson gson = new Gson();
				out.print(gson.toJson(1));
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		/*Iterator trIterator =list.iterator();
		while(trIterator.hasNext()){
			Map<String,Object> map =(Map<String, Object>) trIterator.next();
			for (String key : map.keySet()) {  
					if(key.equals("status")){
						map.get(key);
					}
				
				   System.out.println("key= "+ key + " and value= " + map.get(key));  
				  }  
				    
		}*/
		
	
		return null;
		
	}
	
	
	
}