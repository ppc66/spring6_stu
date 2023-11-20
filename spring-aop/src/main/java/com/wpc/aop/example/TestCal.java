package com.wpc.aop.example;

/**
 * @author wpc
 * @date 2023/10/13 14:20
 */
public class TestCal {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator)proxyFactory.getProxy();
        int add = proxy.add(1, 2);
        System.out.println("add = " + add);
    }
}
