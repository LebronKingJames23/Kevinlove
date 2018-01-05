package cn.crm.service;

import cn.crm.pojo.PageBean;
import cn.crm.pojo.Visit;

public interface VisitService {
    PageBean findAllvisit(int currentPage);
    void addvisit(Visit visit);
    PageBean queryByConditions(int currentPage, Visit visit);
}
