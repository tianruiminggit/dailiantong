package com.dailiantong.dao.impl;

import java.util.List;
import java.util.Map;

import com.dailiantong.dao.UserAccountDao;
import com.dailiantong.pojo.UserAccount;
import com.dailiantong.util.JdbcUtils;
import com.dailiantong.util.PageUtils;

public class UserAccountDaoImpl extends JdbcUtils implements UserAccountDao {

	@Override
	public List<Map<String, Object>> getListUserAccount(String useraccount) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM useraccount AS u " +
					 "INNER JOIN user_status AS u_s ON u.user_status=u_s.user_status " +
					 "INNER JOIN platformmoney AS p ON u.user_account = p.user_account "+
					 "where u.user_account=?";
		Object[] objects = {useraccount};
		return getListMap(sql,objects);
	}

	
	
	@Override
	public int updateUser(UserAccount userAccount) {
		String sql ="UPDATE useraccount SET  user_password=?, user_nickName=? ,user_email=?, user_tel=?, " +
					"user_payPassword=?,user_score=?,user_status=? ,user_root=?,user_finishNum=? ," +
					"user_fcount=? ,user_jcount=? ,user_loginTime=? where user_account =? ";
		//String sql="UPDATE useraccount set user_password=?,user_nickName=?user_score=?";
		Object[] objects ={userAccount.getUser_password(),userAccount.getUser_nickName(),userAccount.getUser_email(),userAccount.getUser_tel()
				,userAccount.getUser_payPassword(),userAccount.getUser_score(),userAccount.getUser_status(),
				userAccount.getUser_root(),userAccount.getUser_finishNum(),userAccount.getUser_fcount(),userAccount.getUser_jcount(),
				userAccount.getUser_loginTime(),userAccount.getUser_account()};
		return updataAll(sql, objects);
	}



	@Override
	public UserAccount getUserAccount(String user_account) {
		String sql="select * from useraccount where user_account =?";
		Object[] objects = {user_account};
		return getBean(sql, UserAccount.class, objects);
	}


}
