package com.qcc.springcloud.controller;

import com.qcc.springcloud.entities.Dept;
import com.qcc.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * TODO
 *
 * @author qianchaochen
 * @date 2020/5/4 1:11
 */
@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable Long id) {
        return deptService.get(id);
    }

    @GetMapping("/list")
    public List<Dept> list() {
        return deptService.list();
    }

    @PostMapping("/add")
    public boolean add(@RequestBody Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        System.out.println(services);

        List<ServiceInstance> instances = discoveryClient.getInstances("microservicecloud-dept");

        for (ServiceInstance instance : instances) {
            System.out.println("ServiceId: " + instance.getServiceId() + "\n"
                    + "Host: " + instance.getHost() + "\n"
                    + "Port: " + instance.getPort() + "\n"
                    + "Uri: " + instance.getUri());
        }

        return this.discoveryClient;
    }

}
