package com.weibin.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by wei.bin on 2017/8/21.
 */
public class IPDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ip = InetAddress.getByName("www.baidu.com");
        //返回该InetAddress实例对应的IP地址字符串（以字符串形式）
        System.out.println(ip.getHostAddress());
        //获取此IP地址的主机名。
        System.out.println(ip.getHostName());
        //获取此IP地址的全限定域名。
        System.out.println("CanonicalHostName: " + ip.getCanonicalHostName());
        System.out.println("Address: " + ip.getAddress().toString());
    }
}
