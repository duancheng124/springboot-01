package com.poxiao.springboot01.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.poxiao.springboot01.dao.entity.User;
import com.poxiao.springboot01.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //用户列表分页
    @GetMapping ("/listUser")
    public String listUser(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 5);
        List<User> list = userService.listUser();
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "listUser";
    }
    //添加一个用户
    @GetMapping("/insertUser")
    public String insertUser(Model m) throws Exception {
        m.addAttribute("user", new User());
        return "insertUser";
    }

    //添加完后重定向到userList界面
    @GetMapping("/saveUser")
    public String saveAdd(@ModelAttribute User user) {
        userService.insertUser(user);
        return "redirect:listUser";
    }

    //获取id,用于更新用户
    @GetMapping("/updateUser")
    public String findById(Integer id,Model model) {
        //创建一个新的对象去存放当前用户的信息
        User user = userService.getById(id);
        //将这个新对象存入到model中
        model.addAttribute("user",user);
        return "updateUser";
    }
    //更新用户
    @PostMapping("/updateUser")
    public String updateUser(User user) throws Exception{
        userService.updateUser(user);
        return "redirect:listUser";
    }
    //删除用户
    @GetMapping("/deleteUserById")
    public String deleteUserById(Integer id) throws Exception {
        userService.deleteUserById(id);
        return "redirect:listUser";
    }

}
