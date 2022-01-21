package com.dorohedoro.inbound;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Description
 * @Author liuziye
 * @Date 2022/1/15 17:24
 */
public class InBoundHandlerB extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //System.out.println("InBoundHandlerB: " + msg);
        //ctx.fireChannelRead(msg);
        throw new RuntimeException("a RunTimeException thrown by InBoundHandlerB");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.pipeline().fireChannelRead("hello world");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(cause instanceof RuntimeException);
        System.out.println(cause.getMessage() + " and now caught by InBoundHandlerB");
        ctx.fireExceptionCaught(cause);
    }
}
