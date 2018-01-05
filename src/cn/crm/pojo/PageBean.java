package cn.crm.pojo;

import java.util.List;

public class PageBean {
private int currentPage;
private int totalCount;
private int totalPage;
private int pageSize;
private List list;
public int getCurrentPage() {
	return currentPage;
}
public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
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
public int getPageSize() {
	return pageSize;
}
public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}
public List getList() {
	return list;
}
public void setList(List list) {
	this.list = list;
}

}
