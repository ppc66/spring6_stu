package com.wpc.spring.validator.two;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author wpc
 * @date 2023/10/18 9:49
 */

/**
 * 原生validator
 */
@Component
public class MyValidation1 {
    @Autowired
    private Validator validator;

    public boolean validatorByUser(User user){
        Set<ConstraintViolation<User>> validate = validator.validate(user);
        return validate.isEmpty();
    }
}
