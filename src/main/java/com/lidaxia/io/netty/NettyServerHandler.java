package com.lidaxia.io.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2022/1/24 22:14
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("channelActive");
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) {
        System.out.println("channelRegistered");
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        System.out.println("handlerAdded");
    }

    @Override
    public void channelRead(final ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);

        new Thread(new Runnable() {
            @Override
            public void run() {
                // 耗时的操作
                String result = loadFromDB();

                ctx.channel().writeAndFlush(result);
                ctx.executor().schedule(new Runnable() {
                    @Override
                    public void run() {
                        // ...
                    }
                }, 1, TimeUnit.SECONDS);

            }
        }).start();
    }

    private String loadFromDB() {
        return "hello world!";
    }
}
