package com.dailiantong.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderNum {


	public static String getOrder(){

		//���ת��
	SimpleDateFormat   formatter   = new   SimpleDateFormat( "yyyy-MM-dd hh:mm:ss");
	String sumString = null;
	String time =formatter.format(new Date());
	//ȡ��ǰ�沿��
	String qString = time.substring(0,10);
	String[] agStrings =qString.split("-");
	for(String iString:agStrings){
		sumString+=iString;
//		System.out.print(iString);
	}
	//ȡ�ú��沿��
	String cString= time.substring(11);
	String[] agsString= cString.split(":");
	for(String iString:agsString){
		sumString+=iString;
//		System.out.print(iString);
	}
	
//	System.out.println(sumString);
	
	return sumString.substring(4);
	}
	
	
}
