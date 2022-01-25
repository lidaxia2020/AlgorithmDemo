package com.lidaxia.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2022/1/24 20:34
 */
public class NioSelectorServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9000));
        // 设置serverSocketChannel 非阻塞
        serverSocketChannel.configureBlocking(false);
        // 打开Selector 处理Channel，即创建epoll
        Selector selector = Selector.open();
        // serverSocketChannel 注册到selector上，并且selector对客户端accept连接操作感兴趣
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务启动成功");

        while (true) {
            // 阻塞等待需要处理的事件发生
            selector.select();

            // 获取selector 中注册的全部事件 SelectionKey实例
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    // 设置socketChannel 非阻塞
                    socketChannel.configureBlocking(false);
                    System.out.println("连接成功");
                    // 这里只注册了读事件，如果需要客户端的发生数据可以注册写事件
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }else if (selectionKey.isReadable()){
                    SocketChannel sc = (SocketChannel) selectionKey.channel();
                    ByteBuffer bf = ByteBuffer.allocate(128);
                    int len = sc.read(bf);
                    if (len > 0) {
                        System.out.println("接收到消息：" + new String(bf.array()));
                    } else if (len == -1) {
                        System.out.println("客户端断开连接");
                        sc.close();
                    }
                }

                // 从事件集合中删除本次处理key,防止下次select重复处理
                iterator.remove();
            }
        }
    }
}
