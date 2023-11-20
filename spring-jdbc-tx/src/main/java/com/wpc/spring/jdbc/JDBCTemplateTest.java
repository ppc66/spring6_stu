package com.wpc.spring.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author wpc
 * @date 2023/10/15 16:18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class JDBCTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert(){

    }

    @Test
    public void testUpdate(){
        /*//添加数据
        String sql = "insert into t_emp values(null,?,?,?)";
        //调用jdbcTemplate的方法，传入相关参数
        Object[] params = {"李四", "18", "女"};
        int row = jdbcTemplate.update(sql,params);
        System.out.println("row = " + row);*/

//        String sql = "update t_emp set name = ? where id = ?";
//        int row = jdbcTemplate.update(sql,"王五","2");
//        System.out.println("row = " + row);

        //删除
        String sql = "delete from t_emp where id = 1";
        int row = jdbcTemplate.update(sql);
        System.out.println("row = " + row);
    }

    @Test
    public void selectTest(){
        String sql = "select * from t_emp where id = ?";
//        Emp empResult = jdbcTemplate.queryForObject(sql,
//         (rs,rowNum) -> {
//             Emp emp = new Emp();
//             emp.setId(rs.getInt("id"));
//             emp.setName(rs.getString("name"));
//             emp.setAge(rs.getInt("age"));
//             emp.setSex(rs.getString("sex"));
//             return emp;
//        },1);
        Emp emp = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Emp>(Emp.class), 1);
        System.out.println("empResult = " + emp);
    }
    @Test
    public void testList(){
        String sql = "select * from t_emp";
        List<Emp> empList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        System.out.println(empList);
    }
    @Test
    public void testSelectValue(){
        String sql = "select count(*) from t_emp";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("count = " + count);
    }
}
