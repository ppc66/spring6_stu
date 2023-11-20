package com.wpc.aop.example;

/**
 * @author wpc
 * @date 2023/10/13 10:13
 */

/**
 * 静态代理
 */
public class CalculatorStaticProxy implements Calculator{
    //被代理目标对象传递过来
    private Calculator calculator;

    public CalculatorStaticProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int add(int i, int j) {
        //输出日志
        System.out.println("[日志] add 方法开始了，参数是：" + i + "," + j);
        //调用目标对象的方法实现核心业务
        int result = calculator.add(i, j);
        System.out.println("[日志] add 方法结束了，结果是：" + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        return 0;
    }

    @Override
    public int mul(int i, int j) {
        return 0;
    }

    @Override
    public int div(int i, int j) {
        return 0;
    }
}
