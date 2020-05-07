package com.qcc.springcloud.service;

import com.qcc.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * TODO
 *
 * @author qianchaochen
 * @date 2020/5/6 19:49
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(long id) {
                Dept errorDept = new Dept();
                errorDept.setDeptno(id);
                errorDept.setDname("该id: "+id+"没有对应的消息,我是FallbackFactory发出来的");
                errorDept.setDb_source("no this database in MySQL");
                return errorDept;
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}
