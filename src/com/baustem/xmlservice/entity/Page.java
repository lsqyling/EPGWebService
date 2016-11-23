package com.baustem.xmlservice.entity;

import java.util.List;

public class Page<T> {
	
	public static final int PAGE_SIZE_SMALL = 5;
	public static final int PAGE_SIZE_MEDIUM = 10;
	public static final int PAGE_SIZE_BIG = 20;
	public static final int PAGE_SIZE_LARGE = 40;
	public static final int PAGE_SIZE_HUGE = 60;
	
	private int pageNo;
	private int pageSize = 5;
	private int totalRecordNo;
	private int totalPageNo;
	private List<T> list;
	
	public Page(String pageNoStr, int pageSize, int totalRecordNo) {
		
		this.totalRecordNo = totalRecordNo;
		
		this.totalPageNo = totalRecordNo/pageSize+(totalRecordNo%pageSize==0?0:1);
		
		this.pageNo = 1;
		try {
			this.pageNo = Integer.parseInt(pageNoStr);
		} catch (NumberFormatException e) {
		}
		if(pageNo >totalPageNo){
			pageNo=totalPageNo;
		}
		if(pageNo<1){
			pageNo = 1;
		}
	}
	
	public List<T> getList() {
		return list;
	}
	
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getPageNo() {
		return pageNo;
	}
	
	public int getTotalRecordNo() {
		return totalRecordNo;
	}
	
	public int getTotalPageNo() {
		return totalPageNo;
	}
	
	public boolean isHasPrev(){
		return pageNo >1;
	}
	
	public boolean isHasNext(){
		return pageNo<totalPageNo;
	}
	
	public int getPrev(){
		return pageNo-1;
	}
	public int getNext(){
		return pageNo+1;
	}
	
	
}
