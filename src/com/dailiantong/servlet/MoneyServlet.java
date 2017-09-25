package com.dailiantong.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dailiantong.pojo.AddMoneyLog;
import com.dailiantong.pojo.Bank;
import com.dailiantong.pojo.DongjieLog;
import com.dailiantong.pojo.PlatformMoney;
import com.dailiantong.pojo.TixianLog;
import com.dailiantong.pojo.UserAccount;
import com.dailiantong.service.AddMoneyLogService;
import com.dailiantong.service.BankService;
import com.dailiantong.service.DongjieLogService;
import com.dailiantong.service.PlatformMoneyService;
import com.dailiantong.service.TixianLogService;
import com.dailiantong.service.UserAccountService;
import com.dailiantong.service.impl.AddMoneyLogServiceImpl;
import com.dailiantong.service.impl.BankServiceImpl;
import com.dailiantong.service.impl.DongjieLogServiceImpl;
import com.dailiantong.service.impl.MoneyServiceImpl;
import com.dailiantong.service.impl.PlatformMoneyServiceImpl;
import com.dailiantong.service.impl.TixianLogServiceImpl;
import com.dailiantong.service.impl.UserAccountServiceImpl;
import com.dailiantong.util.OrderNum;
import com.dailiantong.util.PageUtils;
import com.google.gson.Gson;

@WebServlet("/moneyServlet.do")
public class MoneyServlet extends BaseServlet {
	
	private MoneyServiceImpl moneyservice = new MoneyServiceImpl();
	private BankService bankService = new BankServiceImpl();
	private UserAccountService userAccountService = new UserAccountServiceImpl();
	
	
	//ƽ̨�ʽ����
	private PlatformMoneyService platformMoneyService = new PlatformMoneyServiceImpl();
	
	//��ֵ��־����
	private AddMoneyLogService addMoneyLogService = new AddMoneyLogServiceImpl();
	
	//������־����
	private TixianLogService tixianLogService = new TixianLogServiceImpl();
	
	//������־����
	private DongjieLogService dongjieLogService = new DongjieLogServiceImpl();
	
