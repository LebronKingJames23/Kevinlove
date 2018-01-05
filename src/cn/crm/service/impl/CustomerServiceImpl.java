package cn.crm.service.impl;

import cn.crm.mapper.CustomerMapper;
import cn.crm.mapper.LinkmanMapper;
import cn.crm.pojo.Customer;
import cn.crm.pojo.Dict;
import cn.crm.pojo.LinkMan;
import cn.crm.pojo.PageBean;
import cn.crm.service.CustomerService;
import cn.crm.service.LinkmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private LinkmanMapper linkmanMapper;
    @Autowired
    private LinkmanService linkmanService;
    @Override
    public List<Dict> findCustomerLevel() {
        return customerMapper.findCustomerLevelByDic();
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return customerMapper.findCustomerById(id);
    }

    @Override
    public PageBean listCustomer(int page) {
        PageBean pagebean=new PageBean();
        pagebean.setCurrentPage(page);
        int totalCount= customerMapper.findTotalCount();
        pagebean.setTotalCount(totalCount);
        int pageSize=10;
        pagebean.setPageSize(pageSize);
        int totalPageCount=(int)(totalCount/pageSize)+1;
        pagebean.setTotalPage(totalPageCount);
        int startRows=(pagebean.getCurrentPage()-1)*pageSize;
        List<Customer> list = customerMapper.listCustomerWithoutConditions(startRows,pageSize);
        pagebean.setList(list);
        return pagebean;
    }

    @Override
    public PageBean queryByConditions(int currentPage, Customer customer) {
        PageBean pagebean=new PageBean();
        pagebean.setCurrentPage(currentPage);
        int totalCount= customerMapper.findTotalCountByConditions(customer);
        pagebean.setTotalCount(totalCount);
        int pageSize=10;
        pagebean.setPageSize(pageSize);
        int totalPageCount=(int)(totalCount/pageSize)+1;
        pagebean.setTotalPage(totalPageCount);
        int startRows=(pagebean.getCurrentPage()-1)*pageSize;
        List<Customer> list = customerMapper.listCustomer(startRows, pageSize, customer.getCustName());
        pagebean.setList(list);
        return pagebean;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerMapper.addCustomer(customer);
    }

    @Override
    public void editCustomer(Customer customer) {
        customerMapper.editCustomer(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {
       List<LinkMan> list=linkmanMapper.findLinkmanByCustomerId(id);
       if(list.size()==0){
           customerMapper.deleteCustomer(id);
       }else{

            linkmanMapper.setCustomerNUll(list);
           customerMapper.deleteCustomer(id);
       }

    }

    @Override
    public List<Customer> findCustomerOf() {
        return customerMapper.findAllCustomer();
    }

    @Override
    public List custsourceSta() {
        return customerMapper.custsourceSta();
    }

    @Override
    public List custlevelSta() {
        return customerMapper.custlevelSta();
    }
}
