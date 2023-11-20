package com.wpc.spring.tx.service;

import com.wpc.spring.tx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wpc
 * @date 2023/10/17 8:47
 */
@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    private BookService bookService;

    @Override
    @Transactional
    public void checkout(Integer[] bookIds, Integer userid) {
        for (Integer bookId : bookIds){
            //调用service方法
            bookService.buyBook(bookId,userid);
        }
    }
}
