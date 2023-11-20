package com.wpc.spring.tx.service;

import com.wpc.spring.tx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @author wpc
 * @date 2023/10/16 8:34
 */
@Service
// 添加事务 之后影响当前方法 如果加在类上则会影响当前类的所有方法
//@Transactional(readOnly = true)
//@Transactional(timeout = 3)
//@Transactional(noRollbackFor = ArithmeticException.class)
//@Transactional(noRollbackFor = ArithmeticException.class)
//@Transactional(isolation = Isolation.DEFAULT)  // 可重复读
//两带有事务的方法互相调用 事务该如何传递
//- REQUIRED：支持当前事务，如果不存在就新建一个(默认)**【没有就新建，有就加入】**
//- SUPPORTS：支持当前事务，如果当前没有事务，就以非事务方式执行**【有就加入，没有就不管了】**
//- MANDATORY：必须运行在一个事务中，如果当前没有事务正在发生，将抛出一个异常**【有就加入，没有就抛异常】**
//- REQUIRES_NEW：开启一个新的事务，如果一个事务已经存在，则将这个存在的事务挂起**【不管有没有，直接开启一个新事务，开启的新事务和之前的事务不存在嵌套关系，之前事务被挂起】**
//- NOT_SUPPORTED：以非事务方式运行，如果有事务存在，挂起当前事务**【不支持事务，存在就挂起】**
//- NEVER：以非事务方式运行，如果有事务存在，抛出异常**【不支持事务，存在就抛异常】**
//- NESTED：如果当前正有一个事务在进行中，则该方法应当运行在一个嵌套式事务中。被嵌套的事务可以独立于外层事务进行提交或回滚。如果外层事务不存在，行为就像REQUIRED一样。**【有事务的话，就在这个事务里再嵌套一个完全独立的事务，嵌套的事务可以独立的提交和回滚。没有事务就和REQUIRED一样。】**
@Transactional(propagation = Propagation.REQUIRES_NEW)
/**
 * 相关属性 只读: 设置只读，只能查询，不能添加修改
 *        超时: 在设置超时时间内没有完成，抛出异常（单位:秒）
 *        回滚策略 : 设置那些异常不能回滚
 *        隔离级别 : 读问题
 *        传播行为 : 事务方法之间调用，事务如何使用
 */

public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override

    public void buyBook(Integer bookId, Integer userid) {
//        //todo 模拟超时操作
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //根据图书id查询图书价格
        Integer price = bookDao.getBookPriceByBookId(bookId);
        //更新图书表库存 -1
        bookDao.updateStock(bookId);
        //更新用户余额 - 图书价格
        bookDao.updateUserBalance(userid,price);
    }
}
