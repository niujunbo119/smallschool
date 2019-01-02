package com.smallschool.controller.login;


import com.smallschool.entity.UserEntity;
import com.smallschool.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
//@RequestMapping("/login")
public class Logincontroller {
//    @Autowired
//    private StudentRepository stuRepository;
    @Autowired
    private UserRepository userRepository;

   @RequestMapping(value = "/login")
        public String login(@RequestParam(value = "phone",defaultValue = "") String phone, @RequestParam(value = "password",defaultValue = "") String password, Map map, HttpSession session)
        {
            if (phone.equals("")&&password.equals("")){
                return "login";
            }else{

            UserEntity user= userRepository.findByPhone(phone);

            if (user ==null){
                map.put("msg","该用户不存在");
                return "login";
            }else if (password.equals(user.getPassword())){
                session.setAttribute("user",user);
                return "redirect:/snack/index";
            }
            else
            {
                map.put("msg","密码错误");
                return "login";
            }
        }
    }
    //退出登录
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute("user");
        return "redirect:/snack/index";
    }

}

