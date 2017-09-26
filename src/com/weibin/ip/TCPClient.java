package com.weibin.ip;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 1，建立tcp的socket服务要明确具体的地址和端口。这个对象在创建时，就已经可以对指定ip和端口进行连接(三次握手)。
 * 2，如果连接成功, 通过getInputStream和getOutputStream就可以获取两个流对象。
 * 3，关闭资源。
 * Created by wei.bin on 2017/8/21.
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        // 1，建立tcp的socket服务，最好明确具体的地址和端口。
        // 这个对象在创建时，就已经可以对指定ip和端口进行连接(三次握手)。
        Socket socket = new Socket("127.0.0.1", 10002);
        // 2，如果连接成功，就意味着通道建立了，socket流就已经产生了。
        // 只要获取到socket流中的读取流和写入流即可，
        // 只要通过getInputStream和getOutputStream就可以获取两个流对象。
        OutputStream out = socket.getOutputStream();
        //3.往流中写入数据
        out.write("Hello.Darling".getBytes());
        socket.close();
    }
}
