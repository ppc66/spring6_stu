package com.wpc.spring.validator.one;

import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

/**
 * @author wpc
 * @date 2023/10/18 9:24
 */
public class TestPerson {
    public static void main(String[] args) {
        //创建Person对象
        Person person = new Person();
        person.setAge(-1);
        //创建Person对应的databinder
        DataBinder binder = new DataBinder(person);
        //设置校验器
        binder.setValidator(new PersonValidator());
        //调用方法执行校验
        binder.validate();
        //输出校验结果
        BindingResult bindingResult = binder.getBindingResult();
        System.out.println(bindingResult.getAllErrors());
    }
}
