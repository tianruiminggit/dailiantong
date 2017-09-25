package com.dailiantong.service.impl;



import java.util.Date;
import java.util.List;

import com.dailiantong.dao.MsgDao;
import com.dailiantong.dao.impl.MsgDaoImpl;
import com.dailiantong.pojo.Notice;
import com.dailiantong.service.MsgService;

public class MsgServiceImpl implements MsgService {

	private MsgDao msgDao=new MsgDaoImpl();
	
	@Override
	public List<Notice> getAll() {
		
		return msgDao.getAllMsg();
	}

	@Override
	public void addNotice(Notice notice) {
		if(notice==null){
			System.out.println("����Ϣ");
			return ;
		}
		
		msgDao= new MsgDaoImpl();
		
		System.out.println("���service");
		Date timeDate= new Date();
//		Date sdf=new SimpleDateFormat("yyyy-MM-dd");  
		notice.setNotice_time(timeDate);
		
		int i=msgDao.addNotice(notice);
		if(i==1){
			System.out.println("����"+i+"����¼");
		}
		
	}

	@Override
	public Notice findNotice(int i) {
		return msgDao.getNotice(i);
	}

	@Override
	public void updateNotice(Notice notice) {
		if(notice ==null){
			System.out.println("�����������");
			return ;
		}
		
		notice.setNotice_time(new Date());
		msgDao = new MsgDaoImpl();
		
		int i= msgDao.updateNotice(notice);
		if(i==1){
			System.out.println("����"+i+"����¼");
		}
		
	}

	@Override
	public void delNotice(int notice_id) {
		msgDao = new MsgDaoImpl();
		int i=msgDao.delNotice(notice_id);
		if(i==1){
			System.out.println("ɾ��"+i+"����¼");
		}
		
	}

	@Override
	public Notice getOne() {
		return msgDao.getOne();
	}

}
