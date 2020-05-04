package com.qcc.springcloud.controller;

import com.qcc.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * TODO
 *
 * @author qianchaochen
 * @date 2020/5/4 10:20
 */
@RestController
public class DeptController_Consumer {
    public static final String REST_URL_PREFIX = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;


    @PostMapping("/consumer/dept/add")
    public boolean add(Dept dept) {
        Boolean res = restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
        System.out.println(res);
        return res;
    }

    @GetMapping("/consumer/dept/list")
    public List<Dept> list() {
        List<Dept> list = restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
        System.out.println(list);
        return list;
    }

    @GetMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable Long id) {
        Dept dept = restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
        System.out.println(dept);
        return dept;
    }

    @GetMapping("/consumer/dept/discovery")
    public Object discovery() {
        Object ob = restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
        System.out.println(ob);
        return ob;
    }
}
