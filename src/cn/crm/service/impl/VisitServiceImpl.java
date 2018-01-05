package cn.crm.service.impl;

import cn.crm.mapper.VisitMapper;
import cn.crm.pojo.PageBean;
import cn.crm.pojo.Visit;
import cn.crm.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VisitServiceImpl implements VisitService{
    @Autowired
    private VisitMapper visitMapper;
    @Override
    public PageBean findAllvisit(int currentPage) {
        PageBean pageBean =new PageBean();
        pageBean.setCurrentPage(currentPage);
        int totalCount=visitMapper.findCount();
        pageBean.setTotalCount(totalCount);
        int pageSize=10;
        int totalPage=(int)(totalCount/pageSize)+1;
        pageBean.setPageSize(pageSize);
        pageBean.setTotalPage(totalPage);
        int startRows=(currentPage-1)*pageSize;
        List<Visit> list=visitMapper.findAllvisit(startRows,pageSize);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public PageBean queryByConditions(int currentPage, Visit visit) {
        PageBean pageBean =new PageBean();
        pageBean.setCurrentPage(currentPage);
        int totalCount=visitMapper.findCountByConditions(visit);
        pageBean.setTotalCount(totalCount);
        int pageSize=10;
        int totalPage=(int)(totalCount/pageSize)+1;
        pageBean.setPageSize(pageSize);
        pageBean.setTotalPage(totalPage);
        int startRows=(currentPage-1)*pageSize;
        List<Visit> list=visitMapper.findvisitByConditions(startRows,pageSize,visit);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public void addvisit(Visit visit) {
        visitMapper.addvisit(visit);
    }
}
