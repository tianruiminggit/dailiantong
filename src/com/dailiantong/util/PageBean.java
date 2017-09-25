package com.dailiantong.util;

import java.util.List;

public class PageBean<T> {
	//��ǰҳ
	private int currentPage;
	//�ӵڶ��������ݿ�ʼlimit�Ŀ�ʼ
	private int totalSize;
	//��ҳ����
	private int totalPage;
	//ÿҳ��ʾ����������
	private int pageSize;
/*	private int fromIndex;
	private int toIndex;*/
	private  List<T> list;

	public PageBean(int currentPage, List<T> list) {
		this.currentPage = currentPage;
		this.list = list;
		//�ܼ�¼��
		this.totalSize=list.size();
		this.pageSize=3;
		//��ҳ����
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
