package com.smallschool.controller;

import com.smallschool.entity.SnackOrderEntity;
import com.smallschool.entity.UserEntity;
import com.smallschool.service.ServiceOrderRepository;
import com.smallschool.service.SnackOrderRepository;
import com.smallschool.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * 用来提供与商品订单有关的服务
 */
@Controller
@RequestMapping("/snackOrder")
public class SnackOrderController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SnackOrderRepository snackOrderRepository;

    @RequestMapping("/toShopCart")
    public String shopcart(Map map){

        List<UserEntity> user_list = userRepository.findAll();
        List<SnackOrderEntity> snack_order_list = snackOrderRepository.findAll();

        map.put("user_list",user_list);
        map.put("snack_order_list",snack_order_list);

        return "shopcart";
    }

}
