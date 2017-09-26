package com.weibin.ip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Created by wei.bin on 2017/8/21.
 */
public class UDPSend {
    public static void main(String[] args) throws IOException {
        /**
         * 1，建立udp的socket服务，创建对象时如果没有明确端口，系统会自动分配一个端口。
         * 2，明确要发送的具体数据。
         * 3，将数据封装成了数据包。
         * 4，用socket服务的send方法将数据包发送出去。
         * 5，关闭资源。
          */
        //建立UDP的socket服务
        //可以通过构造方法指定发送端口，不指定系统会随机分配
        DatagramSocket ds = new DatagramSocket();
        // 2，使用转换流把System.in键盘标准输入封装为BufferedReader方便后期逐行读取
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));
        String line;
        while ((line = bufferedReader.readLine()) != null){
            if (" ".equals(line)){
                break;
            }
            //发送的数据
            //String sendText = "Hello, My Darling";
            byte[] buf = line.getBytes();
            //封装成包
            DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"), 8888);
            //发送包
            ds.send(dp);
        }
        //关闭
        ds.close();

    }
}
