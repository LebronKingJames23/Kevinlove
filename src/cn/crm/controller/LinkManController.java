package cn.crm.controller;

import cn.crm.pojo.Customer;
import cn.crm.pojo.LinkMan;
import cn.crm.pojo.PageBean;
import cn.crm.service.CustomerService;
import cn.crm.service.LinkmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.awt.image.ImageWatched;

import java.util.List;

@Controller
@RequestMapping("/linkman")
public class LinkManController {
    @Autowired
    private LinkmanService LinkmanService;
    @Autowired
    private CustomerService customerService;
    @RequestMapping("list")
    public String list(@RequestParam(value="currentPage",defaultValue="1")int currentPage, Model model){
        PageBean pageBean=LinkmanService.listLinkman(currentPage);
        model.addAttribute("pageBean",pageBean);
        return  "/linkman/list";
    }
    @RequestMapping("queryByConditions")
    public String queryByConditions(@RequestParam(value="currentPage",defaultValue="1")int currentPage, LinkMan linkMan, Model model){
        PageBean pageBean=LinkmanService.queryByConditions(currentPage,linkMan);
        model.addAttribute("pageBean",pageBean);
        return  "/linkman/list";
    }
    @RequestMapping("toedit")
    public String toedit(LinkMan linkMan,Model model){
        LinkMan linkman=LinkmanService.findLinkmanByid(linkMan);
        List<Customer> list=customerService.findCustomerOf();
        model.addAttribute("linkman",linkman);
        model.addAttribute("list",list);
        return "/linkman/edit";
    }
    @RequestMapping("editLinkman")
    public String editLinkman(LinkMan linkMan,Model model){
        LinkmanService.updateLinkman(linkMan);
        return "redirect:list.action";
    }
    @RequestMapping("toaddLinkman")
    public String toadd(Model model){
        List<Customer> list=customerService.findCustomerOf();
        model.addAttribute("list",list);
        return "/linkman/add";
    }
    @RequestMapping("addLinkman")
    public  String addLinkman(LinkMan linkMan){
        LinkmanService.addLinkman(linkMan);
        return "redirect:list.action";
    }
    @RequestMapping("delete")
    public String deleteLinkman(LinkMan linkMan){
        LinkmanService.deleteLinkman(linkMan);
        return "redirect:list.action";
    }
    @RequestMapping("select")
    public String toselect(Model model){
        List<Customer> list=customerService.findCustomerOf();
        model.addAttribute("list",list);
        return "/linkman/select";
    }
}
