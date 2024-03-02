package com.sfuhome.controller;

import com.sfuhome.entities.Pay;
import com.sfuhome.entities.PayDTO;
import com.sfuhome.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Pay",description = "crud")
@Slf4j
public class PayController {
    @Resource
    PayService paymentService;

    @PostMapping("/pay/add")
    @Operation(summary = "add",description = "add")
    public String add(@RequestBody PayDTO payDTO){
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO,pay);
        log.info(pay.toString());
        int result = paymentService.add(pay);
        return String.format("执行插入，成功：%d",result);
    }
    @PostMapping("/pay/update")
    public String update(@RequestBody Pay pay){
        int result = paymentService.update(pay);
        return String.format("执行修改，成功：%d",result);
    }
    @PostMapping("/pay/del/{id}")
    public String del(@PathVariable("id") Integer id){
        int result = paymentService.delete(id);
        return String.format("执行删除，成功：%d",result);
    }
    @GetMapping("/pay/find/{id}")
    public Pay find(@PathVariable("id") Integer id){
        try {
            Thread.sleep(10000);
        }catch (Exception e){
            log.info(e.getLocalizedMessage());
        }

        return paymentService.find(id);
    }

    @GetMapping("/pay/list")
    public List<Pay> list(){
        return paymentService.listAll();
    }

    @Value("${server.port}")
    private String serverPort;

    @Value("${app.title}")
    private String appTitle;

    @GetMapping("/pay/info")
    public String serverInfo(String at){
        String result = serverPort+"-"+appTitle+"-"+at;
        return result;

    }
}
