package com.dailiantong.util;

import java.util.List;

public class PageBean<T> {
	//当前页
	private int currentPage;
	//从第多少条数据开始limit的开始
	private int totalSize;
	//总页码数
	private int totalPage;
	//每页显示多少条数据
	private int pageSize;
/*	private int fromIndex;
	private int toIndex;*/
	private  List<T> list;

	public PageBean(int currentPage, List<T> list) {
		this.currentPage = currentPage;
		this.list = list;
		//总记录数
		this.totalSize=list.size();
		this.pageSize=3;
		//总页数：
		if(this.totalSize%this.pageSize==0){
			this.totalPage=this.totalSize/this.pageSize;
		}else{
			this.totalPage=this.totalSize/this.pageSize+1;
		}
		
		this.list=list.subList((currentPage-1)*pageSize, currentPage*pageSize);
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getList() {
		return list;

	}

	public void setList(List<T> list) {
		this.list = list;
	}
	


	
	
	
	
	
	
}
