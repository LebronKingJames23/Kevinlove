package cn.crm.service.impl;

import cn.crm.mapper.LinkmanMapper;
import cn.crm.pojo.LinkMan;
import cn.crm.pojo.PageBean;
import cn.crm.service.LinkmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LinkmanServiceImpl implements LinkmanService{
    @Autowired
    private LinkmanMapper linkmanMapper;
    @Override
    public PageBean listLinkman(int currentPage) {
        PageBean pagebean=new PageBean();
        pagebean.setCurrentPage(currentPage);
        int totalCount= linkmanMapper.findTotalCount();
        pagebean.setTotalCount(totalCount);
        int pageSize=10;
        pagebean.setPageSize(pageSize);
        int totalPageCount=(int)(totalCount/pageSize)+1;
        pagebean.setTotalPage(totalPageCount);
        int startRows=(pagebean.getCurrentPage()-1)*pageSize;
        List<LinkMan> list = linkmanMapper.listLinkman(startRows,pageSize);
        pagebean.setList(list);
        return pagebean;
    }

    @Override
    public PageBean queryByConditions(int currentPage, LinkMan linkMan) {
        PageBean pagebean=new PageBean();
        pagebean.setCurrentPage(currentPage);
        int totalCount= linkmanMapper.findCountByConditions(linkMan);
        pagebean.setTotalCount(totalCount);
        int pageSize=10;
        pagebean.setPageSize(pageSize);
        int totalPageCount=(int)(totalCount/pageSize)+1;
        pagebean.setTotalPage(totalPageCount);
        int startRows=(pagebean.getCurrentPage()-1)*pageSize;
        //List<LinkMan> list = linkmanMapper.queryByConditions(startRows,pageSize,linkMan.getLkmName());
        List<LinkMan> list = linkmanMapper.queryByConditions(startRows,pageSize,linkMan);
        pagebean.setList(list);
        return pagebean;
    }

    @Override
    public LinkMan findLinkmanByid(LinkMan linkMan) {

        return linkmanMapper.findLinkmanById(linkMan);
    }

    @Override
    public void updateLinkman(LinkMan linkMan) {
        linkmanMapper.updateLinkman(linkMan);
    }

    @Override
    public void addLinkman(LinkMan linkMan) {
        linkmanMapper.addLinkman(linkMan);
    }

    @Override
    public void deleteLinkman(LinkMan linkMan) {
        linkmanMapper.deleteLinkman(linkMan);
    }


}
