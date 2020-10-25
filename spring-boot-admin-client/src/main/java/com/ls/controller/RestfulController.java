package com.ls.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: ls-springcloud
 * @author: lishuai
 * @create: 2020-10-24 20:51
 */
@RestController
public class RestfulController {
    @GetMapping("/restful/name")
    public Object test() {
        Map<String,String> map = new HashMap<>();
        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        map.put("name","lishuai");
        return map;
    }
}
