package com.soa.other.netty.server;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

public class ServerLogicHandler extends SimpleChannelHandler {  
    @Override  
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e)  
            throws Exception {  
        System.out.println("######channelConnected");  
        // channel group is thread safe  
        Server.channelGroup.add(e.getChannel());  
        System.out.println(e.getChannel().toString());  
    }  
  
    @Override  
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {  
        System.out.println("######messageReceived");  
          
        // 经过了ServerReadDecoder的处理，这里可以直接得到String类型的message  
        String msg = (String)e.getMessage();  
        System.out.println("The message sent by client is : " + msg);  
          
        Channel ch = e.getChannel();  
        String str = "Hi, Client.";  
        // 由于IO操作是异步的，当方法返回时并不能保证IO操作一定完成了  
        // 因此返回一个ChannelFuture对象实例  
        // 该实例中保存了IO操作的状态信息  
        ChannelFuture cf = ch.write(str);  
        // 为ChannelFuture对象实例添加监听，如果数据发送完毕则关闭连接  
        cf.addListener(new ChannelFutureListener(){  
            @Override  
            public void operationComplete(ChannelFuture future)  
                    throws Exception {  
                Channel ch = future.getChannel();  
                ch.close();  
            }  
        });  
          
        System.out.println("The message has sent to client.");  
    }  
   
    @Override  
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) {  
        e.getCause().printStackTrace();  
        Channel ch = e.getChannel();  
        ch.close();  
    }  
}  