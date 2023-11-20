package com.wpc.spring.validator.two;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * @author wpc
 * @date 2023/10/18 9:45
 */
@Configuration
@ComponentScan("com.wpc.spring.validator.two")
public class ValidatorConfig {

    @Bean
    public LocalValidatorFactoryBean getLocalValidatorFactoryBean(){
        return new LocalValidatorFactoryBean();
    }

}
