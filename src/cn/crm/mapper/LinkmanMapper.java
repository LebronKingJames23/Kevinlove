package cn.crm.mapper;

import cn.crm.pojo.LinkMan;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LinkmanMapper {
    @Select(" select t.linkid ,t.lkmName,t.lkmGender,t.lkmPhone,t.lkmMobile from t_linkman t limit #{startRows},#{pageSize}")
    List<LinkMan> listLinkman(@Param("startRows") int startRows,@Param("pageSize") int pageSize);

    int findTotalCount();

    List<LinkMan> queryByConditions(@Param("startRows")int startRows, @Param("pageSize")int pageSize,@Param("linkman")LinkMan linkman);

    int findCountByConditions(LinkMan linkMan);

    LinkMan findLinkmanById(LinkMan linkMan);

    void updateLinkman(LinkMan linkMan);

    void addLinkman(LinkMan linkMan);

    void deleteLinkman(LinkMan linkMan);

    List<LinkMan> findLinkmanByCustomerId(Integer id);

    void setCustomerNUll(List<LinkMan> list);
}
