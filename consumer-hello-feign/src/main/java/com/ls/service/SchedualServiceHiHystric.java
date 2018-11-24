package com.ls.service;

import org.springframework.stereotype.Component;

/**
 * @Author: lishuai
 * @CreateDate: 2018/11/23 21:01
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}

