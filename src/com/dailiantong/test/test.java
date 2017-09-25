package com.dailiantong.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.dailiantong.dao.impl.OrderDaoImpl;
import com.dailiantong.dao.impl.UserDaoImpl;
import com.dailiantong.pojo.Order;
import com.dailiantong.util.OrderNum;
import com.dailiantong.util.PageBean;

public class test {
	public static void main(String[] args) {
		/*UserDaoImpl dao=new UserDaoImpl();
		//public List<Order> getListTodayFinishAdminOrder
		//List<Order> list=dao.getListTodayFinishAdminOrder();
		List<Map<String, Object>> list=dao.getListMapUser("2");
		PageBean<Map<String, Object>> pageBean=new PageBean<Map<String,Object>>(2, list);
		System.out.println(pageBean.getList());*/
		
		//编号转换
//		SimpleDateFormat   formatter   = new   SimpleDateFormat( "yyyy-MM-dd hh:mm:ss");
	/*	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Timestamp time = null;
					Date date;
					try {
						date = sdf.parse("2016-06-06 16:24:50");
						time = new Timestamp(date.getTime());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					
					System.out.println(time);
*/
	
//		String sumString = null;
//		String time =formatter.format(new Date());
//		//取得前面部分
//		String qString = time.substring(0,10);
//		String[] agStrings =qString.split("-");
//		for(String iString:agStrings){
//			sumString+=iString;
////			System.out.print(iString);
//		}
//		//取得后面部分
//		String cString= time.substring(11);
//		String[] agsString= cString.split(":");
//		for(String iString:agsString){
//			sumString+=iString;
////			System.out.print(iString);
//		}
		
		//System.out.println(sumString);
		
//		System.err.println(cString);
//		String[] ag= time.split("-");
//		String[] ags =ag[2].split(" ");
	/*	String[] agss =ag[2].split(":");
		for(int i=0;i<agss.length;i++){
			System.out.println(ag[i]);
		}*/
		
		OrderNum orderNum = new OrderNum();
		System.out.println(orderNum.getOrder());
	
	}
	
		
}
