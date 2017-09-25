package com.dailiantong.dao;

import java.util.List;

import com.dailiantong.pojo.DongjieLog;

public interface DongjieDao {
	/**
	 * ��Ӷ����ʽ���־
	 * @param dongjieLog
	 * @return
	 */
	 int addDongjieLog(DongjieLog dongjieLog);
	 
	 /**
	  * �޸Ķ����ʽ���־
	  * @param dongjieLog
	  * @return
	  */
	 int upDongjieLog(DongjieLog dongjieLog);
	 
	 /**
	  * ���ն�����־id ɾ��
	  * @param dongjie_id
	  * @return
	  */
	 int delDongjieLog(String dongjie_id);
	 
	 /**
	  * ��ѯ��ʾ���ж�����־
	  * @return
	  */
	 List<DongjieLog> querDongjieLogs(String user_account);
}
