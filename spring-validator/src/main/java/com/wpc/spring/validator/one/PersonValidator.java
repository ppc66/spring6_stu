package com.wpc.spring.validator.one;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author wpc
 * @date 2023/10/18 9:18
 */
public class PersonValidator implements Validator {
    /**
     * 表示用来校验用在那个类型上
     * @param clazz
     * @return
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    /**
     * 添加校验规则
     * @param target
     * @param errors
     */
    @Override
    public void validate(Object target, Errors errors) {
        //name 不能为空
        ValidationUtils.rejectIfEmpty(errors,"name","name.empty","name is null");

        //age不能小于0 不能大于200
        Person p = (Person) target;
        if (p.getAge() < 0){
            errors.rejectValue("age","age.value.error","age < 0");
        }else if(p.getAge() > 200){
            errors.rejectValue("age","age.value.error","age > 200");
        }
    }
}
