package cn.crm.mapper;

import cn.crm.pojo.Visit;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface VisitMapper {
    @Select("select count(1) from t_customer t, user u,t_visit v where t.cid=v.idofcust and v.userid=u.uid")
    int findCount();
    List<Visit> findAllvisit(@Param("startRows") int startRows,@Param("pageSize") int pageSize);
    void addvisit(Visit visit);
    int findCountByConditions(Visit visit);
    List<Visit> findvisitByConditions(@Param("startRows")int startRows, @Param("pageSize")int pageSize,@Param("visit") Visit visit);
}
