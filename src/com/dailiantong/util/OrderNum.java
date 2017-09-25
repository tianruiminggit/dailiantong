package com.dailiantong.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderNum {


	public static String getOrder(){

		//编号转换
	SimpleDateFormat   formatter   = new   SimpleDateFormat( "yyyy-MM-dd hh:mm:ss");
	String sumString = null;
	String time =formatter.format(new Date());
	//取得前面部分
	String qString = time.substring(0,10);
	String[] agStrings =qString.split("-");
	for(String iString:agStrings){
		sumString+=iString;
//		System.out.print(iString);
	}
	//取得后面部分
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
