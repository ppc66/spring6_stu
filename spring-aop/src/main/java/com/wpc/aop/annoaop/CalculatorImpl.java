package com.wpc.aop.annoaop;

import org.springframework.stereotype.Component;

/**
 * @author wpc
 * @date 2023/10/13 8:39
 */
@Component
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int i, int j) {

        int result = i + j;
        System.out.println("方法内部 核心 result = " + result);

        //模拟异常的出现
//        int a = 1/0;
        return result;
    }

    @Override
    public int sub(int i, int j) {

        int result = i - j;

        System.out.println("方法内部 result = " + result);

        return result;
    }

    @Override
    public int mul(int i, int j) {

        int result = i * j;

        System.out.println("方法内部 result = " + result);

        return result;
    }

    @Override
    public int div(int i, int j) {

        int result = i / j;

        System.out.println("方法内部 result = " + result);

        return result;
    }
}
