package util;

import java.util.ArrayList;
import java.util.List;



public class PageBean<T> {
	//当前页
	private int currentPage;
	//当前页显示的条数
	private int currentCount;
	//总条数
	private int totalCount;
	//总页数
	private int totalPage;
	private Object vo;
	private Object object;
	//每页显示的数据
	private  List<T> queryNumberList=new ArrayList<T>();
	
	public List<T> getQueryNumberList() {
		return queryNumberList;
	}
	public void setQueryNumberList(List<T> queryNumberList) {
		this.queryNumberList = queryNumberList;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public Object getVo() {
		return vo;
	}
	public void setVo(Object vo) {
		this.vo = vo;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	
 


	

}
