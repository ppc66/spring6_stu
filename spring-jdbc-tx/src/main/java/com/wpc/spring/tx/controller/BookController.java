package com.wpc.spring.tx.controller;

import com.wpc.spring.tx.service.BookService;
import com.wpc.spring.tx.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author wpc
 * @date 2023/10/16 8:34
 */
@Controller
public class BookController {
    @Autowired
    private BookService service;

    @Autowired
    private CheckoutService checkoutService;

    public void buy(Integer bookId,Integer userid){
        service.buyBook(bookId,userid);
    }

    public void checkout(Integer[] bookIds,Integer userid){
        checkoutService.checkout(bookIds,userid);

    }
}
