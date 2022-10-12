package com.buba.service.impl;

import com.buba.entity.Dept;
import com.buba.service.DeptService;
import com.buba.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DeptServiceImpl implements DeptService {

    @Override
    public List<Dept> finAllDepts() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql = "select * from department";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Dept.class));
    }

    @Override
    public void addDept(Dept d) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql = "insert into department values (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, d.getDeptId(), d.getDeptNumber(), d.getDeptName(), d.getProvince(), d.getPeopleCounting(), d.getDescribed());
    }

    @Override
    public void removeDept(Integer id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        this.updateEmpDept(id);
        String sql = "delete from department where dept_id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateDept(Dept d) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql = "update department set dept_number = ?, dept_name = ?, province = ?, people_counting = ?, described = ?  where dept_id = ?";
        jdbcTemplate.update(sql, d.getDeptNumber(), d.getDeptName(), d.getProvince(), d.getPeopleCounting(), d.getDescribed(), d.getDeptId());
    }

    @Override
    public List<Dept> getDeptList(Integer pageNo) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql = "select * from department limit ?, 5";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Dept.class), (pageNo-1)*5);
    }

    @Override
    public int getDeptCount() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql = "select count(*) from department";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    private void updateEmpDept(Integer id){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql = "update employee set dept = null where dept = ?";
        jdbcTemplate.update(sql, id);
    }
}
