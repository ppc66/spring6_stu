package com.wpc.bean;

import com.wpc.anno.Bean;
import com.wpc.anno.Di;
import com.wpc.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author wpc
 * @date 2023/10/12 19:31
 */
public class MyAnnotationApplicationContext implements MyApplicationContext {
    //创建一个map集合，放bean对象
    private Map<Class,Object> beanFactory = new HashMap<>();
    private static String rootPath;
    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    //设置包扫描规则
    //当前包及其子包，那个类有@Bean注解，把这个类通过反射实例化
    public MyAnnotationApplicationContext(String basePackage) throws IllegalAccessException {
        //
        //1、 将.替换成\
        String packagePath = basePackage.replaceAll("\\.", "\\\\");
        //2、获取绝对路径
        try {
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
            while(urls.hasMoreElements()){
                URL url = urls.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");
                rootPath = filePath.substring(0, filePath.length() - packagePath.length());
                System.out.println("filePath = " + filePath);
                //进行包扫描
                loadBean(new File(filePath));
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        //完成属性注入
        loadDi();
    }

    /**
     * 进行属性的注入
     */
    private void loadDi() {
        //实例化对象在beanFactory的map集合中
        //1、遍历beanFactory的map集合
        Set<Map.Entry<Class, Object>> entries = beanFactory.entrySet();
        for (Map.Entry<Class, Object> entry : entries){
            Object obj = entry.getValue();
            Class clazz = obj.getClass();
            //获取属性
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.getAnnotation(Di.class) != null){
                    //如果是私有属性，设置
                    field.setAccessible(true);
                    try {
                        field.set(obj,beanFactory.get(field.getType()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        //2、获取map集合每个对象(value)，每个对象属性获得到

        //3、遍历得到每个对象属性数组，得到每个属性

        //4、判断属性上面是否有@Di注解

        //5、如果有@Di注解，就把对象进行注入
    }

    /**.
     * 包扫描 进行bean的实例化
     * @param file
     */
    private void loadBean(File file) throws Exception {
        //1、判断当前的内容是否是个文件夹 否则抛异常
        if (file.isDirectory()){
            //2、获取文件下的所有内容
            File[] childrenFiles = file.listFiles();
            //3、判断文件夹里面为空直接返回
            if (childrenFiles == null || childrenFiles.length == 0){
                return;
            }
            //4、如果文件夹不为空则遍历文件夹所有内容
            for (File child : childrenFiles){
                //4.1、便利得到每个File对象，继续判断，如果还是文件夹，递归
                if (child.isDirectory()){
                    loadBean(child);
                }else{
                    //4.2、如果遍历得到的File对象不是文件夹，是文件。
                    //4.3、得到包路径+类名称部分-字符串截取 主需要com.wpc...
                    String pathWithClass = child.getAbsolutePath().substring(rootPath.length() - 1);
                    //4.4、判断当时文件类型是否是.class类型
                    if (pathWithClass.contains(".class")){
                        //4.5、如果是.class类型，把路径中的\替换成\，并将 .class 去掉
                        //com.wpc.service.UserServiceImpl
                        String allName = pathWithClass.replaceAll("\\\\", "\\.")
                                .replace(".class", "");
                        //4.6、判断类上面是否有@Bean注解，如果有的话就进行实例化
                        //4.6.1获取类的Class对象
                        Class<?> clazz = Class.forName(allName);
                        //4.6.2判断是不是接口
                        if (!clazz.isInterface()){
                            //4.6.3 判断有没有@Bean注解
                            Bean annotation = clazz.getAnnotation(Bean.class);
                            if (annotation != null){
                                //4.6.4、有注解进行实例化
                                Object instance = clazz.getDeclaredConstructor().newInstance();
                                //4.7、对象实例化之后放到beanFactory（map）中。
                                //4.7.1、如果当前类有接口，让接口class座位map的key
                                if (clazz.getInterfaces().length > 0){
                                    beanFactory.put(clazz.getInterfaces()[0],instance);
                                }else{
                                    beanFactory.put(clazz,instance);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        MyApplicationContext context =
                new MyAnnotationApplicationContext("com.wpc");
        Object bean = context.getBean(UserServiceImpl.class);
    }
}
