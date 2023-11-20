package com.wpc.spring.tx.service;

/**
 * @author wpc
 * @date 2023/10/17 8:47
 */
public interface CheckoutService {
    void checkout(Integer[] bookIds,Integer userid);
}
