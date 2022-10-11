package com.buba.controller;

import com.buba.entity.Dept;
import com.buba.service.DeptService;
import com.buba.service.impl.DeptServiceImpl;
import com.buba.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DeptServlet extends ViewBaseServlet{
    private DeptService dept = new DeptServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
//        resp.setCharacterEncoding("UTF-8");
        // 查看部门信息
        if (req.getParameter("method").equals("findAllDepts")){
            this.findAllDepts(req, resp);
        }
        // form提交内容
        if (req.getParameter("method").equals("amend")){
            this.amend(req, resp);
        }
        // 添加部门
        if (req.getParameter("method").equals("addDept")){
            this.addDept(req, resp);
        }
        // 修改部门信息
        if (req.getParameter("method").equals("updateDept")){
            this.updateDept(req, resp);
        }

    }

    protected void findAllDepts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dept> depts = dept.finAllDepts();

        req.setAttribute("deptList", depts);
        processTemplate("deptinfo", req, resp);
    }

    protected void amend(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String update = req.getParameter("update");
        if (update.equals("创建")){
            processTemplate("addPage", req, resp);
        }
        if (update.equals("删除")){
            this.removeDept(req, resp);
        }
        if (update.equals("编辑")){
            String sel = req.getParameter("select");
            JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
            String sql = "select * from department where dept_id = ?";
            Dept dept = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Dept.class), sel);
            req.setAttribute("dept", dept);
            processTemplate("updatePage", req, resp);
        }

    }

    protected void addDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("deptId");
        String number = req.getParameter("deptNumber");
        String name = req.getParameter("deptName");
        String province = req.getParameter("province");
        String person = req.getParameter("peopleCounting");
        String described = req.getParameter("described");
        Dept add = new Dept(Integer.valueOf(id), number, name, province, Integer.valueOf(person), described);
        dept.addDept(add);
        this.findAllDepts(req, resp);
    }

    protected void removeDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] sel = req.getParameterValues("select");
        for (String item: sel) {
            dept.removeDept(Integer.valueOf(item));
        }
        this.findAllDepts(req, resp);
    }

    protected void updateDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deptId = req.getParameter("deptId");
        String deptNumber = req.getParameter("deptNumber");
        String name = req.getParameter("deptName");
        String province = req.getParameter("province");
        String peoples = req.getParameter("peopleCounting");
        String described = req.getParameter("described");
        Dept update = new Dept(Integer.valueOf(deptId), deptNumber, name, province, Integer.valueOf(peoples), described);
        dept.updateDept(update);
        this.findAllDepts(req, resp);
    }
}
