package com.wpc.spring.tx;

import com.wpc.spring.tx.config.SpringConfig;
import com.wpc.spring.tx.controller.BookController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wpc
 * @date 2023/10/17 9:22
 */
public class testAnno {
    @Test
    public void testTxAllAnnotation(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        BookController bookController = context.getBean("bookController", BookController.class);
        Integer[] bookIds = {1,2};
        bookController.checkout(bookIds,1);
    }
}
