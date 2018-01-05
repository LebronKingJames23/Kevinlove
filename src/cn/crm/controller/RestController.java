package cn.crm.controller;

import cn.crm.pojo.Customer;
import cn.crm.pojo.User;
import cn.crm.service.CustomerService;
import cn.crm.service.UserService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/text")
public class RestController {
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;
    @RequestMapping("tohtml")
    public String tohtml(){
        return "111";
    }
    @RequestMapping("receiveParams")
    public String receiveParams(String cid){
        System.out.println(cid);
        return "222";
    }
    @RequestMapping("recparambackjson")
   // @Select("select a.custName,b.lname,d.visitcontent,f.username from t_customer a,t_dict b,t_visit d,user f where a.custlevel=b.lid and d.userid=f.uid and d.idofcust=a.cid ")
    @ResponseBody
    public Map<String,String> recparambackjson(String username, String password){
            Map<String,String> map =new HashMap<>() ;
            map.put("username",username);
            map.put("password",password);
        return map;
    }

    // @Select("select a.custName,b.lname,d.visitcontent,f.username from t_customer a,t_dict b,t_visit d,user f where a.custlevel=b.lid and d.userid=f.uid and d.idofcust=a.cid ")
    @ResponseBody
    @RequestMapping(value = "recparams",method = RequestMethod.POST)
    public Customer re(@RequestBody Customer customer){
        Customer customer1=customerService.findCustomerById(customer.getCid());
        return customer1;
    }
}
