package com.weibin.ip;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1，创建服务端socket服务，并监听一个端口。
 * 2，服务端为了给客户端提供服务，获取客户端的内容，可以通过accept方法获取连接过来的客户端对象。
 * 3，可以通过获取到的socket对象中的socket流和具体的客户端进行通讯。
 * 4，如果通讯结束，关闭资源。注意：要先关客户端，再关服务端。
 * Created by wei.bin on 2017/8/21.
 */
public class TCPService {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10002);
        //获取客户端对象
        Socket s = ss.accept();
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip + "...connected");
        // 可以通过获取到的socket对象中的socket流和具体的客户端进行通讯
        // 读取客户端的数据，使用客户端对象的socket读取流
        InputStream in = s.getInputStream();
        byte[] buf =  new byte[1024];
        int len =  in.read(buf);
        String text =  new String(buf, 0, len);
        System.out.println(text);
        // 如果通讯结束，关闭资源。注意：要先关客户端，在关服务端。
        s.close();
        ss.close();
    }
}
