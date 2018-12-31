package com.smallschool.controller;

import com.smallschool.entity.UserEntity;
import com.smallschool.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /*
    * 获取用户信息-
    * */
    @RequestMapping("/info")
    public String getUser(Map map,Integer id){
        id = 1;
        UserEntity userEntity =userRepository.findById(id).orElse(null);
        List<UserEntity> list = new ArrayList<>();
        list.add(userEntity);
        map.put("user_list",list);
        return "myinfo";
    }

    /*
    * 地址管理
    * */
    @RequestMapping("/addressMng")
    public String toManageAddress(Map<String, List> map){
        List<UserEntity> list = userRepository.findAll();
        map.put("user_list",list);

        return "my-deliver";
    }
}
