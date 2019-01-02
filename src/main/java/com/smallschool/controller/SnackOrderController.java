package com.smallschool.controller;

import com.smallschool.entity.CartEntity;
import com.smallschool.entity.SnackEntity;
import com.smallschool.entity.SnackOrderEntity;
import com.smallschool.entity.UserEntity;
import com.smallschool.service.*;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    CartRepository cartRepository;

    @Autowired
    SnackRepository snackRepository;

    @RequestMapping("/toShopCart")
    public String shopcart(Map map){

        UserEntity user_list = userRepository.findById(1).orElse(null);
        List<CartEntity> cart_list = cartRepository.findAll();
        List<SnackEntity> snack_list =new ArrayList<>();
        SnackEntity snackEntity =null;
        Base64 encoder = new Base64();
        for (CartEntity cart : cart_list) {
            snackEntity=snackRepository.findById(cart.getSnackId()).orElse(null);
            String pic ="data:image/jpeg;base64,"+encoder.encodeBase64String(snackEntity.getSnackPic());
            snackEntity.setPicString(pic);
            snack_list.add(snackEntity);
        }


        map.put("user_list",user_list);
        map.put("cart_list",cart_list);
        map.put("snack_list",snack_list);
        return "shopcart";
    }

    @RequestMapping("/changeDeliver")
    public String changeDeliver(Map map){
        List<UserEntity> user_list = userRepository.findAll();
        map.put("user_list",user_list);
        return "deliver";
    }

    @RequestMapping("/payment")
    public String payment(@RequestParam("totalPrices") String totalPrice,
                          @RequestParam("receiveUser") String receiveUser, Model model){

        UserEntity user= userRepository.findByName(receiveUser);

        Float totalPrices = Float.parseFloat(totalPrice);

        /*map.put("user",user);
        map.put("totalPrice",totalPrices);*/
        model.addAttribute("user",user);
        System.out.println(user.toString());
        model.addAttribute("totalPrice",totalPrice);

//        System.out.println(totalPrice);
        return "payment";
    }
}
