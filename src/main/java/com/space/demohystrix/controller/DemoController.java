package com.space.demohystrix.controller;

import com.space.demohystrix.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    public DemoService demoService;
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @RequestMapping("/api/v1/getDetail")
    public String getDetail() {
        return demoService.callNodeJSService();
    }
}
