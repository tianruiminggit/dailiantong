package com.dailiantong.test;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.dailiantong.dao.*;
import com.dailiantong.dao.impl.*;
import com.dailiantong.pojo.Notice;
import com.dailiantong.service.impl.MsgServiceImpl;

public class MsgTest {
		
	public void getAllMsg(){

		AppealDao appealDao = new AppealDaoImpl();
		MsgDao msgDao=new MsgDaoImpl();
		Iterator<Notice> it=msgDao.getAllMsg().iterator();
		while(it.hasNext()){
			System.out.println(it.next().getNotice_content());
			
//			System.out.println(notice.getNotice_content());
		}
	}
	
	
	public void findNotice(){
		MsgDao msgDao= new MsgDaoImpl();
		
		Notice notice=msgDao.getNotice(2);
		

//		MsgDao msgDao=new MsgDaoImpl();
//		Iterator<Notice> it=msgDao.getAllMsg().iterator();
//		while(it.hasNext()){
//			System.out.println(it.next().getNotice_content());
//			
////			System.out.println(notice.getNotice_content());
//		}
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String sdate = sdf.format(new Date());
//					Date date;
//					try {
//						date = sdf.parse(sdate);
//						Timestamp time = new Timestamp(date.getTime());
//						System.out.println(time);
//					} catch (ParseException e) {
//						e.printStackTrace();
//					}
//
//		System.out.println(notice.getManager_account());
	}
	
	
	public void updateNotice(){
//		MsgDao msgDao=new MsgDaoImpl();
//		Notice notice = new Notice();
//		notice.setNotice_id(2);
//		notice.setNotice_title("Dao层操作测试");
//		int i=msgDao.updateNotice(notice);
//		System.out.println(i);
		AppealDao appealDao = new AppealDaoImpl();
		System.out.println(appealDao.getListAppeal("1").size());
		
		
	}
	
	@Test
	public  void getal(){
		MsgDao msgDao=new MsgDaoImpl();
		Notice notice = msgDao.getNotice(1);
		System.out.println(notice.getNotice_title());
		
	}
}
