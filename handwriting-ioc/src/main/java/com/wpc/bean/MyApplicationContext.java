package com.wpc.bean;

import org.springframework.context.ApplicationContext;

/**
 * @author wpc
 * @date 2023/10/12 19:24
 */
public interface MyApplicationContext  {
    Object getBean(Class clazz);
}
