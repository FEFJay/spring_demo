package com.jay.controller;

import com.jay.entities.User;
import com.jay.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
public class TestController {

    @Resource
    private UserService service;

    @RequestMapping("/page1")
    public ModelAndView helloWord() {
        System.out.println("访问page1的后台。。。");
        ModelAndView mav = new ModelAndView("page1");
        List<User> users = service.getAllUser();
        System.out.println(users);
        mav.addObject("user", users.get(0));
        return mav;
//        return "page1"; //跳转到.jsp结尾的对应文件（page1.jsp）
    }

    @RequestMapping(value = "/say", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String sayHi(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("v");
        List<User> users = service.getAllUser();
        System.out.println("{name:jay,context:hi,bingbing我爱你}");
        return name+"-{name:jay,context:hi,bingbing我爱你}"+users;
    }

    public static void main(String[] args) {
        System.out.println("你和");
    }

}