package com.wpc.spring.tx;

import com.wpc.spring.tx.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author wpc
 * @date 2023/10/16 10:03
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestBook {
    @Autowired
    private BookController bookController;

    @Test
    public void testBook(){
        bookController.buy(1,1);
    }
    @Test
    public void testBook1(){
        Integer[] bookIds = {1,2};
        bookController.checkout(bookIds,1);
    }
}
