package com.smallschool.controller;

import com.smallschool.entity.*;
import com.smallschool.service.*;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    DeliverRepository   deliverRepository;

    @Autowired
    SnackOrderRepository snackOrderRepository;


    @RequestMapping("/toShopCart")
    public String shopcart(Map map, HttpServletRequest request){


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
        if (request.getSession().getAttribute("address") !=null){
            map.put("user_list",request.getSession().getAttribute("address"));
        }else {
            UserEntity user = (UserEntity) request.getSession().getAttribute("user");
            map.put("user_list",user);
        }

        map.put("cart_list",cart_list);
        map.put("snack_list",snack_list);

        return "shopcart";
    }

    @RequestMapping("/changeDeliver")
    public String changeDeliver(Map map ,HttpServletRequest request){
//        List<UserEntity> user_list = userRepository.findAll();
        UserEntity user = (UserEntity) request.getSession().getAttribute("user");
        List<DeliverEntity> deliverEntityList = deliverRepository.findByUserPhone(user.getPhone());
        map.put("deliver_list",deliverEntityList);
        return "deliver";
    }

    /*
    * 如果切换默认地址，则将该地址信息存入session
    * */
    @RequestMapping("/changeAddress/{deliverId}")
    public String changeAddress(@PathVariable("deliverId") String deliverId,Map map,HttpServletRequest request){
        DeliverEntity deliverEntity =deliverRepository.findById(deliverId).orElse(null);

        request.getSession().setAttribute("address",deliverEntity);

        return "redirect:/snackOrder/toShopCart";

    }

    @RequestMapping("/payment")
    public String payment(@RequestParam("totalPrices") String totalPrice,
                          @RequestParam("receiveUser") String receiveUser,
                          @RequestParam("receiveAddress") String receiveAddress,
                          @RequestParam("receivePhone") String receivePhone,Model model,HttpServletRequest request){

        model.addAttribute("user",receiveUser);
        model.addAttribute("phone",receivePhone);
        model.addAttribute("address",receiveAddress);
        model.addAttribute("totalPrice",totalPrice);

        request.getSession().setAttribute("receiveUser",receiveUser);
        request.getSession().setAttribute("receivePhone",receivePhone);
        request.getSession().setAttribute("receiveAddress",receiveAddress);
        request.getSession().setAttribute("totalPrice",totalPrice);

//        System.out.println(totalPrice);
        return "payment";
    }
    @RequestMapping("/payments")
    public String payment(Model model,HttpServletRequest request){

        model.addAttribute("user",request.getSession().getAttribute("receiveUser"));
        model.addAttribute("phone",request.getSession().getAttribute("receivePhone"));
        model.addAttribute("address",request.getSession().getAttribute("receiveAddress"));
        model.addAttribute("totalPrice",request.getSession().getAttribute("totalPrice"));

//        System.out.println(totalPrice);
        return "payment";
    }

    @RequestMapping("/checkout")
    public String checkout(@RequestParam("totalPrices") String totalPrice,
                           @RequestParam("receiveUser") String receiveUser,
                           @RequestParam("receiveAddress") String receiveAddress,
                           @RequestParam("receivePhone") String receivePhone,
                           @RequestParam("deliverTime") String deliverTime,
                           @RequestParam("note") String note,HttpServletRequest request,Map map){

        SnackOrderEntity snackOrderEntity=new SnackOrderEntity();
        Date date =new Date();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
        String orderSnackId =sdf.format(date);
        UserEntity  userEntity= (UserEntity)request.getSession().getAttribute("user");

        snackOrderEntity.setOrderSnackId(orderSnackId);
        snackOrderEntity.setUserId(userEntity.getUserId());
        snackOrderEntity.setAddress(receiveAddress);
        snackOrderEntity.setName(receiveUser);
        snackOrderEntity.setPhone(receivePhone);
        snackOrderEntity.setOrderTime(date);
        snackOrderEntity.setTotalCost(Float.parseFloat(totalPrice));
        snackOrderEntity.setDeliverTime(deliverTime);
        snackOrderEntity.setNote(note);

        snackOrderRepository.save(snackOrderEntity);

        cartRepository.deleteAll();

        map.put("orderSnackId",orderSnackId);
        map.put("deliverTime",deliverTime);
        return "buy-success";
    }

    @RequestMapping("/toOrder")
    public String order(Map map){
        List<SnackOrderEntity> snack_order_list = snackOrderRepository.findAll();

        map.put("snack_order_list",snack_order_list);
        return "snack_order";
    }


}
