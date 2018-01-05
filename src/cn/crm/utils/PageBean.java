package cn.crm.utils;

import cn.crm.pojo.Customer;

import java.io.Serializable;
import java.util.List;

public class PageBean implements Serializable {

        private static final long serialVersionUID = -3198048449643774660L;

        private int page = 1; // 当前页数

        private int pageSize = 10; // 每页显示记录的条数

        private int totalCount; // 总的记录条数

        private int totalPageCount; // 总的页数

        private List list;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
