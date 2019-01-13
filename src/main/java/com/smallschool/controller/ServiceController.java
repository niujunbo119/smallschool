package com.smallschool.controller;

import com.smallschool.entity.ServiceEntity;
import com.smallschool.entity.ServiceOrderEntity;
import com.smallschool.service.ServiceOrderRepository;
import com.smallschool.service.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 用来提供与“服务”有关的功能跳转
 */
@Controller
@RequestMapping("/service")
public class ServiceController {


    @Autowired
    private ServiceRepository serviceRepository;//注入服务仓库

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;//注入服务订单仓库

    /*
    * 转入index主页
    * */
    @RequestMapping("/")
    public String main(Map map){
        return "index";
    }

    /*
    * 跳转进服务列表页面
    * */
    @RequestMapping(value = "/service")
    public String getSnackList(Map<String, List> map){

        List list = serviceRepository.findAll();
        map.put("service_list", list);
/*        for (Object s:list) {
            System.out.println(s.toString());
        }*/
        return "service_list";
    }

    /*
    * 根据服务名称进行筛选显示
    * */
    @RequestMapping("/select/{name}")
    public String selectService(@PathVariable("name") String service_name,Map<String, List> map){
        List<ServiceEntity> list = serviceRepository.findByServiceName(service_name);

        map.put("service_list",list);
        for (Object s:list) {
            System.out.println(s.toString());
        }
        return "service_list";
    }

    /*
    * 服务详情界面
    * */
    @RequestMapping("/detail/{serviceId}")
    public String details(@PathVariable("serviceId") Long service_id,Map<String, List> map){
        ServiceEntity serviceEntity = serviceRepository.findById(service_id).orElse(null);
        List<ServiceEntity> list = new ArrayList<>();
        list.add(serviceEntity);
        map.put("service_detail",list);
        System.out.println(serviceEntity.toString());

        return "service_detail";
    }

    /*
    * 跳转到服务订单页面
    * */
    @RequestMapping("/toOrder")
    public String orders(Map<String, List> map){
        List<ServiceOrderEntity> list = serviceOrderRepository.findAll();

        map.put("service_order",list);
        for (Object s:list) {
            System.out.println(s.toString());
        }
        return "service_order";
    }


    @RequestMapping("/saveServerOrder")
    public String saveserviceOrder(@RequestParam("serviceID")String serviceID,Map map){
        Long serviceid =Long.parseLong(serviceID);
        ServiceEntity serviceEntity =serviceRepository.findById(serviceid).orElse(null);
        ServiceOrderEntity serviceOrderEntity =new ServiceOrderEntity();

        Date date =new Date();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
        String orderserviceId =sdf.format(date);
        serviceOrderEntity.setOrderServiceId(orderserviceId);
        serviceOrderEntity.setServiceId(serviceEntity.getServiceId());
        serviceOrderEntity.setServiceContent(serviceEntity.getServiceContent());
        serviceOrderEntity.setOrderServiceFee(serviceEntity.getServiceFee());
        serviceOrderEntity.setOrderServiceCategory(serviceEntity.getServiceCategory());
        serviceOrderEntity.setOrderServiceStatus("1");
        serviceOrderEntity.setOrderServiceStime(date);
        serviceOrderEntity.setOrderServiceEtime(null);
        serviceOrderRepository.save(serviceOrderEntity);

        List<ServiceOrderEntity> list =new ArrayList<>();
        list.add(serviceOrderEntity);

        map.put("service_detail",list);
        System.out.println(serviceEntity.toString());

        return "redirect:/service/service";
    }


}
