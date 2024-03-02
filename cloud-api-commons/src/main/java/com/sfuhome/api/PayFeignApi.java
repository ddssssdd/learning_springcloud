package com.sfuhome.api;


import com.sfuhome.entities.PayDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "cloud-payment-service")
public interface PayFeignApi {
    @PostMapping("/pay/add")
    String add(@RequestBody PayDTO payDTO);

    @GetMapping("/pay/find/{id}")
    PayDTO find(@PathVariable("id") Integer id);

}
