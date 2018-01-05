package cn.crm.controller;

import cn.crm.pojo.Customer;
import cn.crm.pojo.Dict;
import cn.crm.pojo.PageBean;
import cn.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @RequestMapping("toadd")
    public String toadd(Model model){
        List<Dict> list=customerService.findCustomerLevel();
        model.addAttribute("list",list);
        return "customer/add";
    }
    @RequestMapping("addCustomer")
    public String addCustomer(Customer customer){
        customerService.addCustomer(customer);
        return "redirect:tolist.action";
    }
    @RequestMapping("tolist")
    public String tolist(@RequestParam(value="currentPage",defaultValue="1")int currentPage,Model model){
        PageBean pageBean=customerService.listCustomer(currentPage);
        model.addAttribute("pageBean",pageBean);
        return "/customer/list";
    }

    @RequestMapping("queryByConditions")
    public String queryByConditions(@RequestParam(value="currentPage",defaultValue="1")int currentPage, Customer customer,Model model){
        PageBean pageBean=customerService.queryByConditions(currentPage,customer);
        model.addAttribute("pageBean",pageBean);
        return "/customer/list";
    }
    @RequestMapping("toedit")
    public String toedit(Integer id,Model model){
        Customer customer=customerService.findCustomerById(id);
        model.addAttribute("customer",customer);
        List<Dict> list=customerService.findCustomerLevel();
        model.addAttribute("list",list);
    return "/customer/edit";
    }
    @RequestMapping("editCustomer")
    public String editCustomer(Customer customer){
       customerService.editCustomer(customer);
        return "redirect:tolist.action";
    }
    @RequestMapping("delete")
    public String delete(Integer id,Model model){
        customerService.deleteCustomer(id);
        return "redirect:tolist.action";
    }
    @RequestMapping("source")
    public String source(Model model){
        List list=customerService.custsourceSta();
        model.addAttribute("list",list);
        return "/customer/source";
    }
    @RequestMapping("level")
    public String level(Model model){
        List list=customerService.custlevelSta();
        model.addAttribute("list",list);
        return "/customer/level";
    }
}
