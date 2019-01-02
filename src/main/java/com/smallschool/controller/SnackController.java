package com.smallschool.controller;

import com.smallschool.entity.SnackEntity;
import com.smallschool.entity.UserEntity;
import com.smallschool.service.SnackOrderRepository;
import com.smallschool.service.SnackRepository;
import com.smallschool.service.UserRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/snack")
public class SnackController {


    @Autowired
    private SnackRepository snackRepository;

    @Autowired
    private SnackOrderRepository snackOrderRepository;

    @Autowired
    private UserRepository userRepository;

    /*
     * 转入index主页
     * */
    @RequestMapping({"/","/index"})
    public String main(Map map, HttpSession httpSession){

        Object userEntity =httpSession.getAttribute("user");
//        System.out.println(userEntity.toString());
        UserEntity user = (UserEntity)userEntity;
        map.put("user",user);

        return "index";
    }

    /*
    * 重定向：转入服务详情
    * */
    @RequestMapping("/toService")
    public String toService(){
        return "redirect:/service/service";
    }

    /*
    * 跳转到 零食详情页面 （页面未完成）
    * */
    @RequestMapping(value = "/list")
    public String getSnackList(Map<String, List> map){

        List list = snackRepository.findAll();
        map.put("list", list);
        for (Object s:list) {
            System.out.println(s.toString());
        }
        return "list";
    }

    @RequestMapping("/toSnackOrder")
    public String getSnackOrderList(Map map){

        List order_list = snackOrderRepository.findAll();
        map.put("order_list",order_list);
        return "shopcart";
    }

    @RequestMapping("/snackList/{category}")
    public String snackList(Map map, @PathVariable("category") int category){
        List<SnackEntity> snack_list = snackRepository.findBySnackCategory(category);
        Base64 encoder = new Base64();
        for (SnackEntity snack:snack_list) {
            String pic ="data:image/jpeg;base64,"+encoder.encodeBase64String(snack.getSnackPic());
            snack.setPicString(pic);
        }
        map.put("snack_list",snack_list);
        return "snack_list";
    }

    @RequestMapping("/snackDetail/{snackId}")
    public String snackDetail(@PathVariable("snackId") int snackId,Map<String, SnackEntity> map){
        //int snack_id = Integer.parseInt(snackId);
        SnackEntity snack = snackRepository.findById(snackId).orElse(null);
        Base64 encoder = new Base64();
        String pic ="data:image/jpeg;base64,"+encoder.encodeBase64String(snack.getSnackPic());
        snack.setPicString(pic);
        System.out.println(snack.toString());
        map.put("snack_details",snack);
        return "snack_detail";
    }


    /**
     * @param map
     * @return 跳转进入购物车
     */
    @RequestMapping("/shopcart")
    public String shopCart(Map map){

        List <UserEntity> user_list = userRepository.findAll();
        map.put("user_list",user_list);

        return "shopcart";
    }
}
