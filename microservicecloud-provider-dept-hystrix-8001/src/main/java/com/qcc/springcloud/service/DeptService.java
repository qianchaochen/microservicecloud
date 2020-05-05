package com.qcc.springcloud.service;

import com.qcc.springcloud.entities.Dept;

import java.util.List;

/**
 * TODO
 *
 * @author qianchaochen
 * @date 2020/5/4 1:07
 */
public interface DeptService {
    boolean addDept(Dept dept);

    Dept get(Long id);

    List<Dept> list();
}
