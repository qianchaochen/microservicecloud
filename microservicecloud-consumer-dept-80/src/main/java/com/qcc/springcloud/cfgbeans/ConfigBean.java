package com.qcc.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * TODO
 *
 * @author qianchaochen
 * @date 2020/5/4 10:13
 */
@Configuration  //标明该类是一个配置类
public class ConfigBean {

    //将@Bean注解标注的方法的返回值对象加入到ioc容器中
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