	/**
	 *������ϸ 
	 * @param request
	 * @param response
	 * @return
	 */
	public String dongjie(HttpServletRequest request,HttpServletResponse response){
		String user_account = (String) request.getSession().getAttribute("userAccount");
		System.out.println(user_account);
		
		//���û��ڸ�ƽ̨�ʽ�����
		PlatformMoney Money = moneyservice.getListMoney(user_account);
				
		//��õ�ǰҳ
		String page = request.getParameter("page");
		int i;
		if(page==null){
			i=1;
		}else{
			i=Integer.parseInt(page);
		}
		PageUtils.page=i;
		
		//��ö�����־
		List<DongjieLog> logs=dongjieLogService.querDongjieLogs(user_account);
		//����ƴ�Ӻõķ�ҳ
		request.setAttribute("bar",PageUtils.getBar(request.getServletPath().substring(1),request.getQueryString()));

		request.setAttribute("clogs", logs);
		request.setAttribute("ctName", "����");
		request.setAttribute("dongjie", "active");
		request.setAttribute("getPlatform_usableMoney", Money.getPlatform_usableMoney());
		request.setAttribute("getPlatform_freezeMoney", Money.getPlatform_freezeMoney());
		
	
		return PROJECT_FORWARD+"/WEB-INF/userView/moneyManage.jsp";
	}
	
	
	
	
	/**
	 * ɾ����ֵ��־
	 * @param request
	 * @param response
	 * @return
	 */
	public String del(HttpServletRequest request,HttpServletResponse response){
		System.out.println("��ֵ");
		int addMoney_id = Integer.parseInt(request.getParameter("addMoney_id"));
		System.out.println(addMoney_id);
		int i=addMoneyLogService.delAddmoneyLog(addMoney_id);
		if(i==1){
			try {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				Gson gson = new Gson();
				out.print(gson.toJson("1"));
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		System.out.println("ɾ��ʧ��");
		
		
		return null;
	}
	
	
	
	
	
	/**
	 * ɾ��������־
	 * @param request
	 * @param response
	 * @return
	 */
	public String delTixian(HttpServletRequest request,HttpServletResponse response){
		System.out.println("delTixian");
		int tixian_id = Integer.parseInt(request.getParameter("tixian_id"));
		System.out.println(tixian_id);
		int i=tixianLogService.delTixianLog(tixian_id);
		if(i==1){
			try {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				Gson gson = new Gson();
				out.print(gson.toJson("1"));
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		System.out.println("ɾ��ʧ��");
		
		
		return null;
	}
	
	/**
	 * ɾ��������־
	 * @param request
	 * @param response
	 * @return
	 */
	public String delDongjie(HttpServletRequest request,HttpServletResponse response){
		System.out.println("��ֵ");
		String dongjie_id =request.getParameter("dongjie_id");
		System.out.println(dongjie_id);
		int i=dongjieLogService.delDongjieLog(dongjie_id);
		if(i==1){
			try {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				Gson gson = new Gson();
				out.print(gson.toJson("1"));
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		System.out.println("ɾ��ʧ��");
		
		
		return null;
	}
	
	
	
	/**
	 * ������ϸ
	 * @param request
	 * @param response
	 * @return
	 */
	public String tRecord(HttpServletRequest request,HttpServletResponse response){
		String user_account = (String) request.getSession().getAttribute("userAccount");
		System.out.println(user_account);
		
		//���û��ڸ�ƽ̨�ʽ�����
		PlatformMoney Money = moneyservice.getListMoney(user_account);
				
		//��õ�ǰҳ
		String page = request.getParameter("page");
		int i;
		if(page==null){
			i=1;
		}else{
			i=Integer.parseInt(page);
		}
		PageUtils.page=i;
		
		//���������־
		List<TixianLog> logs=tixianLogService.getListTixianLogs(user_account);
		
		//����ƴ�Ӻõķ�ҳ
		request.setAttribute("bar",PageUtils.getBar(request.getServletPath().substring(1),request.getQueryString()));

		request.setAttribute("clogs", logs);
		request.setAttribute("ctName", "����");
		request.setAttribute("tixian", "active");
		request.setAttribute("getPlatform_usableMoney", Money.getPlatform_usableMoney());
		request.setAttribute("getPlatform_freezeMoney", Money.getPlatform_freezeMoney());
		
		return PROJECT_FORWARD+"/WEB-INF/userView/moneyManage.jsp";
	}
	
	
	/**
	 * �����û������ʽ�Ͷ����ʽ�
	 * @param request
	 * @param response
	 * @return
	 */
	public String getUserMoney(HttpServletRequest request,HttpServletResponse response){
		String user_account=(String)request.getSession().getAttribute("userAccount");
		System.out.println("getUserMoney");
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			out.print(gson.toJson(platformMoneyService.getMoney(user_account)));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	
	
	
	
	
	/**
	 * ����ת
	 * @param request
	 * @param response
	 * @return
	 */
	public String getListMoney(HttpServletRequest request,HttpServletResponse response) {
		String user_account = (String) request.getSession().getAttribute("userAccount");
		System.out.println(user_account);
		if(user_account==null){
			return "�Ҳ����û�" ;
		}
		
		//���û��ڸ�ƽ̨�ʽ�����
		PlatformMoney Money = moneyservice.getListMoney(user_account);
		
		//��ֵ��¼��ʾ
				//��õ�ǰҳ
				String page = request.getParameter("page");
				int i;
				if(page==null){
					i=1;
				}else{
					i=Integer.parseInt(page);
				}
				PageUtils.page=i;
				//��ø��û���ֵ��¼��Ϣ
				List<AddMoneyLog> logs = addMoneyLogService.getAddMoneyLogs(user_account);
			  /*	
				OrderNum orderNum = new OrderNum();
				
				for(AddMoneyLog addMoneyLog:logs){
					addMoneyLog.setAddMoney_id(Integer.parseInt(orderNum.getOrder()));
				}
				*/
				//����ƴ�Ӻõķ�ҳ
				request.setAttribute("bar",PageUtils.getBar(request.getServletPath().substring(1),request.getQueryString()));
		
		request.setAttribute("clogs", logs);
		request.setAttribute("ctName", "��ֵ");
		request.setAttribute("congzhi", "active");
		request.setAttribute("getPlatform_usableMoney", Money.getPlatform_usableMoney());
		request.setAttribute("getPlatform_freezeMoney", Money.getPlatform_freezeMoney());
		
		
		
		return PROJECT_FORWARD+"/WEB-INF/userView/moneyManage.jsp";
	}
	
	
	
	
	
	
	
	
	
	/**
	 * �����û���ѯ���п���Ϣ����ֵ
	 * @param request
	 * @param response
	 * @return
	 */
	public String pdMoney(HttpServletRequest request,HttpServletResponse response){
		//��session �л���û��˺�
		String user_account = (String) request.getSession().getAttribute("userAccount");
		
		//�õ���ֵ���
		double money  = Double.parseDouble(request.getParameter("money"));
		
		//��ø��û����п�����
		Bank bank =bankService.getBank(user_account);
		
		double nowMoney =bank.getBank_money();
		
		if(money>nowMoney){
			//ajax
			try {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				Gson gson = new Gson();
				out.print(gson.toJson("��������"));
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		else if(money<nowMoney){
			//1.����ƽ̨�ʽ��
			PlatformMoney pMoney =platformMoneyService.getMoney(user_account);
				//ԭ�ȿ����ʽ�+ ��ֵ���
				pMoney.setPlatform_usableMoney(pMoney.getPlatform_usableMoney()+money);
				//����ƽ̨�ʽ��
				platformMoneyService.updateMoney(pMoney);
			//2.�������п���
				Bank bMoney = bankService.getBank(user_account);
				//ԭ���е�-��ֵ���
			    System.out.println("��ǰ�û����п����Ϊ��"+bMoney.getBank_money()); 
				bMoney.setBank_money(bMoney.getBank_money()+(-money));
				
				//�������п������� bank_money
				bankService.upBank(bMoney);
			//3.��ӳ�ֵ��¼��
				//ʵ������ֵ��־����
				AddMoneyLog addMoneyLog = new AddMoneyLog();
				addMoneyLog.setAddMoney(money);
				addMoneyLog.setUser_account(user_account);
				addMoneyLog.setCongzhi_time(new Date());
				
				//��ӳ�ֵ��־����
				int i=addMoneyLogService.upMoneyLog(addMoneyLog);
				if(i==1){
					System.out.println("��ӳ�ֵ��ϸ�ɹ�");
				}
			
			//ajax
			try {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				Gson gson = new Gson();
				out.print(gson.toJson("��ֵ�ɹ�"));
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}		
			
		return null;
	}
	
	
	
	/**
	 * ���֣��жϿ����ʽ��Ƿ��㹻
	 * @param request
	 * @param response
	 * @return
	 */
	public String pdPlatMoney(HttpServletRequest request,HttpServletResponse response){
		//��session �л���û��˺�
		String user_account = (String) request.getSession().getAttribute("userAccount");
		//�õ����ֽ��
		double money  = Double.parseDouble(request.getParameter("money"));
		
		//1.����ƽ̨�ʽ��
		PlatformMoney pMoney =platformMoneyService.getMoney(user_account);
		
		//��ǰ�û������ʽ�
		double nowMoney = pMoney.getPlatform_usableMoney();
		
		//���ֽ���������
		if(money>nowMoney){
			//ajax
			try {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				Gson gson = new Gson();
				out.print(gson.toJson("��������"));
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		else if(money<nowMoney){
			//���δ������ִ��
			
			//1.����ƽ̨�ʽ��
				
				//ԭ�ȿ����ʽ�- ���ֽ��
				pMoney.setPlatform_usableMoney(pMoney.getPlatform_usableMoney()-money);
				//����ƽ̨�ʽ��
				platformMoneyService.updateMoney(pMoney);
				
				
			//2.�������п���
				//��ѯ����ǰ�û����п�
				Bank bMoney = bankService.getBank(user_account);
				//ԭ���е�+���ֽ��
			    System.out.println("��ǰ�û����п����Ϊ��"+bMoney.getBank_money()); 
				bMoney.setBank_money(bMoney.getBank_money()+money);
				
				//�������п������� bank_money
				bankService.upBank(bMoney);
			
			//3.���������־��
				TixianLog tixianLog = new TixianLog();
				//����������־������
				tixianLog.setTixian_money(money);
				tixianLog.setUser_account(user_account);
				tixianLog.setTixian_time(new Date());
				
				//���������־
				tixianLogService.insertTixianLog(tixianLog);
				//ajax
				try {
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out = response.getWriter();
					Gson gson = new Gson();
					out.print(gson.toJson("���ֳɹ�"));
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
		}
	
		return null;
	}
	
	
	
	/**
	 * �����û�������п�
	 * @param request
	 * @param response
	 * @return
	 */
		public String addBank(HttpServletRequest request,HttpServletResponse response){
			System.out.println("����addBank");
			
			//��session �л���û��˺�
			
			String user_account = (String) request.getSession().getAttribute("userAccount");
			
			//������п���
			String bank_num = request.getParameter("bank_num");
			String bank_name = request.getParameter("bank_name");
			String pay_password = request.getParameter("pay_password");
			
			Bank bank = new Bank();
			bank.setBank_name(bank_name);
			bank.setBank_num(bank_num);
			bank.setUser_account(user_account);
			bank.setBank_money(1000);
			//��ѯ���û�������֧������
					//��ѯ���û���Ϣ
					UserAccount userAccount=userAccountService.getUserAccount(user_account);
					
					//�����û�֧������
					userAccount.setUser_payPassword(pay_password);
					
					int u=userAccountService.updateUser(userAccount);
					//������п�
					bankService.addBank(bank);
					
						try {
							response.setContentType("text/html;charset=utf-8");
							PrintWriter out = response.getWriter();
							Gson gson = new Gson();
							if(u==1){
								out.print(gson.toJson(1));
								out.close();
							}
							else{
								out.print(gson.toJson(0));
								out.close();
							}
							
						} catch (IOException e) {
							e.printStackTrace();
						}
					
					
			
			return null;
		}
}
