package com.wpc.spring.javai18n;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author wpc
 * @date 2023/10/18 8:43
 */
public class ResourceI18n {
    public static void main(String[] args) {
        ResourceBundle bundle1 = ResourceBundle.getBundle("message", new Locale("zh", "CN"));
        String value1 = bundle1.getString("test");
        System.out.println("value1 = " + value1);
        ResourceBundle bundle2 = ResourceBundle.getBundle("message", new Locale("en", "GB"));
        String value2 = bundle2.getString("test");
        System.out.println("value2 = " + value2);
    }
}
