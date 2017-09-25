package com.dailiantong.dao;

import java.util.List;

import com.dailiantong.pojo.DongjieLog;

public interface DongjieDao {
	/**
	 * 添加冻结资金日志
	 * @param dongjieLog
	 * @return
	 */
	 int addDongjieLog(DongjieLog dongjieLog);
	 
	 /**
	  * 修改冻结资金日志
	  * @param dongjieLog
	  * @return
	  */
	 int upDongjieLog(DongjieLog dongjieLog);
	 
	 /**
	  * 按照冻结日志id 删除
	  * @param dongjie_id
	  * @return
	  */
	 int delDongjieLog(String dongjie_id);
	 
	 /**
	  * 查询显示所有冻结日志
	  * @return
	  */
	 List<DongjieLog> querDongjieLogs(String user_account);
}
