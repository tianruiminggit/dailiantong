package com.dailiantong.dao.impl;

import java.util.List;
import java.util.Map;

import com.dailiantong.dao.UserDao;
import com.dailiantong.pojo.Bank;
import com.dailiantong.pojo.Notice;
import com.dailiantong.pojo.UserAccount;
import com.dailiantong.pojo.UserStatus;
import com.dailiantong.util.JdbcUtils;
import com.dailiantong.util.PageUtils;
import com.sun.org.apache.xalan.internal.utils.XMLSecurityManager.Limit;

public class UserDaoImpl extends JdbcUtils implements UserDao {

	@Override
	public UserAccount getUserAccount(String userAccount) {
		String sql = "select * from useraccount where user_account = ?";
		Object[] objects={userAccount};
		return getBean(sql, UserAccount.class, objects);
	}

	@Override
	public int addUserAccount(UserAccount user) {
		String sql = "INSERT INTO useraccount (`user_account`, `user_password`, `user_nickName`, `user_email`, `user_tel`) VALUES (?,?,?,?,?); ";
		Object[] objects = {user.getUser_account(),user.getUser_password(),user.getUser_nickName(),user.getUser_email(),user.getUser_tel()};
		return updataAll(sql, objects);
	}



	@Override
	public List<Map<String, Object>> getListMapUser(String where) {
		String sql;
		int i= Integer.parseInt(where);
		System.out.println(i);
		if(i!=0){
			String sql2="SELECT * FROM useraccount AS u "+
					"INNER JOIN user_status AS u_s ON u.user_status=u_s.user_status "+
					"inner JOIN platformmoney AS p ON u.user_account = p.user_account "+
					"where u_s.user_status= ? ";
				
				PageUtils.pagination(getListMap(sql2,where).size());
				sql2="SELECT * FROM useraccount AS u "+
						"INNER JOIN user_status AS u_s ON u.user_status=u_s.user_status "+
						"inner JOIN platformmoney AS p ON u.user_account = p.user_account "+
						"where u_s.user_status=?  limit ?,?" ;
				if(PageUtils.page==0){
					PageUtils.page=1;
				}
				int e =  5;
				int s  = (PageUtils.page-1)*e;
				
				System.out.println(s+"==="+e+"====="+where);
				Object[] objects1={where,s,e};
				return getListMap(sql2, objects1);
			
			
			
		}
		sql="SELECT * FROM useraccount AS u "+
				"INNER JOIN user_status AS u_s ON u.user_status=u_s.user_status "+
				"LEFT JOIN platformmoney AS p ON u.user_account = p.user_account";
		//
		PageUtils.pagination( getListMap(sql).size());
		
		sql="SELECT * FROM useraccount AS u "+
			"INNER JOIN user_status AS u_s ON u.user_status=u_s.user_status "+
			"LEFT JOIN platformmoney AS p ON u.user_account = p.user_account limit ?,?";
		//设置每页显示条数
		int e = 5;
		//设置开始位置（页码-1）*每页显示条数
		int s = (PageUtils.page-1)*e;
		
		Object[] objects2 ={s,e};
		
		return getListMap(sql,objects2);
	}


	@Override
	public int delUser(String account) {
		String sql="DELETE FROM useraccount WHERE 	user_account =?";
		Object[] objects ={account};
		return updataAll(sql, objects);
	}

	
	

}
