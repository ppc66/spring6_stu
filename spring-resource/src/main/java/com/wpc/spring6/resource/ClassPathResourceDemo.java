package com.wpc.spring6.resource;

/**
 * @author wpc
 * @date 2023/10/17 9:54
 */

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassPathResource 用来访问类加载路径下的资源
 */
public class ClassPathResourceDemo {
    public static void loadClassResource(String path){
        ClassPathResource resource = new ClassPathResource(path);
        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());
        try {
            InputStream in = resource.getInputStream();
            byte[] b = new byte[1024];
            while (in.read(b) != -1){
                System.out.println(new String(b));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        loadClassResource("demo.txt");
    }
}
