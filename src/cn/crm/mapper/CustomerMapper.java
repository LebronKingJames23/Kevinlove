package cn.crm.mapper;

import cn.crm.pojo.Customer;
import cn.crm.pojo.Dict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {
    List<Dict> findCustomerLevelByDic();
    void addCustomer(Customer customer);
    int findTotalCount();

    List<Customer>  listCustomerWithoutConditions(@Param("startRows")int startRows, @Param("pageSize") int pageSize);

    List<Customer> listCustomer(@Param("startRows")int startRows, @Param("pageSize") int pageSize,@Param("custName") String custName);

    Customer findCustomerById(Integer id);

    void editCustomer(Customer customer);

    void deleteCustomer(Integer id);

    int findTotalCountByConditions(Customer customer);

    List<Customer> findAllCustomer();

    List custsourceSta();

    List custlevelSta();
}
