package com.qcc.springcloud.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * TODO
 *
 * @author qianchaochen
 * @date 2020/5/3 23:39
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)        //链式风格访问对象
public class Dept implements Serializable {
    private Long deptno;        //主键
    private String dname;       //部门名称
    private String db_source;   //代表数据存进哪个数据库

    public Dept(String dname) {
        this.dname = dname;
    }

    public static void main(String[] args) {
        Dept dept = new Dept();
        dept.setDeptno(11L).setDname("RD").setDb_source("DB01号库");
        System.out.println(dept);
    }

}
