package com.qcc.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * TODO
 *
 * @author qianchaochen
 * @date 2020/5/4 1:19
 */
@SpringBootApplication
@EnableEurekaClient     //本服务启动后,会自动注册进Eureka服务列表中
@EnableDiscoveryClient  //开启服务发现
@MapperScan(basePackages = "com.qcc.springcloud.dao")
public class DeptProvider8001_App {


    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001_App.class, args);
    }
}
