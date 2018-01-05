package cn.crm.service;

import cn.crm.pojo.Customer;
import cn.crm.pojo.Dict;
import cn.crm.pojo.PageBean;

import java.util.List;

public interface CustomerService {
    List<Dict> findCustomerLevel();
    void addCustomer(Customer customer);

    PageBean listCustomer(int page);

    Customer findCustomerById(Integer id);

    void editCustomer(Customer customer);

    void deleteCustomer(Integer id);

    PageBean queryByConditions(int currentPage, Customer customer);

    List<Customer> findCustomerOf();

    List custsourceSta();

    List custlevelSta();
}
