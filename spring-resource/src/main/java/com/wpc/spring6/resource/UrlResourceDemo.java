package com.wpc.spring6.resource;

/**
 * @author wpc
 * @date 2023/10/17 9:48
 */

import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * 演示UrlResource访问网络资源
 * Resource的一个实现类，用来访问网络资源，它支持URL的绝对路径。
 *
 * http:------该前缀用于访问基于HTTP协议的网络资源。
 *
 * ftp:------该前缀用于访问基于FTP协议的网络资源
 *
 * file: ------该前缀用于从文件系统中读取资源
 */
public class UrlResourceDemo {
    //访问前缀是http
    public static void loadUrlResource(String path){
        //1 创建Resource接口的实现类对象
        try {
            UrlResource url = new UrlResource(path);
            //2 调用方法进行访问
            System.out.println(url.getFilename());
            System.out.println(url.getURL());
            System.out.println(url.getDescription());
            System.out.println(url.getInputStream().read());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //http 前缀开头
//        loadUrlResource("http://www.baidu.com");
        //要放在根路径
//        loadUrlResource("file:demo.txt");
    }
}
