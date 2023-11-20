package com.wpc.spring.tx.dao;

/**
 * @author wpc
 * @date 2023/10/16 8:34
 */
public interface BookDao {

    Integer getBookPriceByBookId(Integer bookId);

    void updateStock(Integer bookId);

    void updateUserBalance(Integer userid, Integer price);
}
