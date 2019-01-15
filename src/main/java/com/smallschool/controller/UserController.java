package com.smallschool.controller;

import com.smallschool.entity.DeliverEntity;
import com.smallschool.entity.UserEntity;
import com.smallschool.service.DeliverRepository;
import com.smallschool.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DeliverRepository deliverRepository;

    /*
    * 获取用户信息-
    * */
    @RequestMapping("/info")
    public String getUser(Map map, Integer id, HttpServletRequest request){
        id = 1;
        UserEntity userEntity =userRepository.findById(id).orElse(null);
        List<UserEntity> list = new ArrayList<>();
        list.add(userEntity);
        map.put("user_list",list);

        UserEntity user =(UserEntity)request.getSession().getAttribute("user");
        map.put("user",user);
        System.out.println(user);
        return "myinfo";
    }

    /*
    * 地址管理
    * */
    @RequestMapping("/addressMng")
    public String toManageAddress(Map<String, List> map, HttpServletRequest request){
        UserEntity user = (UserEntity)request.getSession().getAttribute("user");
        String phone =user.getPhone();


        List<DeliverEntity> deliver_list = deliverRepository.findByUserPhone(phone);

        map.put("deliver_list",deliver_list);
        return "my-deliver";
    }

    @RequestMapping("/toAddAddress")
    public String toAddress(){
        return "addAddress";
    }

    @RequestMapping("/addAddress")
    public String addAddress(@RequestParam("recipients") String recipients,
                             @RequestParam("recPhone") String recPhone,
                             @RequestParam("recGender") String recGender,
                             @RequestParam("address") String address,
                             HttpServletRequest request){

        UserEntity user = (UserEntity)request.getSession().getAttribute("user");
        String phone =user.getPhone();
        DeliverEntity deliverEntity =new DeliverEntity();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
        String dates =sdf.format(new Date());
        deliverEntity.setDeliverId(dates);
        deliverEntity.setUserPhone(phone);
        deliverEntity.setAddress(address);
        deliverEntity.setName(recipients);
        deliverEntity.setGender(recGender);
        deliverEntity.setPhone(recPhone);

        deliverRepository.save(deliverEntity);

        return "redirect:/user/addressMng";
    }
    @RequestMapping("/toUpdate/{deliverId}")
    public String toUpdate(@PathVariable("deliverId") String deliverId, Map map){
        DeliverEntity deliverEntity = deliverRepository.findById(deliverId).orElse(null);
        if (deliverEntity == null){
            return "errorpage";
        }
        map.put("deliverEntity",deliverEntity);
        return "updateAddress";
    }
    @RequestMapping("/update/{deliverId}")
    public String addressUpdate(@PathVariable("deliverId") String deliverId,
                                @RequestParam("recipients") String recipients,
                                @RequestParam("recPhone") String recPhone,
                                @RequestParam("recGender") String recGender,
                                @RequestParam("address") String address){
        DeliverEntity deliverEntity =deliverRepository.findById(deliverId).orElse(null);
        SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
        String dates =sdf.format(new Date());
        deliverEntity.setAddress(address);
        deliverEntity.setName(recipients);
        deliverEntity.setGender(recGender);
        deliverEntity.setPhone(recPhone);
        deliverRepository.save(deliverEntity);

        return "redirect:/user/addressMng";
    }

    @RequestMapping("/coupon")
    public String coupon(Map map){

        return "ticket";
    }
}
