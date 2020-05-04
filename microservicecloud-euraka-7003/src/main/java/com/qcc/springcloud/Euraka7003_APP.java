package com.qcc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * TODO
 *
 * @author qianchaochen
 * @date 2020/5/4 13:12
 */

@SpringBootApplication
@EnableEurekaServer
public class Euraka7003_APP {

    public static void main(String[] args) {
        SpringApplication.run(Euraka7003_APP.class, args);
    }
}
