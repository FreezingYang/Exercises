package com.buba.service;

import com.buba.entity.Dept;

import java.util.List;

public interface DeptService {
    // 查看部门信息
    List<Dept> finAllDepts();
    // 添加部门信息
    void addDept(Dept d);

    void removeDept(Integer id);

    void updateDept(Dept d);
}
