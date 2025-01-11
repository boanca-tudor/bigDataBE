package com.bigdata.app.controller;

import com.bigdata.app.dto.ParamValues;
import com.bigdata.app.kafka.producer.ParamValuesProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ParamValuesController {

    @Autowired
    private ParamValuesProducer paramValuesProducer;


    @PostMapping("/setParams")
    public String sendSample(@RequestBody ParamValues node) {
        paramValuesProducer.sendParamValues(node);
        return "Da";
    }
}
