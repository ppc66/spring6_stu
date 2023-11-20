package com.wpc.spring6.junit.junit5;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author wpc
 * @date 2023/10/15 15:17
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class SpringTestJunit5 {
    @Autowired
    private User user;

    @Test
    public void test1(){
        user.run();
        System.out.println("123");

    }

    public static void main(String[] args) {
        System.out.println("123");
    }
}
