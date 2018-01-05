package cn.crm.service;

import cn.crm.pojo.LinkMan;
import cn.crm.pojo.PageBean;

import java.util.List;

public interface LinkmanService {
    PageBean listLinkman(int currentPage);

    PageBean queryByConditions(int currentPage, LinkMan linkMan);

    LinkMan findLinkmanByid(LinkMan linkMan);

    void updateLinkman(LinkMan linkMan);

    void addLinkman(LinkMan linkMan);

    void deleteLinkman(LinkMan linkMan);


}
