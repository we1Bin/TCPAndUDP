package com.weibin.ip;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by wei.bin on 2017/8/21.
 */
public class UDPReceive {
    public static void main(String[] args) throws IOException {
        /**
         * 1，创建udp的socket服务，必须要明确一个端口
         * 2，定义数据包，用于存储接收到数据。
         * 3，通过socket服务的接收方法将收到的数据存储到数据包中。
         * 4，通过数据包的方法获取数据包中的具体数据内容，比如ip、端口、数据等等。
         * 5，关闭资源。
         */

        DatagramSocket ds = new DatagramSocket(8888);
        // 2，定义数据包，用于存储接收到数据。先定义字节数组，数据包会把数据存储到字节数组中。
        while (true){
            byte[] buf =  new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            // 3，通过socket服务的接收方法将收到的数据存储到数据包中。
            ds.receive(dp);//  该方法是阻塞式方法
            // 4，通过数据包的方法获取数据包中的具体数据内容，比如ip，端口，数据等等。
            String ip =  dp.getAddress().getHostAddress();
            String data = new String(dp.getData());
            int port =  dp.getPort();
            //String text =  new String(dp.getData(), 0, dp.getLength());// 将字节数组中的有效部分转成字符串。
            System.out.println("IP:"+ip  + ",DATA:" + data + ",PORT:" + port);
        }
    }
}
