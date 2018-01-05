package cn.crm.controller;

import cn.crm.pojo.Customer;
import cn.crm.pojo.PageBean;
import cn.crm.pojo.User;
import cn.crm.pojo.Visit;
import cn.crm.service.CustomerService;
import cn.crm.service.UserService;
import cn.crm.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/visit")
public class VisitController {
    @Autowired
    private VisitService visitService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserService userService;
    @RequestMapping("visitlist")
    public String list(@RequestParam(value="currentPage",defaultValue="1")int currentPage, Model model){
        PageBean pageBean=visitService.findAllvisit(currentPage);
        model.addAttribute("pageBean",pageBean);
        return "/visit/list";
    }
    @RequestMapping("toadd")
    public String toadd(Model model){
        List<Customer> listCustomer =customerService.findCustomerOf();
        List<User> listUser=userService.findAllUsers();
        model.addAttribute("listCustomer",listCustomer);
        model.addAttribute("listUser",listUser);
        return  "/visit/add";
    }
    @RequestMapping("addvisit")
    public String addvisit(Visit visit){
        visitService.addvisit(visit);
        return "redirect:visitlist.action";
    }
    @RequestMapping("select")
    public String toselect(Model model){
        List<Customer> listcustomer =customerService.findCustomerOf();
        List<User> listuser=userService.findAllUsers();
        model.addAttribute("listcustomer",listcustomer);
        model.addAttribute("listuser",listuser);
        return "visit/select";
    }
    @RequestMapping("queryByConditions")
    public String queryByConditions(@RequestParam(value="currentPage",defaultValue="1")int currentPage,Visit visit, Model model){
       PageBean pageBean=visitService.queryByConditions(currentPage,visit);
       model.addAttribute("pageBean",pageBean);
       return "visit/list";
    }
}
