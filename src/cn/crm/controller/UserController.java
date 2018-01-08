package cn.crm.controller;

import cn.crm.pojo.User;
import cn.crm.service.UserService;
import cn.crm.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService UserService;
    @RequestMapping("login")
    public String login(User User, HttpServletRequest request, HttpServletResponse response) {
        User.setPassword(MD5Utils.md5(User.getPassword()));
        //User user = UserService.login(User);
       User user=UserService.loginByProcedure(User);
        if (user == null) {
            try {
                return "login";
                //response.sendRedirect("jsp/login.jsp");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                request.getSession().setAttribute("loginUser", user);
                ServletContext application= request.getServletContext();
                Integer count = (Integer) application.getAttribute("count");
                if (count==null){
                    count=new Integer(0);
                }
                count++;
                application.setAttribute("count",count);
                Cookie[] cookies = request.getCookies();
                if(cookies!=null) {
                    for (Cookie cookie : cookies) {
                        if (user.getUsername().equals(cookie.getName())) {
                            String loginuser = cookie.getValue();
                            String login = cookie.getValue();
                            request.getSession().setAttribute("loginTime",login);
                        }
                    }
                }
                Date date =new Date();
                SimpleDateFormat sy = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
                sy.format(date);
                Cookie c =new Cookie(user.getUsername(),""+date);
                response.addCookie(c);
                response.sendRedirect(request.getContextPath() + "/index.htm");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "login";
    }
    @RequestMapping("regist")
    public String  regist(User user){
        user.setPassword(MD5Utils.md5(user.getPassword()));
        UserService.registUser(user);
        return  "login";
    }
    @RequestMapping("tologin")
    public String tologin(){
        return "login";
    }
    @RequestMapping("logout")
    public void logout(HttpServletRequest request,HttpServletResponse response){
        request.getSession().removeAttribute("loginUser");
        Integer count = (Integer) request.getServletContext().getAttribute("count");
        count--;
        request.getServletContext().setAttribute("count",count);
        try {
            response.sendRedirect(request.getContextPath()+"/index.htm");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
