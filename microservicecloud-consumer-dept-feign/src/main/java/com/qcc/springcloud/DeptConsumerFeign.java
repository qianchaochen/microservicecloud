package com.qcc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * TODO
 *
 * @author qianchaochen
 * @date 2020/5/4 10:26
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class DeptConsumerFeign {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerFeign.class, args);
    }

}
