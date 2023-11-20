package com.wpc.spring.validator.two;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

import java.util.List;

/**
 * @author wpc
 * @date 2023/10/18 9:49
 */
@Component
public class MyValidation2 {
    @Autowired
    private Validator validator;

    public boolean validatorByUser2(User user){
        BindException bindException = new BindException(user,user.getName());
        validator.validate(user,bindException);
        List<ObjectError> allErrors = bindException.getAllErrors();
        System.out.println("allErrors = " + allErrors);
        return bindException.hasErrors();
    }
}
