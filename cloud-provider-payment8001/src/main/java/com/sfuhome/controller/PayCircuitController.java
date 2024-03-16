package com.sfuhome.controller;

import ch.qos.logback.core.util.TimeUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayCircuitController {

    @GetMapping("/pay/circuit/{id}")
    public String myCircuit(@PathVariable("id") Integer id){
        if (id<0) throw new RuntimeException("--id can not be under 0");
        if (id==999){
            try{
                Thread.sleep(5000);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return "hello, input id="+id.toString();
    }
}
