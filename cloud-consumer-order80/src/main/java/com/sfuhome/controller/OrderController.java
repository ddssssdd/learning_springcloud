package com.sfuhome.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.LocalDateTimeUtil;
import com.sfuhome.api.PayFeignApi;
import com.sfuhome.entities.PayDTO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    //private static final String PAYMENT_SRV_URL = "http://localhost:8001";
    private static final String PAYMENT_SRV_URL = "http://cloud-payment-service";

    @Resource
    RestTemplate restTemplate;

    @Resource
    PayFeignApi payFeignApi;

    @PostMapping("/feign/order/add")
    public String addByFeign(@RequestBody PayDTO pay){
        return payFeignApi.add(pay);

    }
    @GetMapping("/feign/order/find/{id}")
    public PayDTO findByFeign(@PathVariable("id") Integer id){
        System.out.println("begin call "+ DateTime.now());
        PayDTO result = null;
        try {
            result= payFeignApi.find(id);

        }catch (Exception e){

            System.out.println("end call "+ DateTime.now());
        }
        return result;
    }

    @GetMapping("/consumer/order/find/{id}")
    public String find(@PathVariable("id") Integer id){
        String result = restTemplate.getForObject(PAYMENT_SRV_URL+"/pay/find/"+id.toString(),String.class);
        return result;
    }
    @PostMapping("/consumer/order/add")
    public String add(@RequestBody PayDTO pay){
        return restTemplate.postForObject(PAYMENT_SRV_URL+"/pay/add",pay,String.class);

    }
}
