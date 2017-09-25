package com.dailiantong.util;

public class PageUtils {
	public static int pages;//总页数
	public static int page;//当前页码
	/**
	 * 获得总页数并存下来
	 * @param count
	 * @return
	 */
	public static int pagination(int count){
		
		if(count%5 == 0){
			
			pages = count/5;
		} else{
			pages = count/5+1;
		}
		
		
		return pages;
		
	}
	/****
	 * 获取拼接好的分页栏
	 * @param ourl
	 * @param method
	 * @return
	 */
	public static StringBuffer getBar(String ourl,String method){
		StringBuffer sb = new StringBuffer();
		StringBuffer url = new StringBuffer();
		url.append(ourl);
		url.append("?");
		String[] n = method.split("&&page");
		if(n.length>1){
			url.append(n[0]);
		}
		else url.append(method);
		String s = " <div class='text-center'><ul class='pagination pagination-sm'>";
		sb.append(s);
		if(page<1) page = 1;
		if(page > pages) page = pages;
		if(page > 1) sb.append("<li><a href='"+url.toString()+"&&page="+(page-1)+"'>&laquo;</a></li>");
		for(int i = 1; i <= pages ;i++){
			if(i == page)
				sb.append("<li class='active'><a href='#'>"+i+"</a></li>");
			else sb.append("<li><a href='"+url.toString()+"&&page="+i+"'>"+i+"</a></li>");
		}
		if(page < pages ) sb.append("<li><a href='"+url.toString()+"&&page="+(page+1)+"'>&raquo;</a></li>");
		sb.append("</ul></div>");
		return sb;
		
	}
}
//<ul class="pagination pagination-sm">
//<li class="disabled"><a href="#">&laquo;</a></li>
//<li class="active"><a href="#">1</a></li>
//<li><a href="#">2</a></li>
//<li><a href="#">3</a></li>
//<li><a href="#">4</a></li>
//<li><a href="#">5</a></li>
//<li><a href="#">&raquo;</a></li>
//</ul>