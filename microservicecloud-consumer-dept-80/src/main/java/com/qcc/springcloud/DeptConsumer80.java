package com.qcc.springcloud;

import com.qcc.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * TODO
 *
 * @author qianchaochen
 * @date 2020/5/4 10:26
 */
@SpringBootApplication
@EnableEurekaClient
//在启动该微服务时,能自动去加载我们自定义的Ribbon配置类,从而使配置生效
@RibbonClient(name="microservicecloud-dept", configuration = MySelfRule.class) //使用自定义的负载均衡策略
public class DeptConsumer80 {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80.class, args);
    }

}
