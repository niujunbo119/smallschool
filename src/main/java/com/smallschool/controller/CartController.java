package com.smallschool.controller;

import com.smallschool.entity.CartEntity;
import com.smallschool.entity.SnackEntity;
import com.smallschool.service.CartRepository;
import com.smallschool.service.SnackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
* 实现商品购物车的添加和删除功能
* */
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    SnackRepository snackRepository;

    @RequestMapping("/addCart")
    @ResponseBody
    public void addCart(@RequestParam(value = "snackId",defaultValue = "") String snackId){

        int snack_id =Integer.parseInt(snackId);
        CartEntity cartEntity=cartRepository.findBySnackId(snack_id);
        if (cartEntity != null){
            int snackNum =cartEntity.getSnackNumber();
            cartEntity.setSnackNumber(snackNum+1);
            cartRepository.save(cartEntity);
        }else {
//            Long cartId = Long.parseLong((new Date()).toLocaleString());

            Date date =new Date();
            SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
            String dates =sdf.format(date);
//            System.out.println("dates:"+dates);
            Long cartId =Long.parseLong(dates);

//            System.out.println("cartId:"+cartId);
            assert false;
            cartEntity =new CartEntity();
            cartEntity.setCartId(cartId);
            cartEntity.setSnackId(snack_id);
            SnackEntity snackEntity =snackRepository.findById(snack_id).orElse(null);
            cartEntity.setSnackName(snackEntity.getSnackName());
            cartEntity.setSnackPrice(snackEntity.getSnackPrice());
            cartEntity.setSnackNumber(1);
            System.out.println(cartEntity.toString());
            cartRepository.save(cartEntity);
        }
        System.out.println("add success");
    }

    @RequestMapping("/subCart")
    @ResponseBody
    public void subCart(@RequestParam(value = "snackId",defaultValue = "") String snackId){

        int snack_id =Integer.parseInt(snackId);
        CartEntity cartEntity=cartRepository.findBySnackId(snack_id);
        if (cartEntity != null){
            int snackNum =cartEntity.getSnackNumber();
            if (snackNum > 1) {
                cartEntity.setSnackNumber(snackNum - 1);
                cartRepository.save(cartEntity);
            }else if (snackNum ==1){
                cartRepository.delete(cartEntity);
            }
        }
        /*else {
//            Long cartId = Long.parseLong((new Date()).toLocaleString());

            Date date =new Date();
            SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
            String dates =sdf.format(date);
//            System.out.println("dates:"+dates);
            Long cartId =Long.parseLong(dates);

//            System.out.println("cartId:"+cartId);
            assert false;
            cartEntity =new CartEntity();
            cartEntity.setCartId(cartId);
            cartEntity.setSnackId(snack_id);
            SnackEntity snackEntity =snackRepository.findById(snack_id).orElse(null);
            cartEntity.setSnackName(snackEntity.getSnackName());
            cartEntity.setSnackPrice(snackEntity.getSnackPrice());
            cartEntity.setSnackNumber(1);
            System.out.println(cartEntity.toString());
            cartRepository.save(cartEntity);
        }*/
        System.out.println("reduce success");
    }
}
