package com.wpc.spring.validator.three;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * @author wpc
 * @date 2023/10/18 10:14
 */
@Service
@Validated // 基于方法进行校验
public class MyService {

    public String testMethod(@NotNull @Valid User user){
        return user.toString();
    }
}
