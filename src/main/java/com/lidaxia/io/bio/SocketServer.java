package com.lidaxia.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2022/1/24 19:27
 */
public class SocketServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true) {
            System.out.println("等待连接...");
            Socket client = serverSocket.accept();
            System.out.println("有客户端连接了...");
            // C 10k
            // connection  1万个连接
            new Thread(()->{
                try {
                    handler(client) ;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private static void handler(Socket client) throws IOException {
        byte[] bytes = new byte[1024];
        System.out.println("准备read...");
        // 阻塞
        int read = client.getInputStream().read(bytes);
        System.out.println("read完毕...");
        if (read != -1) {
            System.out.println("接收到客户端的数据:" + new String(bytes, 0, read));
        }

    }

}
