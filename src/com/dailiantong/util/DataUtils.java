package com.dailiantong.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;






public class DataUtils {
	
	
	public static Date getDate(){
		
		   Date currentTime = new Date();
		   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   System.out.println(formatter.format(currentTime));
		   Date date=null;
		   try {
			  date = formatter.parse(formatter.format(currentTime));
			   System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
//		   String dateString = formatter.format(currentTime);
//		   System.out.println(dateString);
		  return date;
		   
	}
	public static Date getDateByDay(){
		
		   Date currentTime = new Date();
		   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		   System.out.println(formatter.format(currentTime));
		   Date date=null;
		   try {
			  date = formatter.parse(formatter.format(currentTime));
			   System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
//		   String dateString = formatter.format(currentTime);
//		   System.out.println(dateString);
		  return date;
		   
	}
	
}
