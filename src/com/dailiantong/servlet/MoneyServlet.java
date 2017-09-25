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
	
	
	//平台资金对象
	private PlatformMoneyService platformMoneyService = new PlatformMoneyServiceImpl();
	
	//充值日志对象
	private AddMoneyLogService addMoneyLogService = new AddMoneyLogServiceImpl();
	
	//提现日志对象
	private TixianLogService tixianLogService = new TixianLogServiceImpl();
	
	//冻结日志对象
	private DongjieLogService dongjieLogService = new DongjieLogServiceImpl();
	
	/**
	 *冻结明细 
	 * @param request
	 * @param response
	 * @return
	 */
	public String dongjie(HttpServletRequest request,HttpServletResponse response){
		String user_account = (String) request.getSession().getAttribute("userAccount");
		System.out.println(user_account);
		
		//该用户在该平台资金详情
		PlatformMoney Money = moneyservice.getListMoney(user_account);
				
		//获得当前页
		String page = request.getParameter("page");
		int i;
		if(page==null){
			i=1;
		}else{
			i=Integer.parseInt(page);
		}
		PageUtils.page=i;
		
		//获得冻结日志
		List<DongjieLog> logs=dongjieLogService.querDongjieLogs(user_account);
		//传入拼接好的分页
		request.setAttribute("bar",PageUtils.getBar(request.getServletPath().substring(1),request.getQueryString()));

		request.setAttribute("clogs", logs);
		request.setAttribute("ctName", "冻结");
		request.setAttribute("dongjie", "active");
		request.setAttribute("getPlatform_usableMoney", Money.getPlatform_usableMoney());
		request.setAttribute("getPlatform_freezeMoney", Money.getPlatform_freezeMoney());
		
	
		return PROJECT_FORWARD+"/WEB-INF/userView/moneyManage.jsp";
	}
	
	
	
	
	/**
	 * 删除充值日志
	 * @param request
	 * @param response
	 * @return
	 */
	public String del(HttpServletRequest request,HttpServletResponse response){
		System.out.println("充值");
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
		System.out.println("删除失败");
		
		
		return null;
	}
	
	
	
	
	
	/**
	 * 删除提现日志
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
		System.out.println("删除失败");
		
		
		return null;
	}
	
	/**
	 * 删除冻结日志
	 * @param request
	 * @param response
	 * @return
	 */
	public String delDongjie(HttpServletRequest request,HttpServletResponse response){
		System.out.println("充值");
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
		System.out.println("删除失败");
		
		
		return null;
	}
	
	
	
	/**
	 * 提现明细
	 * @param request
	 * @param response
	 * @return
	 */
	public String tRecord(HttpServletRequest request,HttpServletResponse response){
		String user_account = (String) request.getSession().getAttribute("userAccount");
		System.out.println(user_account);
		
		//该用户在该平台资金详情
		PlatformMoney Money = moneyservice.getListMoney(user_account);
				
		//获得当前页
		String page = request.getParameter("page");
		int i;
		if(page==null){
			i=1;
		}else{
			i=Integer.parseInt(page);
		}
		PageUtils.page=i;
		
		//获得提现日志
		List<TixianLog> logs=tixianLogService.getListTixianLogs(user_account);
		
		//传入拼接好的分页
		request.setAttribute("bar",PageUtils.getBar(request.getServletPath().substring(1),request.getQueryString()));

		request.setAttribute("clogs", logs);
		request.setAttribute("ctName", "提现");
		request.setAttribute("tixian", "active");
		request.setAttribute("getPlatform_usableMoney", Money.getPlatform_usableMoney());
		request.setAttribute("getPlatform_freezeMoney", Money.getPlatform_freezeMoney());
		
		return PROJECT_FORWARD+"/WEB-INF/userView/moneyManage.jsp";
	}
	
	
	/**
	 * 更新用户可用资金和冻结资金
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
	 * 主跳转
	 * @param request
	 * @param response
	 * @return
	 */
	public String getListMoney(HttpServletRequest request,HttpServletResponse response) {
		String user_account = (String) request.getSession().getAttribute("userAccount");
		System.out.println(user_account);
		if(user_account==null){
			return "找不到用户" ;
		}
		
		//该用户在该平台资金详情
		PlatformMoney Money = moneyservice.getListMoney(user_account);
		
		//充值记录显示
				//获得当前页
				String page = request.getParameter("page");
				int i;
				if(page==null){
					i=1;
				}else{
					i=Integer.parseInt(page);
				}
				PageUtils.page=i;
				//获得该用户充值记录信息
				List<AddMoneyLog> logs = addMoneyLogService.getAddMoneyLogs(user_account);
			  /*	
				OrderNum orderNum = new OrderNum();
				
				for(AddMoneyLog addMoneyLog:logs){
					addMoneyLog.setAddMoney_id(Integer.parseInt(orderNum.getOrder()));
				}
				*/
				//传入拼接好的分页
				request.setAttribute("bar",PageUtils.getBar(request.getServletPath().substring(1),request.getQueryString()));
		
		request.setAttribute("clogs", logs);
		request.setAttribute("ctName", "充值");
		request.setAttribute("congzhi", "active");
		request.setAttribute("getPlatform_usableMoney", Money.getPlatform_usableMoney());
		request.setAttribute("getPlatform_freezeMoney", Money.getPlatform_freezeMoney());
		
		
		
		return PROJECT_FORWARD+"/WEB-INF/userView/moneyManage.jsp";
	}
	
	
	
	
	
	
	
	
	
	/**
	 * 根据用户查询银行卡信息，充值
	 * @param request
	 * @param response
	 * @return
	 */
	public String pdMoney(HttpServletRequest request,HttpServletResponse response){
		//从session 中获得用户账号
		String user_account = (String) request.getSession().getAttribute("userAccount");
		
		//得到充值金额
		double money  = Double.parseDouble(request.getParameter("money"));
		
		//获得该用户银行卡对象
		Bank bank =bankService.getBank(user_account);
		
		double nowMoney =bank.getBank_money();
		
		if(money>nowMoney){
			//ajax
			try {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				Gson gson = new Gson();
				out.print(gson.toJson("您的余额不足"));
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		else if(money<nowMoney){
			//1.更新平台资金表
			PlatformMoney pMoney =platformMoneyService.getMoney(user_account);
				//原先可用资金+ 充值金额
				pMoney.setPlatform_usableMoney(pMoney.getPlatform_usableMoney()+money);
				//更新平台资金表
				platformMoneyService.updateMoney(pMoney);
			//2.更新银行卡表
				Bank bMoney = bankService.getBank(user_account);
				//原先有的-充值金额
			    System.out.println("当前用户银行卡余额为："+bMoney.getBank_money()); 
				bMoney.setBank_money(bMoney.getBank_money()+(-money));
				
				//更新银行卡表数据 bank_money
				bankService.upBank(bMoney);
			//3.添加充值记录表
				//实例化充值日志对象
				AddMoneyLog addMoneyLog = new AddMoneyLog();
				addMoneyLog.setAddMoney(money);
				addMoneyLog.setUser_account(user_account);
				addMoneyLog.setCongzhi_time(new Date());
				
				//添加充值日志数据
				int i=addMoneyLogService.upMoneyLog(addMoneyLog);
				if(i==1){
					System.out.println("添加充值明细成功");
				}
			
			//ajax
			try {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				Gson gson = new Gson();
				out.print(gson.toJson("充值成功"));
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}		
			
		return null;
	}
	
	
	
	/**
	 * 提现，判断可用资金是否足够
	 * @param request
	 * @param response
	 * @return
	 */
	public String pdPlatMoney(HttpServletRequest request,HttpServletResponse response){
		//从session 中获得用户账号
		String user_account = (String) request.getSession().getAttribute("userAccount");
		//得到提现金额
		double money  = Double.parseDouble(request.getParameter("money"));
		
		//1.更新平台资金表
		PlatformMoney pMoney =platformMoneyService.getMoney(user_account);
		
		//当前用户可用资金
		double nowMoney = pMoney.getPlatform_usableMoney();
		
		//提现金额超出，跳出
		if(money>nowMoney){
			//ajax
			try {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				Gson gson = new Gson();
				out.print(gson.toJson("您的余额不足"));
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		else if(money<nowMoney){
			//金额未超出，执行
			
			//1.更新平台资金表
				
				//原先可用资金- 提现金额
				pMoney.setPlatform_usableMoney(pMoney.getPlatform_usableMoney()-money);
				//更新平台资金表
				platformMoneyService.updateMoney(pMoney);
				
				
			//2.更新银行卡表
				//查询到当前用户银行卡
				Bank bMoney = bankService.getBank(user_account);
				//原先有的+提现金额
			    System.out.println("当前用户银行卡余额为："+bMoney.getBank_money()); 
				bMoney.setBank_money(bMoney.getBank_money()+money);
				
				//更新银行卡表数据 bank_money
				bankService.upBank(bMoney);
			
			//3.添加提现日志表
				TixianLog tixianLog = new TixianLog();
				//设置提现日志的内容
				tixianLog.setTixian_money(money);
				tixianLog.setUser_account(user_account);
				tixianLog.setTixian_time(new Date());
				
				//添加提现日志
				tixianLogService.insertTixianLog(tixianLog);
				//ajax
				try {
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out = response.getWriter();
					Gson gson = new Gson();
					out.print(gson.toJson("提现成功"));
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
		}
	
		return null;
	}
	
	
	
	/**
	 * 根据用户添加银行卡
	 * @param request
	 * @param response
	 * @return
	 */
		public String addBank(HttpServletRequest request,HttpServletResponse response){
			System.out.println("运行addBank");
			
			//从session 中获得用户账号
			
			String user_account = (String) request.getSession().getAttribute("userAccount");
			
			//获得银行卡号
			String bank_num = request.getParameter("bank_num");
			String bank_name = request.getParameter("bank_name");
			String pay_password = request.getParameter("pay_password");
			
			Bank bank = new Bank();
			bank.setBank_name(bank_name);
			bank.setBank_num(bank_num);
			bank.setUser_account(user_account);
			bank.setBank_money(1000);
			//查询到用户表，更新支付密码
					//查询到用户信息
					UserAccount userAccount=userAccountService.getUserAccount(user_account);
					
					//更新用户支付密码
					userAccount.setUser_payPassword(pay_password);
					
					int u=userAccountService.updateUser(userAccount);
					//添加银行卡
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
