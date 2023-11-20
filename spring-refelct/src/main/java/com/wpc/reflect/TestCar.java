package com.wpc.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wpc
 * @date 2023/10/12 14:13
 */
public class TestCar {
    //获取Class对象的多种方式
    @Test
    public void test01() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //1、通过类名.class
        Class<Car> clazz1 = Car.class;
        //2、对象.getClass()
        Class<? extends Car> clazz2 = new Car().getClass();
        //Class.forName()
        Class<?> clazz3 = Class.forName("com.wpc.reflect.Car");
        //实例化 获取public 的构造方法
        Car car = (Car)clazz3.getDeclaredConstructor().newInstance();
        System.out.println(car);

    }

    //获取构造方法
    @Test
    public void test02() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Car> clazz = Car.class;
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor c : constructors){
            System.out.println("c = " + c.getName() + "参数个数:" +c.getParameterCount());
        }
        //只适合public修饰的构造方法
//        Constructor c1 = clazz.getConstructor(String.class,int.class,String.class);
//        Car car = (Car)c1.newInstance("BYD", 1, "PINK");
//        System.out.println("car = " + car);
        //访问private的方式
        Constructor c2 = clazz.getDeclaredConstructor(String.class,int.class,String.class);
        c2.setAccessible(true);
        Car car2 = (Car)c2.newInstance("BYD", 10, "YELLOW");
        System.out.println("car2 = " + car2);
    }
    //获取属性
    @Test
    public void test03() throws Exception{
        Class clazz = Car.class;
        Car car = (Car)clazz.getDeclaredConstructor().newInstance();
//        Field[] fields = clazz.getFields(); //获取公共属性
        //获取私有属性
        Field[] fields = clazz.getDeclaredFields();
        for (Field field: fields){
            System.out.println(field.getName());
            if (field.getName().equals("name")){
                field.setAccessible(true);
                field.set(car,"五菱宏光");
            }
        }
        System.out.println("car = " + car);
    }
    //通过反射获取类中的所有方法(public private)
    @Test
    public void test04() throws Exception{
        Car car = new Car("奔驰", 10, "黑色");
        Class clazz = car.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods){
            System.out.println("method = " + method.getName());
            if (method.getName().equals("toString")){
                System.out.println(method.invoke(car));
            }
        }
        //private方法的执行
        Method[] methodsAll = clazz.getDeclaredMethods();
        for (Method m : methodsAll){
            if (m.getName().equals("run")){
                m.setAccessible(true);
                m.invoke(car);
            }
        }
    }
}
