package com.qcc.springcloud.dao;

import com.qcc.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * TODO
 *
 * @author qianchaochen
 * @date 2020/5/4 0:52
 */
//@Mapper
public interface DeptDao {

    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();
}
