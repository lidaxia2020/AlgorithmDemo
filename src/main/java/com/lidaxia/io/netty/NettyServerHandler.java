package com.lidaxia.io.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2022/1/24 22:14
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端连接通道完成");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        Channel channel = ctx.channel();
//        ChannelPipeline channelPipeline = ctx.pipeline();

        ByteBuf buf = (ByteBuf) msg;
        System.out.println("收到客户端消息：" + buf.toString(CharsetUtil.UTF_8));
    }
}
